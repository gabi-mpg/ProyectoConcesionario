package controllers;

import entidades.Moto;
import modelo.MotoModel;

import java.util.ArrayList;

public class MotoCRUD {

    public MotoCRUD(){
        MotoModel.conectar();
    }

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

    public boolean comprobarMatricula(String matricula){
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }

    public Moto buscarMoto(String pk){
        return MotoModel.buscarMoto(pk);
    }

    public void listarMoto(String pk){
        if (buscarMoto(pk) != null){
            System.out.println(buscarMoto(pk).toString());
        } else{
            System.out.println("La moto no existe en la bd");
        }
    }

    public void removeMoto(String pk){
        if (MotoModel.removeMoto(pk)){
            System.out.println("Moto eliminada con exito");
        } else {
            System.out.println("Error eliminando la moto");
        }
    }

    public void updateMoto(Moto moto){
        if (MotoModel.updateMoto(moto)){
            System.out.println("Moto actualizada con exito");
        } else {
            System.out.println("Error actualizando la moto");
        }
    }

    public static void main(String[] args) {
        MotoCRUD mc = new MotoCRUD();
        //mc.listarMoto("0677fwj");
        //mc.listarMoto("5647gfd");
        Moto moto = mc.buscarMoto("0677fwj");
        moto.setMarca("Suzuki");
        moto.setColor("Verde");
        //System.out.println(moto.toString());

        mc.updateMoto(moto);
        mc.listarMoto("0677fwj");
    }
    //en el update ponemos todos los campos y los que deje en blanco o ponga un guion se mandan los preexistentes, sino se mandan los nuevos
    //agregar el removeMoto, buscar moto, updateMoto
//
//    public Moto buscarMoto(String matricula){
//        return
//    }

}
