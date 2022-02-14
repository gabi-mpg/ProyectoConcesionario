package models;

import controllers.ControllerConexion;
import entidades.Cliente;
import models.Config;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que contiene todos los metodos encargados de gestionar los clientes y las operaciones
 * que se hacen con los mismos atacando a la base de datos.
 */
public class ClienteModel {

    private ArrayList<Cliente> listaClientes;
    private ControllerConexion cnControl;
    private Connection conexion;

    /**
     * Constructor de la clase.
     */
    public ClienteModel(){
        listaClientes = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.conectar();
        saveClientes();
    }

    /**
     * Metodo que recoge todos los clientes de la base de datos y los guarda en el ArrayList
     * de la clase.
     */
    private void saveClientes(){
        listaClientes.clear();
        String sql = "SELECT * FROM t_clientes";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                String dni = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String direcc = rs.getString("Direccion");
                int existe = rs.getInt("existe");
                Cliente cliente = new Cliente(dni, nombre, apellido, direcc, existe);
                listaClientes.add(cliente);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * Metodo que busca un cliente, usando el dni como clave primaria, en el
     * ArrayList de la clase que los contiene.
     * @param pk Recibe el dni del cliente a buscar.
     * @return Devuelve el objeto de tipo cliente correspondiente al dni dado.
     */
    public Cliente buscarCliente(String pk){
        saveClientes();
        for(Cliente c : listaClientes){
            if (c.getDni().equalsIgnoreCase(pk)){
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo que comprueba si un cliente existe o no, buscando en el ArrayList de la clase, usando la primary
     * key.
     * @param pk String correspondiente al dni del que se quiere comprobar su existencia.
     * @return Devuelve un booleano segun el resultado de la busqueda.
     */
    public boolean clienteExiste(String pk){
        return buscarCliente(pk) != null;
    }

    /**
     * Metodo que devuelve el arrayList de la clase que hace de contenedor de todos
     * los clientes existentes. Siempre refresca los datos antes de devolverlo, llamando al metodo
     * saveClientes().
     * @return Devuelve el ArrayList lista de clientes.
     */
    public ArrayList<Cliente> getListaClientes(){
        this.listaClientes = new ArrayList<>();
        saveClientes();
        return listaClientes;
    }

    /**
     * Guarda el nuevo cliente en la base de datos y actualiza el ArrayList de la clase llamando
     * al metodo saveClientes()
     * @param cliente Recibe el nuevo cliente a guardar en la base de datos.
     */
    public void addCliente(Cliente cliente){
        saveClientes();
        String sql = "INSERT INTO t_clientes values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, cliente.getDni());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getDireccion());
            pst.setInt(5,1);

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando el cliente. " + e);
        }
        saveClientes();
    }

    /**
     * Elimina a un cliente de la base de datos utilizando la funcion sql creada con esa finalidad.
     * @param dni Recibe el dni del cliente que se quiere eliminar.
     * @return Devuelve un booleano indicando el exito que ha tenido la accion.
     */
    public boolean removeCliente(String dni){
        saveClientes();
        String sql = "{call sp_eliminarcliente(?)}";
        try {
            CallableStatement cst = conexion.prepareCall(sql);
            cst.setString(1, dni);
            cst.executeQuery();
            //updateExiste(false, dni);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Cambia el estado de un cliente en la base de datos, al estado que recibe por parametro. Para ello, recoge el cliente coincidente
     * con el dni, settea el nuevo valor y llama al metodo de esta clase que actualiza el cliente, pasandole el cliente recogido.
     * @param exists Recibe el valor que se le ha asignar en la BD: 0 si ya no esta disponible y 1 si esta disponible.
     * @param dni DNI del cliente que actulizaremos.
     */
    public void updateExiste(int exists, String dni){
        Cliente cliente = buscarCliente(dni);
        cliente.setExiste(exists);
        updateCliente(cliente);
    }

    /**
     * Metodo que actualiza el cliente en la base de datos, usando todos los valores del cliente recibido. Tras actulizarlo en
     * la base de datos, llama al metodo encargado de actulizar el cliente en la lista general de los clientes.
     * @param cliente Recibe el cliente entero que se ha de actualizar.
     * @return Devuelve un booleano que indica el exito de la accion.
     */
    public boolean updateCliente(Cliente cliente){
        System.out.println(cliente.toString());
        saveClientes();
        String sql = "UPDATE t_clientes set Nombre = ?, Apellido = ?, Direccion = ?, existe = ? where DNI like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getDireccion());
            pst.setInt(4,cliente.getExiste());
            pst.setString(5, cliente.getDni());

            pst.executeUpdate();
            updateClienteLista(cliente);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * Actuliza los valores del cliente actualizado en el ArrayList de la clase, de modo que los valores de la base
     * de datos y de la lista que contiene el programa, coincidan.
     * @param cliente Recibe el cliente a actulizar
     */
    private void updateClienteLista(Cliente cliente){
        for (Cliente c : listaClientes){
            if (c.getDni().equalsIgnoreCase(cliente.getDni())){
                c.setNombre(cliente.getNombre());
                c.setApellido(cliente.getApellido());
                c.setDireccion(cliente.getDireccion());
            }
        }
    }

}
