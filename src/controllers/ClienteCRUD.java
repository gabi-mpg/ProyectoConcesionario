package controllers;

import entidades.Cliente;
import entidades.Moto;
import modelo.ClienteModel;

import java.sql.Connection;
import java.util.ArrayList;

public class ClienteCRUD {

    private ClienteModel model;

    public ClienteCRUD(){
        this.model = new ClienteModel();
    }

    public ArrayList<Cliente> getListaClientes(){
        return model.getListaClientes();
    }

    public boolean agregarCliente(String dni, String nombre, String apellido, String direcc){
        if (model.buscarCliente(dni) != null){
            updateCliente(new Cliente(dni,nombre,apellido,direcc,1));
            return true;
        } else {
            model.addCliente(new Cliente(dni, apellido, nombre, direcc, 1));
            return true;
        }
    }

    public boolean comprobarDNI(String dni){
        return dni.matches("[0-9]{7,8}[A-Za-z]");
    }

    public void cambiarEstadoCliente(String dni){
        Cliente cliente = buscarCliente(dni);
        removeCliente(dni);
        cliente.setExiste(1);
        model.addCliente(cliente);
    }

    public Cliente buscarCliente(String pk){
        return model.buscarCliente(pk);
    }

    public boolean clienteExiste(String pk){
        return model.clienteExiste(pk);
    }


    public void removeCliente(String pk){
        model.removeCliente(pk);
    }

    public void updateExiste(int existe, String pk){
        model.updateExiste(existe, pk);
    }


    public void updateCliente(Cliente cliente){
        model.updateCliente(cliente);
    }

}
