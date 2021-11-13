package controllers;

import entidades.Cliente;
import entidades.Moto;
import entidades.Venta;
import modelo.EntidadesModels.VentaModel;

import java.util.ArrayList;

public class VentaCRUD {

    private VentaModel model;
    public VentaCRUD(){
        model = new VentaModel();
    }

    public ArrayList<Venta> getListaVentas(){
        return model.getListaVentas();
    }

    public boolean agregarVenta(String matricula, String DNI, float precio, String idUsuario){
        if (model.buscarExistencia(matricula, DNI)){
            model.addVenta(new Venta(matricula, DNI, precio, idUsuario, 1));
            return true;
        } else {
            return false;
        }
    }

    public Moto buscarMoto(String matricula){
        return model.buscarMoto(matricula);
    }

    public Cliente buscarCliente(String dni){
        return model.buscarCliente(dni);
    }

    public boolean comprobarMatricula(String matricula){
        return matricula.matches("^[0-9]{4}[A-Za-z]{3}$");
    }
    
    public boolean comprobarDNI(String dni){
        return dni.matches("[0-9]{7,8}[A-Za-z]");
    }
    
    public Venta buscarVenta(String pk){
        return model.buscarVenta(pk);
    }

    public ArrayList<Venta> buscarVentasCliente(String dni){
        return model.buscarVentasCliente(dni);
    }

    public ArrayList<Venta> buscarVentasNick(String nick){
        return model.buscarVentasNick(nick);
    }

    public Venta buscarVenta(int pk){
        return model.buscarVenta(pk);
    }

    public boolean ventaExiste(String pk){
        return model.ventaExiste(pk);
    }


    public boolean ventaExiste(int pk){
        return model.ventaExiste(pk);
    }

    public void removeVenta(String pk){
        model.removeVenta(pk);
    }

    public void updateVenta(Venta venta){
        model.updateVenta(venta);
    }

    public void cambioExsite(Venta venta){
        model.cambiarExiste(venta);
    }


}
