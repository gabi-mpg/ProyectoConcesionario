package controllers;

import entidades.Cliente;
import models.ClienteModel;

import java.util.ArrayList;

/**
 * Clase que recoge los metodos que hacen de intermediarios entre el modelo de cliente y la vista del mismo
 */
public class ClienteCRUD {

    private ClienteModel model;

    /**
     * Constructor de la clase
     */
    public ClienteCRUD(){
        this.model = new ClienteModel();
    }

    public ArrayList<Cliente> getListaClientes(){
        return model.getListaClientes();
    }

    /**
     * Metodo que recibe los atributos de un cliente, comprueba si existe ya o no. Si existe llama
     * al update del modelo y sino, llama al metodo del modelo que los agrega.
     * @param dni
     * @param nombre
     * @param apellido
     * @param direcc
     * @return
     */
    public boolean agregarCliente(String dni, String nombre, String apellido, String direcc){
        if (model.buscarCliente(dni) != null){
            updateCliente(new Cliente(dni,nombre,apellido,direcc,1));
            return true;
        } else {
            model.addCliente(new Cliente(dni, apellido, nombre, direcc, 1));
            return true;
        }
    }

    /**
     * Metodo para comprobar que el patron del dni es correcto.
     * @param dni Recibe el String correspondiente al DNI
     * @return
     */
    public boolean comprobarDNI(String dni){
        return dni.matches("[0-9]{7,8}[A-Za-z]");
    }

    /**
     * Busca y devuelve un Cliente usando la pk.
     * @param pk Primary key de cliente.
     * @return Devuelve el Cliente que coincida.
     */
    public Cliente buscarCliente(String pk){
        return model.buscarCliente(pk);
    }

    /**
     * Con este metodo comprobamos si existe algun cliente que coincida
     * con el dni dado
     * @param pk String correspondiente al dni que se quiere comprobar
     * @return Devuelve un boolean de si existe o no
     */
    public boolean clienteExiste(String pk){
        return model.clienteExiste(pk);
    }

    /**
     * Metodo que llama al metodo del modelo que se encarga de eliminar
     * el cliente haciendo uso de la primary key.
     * @param pk Valor correspondiente al dni del cliente a eliminar
     */
    public void removeCliente(String pk){
        model.removeCliente(pk);
    }

    /**
     * Metodo que llama al metodo encargado de actulizar el estado del cliente.
     * @param existe Valor que se le asignara al campo existe del cliente.
     * @param pk DNI del cliente del que se quiere modificar el valor.
     */
    public void updateExiste(int existe, String pk){
        model.updateExiste(existe, pk);
    }

    /**
     * Metodo usado para llamar al modelo y que actulice un cliente.
     * @param cliente Recibe un objeto de tipo cliente, el que se quiere actualizar.
     */
    public void updateCliente(Cliente cliente){
        model.updateCliente(cliente);
    }

}
