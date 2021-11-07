package modelo;

import controllers.ControllerConexion;
import controllers.ICRUD;
import entidades.Moto;

import java.sql.Connection;
import java.util.ArrayList;

public class MotoModel implements ICRUD {

    private ArrayList<Moto> motos;
    private ControllerConexion cnControl;
    private Connection conexion;

    public MotoModel(){
        this.motos = new ArrayList<>();
        this.cnControl = new ControllerConexion();
    }

    private void rellenarArray(){

    }

    @Override
    public Boolean crear(Object o) {
        return null;
    }

    @Override
    public Object leer(Object o, int id) {
        return null;
    }

    @Override
    public Object leerString(Object o, String pk) {
        return null;
    }

    @Override
    public void listar(Object o) {

    }

    @Override
    public Boolean actualizar(Object o, int id) {
        return null;
    }

    @Override
    public Boolean eliminar(Object o, int id) {
        return null;
    }
}
