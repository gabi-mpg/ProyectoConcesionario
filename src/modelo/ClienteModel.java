package modelo;

import controllers.ControllerConexion;
import entidades.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteModel {

    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static ControllerConexion cnControl = new ControllerConexion();
    private static Connection conexion;

    public ClienteModel(){
        listaClientes = new ArrayList<>();
        cnControl = new ControllerConexion();
        //conexion = cnControl.getConexion();
        //conexion = conectar();
        saveClientes();
    }

    private static void saveClientes(){
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
                Cliente cliente = new Cliente(dni, apellido, nombre, direcc);
                listaClientes.add(cliente);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Cliente buscarCliente(String pk){
        saveClientes();
        for(Cliente c : listaClientes){
            if (c.getDni().equalsIgnoreCase(pk)){
                return c;
            }
        }
        return null;
    }

    public static boolean clienteExiste(String pk){
        return buscarCliente(pk) != null;
    }

    public static void listarCliente(String pk){
        if (buscarCliente(pk) != null){
            System.out.println(buscarCliente(pk).toString());
        } else{
            System.out.println("El cliente no existe en la bd");
        }

    }

    public static ArrayList<Cliente> getListaClientes(){
        saveClientes();
        return listaClientes;
    }

    public static ArrayList<Cliente> addCliente(Cliente cliente){
        saveClientes();
        String sql = "INSERT INTO t_clientes values (?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, cliente.getDni());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getDireccion());

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando el cliente. " + e);
        }

        return getListaClientes();
    }

    public static boolean removeCliente(String dni){
        saveClientes();
        String sql = "delete from t_clientes where dni like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, dni);
            pst.executeUpdate();
            listaClientes.removeIf(c -> c.getDni().equalsIgnoreCase(dni));
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean updateCliente(Cliente cliente){
        System.out.println(cliente.toString());
        saveClientes();
        String sql = "UPDATE t_clientes set Nombre = ?, Apellido = ?, Direccion = ? where DNI like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getDireccion());
            pst.setString(4, cliente.getDni());
            pst.executeUpdate();
            updateClienteLista(cliente);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private static void updateClienteLista(Cliente cliente){
        for (Cliente c : listaClientes){
            if (c.getDni().equalsIgnoreCase(cliente.getDni())){
                c.setNombre(cliente.getNombre());
                c.setApellido(cliente.getApellido());
                c.setDireccion(cliente.getDireccion());
            }
        }
    }

    public static void conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/concesionario?useSSL=false", "root", "");
            conexion = cn;
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }
    }

}
