/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas.Interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import modelo.config;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utils.Utilidades.jMensaje;
/**
 *
 * @author chris
 */
public class interfazConfig extends javax.swing.JFrame implements ActionListener {

    private final String[] configuracionRecogida;
    private final config configuracion;
    private javax.swing.JButton boton;
    private javax.swing.JLabel configWallpaper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textoClave;
    private javax.swing.JTextField textoRuta;
    private javax.swing.JTextField textoUser;


    public interfazConfig(String[] config, config configuracion) {
        initComponents();
        colorTextos();
        this.configuracionRecogida = config;
        this.configuracion = configuracion;
        modificarTexto();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        configWallpaper.setSize(370, 410);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.boton.addActionListener(this);

    }


    private void colorTextos() {
        this.jLabel1.setForeground(Color.WHITE);
        this.jLabel2.setForeground(Color.WHITE);
        this.jLabel3.setForeground(Color.WHITE);
    }

    private void modificarTexto() {
        textoRuta.setText(configuracionRecogida[0]);
        textoUser.setText(configuracionRecogida[1]);
        textoClave.setText(configuracionRecogida[2]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ruta, user, pass;
        ruta = textoRuta.getText();
        user = textoUser.getText();
        pass = textoClave.getText();
        if (ruta.isEmpty() | user.isEmpty()) {
            jMensaje(this, "No se ha introducida toda la información", "Falta informacion", 2);
        } else {
            String[] registros = {ruta, user, pass};
            this.configuracion.setConfig(registros);
            this.dispose();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        setTitle("Concesonario Mercado Corral");
        Image icono = Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES + "icono.png");
        setIconImage(icono);

        JPanel panelPrincipal = new JPanel();
        boton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoClave = new javax.swing.JTextField();
        textoRuta = new javax.swing.JTextField();
        textoUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        configWallpaper = new javax.swing.JLabel();

        java.awt.GridBagConstraints gridBagConstraints;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(false);

        panelPrincipal.setBackground(new java.awt.Color(102, 102, 255));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(300, 400));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        boton.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        boton.setText("Guardar configuración");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(29, 0, 0, 0);
        panelPrincipal.add(boton, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel1.setText("URL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(33, 40, 0, 5);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        textoClave.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(33, 35, 29, 22);
        panelPrincipal.add(textoClave, gridBagConstraints);

        textoRuta.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(62, 35, 29, 22);
        panelPrincipal.add(textoRuta, gridBagConstraints);

        textoUser.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(33, 35, 29, 22);
        panelPrincipal.add(textoUser, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel2.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 40, 0, 10);
        panelPrincipal.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel3.setText("Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 40, 0, 10);
        panelPrincipal.add(jLabel3, gridBagConstraints);

        configWallpaper.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES + "fondoConfig.jpg")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        panelPrincipal.add(configWallpaper, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }


}
