package controllers;

import entidades.Cliente;
import entidades.Moto;
import entidades.Venta;
import modelo.VentaModel;

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
            System.out.println("Venta CRUD if de matricula y dni existen");
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

//    public boolean ventaExisteDNI(String pk){
//        return model.ventaExisteDNI(pk);
//    }

    public boolean ventaExiste(int pk){
        System.out.println(model.ventaExiste(pk));
        return model.ventaExiste(pk);
    }

    public void listarVenta(String pk){
        if (buscarVenta(pk) != null){
            System.out.println(buscarVenta(pk).toString());
        } else{
            System.out.println("La moto no existe en la bd");
        }
    }

    public void removeVenta(String pk){
        if (model.removeVenta(pk)){
            System.out.println("Venta eliminada con exito");
        } else {
            System.out.println("Error eliminando la venta");
        }
    }

//    public void removeVenta(int pk){
//        if (model.removeVenta(pk)){
//            System.out.println("Venta eliminada con exito");
//        } else {
//            System.out.println("Error eliminando la venta");
//        }
//    }

    public void updateVenta(Venta venta){
        if (model.updateVenta(venta)){
            System.out.println("Venta actualizada con exito");
        } else {
            System.out.println("Error actualizando la venta");
        }
    }

    public void cambioExsite(Venta venta){
        if(model.cambiarExiste(venta)){
            System.out.println("Moto cambiada");
        }else{
            System.out.println("No se ha podido cambiar");
        }
    }


}
