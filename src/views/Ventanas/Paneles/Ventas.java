/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas.Paneles;

import controllers.VentaCRUD;
import entidades.Venta;
import views.Ventanas.crudVentas.PanelModificarVenta;
import views.Ventanas.crudVentas.buscarVenta;
import views.Ventanas.crudVentas.insertarVenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Ventas extends javax.swing.JPanel implements ActionListener {

    private int nivelUsuario;
    private String nombreUsuario;
    
    public Ventas() {
        initComponents();
    }
    
    public Ventas(int nivelUsuario, String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
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
        tema = 1;

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
        jScrollPane1.setPreferredSize(new Dimension(572,400));
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 6, 10);
        add(jScrollPane1, gridBagConstraints);

        botonBuscar.setText("Buscar");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(15, 10, 0, 12);
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
        gridBagConstraints.insets = new Insets(15, 30, 0, 10);
        add(botonEliminar, gridBagConstraints);
        this.setBackground(new java.awt.Color(204, 255, 204));
        agregarListeners();
    }// </editor-fold>//GEN-END:initComponents

    private void setHeaders(){
        this.tablaResultado = new JTable(model);
        jScrollPane1.setViewportView(tablaResultado);
        model.addColumn("ID");
        model.addColumn("DNI");
        model.addColumn("Matricula");
        model.addColumn("Precio");
        model.addColumn("Vendedor");
    }

    public void fillTable(){
        VentaCRUD controlador = new VentaCRUD();
        ArrayList<Venta> listaVentas = controlador.getListaVentas();
        model.setRowCount(0);
        for (Venta v : listaVentas){
            if (v.isExiste() == 1){
                Object[] datosVenta = new Object[5];
                datosVenta[0] = v.getIdVenta();
                datosVenta[1] = v.getDni();
                datosVenta[2] = v.getMatricula();
                datosVenta[3] = v.getPrecio();
                datosVenta[4] = v.getIdVendedor();
                model.addRow(datosVenta);
            }

        }
    }

    private void fillTableBuscar(ArrayList<Venta> listaV){
        model.setRowCount(0);
        for (Venta v : listaV){
            Object[] datosVenta = new Object[5];
            datosVenta[0] = v.getIdVenta();
            datosVenta[1] = v.getDni();
            datosVenta[2] = v.getMatricula();
            datosVenta[3] = v.getPrecio();
            datosVenta[4] = v.getIdVendedor();
            model.addRow(datosVenta);
        }
    }

    private void agregarListeners(){
        botonBuscar.addActionListener(this);
        botonModificar.addActionListener(this);
        botonEliminar.addActionListener(this);
        botonCrear.addActionListener(this);
    }

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            buscarVenta bv = new buscarVenta(cnVentas);
            ArrayList<Venta> listaV = bv.getListaV();//este metodo nos devolvera la venta
            if (listaV.size() > 0){
                fillTableBuscar(listaV);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void botonEliminarActionPerformed(ActionEvent evt) {
        String ID = JOptionPane.showInputDialog(this, "Introduce el ID de la venta", "ID Venta", JOptionPane.PLAIN_MESSAGE);
        if(ID != null){
            try{
                int IDint = Integer.parseInt(ID);
                if(cnVentas.ventaExiste(IDint)){
                    cnVentas.removeVenta(cnVentas.buscarVenta(IDint).getMatricula());
                    fillTable();
                } else {
                    JOptionPane.showMessageDialog(this, "La venta con ese ID no existe en la BD", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this,"No se ha introducido un numero","Error en la entrada",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if(b == botonBuscar){
            botonBuscarActionPerformed(e);
        }else if(b == botonCrear){
            new insertarVenta(nombreUsuario);
        } else if (b == botonEliminar) {
            botonEliminarActionPerformed(e);
        }else{
            try{
                String ID = JOptionPane.showInputDialog(this, "Introduce el ID de la venta", "ID Venta", JOptionPane.PLAIN_MESSAGE);
                if (!ID.isEmpty()){
                    new PanelModificarVenta(ID);
                    fillTable();
                }else{
                    JOptionPane.showMessageDialog(this,"No se ha introducido búsqueda","Entrada vacía",JOptionPane.ERROR_MESSAGE);
                }
            }catch (NullPointerException ex){
                System.out.println(ex.getMessage());
            }

        }
    }

    private String pedirMatricula(){
        try{
            String matricula = JOptionPane.showInputDialog(this, "Introduce la matricula de la moto", 1);

            while (!cnVentas.comprobarMatricula(matricula)){
                JOptionPane.showMessageDialog(this, "Formato matrícula incorrecto");
                matricula = JOptionPane.showInputDialog(this, "Introduce la matrícula de la moto", 1);
            }
            return matricula;
        } catch (Exception e){
            return null;
        }
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
    }

    public void setTema(int tema) {
        this.tema = tema;
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

    private PanelModificarVenta panelModificar;
    private int tema;


    // End of variables declaration//GEN-END:variables
}
