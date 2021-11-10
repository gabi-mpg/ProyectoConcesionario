/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas.Paneles;

import controllers.ControllerConexion;
import controllers.MotoCRUD;
import entidades.Moto;
import views.Ventanas.crudMotos.PanelModificarMoto;
import views.Ventanas.crudMotos.insertarMoto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Motos extends javax.swing.JPanel {

    private insertarMoto insertar;
    private int nivelUsuario;


    public Motos(ControllerConexion conexion) {
        this.insertar = new insertarMoto();
        insertar.setVisible(false);
        initComponents();
    }

    public Motos(int nivelUsuario){
        this.insertar = new insertarMoto();
        this.nivelUsuario = nivelUsuario;
        insertar.setVisible(false);
        initComponents();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        jScrollPane1 = new JScrollPane();
        tablaResultado = new JTable();
        botonBuscar = new JButton();
        botonModificar = new JButton();
        botonCrear = new JButton();
        botonEliminar = new JButton();
        model = new DefaultTableModel();
        cnMoto = new MotoCRUD();
        panelModificar = new PanelModificarMoto();
        panelModificar.setVisible(false);
        setPreferredSize(new Dimension(600, 300));
        setLayout(new GridBagLayout());

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

        agregarListeners();
    }// </editor-fold>//GEN-END:initComponents

    private void setHeaders(){
        this.tablaResultado = new JTable(model);
        jScrollPane1.setViewportView(tablaResultado);
        model.addColumn("Matricula");
        model.addColumn("Marca");
        model.addColumn("Color");
        model.addColumn("Tanque");
    }
    public void fillTable(){
        MotoCRUD controlador = new MotoCRUD();
        ArrayList<Moto> listaMotos = controlador.getListaMotos();
        model.setRowCount(0);
        for (Moto m : listaMotos){
            if(m.isExiste()){
                Object[] datosMoto = new Object[4];
                datosMoto[0] = m.getMatricula();
                datosMoto[1] = m.getMarca();
                datosMoto[2] = m.getColor();
                datosMoto[3] = m.getTanque();
                model.addRow(datosMoto);
            }
        }
    }

    private void fillTableBuscar(Moto m){
        model.setRowCount(0);
        Object[] datosMoto = new Object[4];
        datosMoto[0] = m.getMatricula();
        datosMoto[1] = m.getMarca();
        datosMoto[2] = m.getColor();
        datosMoto[3] = m.getTanque();
        model.addRow(datosMoto);
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
            String matricula = pedirMatricula();
            if (cnMoto.motoExiste(matricula)){
                Moto moto = cnMoto.buscarMoto(matricula);
                fillTableBuscar(moto);
            } else {
                JOptionPane.showMessageDialog(this, "La moto con esa matrícula no existe en la BD");
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private String pedirMatricula(){
        String matricula = JOptionPane.showInputDialog(this, "Introduce la matricula de la moto", 1);

        while (!cnMoto.comprobarMatricula(matricula)){
            JOptionPane.showMessageDialog(this, "Formato matrícula incorrecto");
            matricula = JOptionPane.showInputDialog(this, "Introduce la matrícula de la moto", 1);
        }
        return matricula;
    }

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {
        String matricula = pedirMatricula();
        panelModificar.setMatricula(matricula);
        panelModificar.rellenarCampos();
        fillTable();
    }

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {
        insertar.setVisible(true);
    }

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        String matricula = pedirMatricula();
        cnMoto.removeMoto(matricula);
        fillTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaResultado;
    private DefaultTableModel model;
    private MotoCRUD cnMoto;
    private PanelModificarMoto panelModificar;
    // End of variables declaration//GEN-END:variables
}
