package controllers;

import entidades.Cliente;
import modelo.ClienteModel;

import java.util.ArrayList;

public class ClienteCRUD {

    public ClienteCRUD(){
        ClienteModel.conectar();
    }

    public ArrayList<Cliente> getListaClientes(){
        return ClienteModel.getListaClientes();
    }

    public boolean agregarCliente(String dni, String nombre, String apellido, String direcc){
        if (ClienteModel.buscarCliente(dni) != null){
            return false;
        } else {
            ClienteModel.addCliente(new Cliente(dni, apellido, nombre, direcc));
            return true;
        }
    }

    public boolean comprobarDNI(String dni){
        return dni.matches("[0-9]{7,8}[A-Za-z]");
    }

    public Cliente buscarCliente(String pk){
        return ClienteModel.buscarCliente(pk);
    }

    public void listarCliente(String pk){
        if (buscarCliente(pk) != null){
            System.out.println(buscarCliente(pk).toString());
        } else{
            System.out.println("El cliente no existe en la bd");
        }
    }

    public void removeCliente(String pk){
        if (ClienteModel.removeCliente(pk)){
            System.out.println("Cliente eliminado con exito");
        } else {
            System.out.println("Error eliminando el cliente");
        }
    }

    public void updateCliente(Cliente cliente){
        if (ClienteModel.updateCliente(cliente)){
            System.out.println("Cliente actualizado con exito");
        } else {
            System.out.println("Error actualizando el cliente");
        }
    }

}
