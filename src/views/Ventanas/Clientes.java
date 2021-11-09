/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas;

import com.mysql.cj.xdevapi.Client;
import controllers.ClienteCRUD;
import controllers.MotoCRUD;
import controllers.UsuarioCRUD;
import controllers.VentaCRUD;
import entidades.Cliente;
import entidades.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Clientes extends javax.swing.JPanel {

    private int nivelUsuario;
    
    public Clientes() {
        initComponents();
    }
    
    public Clientes(int nivelUsuario){
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
        botonBuscar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonCrear = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        model = new DefaultTableModel();
        cnCliente = new ClienteCRUD();

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
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 5, 6, 5);
        add(jScrollPane1, gridBagConstraints);

        botonBuscar.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 8);
        add(botonBuscar, gridBagConstraints);

        botonModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 26, 0, 8);
        add(botonModificar, gridBagConstraints);

        botonCrear.setText("Crear");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 26, 0, 8);
        add(botonCrear, gridBagConstraints);

        botonEliminar.setText("Eliminar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 0, 8);
        add(botonEliminar, gridBagConstraints);

        agregarListeners();
    }// </editor-fold>//GEN-END:initComponents

    private void setHeaders(){
        this.tablaResultado = new JTable(model);
        jScrollPane1.setViewportView(tablaResultado);
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Direccion");
    }
    private void fillTable(){
        ClienteCRUD controlador = new ClienteCRUD();
        ArrayList<Cliente> listaClientes = controlador.getListaClientes();
        model.setRowCount(0);
        for (Cliente c : listaClientes){
            Object[] datosCliente = new Object[4];
            datosCliente[0] = c.getDni();
            datosCliente[1] = c.getNombre();
            datosCliente[2] = c.getApellido();
            datosCliente[3] = c.getDireccion();
            model.addRow(datosCliente);
        }
    }

    private void fillTableBuscar(Cliente c){
        model.setRowCount(0);
            Object[] datosCliente = new Object[4];
            datosCliente[0] = c.getDni();
            datosCliente[1] = c.getNombre();
            datosCliente[2] = c.getApellido();
            datosCliente[3] = c.getDireccion();
            model.addRow(datosCliente);
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
            String dni = pedirDNI();
            if (cnCliente.clienteExiste(dni)){
                Cliente cliente = cnCliente.buscarCliente(dni);
                fillTableBuscar(cliente);
            } else {
                JOptionPane.showMessageDialog(this, "El cliente con ese DNI no existe en la BD");
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private String pedirDNI(){
        String dni = JOptionPane.showInputDialog(this, "Introduce el DNI a buscar", 1);

        while (!cnCliente.comprobarDNI(dni)){
            JOptionPane.showMessageDialog(this, "Formato DNI incorrecto");

            dni = JOptionPane.showInputDialog(this, "Introduce el DNI a buscar", 1);
        }
        return dni;
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
    private ClienteCRUD cnCliente;

    // End of variables declaration//GEN-END:variables
}
