/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import views.interfaces.interfazLogin;

/**
 * Clase que recoge la instancia de la interfaz de login, donde se dispara la ejecucion del resto del programa
 * @author chris
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Esto es para hacer pruebas evitando tener que logearse cada vez
        //new mainInterface(1,"delcorral",new ControllerConexion());
        new interfazLogin();
        //new mainInterface(1, "fenixabi", new ControllerConexion());
        //new NewJFrame();




    }
    
}
