/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbasedatos;

import Interfaz.configInterface;
import Interfaz.loginInterface;
import Interfaz.mainInterface;

import javax.swing.*;
import java.sql.Connection;

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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                loginInterface interfaz = new loginInterface();
            }
        });


    }
    
}
