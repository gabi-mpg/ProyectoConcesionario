package models;

import controllers.ControllerConexion;
import entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que contiene todos los metodos encargados de gestionar los usuarios y las operaciones
 * que se hacen con los mismos atacando a la base de datos.
 */
public class UsuarioModel {
    private static ArrayList<Usuario> listaUsuarios;
    private static ControllerConexion cnControl;
    private static Connection conexion;

    /**
     * Constructor de la clase.
     */
    public UsuarioModel(){
        listaUsuarios = new ArrayList<>();
        cnControl = new ControllerConexion();
        conexion = cnControl.conectar();
        saveUsuario();
    }

    /**
     * Metodo que recoge todos los usuarios de la base de datos y los guarda en el ArrayList
     * de la clase.
     */
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

    /**
     * Metodo que busca un usuario, usando el nick como clave primaria, en el
     * ArrayList de la clase que los contiene.
     * @param pk Recibe el nick del usuario a buscar.
     * @return Devuelve el objeto de tipo usuario correspondiente al nick dado.
     */
    public Usuario buscarUsuario(String pk){
        saveUsuario();
        for(Usuario u : listaUsuarios){
            if (u.getNick().equalsIgnoreCase(pk)){
                return u;
            }
        }
        return null;
    }

    /**
     * Metodo que comprueba si un usuario existe o no, buscando en el ArrayList de la clase, usando la primary
     * key.
     * @param pk String correspondiente al nick del que se quiere comprobar su existencia.
     * @return Devuelve un booleano segun el resultado de la busqueda.
     */
    public boolean usuarioExiste(String pk){
        return buscarUsuario(pk) != null;
    }

    /**
     * Metodo que devuelve el arrayList de la clase que hace de contenedor de todos
     * los usuarios existentes. Siempre refresca los datos antes de devolverlo, llamando al metodo
     * saveUsuario().
     * @return Devuelve el ArrayList lista de usuarios.
     */
    public ArrayList<Usuario> getListaUsuarios(){
        saveUsuario();
        return listaUsuarios;
    }

    /**
     * Guarda el nuevo usuario en la base de datos y actualiza el ArrayList de la clase llamando
     * al metodo saveUsuario()
     * @param usuario Recibe el nuevo usuario a guardar en la base de datos.
     */
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

    /**
     * Elimina a un usuario de la base de datos utilizando la funcion sql creada con esa finalidad.
     * @param pk Recibe el nick del usuario que se quiere eliminar.
     * @return Devuelve un booleano indicando el exito que ha tenido la accion.
     */
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

    /**
     * Metodo que actualiza el usuario en la base de datos, usando todos los valores del usuario recibido. Tras actulizarlo en
     * la base de datos, llama al metodo encargado de actulizar el usuario en la lista general de los usuarios.
     * @param usuario Recibe el usuario entero que se ha de actualizar.
     * @return Devuelve un booleano que indica el exito de la accion.
     */
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
            updateUserLista(usuario);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    /**
     * Actuliza los valores del usuario actualizado en el ArrayList de la clase, de modo que los valores de la base
     * de datos y de la lista que contiene el programa, coincidan.
     * @param usuario Recibe el usuario a actulizar
     */
    private void updateUserLista(Usuario usuario){
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

    /**
     * Cambia el estado de un usuario en la base de datos, al estado que recibe por parametro. Para ello, recoge el usuario coincidente
     * con el nick, settea el nuevo valor y llama al metodo de esta clase que actualiza el usuario, pasandole el usuario recogido.
     * @param exists Recibe el valor que se le ha asignar en la BD: 0 si ya no esta disponible y 1 si esta disponible.
     * @param nick Nick del usuario que actulizaremos.
     */
    public void updateExiste(boolean exists, String nick){
        Usuario user = buscarUsuario(nick);
        user.setExiste(exists);
        updateUsuario(user);
    }

}
