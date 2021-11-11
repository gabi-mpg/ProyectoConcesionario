package controllers;

import entidades.Cliente;
import entidades.Usuario;
import modelo.UsuarioModel;

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

    public void listarUsuario(String pk){
        if (buscarUsuario(pk) != null){
            System.out.println(buscarUsuario(pk).toString());
        } else{
            System.out.println("El usuario no existe en la bd");
        }
    }

    public void removeUsuario(String pk){
        if (model.removeUsuario(pk)){
            System.out.println("Usuario eliminado con exito");
        } else {
            System.out.println("Error eliminando el usuario");
        }
    }

    public void updateExiste(boolean existe, String pk){
        model.updateExiste(existe, pk);
    }

    public void updateUsuario(Usuario usuario){
        if (model.updateUsuario(usuario)){
            System.out.println("Usuario actualizado con exito");
        } else {
            System.out.println("Error actualizando el usuario");
        }
    }


}
