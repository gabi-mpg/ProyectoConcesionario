package controllers;

import entidades.Moto;
import modelo.MotoModel;

import java.util.ArrayList;

public class MotoCRUD {

    public ArrayList<Moto> getListaMotos(){
        return MotoModel.getListaMotos();
    }

    public boolean agregarMoto(String matricula, String color, String marca, int tanque){
        if (MotoModel.buscarMoto(matricula) != null){
            return false;
        } else {
            MotoModel.addMoto(new Moto(matricula, marca, color, tanque));
            return true;
        }
    }
    //en el update ponemos todos los campos y los que deje en blanco o ponga un guion se mandan los preexistentes, sino se mandan los nuevos
    //agregar el removeMoto, buscar moto, updateMoto
//
//    public Moto buscarMoto(String matricula){
//        return
//    }

}
