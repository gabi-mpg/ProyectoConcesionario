package views.Ventanas.crudUsuarios;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controllers.UsuarioCRUD;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author chris
 */
public class insertarUsuario extends JDialog {


    public insertarUsuario() {
        setModal(true);
        setLocationRelativeTo(null);
        setSize(260,410);
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        setTitle("Insertar usuario");
        setIconImage(Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES+"iconoInsertar.png"));
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        iconoInsertar = new javax.swing.JLabel();
        textoNick = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoApellidos = new javax.swing.JTextField();
        textoContra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonInsertar = new javax.swing.JButton();
        cnUser = new UsuarioCRUD();

        setPreferredSize(new java.awt.Dimension(230, 390));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Insertar un nuevo usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(16, 32, 6, 32);
        add(jLabel1, gridBagConstraints);

        iconoInsertar.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"iconoInsertar.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        add(iconoInsertar, gridBagConstraints);

        textoNick.setMinimumSize(new java.awt.Dimension(130, 24));
        textoNick.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoNick, gridBagConstraints);

        textoNombre.setMinimumSize(new java.awt.Dimension(130, 24));
        textoNombre.setPreferredSize(new java.awt.Dimension(130, 24));
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoMatriculaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoNombre, gridBagConstraints);

        textoApellidos.setMinimumSize(new java.awt.Dimension(130, 24));
        textoApellidos.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoApellidos, gridBagConstraints);

        textoContra.setMinimumSize(new java.awt.Dimension(130, 24));
        textoContra.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoContra, gridBagConstraints);

        jLabel3.setText("Nick");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Apellidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Contraseña");
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
        add(botonInsertar, gridBagConstraints);

        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insertarUser();
            }
        });
    }// </editor-fold>

    private void textoMatriculaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void insertarUser(){
            String nick = textoNick.getText();
            if (cnUser.usuarioExiste(nick)){
                if(!cnUser.buscarUsuario(nick).isExiste()){
                    cnUser.updateExiste(true, nick);
                    JOptionPane.showMessageDialog(this, "Usuario agregado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,"Usuario agregado","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
            }

            } else {
                String nombre = textoNombre.getText();
                String apellido = textoApellidos.getText();
                String contra = textoContra.getText();
                nick = textoNick.getText();
                if(!contra.isEmpty() && !nick.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty()){
                    if(cnUser.agregarUsuario(nick, nombre, apellido, contra, 0)){
                        JOptionPane.showMessageDialog(this,"Usuario agregado","Éxito",JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JTextField textoContra;
    private javax.swing.JTextField textoApellidos;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoNick;
    private UsuarioCRUD cnUser;

    // End of variables declaration
}
