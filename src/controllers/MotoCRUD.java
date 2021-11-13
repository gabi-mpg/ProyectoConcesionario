package controllers;

import entidades.Moto;
import modelo.ClienteModel;
import modelo.MotoModel;

import java.util.ArrayList;
import java.util.Locale;

public class MotoCRUD {

    private MotoModel model;
    public MotoCRUD(){
        this.model = new MotoModel();
    }

    public ArrayList<Moto> getListaMotos(){
        return model.getListaMotos();
    }

    public boolean agregarMoto(String matricula, String color, String marca, int tanque){
        if (model.buscarMoto(matricula) != null){
            return false;
        } else {
            model.addMoto(new Moto(matricula, marca, color, tanque, 1));
            return true;
        }
    }

    public boolean comprobarMatricula(String matricula){
        matricula = matricula.toUpperCase();
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }

    public Moto buscarMoto(String pk){
        return model.buscarMoto(pk);
    }

    public boolean motoExiste(String pk){
        return model.motoExiste(pk);
    }

    public void listarMoto(String pk){
        if (buscarMoto(pk) != null){
            System.out.println(buscarMoto(pk).toString());
        } else{
            System.out.println("La moto no existe en la bd");
        }
    }

    public void removeMoto(String pk){
        model.removeMoto(pk);
    }

    public void updateExiste(int existe, String pk){
        model.updateExiste(existe, pk);
    }

    public void updateMoto(Moto moto){
        model.updateMoto(moto);
    }

}
