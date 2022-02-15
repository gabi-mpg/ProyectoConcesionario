package views.crudMotos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controllers.ControllerConexion;
import controllers.MotoCRUD;
import entidades.Moto;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 *
 * @author chris
 */
public class insertarMoto extends javax.swing.JDialog {


    private String ruta =  System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"+File.separator
            +"imagenes"+ File.separator;
    private MotoCRUD cnMoto;
    private boolean motoDigito = false;

    public insertarMoto() {
        cnMoto = new MotoCRUD();
        setModal(true);
        setSize(240,410);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    /**
     * Método que se encarga de inciializar todos los componentes de la interfaz graifca
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        setTitle("Insertar moto");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ruta+"iconoInsertar.png"));

        jLabel1 = new javax.swing.JLabel();
        iconoInsertar = new javax.swing.JLabel();
        textoTanque = new javax.swing.JTextField();
        textoMatricula = new javax.swing.JTextField();
        textoMarca = new javax.swing.JTextField();
        textoColor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonInsertar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(230, 390));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Insertar una nueva moto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(16, 32, 6, 32);
        add(jLabel1, gridBagConstraints);

        iconoInsertar.setIcon(new javax.swing.ImageIcon(ruta+"iconoInsertar.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(iconoInsertar, gridBagConstraints);

        textoTanque.setMinimumSize(new java.awt.Dimension(130, 24));
        textoTanque.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoTanque, gridBagConstraints);

        textoMatricula.setMinimumSize(new java.awt.Dimension(130, 24));
        textoMatricula.setPreferredSize(new java.awt.Dimension(130, 24));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoMatricula, gridBagConstraints);

        textoMarca.setMinimumSize(new java.awt.Dimension(130, 24));
        textoMarca.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoMarca, gridBagConstraints);

        textoColor.setMinimumSize(new java.awt.Dimension(130, 24));
        textoColor.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoColor, gridBagConstraints);

        jLabel3.setText("Tanque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Matricula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Color");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Marca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel6, gridBagConstraints);

        botonInsertar.setText("Insertar registro");
        botonInsertar.setPreferredSize(new java.awt.Dimension(240, 370));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarCampos();
            }
        });
        add(botonInsertar, gridBagConstraints);
        textoTanque.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String s = textoTanque.getText();{
                    for (int i = 0 ; i < s.length() ; i++){
                        if(Character.isDigit(s.charAt(i))){
                            motoDigito = true;
                        }else{
                            motoDigito = false;
                        }
                    }
                }
            }
        });
    }// </editor-fold>


    /**
     * En este método se comprueba que todos los campos introducidos para la información de la moto sean correctos.
     * Además se comprueba que la moto exista o no exista en la base de datos, al igual que la validez del formato
     * de cada valor
     */
    private void comprobarCampos(){
        String matricula = textoMatricula.getText();
        if (cnMoto.motoExiste(matricula)){
            Moto moto = cnMoto.buscarMoto(matricula);
            moto.setExiste(1);
            cnMoto.updateMoto(moto);
            JOptionPane.showMessageDialog(this,"Moto agregada","Éxito",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            String marca = textoMarca.getText();
            String color = textoColor.getText();
            String tanque = textoTanque.getText();
            if(cnMoto.comprobarMatricula(matricula) && !marca.isEmpty() && !color.isEmpty() && motoDigito){
                if(cnMoto.agregarMoto(matricula,marca,color,Integer.parseInt(tanque))){
                    JOptionPane.showMessageDialog(this,"Moto agregada","Éxito",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"No se ha podido agregar","Error",JOptionPane.ERROR_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(this,"Faltan campos","Informacion",JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    // Variables declaration - do not modify
    private javax.swing.JButton botonInsertar;
    private javax.swing.JLabel iconoInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textoColor;
    private javax.swing.JTextField textoMarca;
    private javax.swing.JTextField textoMatricula;
    private javax.swing.JTextField textoTanque;
    // End of variables declaration
}
