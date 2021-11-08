package controllers;

import modelo.MNGDB;
import modelo.config;

import java.sql.Connection;

public class ControllerConexion {

    private final MNGDB conexionMng;
    private final config configuracion;

    public ControllerConexion(){
        this.conexionMng = new MNGDB();
        this.configuracion = new config();
    }

    public void setRegistros(){
        conexionMng.setRegistros(configuracion.getConfig());
    }

    public boolean estadoCn(){
        return conexionMng.isEstado();
    }

    public boolean conectar(){
        return conexionMng.establecerConexion();
    }

    public boolean cerrarCn(){
        return conexionMng.cerrarConexion();
    }

    public int login(String user, String passw){
        return conexionMng.iniciarSesion(user, passw);
    }

    public Connection getConexion(){
        return conexionMng.getConexion();
    }

}
