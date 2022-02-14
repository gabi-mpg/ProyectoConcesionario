package controllers;

import models.MNGDB;
import models.Config;

import java.sql.Connection;

public class ControllerConexion {

    private final MNGDB conexionMng;
    private final Config configuracion;

    public ControllerConexion(){
        this.conexionMng = new MNGDB();
        this.configuracion = new Config();
    }

    public void setRegistros(){
        conexionMng.setRegistros(configuracion.getConfig());
    }

    public String[] getRegistros(){
        return configuracion.getConfig();
    }

    public boolean conectarComprobar(){
        return conexionMng.establecerConexionComprobar();
    }

    public Connection conectar(){
        return conexionMng.conectar();
    }

    public boolean cerrarCn(){
        return conexionMng.cerrarConexion();
    }

    public int login(String user, String passw){
        return conexionMng.iniciarSesion(user, passw);
    }


}
