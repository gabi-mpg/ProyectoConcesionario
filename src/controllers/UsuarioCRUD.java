package controllers;

import entidades.Usuario;
import models.UsuarioModel;

import java.util.ArrayList;

/**
 * Dentro de esta clase recogemos todos los metodos que representan los metodos del modelo de usuario.
 * De este modo, esta clase se usa para hacer de intermediaria entre las vistas y el modelo. Para mas informacion
 * al respecto, consultar las explicaciones de los metodos del modelo.
 */
public class UsuarioCRUD {

    private UsuarioModel model;
    public UsuarioCRUD(){
        this.model = new UsuarioModel();
    }

    public ArrayList<Usuario> gesListaUsuarios(){
        return model.getListaUsuarios();
    }

    public boolean agregarUsuario(String nick, String nombre, String apellidos, String contra, int nivel){
        if (model.buscarUsuario(nick) == null){
            model.addUsuario(new Usuario(nick, nombre, apellidos, contra, nivel, true));
            return true;
        } else {
            return false;
        }
    }

    public Usuario buscarUsuario(String pk){
        return model.buscarUsuario(pk);
    }

    public boolean usuarioExiste(String pk){
        return model.usuarioExiste(pk);
    }


    public void removeUsuario(String pk){
        model.removeUsuario(pk);
    }

    public void updateExiste(boolean existe, String pk){
        model.updateExiste(existe, pk);
    }

    public void updateUsuario(Usuario usuario){
        model.updateUsuario(usuario);
    }


}
