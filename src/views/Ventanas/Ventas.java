/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas;

import controllers.ClienteCRUD;
import controllers.VentaCRUD;
import entidades.Cliente;
import entidades.Usuario;
import entidades.Venta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Ventas extends javax.swing.JPanel {

    private int nivelUsuario;
    
    public Ventas() {
        initComponents();
    }
    
    public Ventas(int nivelUsuario){
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
        cnVentas = new VentaCRUD();

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
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });


        agregarListeners();
    }// </editor-fold>//GEN-END:initComponents

    private void setHeaders(){
        this.tablaResultado = new JTable(model);
        jScrollPane1.setViewportView(tablaResultado);
        model.addColumn("ID");
        model.addColumn("Matricula");
        model.addColumn("DNI");
        model.addColumn("Precio");
        model.addColumn("Vendedor");
    }

    public void fillTable(){
        VentaCRUD controlador = new VentaCRUD();
        ArrayList<Venta> listaVentas = controlador.getListaVentas();
        model.setRowCount(0);
        for (Venta v : listaVentas){
            Object[] datosVenta = new Object[5];
            datosVenta[0] = v.getIdVenta();
            datosVenta[1] = v.getDni();
            datosVenta[2] = v.getMatricula();
            datosVenta[3] = v.getPrecio();
            datosVenta[4] = v.getIdVendedor();
            model.addRow(datosVenta);
        }
    }

    private void fillTableBuscar(Venta v){
        model.setRowCount(0);
        Object[] datosVenta = new Object[4];
        datosVenta[0] = v.getIdVenta();
        datosVenta[1] = v.getDni();
        datosVenta[2] = v.getMatricula();
        datosVenta[3] = v.getPrecio();
        model.addRow(datosVenta);
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
            int IDVenta = Integer.parseInt(JOptionPane.showInputDialog(this, "Introduce el IDVenta", 1));
            if (cnVentas.ventaExiste(IDVenta)){
                Venta venta = cnVentas.buscarVenta(IDVenta);
                fillTableBuscar(venta);
            } else {
                JOptionPane.showMessageDialog(this, "La venta con ese ID no existe en la BD");
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
    private VentaCRUD cnVentas;
    // End of variables declaration//GEN-END:variables
}
