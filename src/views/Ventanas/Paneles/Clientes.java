/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas.Paneles;

import controllers.ClienteCRUD;
import entidades.Cliente;
import views.Ventanas.crudClientes.PanelModificarCliente;
import views.Ventanas.crudClientes.insertarCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Clientes extends javax.swing.JPanel {

    private final int nivelUsuario;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private DefaultTableModel model;
    private ClienteCRUD cnCliente;

    private int tema;
    

    
    public Clientes(int nivelUsuario){
        initComponents();
        this.nivelUsuario = nivelUsuario;
        cambiarPermisos();
    }
    
    private void cambiarPermisos(){
        if(nivelUsuario == 3){
            botonCrear.setEnabled(false);
            botonEliminar.setEnabled(false);
            botonModificar.setEnabled(false);
        }else if(nivelUsuario == 2){
            botonCrear.setEnabled(false);
            botonEliminar.setEnabled(false);
        }
    }


    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        botonBuscar = new JButton();
        botonModificar = new JButton();
        botonCrear = new JButton();
        botonEliminar = new JButton();
        model = new DefaultTableModel();
        cnCliente = new ClienteCRUD();
        tema = 1;

        setPreferredSize(new java.awt.Dimension(600, 300));
        setLayout(new java.awt.GridBagLayout());

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

        this.setBackground(new java.awt.Color(204, 255, 204));
        setHeaders();
        fillTable();
        agregarListeners();
    }

    private void setHeaders(){
        JTable tablaResultado = new JTable(model);
        jScrollPane1.setViewportView(tablaResultado);
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Direccion");
    }
    public void fillTable(){
        ClienteCRUD controlador = new ClienteCRUD();
        ArrayList<Cliente> listaClientes = controlador.getListaClientes();
        model.setRowCount(0);
        for (Cliente c : listaClientes){
            if (c.getExiste() == 1){
                Object[] datosCliente = new Object[4];
                datosCliente[0] = c.getDni();
                datosCliente[1] = c.getNombre();
                datosCliente[2] = c.getApellido();
                datosCliente[3] = c.getDireccion();
                model.addRow(datosCliente);
            }
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

    public void cambiarTema(){
        if (tema == 0){
            botonBuscar.setBackground(new Color(246, 231, 23));
            botonEliminar.setBackground(new Color(246, 231, 23));
            botonModificar.setBackground(new Color(246, 231, 23));
            botonCrear.setBackground(new Color(246, 231, 23));
            this.setBackground(new Color(53, 52, 53));
            setTema(1);
        } else {
            botonBuscar.setBackground(new Color(218, 218, 218));
            botonCrear.setBackground(new Color(218, 218, 218));
            botonEliminar.setBackground(new Color(218, 218, 218));
            botonModificar.setBackground(new Color(218, 218, 218));
            this.setBackground(new java.awt.Color(204, 255, 204));
            setTema(0);
        }
        System.out.println(tema);
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    private void agregarListeners(){
        botonBuscar.addActionListener(e -> accionBotonBuscar());
        botonCrear.addActionListener(e -> accionBotonCrear());
        botonModificar.addActionListener(e ->  accionBotonModificar());
        botonEliminar.addActionListener(e -> accionBotonEliminar());
    }

    private void accionBotonBuscar() {
        try{
            String dni = pedirDNI();
            if (dni != null){
                if (cnCliente.clienteExiste(dni)){
                    Cliente cliente = cnCliente.buscarCliente(dni);
                    if (cliente.getExiste() == 1){
                        fillTableBuscar(cliente);
                    } else {
                        JOptionPane.showMessageDialog(this, "Los datos de ese cliente ya no están disponibles", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El cliente con ese DNI no existe en la BD", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void accionBotonModificar() {
        String dni = pedirDNI();
        if (dni != null){
            new PanelModificarCliente(dni);
            fillTable();
        }

    }

    private void accionBotonCrear() {
        new insertarCliente();
        fillTable();
    }

    private void accionBotonEliminar() {
        String matricula = pedirDNI();
        if (matricula != null){
            cnCliente.removeCliente(matricula);
            fillTable();
        }
    }


    private String pedirDNI(){
        try{
            String dni = JOptionPane.showInputDialog(this, "Introduce el DNI del cliente", "DNI", JOptionPane.PLAIN_MESSAGE);

            while (!cnCliente.comprobarDNI(dni)){
                JOptionPane.showMessageDialog(this, "Formato DNI incorrecto", "Error", JOptionPane.ERROR_MESSAGE);

                dni = JOptionPane.showInputDialog(this, "Introduce el DNI del cliente", "DNI", JOptionPane.PLAIN_MESSAGE);
            }
            return dni;
        } catch (Exception e) {
            return null;
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables

    // End of variables declaration//GEN-END:variables
}
