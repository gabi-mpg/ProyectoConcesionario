package models;

import controllers.ControllerConexion;
import entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioModel {
    private static ArrayList<Usuario> listaUsuarios;
    private static ControllerConexion cnControl;
    private static Connection conexion;

    public UsuarioModel(){
        listaUsuarios = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.conectar();
        saveUsuario();
    }

    private void saveUsuario(){
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
                boolean existe = rs.getBoolean("existe");
                Usuario usuario = new Usuario(nick, nombre, apellidos, contra, permiso, existe);
                listaUsuarios.add(usuario);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Usuario buscarUsuario(String pk){
        saveUsuario();
        for(Usuario u : listaUsuarios){
            if (u.getNick().equalsIgnoreCase(pk)){
                return u;
            }
        }
        return null;
    }

    public boolean usuarioExiste(String pk){
        return buscarUsuario(pk) != null;
    }


    public ArrayList<Usuario> getListaUsuarios(){
        saveUsuario();
        return listaUsuarios;
    }

    public boolean buscarExistencia(String pk){
        return buscarUsuario(pk) != null;
    }

    public void addUsuario(Usuario usuario){
        saveUsuario();
        String sql = "INSERT INTO t_usuarios values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, usuario.getNick());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellidos());
            pst.setString(4, usuario.getContra());
            pst.setInt(5, usuario.getPermiso());
            pst.setInt(6, 1);

            pst.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error registrando el usuario. " + e);
        }

        getListaUsuarios();
    }

    public boolean removeUsuario(String pk){
        saveUsuario();
        String sql = "delete from t_usuarios where nick like ?";
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

    public boolean updateUsuario(Usuario usuario){
        saveUsuario();
        String sql = "UPDATE t_usuarios set Nombre = ?, Apellidos = ?, Contrasena = ?, nivelPermiso = ?, existe = ? where nick like ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidos());
            pst.setString(3, usuario.getContra());
            pst.setInt(4, usuario.getPermiso());
            pst.setBoolean(5, true);
            pst.setString(6, usuario.getNick());
            pst.executeUpdate();
            updateVentaLista(usuario);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private void updateVentaLista(Usuario usuario){
        for (Usuario u : listaUsuarios){
            if (u.getNick().equalsIgnoreCase(usuario.getNick())){
                u.setNombre(usuario.getNombre());
                u.setApellidos(usuario.getApellidos());
                u.setContra(usuario.getContra());
                u.setPermiso(usuario.getPermiso());
                u.setExiste(usuario.isExiste());
            }
        }
    }

    public void updateExiste(boolean exists, String nick){
        Usuario user = buscarUsuario(nick);
        user.setExiste(exists);
        updateUsuario(user);
    }

    public void conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/concesionario?useSSL=false", "root", "");
            conexion = cn;
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }
    }
}
