/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas;

import controllers.ClienteCRUD;
import controllers.UsuarioCRUD;
import entidades.Cliente;
import entidades.Moto;
import entidades.Usuario;
import modelo.UsuarioModel;
import views.Ventanas.crudUsuarios.PanelModificarUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Usuarios extends javax.swing.JPanel {

    private int nivelUsuario;
    
    public Usuarios() {
        initComponents();
    }
    
    public Usuarios(int nivelUsuario){
        initComponents();
        this.nivelUsuario = nivelUsuario;
        cambiarPermisos();
    }
    
    private void cambiarPermisos(){
        if(nivelUsuario == 0){
            botonCrear.setEnabled(false);
            botonEliminar.setEnabled(false);
            botonModificar.setEnabled(false);
        }else if(nivelUsuario == 1){
            botonCrear.setEnabled(false);
            botonEliminar.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultado = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonCrear = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        model = new DefaultTableModel();
        cnUsuario = new UsuarioCRUD();
        panelModificar = new PanelModificarUsuario();

        setPreferredSize(new java.awt.Dimension(600, 300));
        setLayout(new java.awt.GridBagLayout());

        setHeaders();
        fillTable();

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 368;
        gridBagConstraints.ipady = 210;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(18, 5, 6, 5);
        add(jScrollPane1, gridBagConstraints);

        botonBuscar.setText("Buscar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(15, 5, 0, 12);
        add(botonBuscar, gridBagConstraints);

        botonModificar.setText("Modificar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(15, 30, 0, 12);
        add(botonModificar, gridBagConstraints);

        botonCrear.setText("Crear");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 2.3;
        gridBagConstraints.insets = new Insets(15, 30, 0, 12);
        add(botonCrear, gridBagConstraints);

        botonEliminar.setText("Eliminar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(15, 30, 0, 5);
        add(botonEliminar, gridBagConstraints);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        agregarListeners();
    }// </editor-fold>//GEN-END:initComponents

    private void setHeaders(){
        this.tablaResultado = new JTable(model);
        jScrollPane1.setViewportView(tablaResultado);
        model.addColumn("Nick");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Password");
    }
    public void fillTable(){
        UsuarioCRUD controlador = new UsuarioCRUD();
        ArrayList<Usuario> listaUsuarios = controlador.gesListaUsuarios();
        model.setRowCount(0);
        for (Usuario u : listaUsuarios){
            Object[] datosUsuario = new Object[4];
            datosUsuario[0] = u.getNick();
            datosUsuario[1] = u.getNombre();
            datosUsuario[2] = u.getApellidos();
            datosUsuario[3] = u.getContra();
            model.addRow(datosUsuario);
        }
    }

    private void fillTableBuscar(Usuario u){
        model.setRowCount(0);
        Object[] datosUser = new Object[4];
        datosUser[0] = u.getNick();
        datosUser[1] = u.getNombre();
        datosUser[2] = u.getApellidos();
        datosUser[3] = u.getContra();
        model.addRow(datosUser);
    }

    private void agregarListeners(){
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
    }

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            String nick = JOptionPane.showInputDialog(this, "Introduce el nick de usuario", 1);
            if (cnUsuario.usuarioExiste(nick)){
                Usuario user = cnUsuario.buscarUsuario(nick);
                fillTableBuscar(user);
            } else {
                JOptionPane.showMessageDialog(this, "La moto con esa matrícula no existe en la BD");
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaResultado;
    private DefaultTableModel model;
    private UsuarioCRUD cnUsuario;
    private PanelModificarUsuario panelModificar;
    // End of variables declaration//GEN-END:variables
}
