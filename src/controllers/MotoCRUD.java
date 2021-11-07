package controllers;

import entidades.Moto;
import modelo.MotoModel;

public class MotoCRUD {

    public boolean crearMoto(String matricula, String color, String marca, int tanque){
        if (MotoModel.buscarMoto(matricula) != null){
            return false;
        } else {
            MotoModel.addMoto(new Moto(matricula, marca, color, tanque));
            return true;
        }
    }
//
//    public Moto buscarMoto(String matricula){
//        return
//    }

}
