package models;

import controllers.ControllerConexion;
import entidades.Cliente;
import entidades.Moto;
import entidades.Venta;
import models.ClienteModel;
import models.MotoModel;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que contiene todos los metodos encargados de gestionar los clientes y las operaciones
 * que se hacen con los mismos atacando a la base de datos.
 */
public class VentaModel {

    private ArrayList<Venta> listaVentas;
    private ControllerConexion cnControl;
    private ClienteModel modelC;
    private MotoModel modelM;
    private Connection conexion;

    /**
     * Constructor de la clase.
     */
    public VentaModel(){
        listaVentas = new ArrayList<>();
        cnControl = new ControllerConexion();
        modelC = new ClienteModel();
        modelM = new MotoModel();
        conexion = cnControl.conectar();
        saveVentas();
    }

    /**
     * Metodo que recoge todos los clientes de la base de datos y los guarda en el ArrayList
     * de la clase.
     */
    private void saveVentas(){
        listaVentas.clear();
        String sql = "SELECT * FROM t_ventas";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                int idVenta = rs.getInt("IDVenta");
                String matricula = rs.getString("Matricula");
                String dni = rs.getString("DNI");
                float precio = rs.getFloat("Precio");
                String idVendedor = rs.getString("IDVendedor");
                int existe = rs.getInt("existe");
                Venta venta = new Venta(idVenta, matricula, dni, precio, idVendedor, existe);
                listaVentas.add(venta);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * Metodo que busca una venta, usando una matricula de moto como clave, en el ArrayList de la clase que las contiene.
     * @param pk Recibe la matricula de la moto vendida en la venta a buscar.
     * @return Devuelve el objeto de tipo venta correspondiente a la matricula dado.
     */
    public Venta buscarVenta(String pk){
        //saveVentas();
        for(Venta v : listaVentas){
            if (v.getMatricula().equals(pk)){
                return v;

            }
        }
        return null;
    }

    /**
     * Metodo que busca una venta, usando el id como clave primaria, en el
     * ArrayList de la clase que los contiene.
     * @param pk Recibe el id de la venta a buscar.
     * @return Devuelve el objeto de tipo venta correspondiente a la venta dada.
     */
    public Venta buscarVenta(int pk){
        //saveVentas();
        for(Venta v : listaVentas){
            if (v.getIdVenta() == (pk)){
                return v;
            }
        }
        return null;
    }

    public ArrayList<Venta> buscarVentasCliente(String dni){
        ArrayList<Venta> listaVCliente = new ArrayList<>();
        for (Venta v : listaVentas){
            if (v.getDni().equalsIgnoreCase(dni)){
                listaVCliente.add(v);
            }
        }
        return  listaVCliente;
    }


    public ArrayList<Venta> buscarVentasNick(String nick){
        ArrayList<Venta> listaVCliente = new ArrayList<>();
        for (Venta v : listaVentas){
            if (v.getIdVendedor().equalsIgnoreCase(nick)){
                listaVCliente.add(v);
            }
        }
        return  listaVCliente;
    }

    /**
     * Metodo que comprueba si una venta existe o no, buscando en el ArrayList de la clase, usando la primary
     * key.
     * @param pk String correspondiente al dni del que se quiere comprobar su existencia.
     * @return Devuelve un booleano segun el resultado de la busqueda.
     */
    public boolean ventaExiste(String pk){
        return buscarVenta(pk) != null;
    }

    /**
     * Metodo que comprueba si una venta existe o no, buscando en el ArrayList de la clase, usando la primary
     * key.
     * @param pk Int correspondiente al id de la venta de la que se quiere comprobar su existencia.
     * @return Devuelve un booleano segun el resultado de la busqueda.
     */
    public boolean ventaExiste(int pk){
        return buscarVenta(pk) != null;
    }

    /**
     * Metodo que devuelve el arrayList de la clase que hace de contenedor de todas
     * las ventas existentes. Siempre refresca los datos antes de devolverlo, llamando al metodo
     * saveVentas().
     * @return Devuelve el ArrayList lista de clientes.
     */
    public ArrayList<Venta> getListaVentas(){
        saveVentas();
        return listaVentas;
    }

    public boolean buscarExistencia(String matricula, String dni){
        return modelM.motoExiste(matricula) && modelC.clienteExiste(dni);
    }

    public Moto buscarMoto(String matricula){
        return modelM.buscarMoto(matricula);
    }

    public Cliente buscarCliente(String DNI){
        return modelC.buscarCliente(DNI);
    }
    public void addVenta(Venta venta){
        //saveVentas();
        String sql = "INSERT INTO t_ventas (Matricula, DNI, Precio, IDVendedor, existe) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, venta.getMatricula());
            pst.setString(2, venta.getDni());
            pst.setDouble(3, venta.getPrecio());
            pst.setString(4, venta.getIdVendedor());//esto no lo pediremos al usuario
            pst.setInt(5,1);
            //sino que lo mandaremos directamente segun quien haya iniciado sesion
            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando la venta: " + e);
        }

        getListaVentas();
    }

    /**
     * Elimina una venta de la base de datos utilizando la funcion sql creada con esa finalidad.
     * @param pk Recibe el id de la venta que se quiere eliminar.
     * @return Devuelve un booleano indicando el exito que ha tenido la accion.
     */
    public boolean removeVenta(String pk){
        //saveVentas();
        String sql = "{call sp_eliminarVenta(?)}";
        try {
            CallableStatement cst = conexion.prepareCall(sql);
            cst.setString(1, pk);
            cst.execute();
            //updateExiste(0, pk);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Cambia el estado de una venta en la base de datos, al estado que recibe por parametro. Para ello, recoge la venta coincidente
     * con el id, settea el nuevo valor y llama al metodo de esta clase que actualiza la venta, pasandole la venta recogido.
     * @param exists Recibe el valor que se le ha asignar en la BD: 0 si ya no esta disponible y 1 si esta disponible.
     * @param pk ID de la venta que actulizaremos.
     */
    public void updateExiste(int exists, int pk){
        Venta venta = buscarVenta(pk);
        venta.setExiste(exists);
        updateVentaLista(venta);
        updateVenta(venta);
    }

    /**
     * Metodo que actualiza la venta en la base de datos, usando todos los valores de la venta recibida. Tras actulizarla en
     * la base de datos, llama al metodo encargado de actulizar la venta en la lista general de las ventas.
     * @param venta Recibe la venta que se ha de actualizar.
     * @return Devuelve un booleano que indica el exito de la accion.
     */
    public boolean updateVenta(Venta venta){
        //saveVentas();
        String sql = "UPDATE t_ventas set Precio = ?, existe = ? where IDVenta = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setDouble(1, venta.getPrecio());
            pst.setInt(2, 1);
            pst.setInt(3, venta.getIdVenta());
            pst.executeUpdate();
            updateVentaLista(venta);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Cambia el estado de una venta en la base de datos, al estado que recibe por parametro. Para ello, recoge la venta coincidente
     * con el id, settea el nuevo valor y llama al metodo de esta clase que actualiza la venta, pasandole la venta recogida.
     * @param venta La venta que se actualizara.
     */
    public boolean cambiarExiste(Venta venta){
        //saveVentas();
        String sql = "UPDATE t_ventas set existe = ? where Matricula = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, venta.isExiste());
            pst.setString(2, venta.getMatricula());
            pst.executeUpdate();
            updateVentaLista(venta);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Actuliza los valores de la venta actualizada en el ArrayList de la clase, de modo que los valores de la base
     * de datos y de la lista que contiene el programa, coincidan.
     * @param venta Recibe la venta a actulizar.
     */
    private void updateVentaLista(Venta venta){
        for (Venta v : listaVentas){
            if (v.getIdVenta() == venta.getIdVenta()){
                v.setMatricula(venta.getMatricula());
                v.setDni(venta.getDni());
                v.setPrecio(venta.getPrecio());
            }
        }
    }

}
