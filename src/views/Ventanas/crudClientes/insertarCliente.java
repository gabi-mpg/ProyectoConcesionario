package views.Ventanas.crudClientes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.ClienteCRUD;
import entidades.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.regex.Pattern;


/**
 *
 * @author chris
 */
public class insertarCliente extends javax.swing.JFrame {

    private String ruta =  System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"+File.separator
            +"imagenes"+ File.separator;
    private Cliente cliente;
    private ClienteCRUD cnCliente;

    public insertarCliente() {
        this.cnCliente = new ClienteCRUD();
        this.setVisible(true);
        setLocationRelativeTo(null);
        setSize(240,410);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        iconoInsertar = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        textoDNI = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonInsertar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(230, 390));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Insertar un nuevo cliente");
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

        textoDireccion.setMinimumSize(new java.awt.Dimension(130, 24));
        textoDireccion.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoDireccion, gridBagConstraints);

        textoDNI.setMinimumSize(new java.awt.Dimension(130, 24));
        textoDNI.setPreferredSize(new java.awt.Dimension(130, 24));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoDNI, gridBagConstraints);

        textoNombre.setMinimumSize(new java.awt.Dimension(130, 24));
        textoNombre.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoNombre, gridBagConstraints);

        textoApellido.setMinimumSize(new java.awt.Dimension(130, 24));
        textoApellido.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoApellido, gridBagConstraints);

        jLabel3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Direccion");
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
            public void actionPerformed(ActionEvent e) {
                comprobarCampos();
            }
        });
    }// </editor-fold>

    private void comprobarCampos(){
        String DNI = textoDNI.getText();
        String nombre = textoNombre.getText();
        String apellido = textoApellido.getText();
        String direccion = textoDireccion.getText();
        if(cnCliente.comprobarDNI(DNI) && !nombre.isEmpty() && !apellido.isEmpty() && !direccion.isEmpty()){
            if(cnCliente.agregarCliente(DNI,nombre,apellido,direccion)){
                JOptionPane.showMessageDialog(this,"Cliente agregado","Éxito",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"No se ha podido agregar","Error",JOptionPane.ERROR_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(this,"Faltan campos","Informacion",JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JTextField textoApellido;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoDireccion;
    // End of variables declaration
}
