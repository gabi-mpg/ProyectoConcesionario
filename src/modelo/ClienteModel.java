package modelo;

import controllers.ControllerConexion;
import entidades.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteModel {

    private ArrayList<Cliente> listaClientes;
    private ControllerConexion cnControl;
    private Connection conexion;

    public ClienteModel(){
        listaClientes = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.conectar();
        saveClientes();
    }

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

    public Cliente buscarCliente(String pk){
        saveClientes();
        for(Cliente c : listaClientes){
            if (c.getDni().equalsIgnoreCase(pk)){
                return c;
            }
        }
        return null;
    }

    public boolean clienteExiste(String pk){
        return buscarCliente(pk) != null;
    }


    public ArrayList<Cliente> getListaClientes(){
        this.listaClientes = new ArrayList<Cliente>();
        saveClientes();
        return listaClientes;
    }

    public ArrayList<Cliente> addCliente(Cliente cliente){
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

        return getListaClientes();
    }

    /*public boolean removeCliente(String dni){
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
    }*/

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

    public void updateExiste(int exists, String dni){
        Cliente cliente = buscarCliente(dni);
        cliente.setExiste(exists);
        updateCliente(cliente);
    }

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

    private void updateClienteLista(Cliente cliente){
        for (Cliente c : listaClientes){
            if (c.getDni().equalsIgnoreCase(cliente.getDni())){
                c.setNombre(cliente.getNombre());
                c.setApellido(cliente.getApellido());
                c.setDireccion(cliente.getDireccion());
            }
        }
    }

    public void conectar(){
        try{
            String[] valores = new config().getConfig();
            conexion = DriverManager.getConnection(valores[0], valores[1], valores[2]);
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }
    }

}
