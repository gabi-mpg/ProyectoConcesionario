package controllers;

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

    public boolean agregarVenta(String matricula, String DNI, double precio, String idUsuario){
        if (model.buscarExistencia(matricula, DNI)){
            model.addVenta(new Venta(matricula, DNI, precio, idUsuario));
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobarMatricula(String matricula){
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }
    
    public boolean comprobarDNI(String dni){
        return dni.matches("[0-9]{7,8}[A-Za-z]");
    }
    
    public Venta buscarVenta(String pk){
        return model.buscarVenta(pk);
    }

    public boolean ventaExiste(String pk){
        return model.ventaExiste(pk);
    }

    public void listarVenta(String pk){
        if (buscarVenta(pk) != null){
            System.out.println(buscarVenta(pk).toString());
        } else{
            System.out.println("La moto no existe en la bd");
        }
    }

    public void removevENTA(int pk){
        if (model.removeVenta(pk)){
            System.out.println("Venta eliminada con exito");
        } else {
            System.out.println("Error eliminando la venta");
        }
    }

    public void updateVenta(Venta venta){
        if (model.updateVenta(venta)){
            System.out.println("Venta actualizada con exito");
        } else {
            System.out.println("Error actualizando la venta");
        }
    }
}
