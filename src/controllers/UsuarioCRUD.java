package controllers;

import entidades.Usuario;
import modelo.EntidadesModels.UsuarioModel;

import java.util.ArrayList;

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
