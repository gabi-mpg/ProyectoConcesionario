package controllers;

import entidades.Usuario;
import modelo.UsuarioModel;

import java.util.ArrayList;

public class UsuarioCRUD {

    public UsuarioCRUD(){
        UsuarioModel.conectar();
    }

    public ArrayList<Usuario> gesListaUsuarios(){
        return UsuarioModel.getListaUsuarios();
    }

    public boolean agregarUsuario(String nick, String nombre, String apellidos, String contra, int nivel){
        if (UsuarioModel.buscarUsuario(nick) == null){
            UsuarioModel.addUsuario(new Usuario(nick, nombre, apellidos, contra, nivel));
            return true;
        } else {
            return false;
        }
    }

    public Usuario buscarUsuario(String pk){
        return UsuarioModel.buscarUsuario(pk);
    }

    public void listarUsuario(String pk){
        if (buscarUsuario(pk) != null){
            System.out.println(buscarUsuario(pk).toString());
        } else{
            System.out.println("El usuario no existe en la bd");
        }
    }

    public void removeUsuario(String pk){
        if (UsuarioModel.removeUsuario(pk)){
            System.out.println("Usuario eliminado con exito");
        } else {
            System.out.println("Error eliminando el usuario");
        }
    }

    public void updateUsuario(Usuario usuario){
        if (UsuarioModel.updateUsuario(usuario)){
            System.out.println("Usuario actualizado con exito");
        } else {
            System.out.println("Error actualizando el usuario");
        }
    }
}
