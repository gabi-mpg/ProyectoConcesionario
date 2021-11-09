package modelo;

import controllers.ControllerConexion;
import entidades.Usuario;
import entidades.Venta;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioModel {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static ControllerConexion cnControl = new ControllerConexion();
    private static Connection conexion;

    public UsuarioModel(){
        listaUsuarios = new ArrayList<>();
        cnControl = new ControllerConexion();
        cnControl.conectar();
        conexion = cnControl.getConexion();
        //conexion = conectar();
        saveUsuario();
    }

    private static void saveUsuario(){
        listaUsuarios.clear();
        String sql = "SELECT * FROM t_usuarios";

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                int permiso = rs.getInt("nivelPermiso");
                String nick = rs.getString("nick");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String contra = rs.getString("Contrasena");
                Usuario usuario = new Usuario(nick, nombre, apellidos, contra, permiso);
                listaUsuarios.add(usuario);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Usuario buscarUsuario(String pk){
        saveUsuario();
        for(Usuario u : listaUsuarios){
            if (u.getNick().equalsIgnoreCase(pk)){
                return u;
            }
        }
        return null;
    }

    public static void listarUsuario(String pk){
        if (buscarUsuario(pk) != null){
            System.out.println(buscarUsuario(pk).toString());
        } else{
            System.out.println("La venta no existe en la bd");
        }

    }

    public static ArrayList<Usuario> getListaUsuarios(){
        saveUsuario();
        return listaUsuarios;
    }

    public static boolean buscarExistencia(String pk){
        return buscarUsuario(pk) != null;
    }

    public static void addUsuario(Usuario usuario){
        saveUsuario();
        String sql = "INSERT INTO t_usuarios values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, usuario.getNick());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellidos());
            pst.setString(4, usuario.getContra());
            pst.setInt(5, usuario.getPermiso());

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando el usuario. " + e);
        }

        getListaUsuarios();
    }

    public static boolean removeUsuario(String pk){
        saveUsuario();
        String sql = "delete from t_usuarios where pk like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, pk);
            pst.executeUpdate();
            listaUsuarios.removeIf(u -> u.getNick().equalsIgnoreCase(pk));
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean updateUsuario(Usuario usuario){
        System.out.println(usuario.toString());
        saveUsuario();
        String sql = "UPDATE t_usuarios set Nombre = ?, Apellidos = ?, Contrasena = ?, nivelPermiso = ? where IDVenta = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getContra());
            pst.setInt(4, usuario.getPermiso());
            pst.executeUpdate();
            updateVentaLista(usuario);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private static void updateVentaLista(Usuario usuario){
        for (Usuario u : listaUsuarios){
            if (u.getNick().equalsIgnoreCase(usuario.getNick())){
                u.setNombre(usuario.getNombre());
                u.setApellidos(usuario.getApellidos());
                u.setContra(usuario.getContra());
                u.setPermiso(usuario.getPermiso());
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
