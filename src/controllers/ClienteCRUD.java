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
            return false;
        } else {
            model.addCliente(new Cliente(dni, apellido, nombre, direcc, true));
            return true;
        }
    }

    public boolean comprobarDNI(String dni){
        return dni.matches("[0-9]{7,8}[A-Za-z]");
    }

    public Cliente buscarCliente(String pk){
        return model.buscarCliente(pk);
    }

    public boolean clienteExiste(String pk){
        return model.clienteExiste(pk);
    }

    public void listarCliente(String pk){
        if (buscarCliente(pk) != null){
            System.out.println(buscarCliente(pk).toString());
        } else{
            System.out.println("El cliente no existe en la bd");
        }
    }

    public void removeCliente(String pk){
        if (model.removeCliente(pk)){
            System.out.println("Cliente eliminado con exito");
        } else {
            System.out.println("Error eliminando el cliente");
        }
    }

    public void updateExiste(boolean existe, String pk){
        model.updateExiste(existe, pk);
    }

    public void updateCliente(Cliente cliente){
        if (model.updateCliente(cliente)){
            System.out.println("Cliente actualizado con exito");
        } else {
            System.out.println("Error actualizando el cliente");
        }
    }
    public static void main(String[] args) {
        ClienteCRUD mc = new ClienteCRUD();
        //mc.listarMoto("0677fwj");
        //mc.listarMoto("5647gfd");
        //Cliente cliente = new Cliente("79070841S", "Gabriela", "Mercado Perez", "Los Adelantaods, 11");
        //mc.agregarCliente("79070841S", "Gabriela", "Mercado Perez", "Los Adelantaods, 11");
        //mc.agregarCliente("79070842Q", "Lucia", "Mercado Perez", "Los Adelantaods, 11");
        //System.out.println(cliente.toString());
        Cliente luci =mc.buscarCliente("79070842Q");
        Cliente gabi =mc.buscarCliente("79070841S");
        luci.setNombre("Lucia");
        luci.setApellido("Mercado Perez");
        gabi.setNombre("Gabriela");
        gabi.setApellido("Mercado Perez");
        mc.updateCliente(luci);
        mc.updateCliente(gabi);
    }
}
