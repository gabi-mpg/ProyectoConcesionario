package views.crudVentas;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controllers.VentaCRUD;
import entidades.Venta;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 *
 * @author gaby y chris
 */
public class insertarVenta extends javax.swing.JFrame {

    private boolean DNICorrecto = false;
    private boolean MatriculaCorrecta = false;
    private String nombreUsuario;

    /**
     * Crea una nueva instancia del frame de búsqueda
     * @param nombreUsuarioLogeado Toma el nombre del usuario logueado para reigstrar al nuevo cliente en la base
     *                             de datos con creador -> usuario
     */
    public insertarVenta(String nombreUsuarioLogeado) {
        this.nombreUsuario = nombreUsuarioLogeado;
        setSize(260,410);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Este método es llamado para inicializar todos los componentes de la ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        setTitle("Insertar venta");
        setIconImage(Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES+"iconoInsertar.png"));
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        iconoInsertar = new javax.swing.JLabel();
        textoIDVendedor = new javax.swing.JTextField();
        textoDNI = new javax.swing.JTextField();
        textoPrecio = new javax.swing.JTextField();
        textoMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonInsertar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(230, 390));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Insertar una nueva venta");
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

        textoIDVendedor.setMinimumSize(new java.awt.Dimension(130, 24));
        textoIDVendedor.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoIDVendedor, gridBagConstraints);
        textoIDVendedor.setText(nombreUsuario);
        textoIDVendedor.setEnabled(false);

        textoDNI.setMinimumSize(new java.awt.Dimension(130, 24));
        textoDNI.setPreferredSize(new java.awt.Dimension(130, 24));
        textoDNI.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(textoDNI.getText().matches("[0-9]{7,8}[A-Za-z]")){
                    textoDNI.setForeground(new Color(0,143,57));
                    DNICorrecto = true;
                }else{
                    textoDNI.setForeground(Color.RED);
                    DNICorrecto = false;
                }
        }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoDNI, gridBagConstraints);

        textoPrecio.setMinimumSize(new java.awt.Dimension(130, 24));
        textoPrecio.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoPrecio, gridBagConstraints);

        textoMatricula.setMinimumSize(new java.awt.Dimension(130, 24));
        textoMatricula.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoMatricula, gridBagConstraints);
        textoMatricula.addKeyListener(new KeyAdapter() {
          @Override
          public void keyReleased(KeyEvent e) {
              if(textoMatricula.getText().matches("^[0-9]{4}[A-Za-z]{3}$")){
                  textoMatricula.setForeground(new Color(0,143,57));
                  MatriculaCorrecta = true;
              }else{
                  textoMatricula.setForeground(Color.RED);
                  MatriculaCorrecta = false;
              }
          }
      });

                jLabel3.setText("Vendedor");
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

        jLabel5.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Matricula");
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


    /**
     * Comprueba que los valores de los campos sean correctos. En el caso de que no, se muestra un mensaje al
     * usuario con todos los fallos que tiene
     */
    private void comprobarCampos(){
        String mensajeError = "";
        if(!DNICorrecto){
            mensajeError+=" DNI, ";
        }
        if(!MatriculaCorrecta){
            mensajeError+=" Matricula, ";
        }
        if(textoPrecio.getText().isEmpty()){
            mensajeError+=" Campo precio, ";
        }
        if(!mensajeError.isEmpty()){
            mensajeError = mensajeError.substring(0,mensajeError.lastIndexOf(","));
            mensajeError+= " incorrecto/s";
            JOptionPane.showMessageDialog(this,mensajeError,"Error en los datos",JOptionPane.ERROR_MESSAGE);
        }else{
            anadirVenta();
        }
    }

    private void anadirVenta(){
        cnVenta = new VentaCRUD();
       if(cnVenta.ventaExiste(textoMatricula.getText())){
           Venta venta = cnVenta.buscarVenta(textoMatricula.getText());
           venta.setExiste(1);
           cnVenta.cambioExsite(venta);
           JOptionPane.showMessageDialog(this,"Venta recuperada","Venta preexistente",JOptionPane.INFORMATION_MESSAGE);
       }else{
            if(cnVenta.agregarVenta(textoMatricula.getText(),
                    textoDNI.getText(),
                    Float.parseFloat(textoPrecio.getText()),
                    textoIDVendedor.getText())){
                JOptionPane.showMessageDialog(this,"Se ha añadido la nueva venta","Registro creado",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"No se ha registrado la nueva venta", "Error al crear",JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JTextField textoMatricula;
    private javax.swing.JTextField textoPrecio;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoIDVendedor;
    private VentaCRUD cnVenta;
    // End of variables declaration
}
