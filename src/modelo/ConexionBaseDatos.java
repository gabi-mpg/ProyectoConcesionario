/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import views.Ventanas.Interfaces.interfazLogin;

/**
 *
 * @author chris
 */
public class ConexionBaseDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Esto es para hacer pruebas evitando tener que logearse cada vez
        //new mainInterface(new MNGDB(new JPanel()).getConexion(),1,"Prueba");
        new interfazLogin();
        //new NewJFrame();


    }
    
}
