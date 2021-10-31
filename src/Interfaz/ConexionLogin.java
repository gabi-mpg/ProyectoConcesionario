package Interfaz;

import conexionbasedatos.MNGDB;

import javax.swing.*;
import java.awt.*;

public class ConexionLogin extends JFrame {

    private MNGDB conexion;
    private boolean estadoConexion = false;
    private JPanel panelIndicador;
    private JPanel panelGeneral;
    private JButton botonConexion, botonLogin;
    private JLabel conexionEstablecida, user, pass;

    public ConexionLogin (){
        this.conexion = new MNGDB(this);
        initComponents();
        //habilitarPaneles(false,panelGeneral);
        panelIndicador.setBackground(Color.RED);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void initComponents(){
        panelGeneral = new JPanel();
        panelGeneral.setPreferredSize(new Dimension(500, 400));
        panelIndicador = new JPanel();
        panelIndicador.setPreferredSize(new Dimension(500,5));
        add(panelGeneral,BorderLayout.CENTER);
        add(panelIndicador,BorderLayout.NORTH);
    }

    private void anadirBotones(){
        botonLogin = new JButton("Iniciar sesión");
        botonConexion = new JButton("Establecer conexión");
        botonConexion.setPreferredSize(new Dimension(40,20));
        botonLogin.setPreferredSize(new Dimension(40,20));
        add(botonConexion, BorderLayout.NORTH);
        panelGeneral.add(botonLogin, BorderLayout.SOUTH);
    }

    private void habilitarPaneles(boolean indicador, JPanel componente){
        for(Component compo : componente.getComponents()){
            compo.setEnabled(indicador);
        }

    }
}
