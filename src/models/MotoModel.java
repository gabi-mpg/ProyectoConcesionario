package models;

import controllers.ControllerConexion;
import entidades.Moto;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que contiene todos los metodos encargados de gestionar las motos y las operaciones
 * que se hacen con las mismas atacando a la base de datos.
 */
public class MotoModel{

    private ArrayList<Moto> listaMotos;
    private ControllerConexion cnControl;
    private Connection conexion;

    /**
     * Constructor de la clase.
     */
    public MotoModel(){
        listaMotos = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.conectar();
        saveMotos();
    }

    /**
     * Metodo que recoge todas las motos de la base de datos y las guarda en el ArrayList
     * de la clase.
     */
    private void saveMotos(){
        listaMotos.clear();
        String sql = "SELECT * FROM t_motos";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                String matricula = rs.getString("Matricula");
                String color = rs.getString("Color");
                String marca = rs.getString("Marca");
                int tanque = rs.getInt("Tanque");
                int existe = rs.getByte("existe");
                Moto moto = new Moto(matricula, marca, color, tanque, existe);
                listaMotos.add(moto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Metodo que busca una moto, usando la primary key como clave primaria, en el
     * ArrayList de la clase que los contiene.
     * @param pk Recibe la primary key del objeto a buscar.
     * @return Devuelve el objeto de tipo moto correspondiente a la primary key dada.
     */
    public Moto buscarMoto(String pk){
        saveMotos();
        for(Moto m : listaMotos){
            if (m.getMatricula().equalsIgnoreCase(pk)){
                return m;
            }
        }
        return null;
    }

    /**
     * Metodo que comprueba si una moto existe o no, buscando en el ArrayList de la clase, usando la primary
     * key dada.
     * @param pk String correspondiente a la primary key del objeto del que se quiere comprobar su existencia.
     * @return Devuelve un booleano segun el resultado de la busqueda.
     */
    public boolean motoExiste(String pk){
        return buscarMoto(pk) != null;
    }

    /**
     * Metodo que devuelve el arrayList de la clase que hace de contenedor de todos
     * las motos existentes. Siempre refresca los datos antes de devolverlo, llamando al metodo
     * saveMotos().
     * @return Devuelve el ArrayList lista de clientes.
     */
    public ArrayList<Moto> getListaMotos(){
        saveMotos();
        return listaMotos;
    }

    /**
     * Guarda la nueva moto en la base de datos y actualiza el ArrayList de la clase llamando
     * al metodo saveMotos()
     * @param moto Recibe la nueva moto a guardar en la base de datos.
     */
    public void addMoto(Moto moto){
        saveMotos();
        String sql = "INSERT INTO t_motos (Matricula, Marca, Color, Tanque, existe) values (?, ?, ?, ?,?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, moto.getMatricula());
            pst.setString(2, moto.getMarca());
            pst.setString(3, moto.getColor());
            pst.setInt(4, moto.getTanque());
            pst.setInt(5,moto.isExiste());

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando la moto. " + e);
        }
        saveMotos();
    }

    /**
     * Elimina una moto de la base de datos utilizando la funcion sql creada con esa finalidad.
     * @param matricula Recibe la matricula de la moto que se quiere eliminar.
     * @return Devuelve un booleano indicando el exito que ha tenido la accion.
     */
    public boolean removeMoto(String matricula){
        saveMotos();
        String sql = "{call sp_eliminarmoto(?)}";
        try {
            CallableStatement cst = conexion.prepareCall(sql);
            cst.setString(1, matricula);
            cst.execute();
            updateExiste(0, matricula);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Cambia el estado de una moto en la base de datos, al estado que recibe por parametro. Para ello, recoge la moto coincidente
     * con la matricula dada, settea el nuevo valor y llama al metodo de esta clase que actualiza la moto, pasandole la moto recogida.
     * @param exists Recibe el valor que se le ha asignar en la BD: 0 si ya no esta disponible y 1 si esta disponible.
     * @param matricula Matricula de la moto que actulizaremos.
     */
    public void updateExiste(int exists, String matricula){
        Moto moto = buscarMoto(matricula);
        moto.setExiste(exists);
        updateMotoLista(moto);
        updateMoto(moto);
    }

    /**
     * Metodo que actualiza la moto en la base de datos, usando todos los valores de la moto recibida. Tras actulizarla en
     * la base de datos, llama al metodo encargado de actulizar la moto en la lista general de las motos.
     * @param moto Recibe la moto que se ha de actualizar.
     * @return Devuelve un booleano que indica el exito de la accion.
     */
    public boolean updateMoto(Moto moto){
        saveMotos();
        String sql = "UPDATE t_motos set Marca = ?, Color = ?, Tanque = ?, existe = ? where matricula like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, moto.getMarca());
            pst.setString(2, moto.getColor());
            pst.setInt(3, moto.getTanque());
            pst.setString(5, moto.getMatricula());
            pst.setInt(4, moto.isExiste());
            pst.executeUpdate();
            updateMotoLista(moto);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Actuliza los valores de la moto actualizado el ArrayList de la clase, de modo que los valores de la base
     * de datos y de la lista que contiene el programa, coincidan.
     * @param moto Recibe la moto a actulizar
     */
    private void updateMotoLista(Moto moto){
        for (Moto m : listaMotos){
            if (m.getMatricula().equalsIgnoreCase(moto.getMatricula())){
                m.setColor(moto.getColor());
                m.setMarca(moto.getMarca());
                m.setTanque(moto.getTanque());
                m.setExiste(moto.isExiste());
            }
        }
    }
}
