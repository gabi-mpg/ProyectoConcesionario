package views.Ventanas.panelesMenu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.UsuarioCRUD;
import controllers.VentaCRUD;
import javafx.scene.control.RadioButton;
import views.Ventanas.Paneles.Graficos.JFreeChart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author chris
 */
public class generadorGraficos extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form estadisticas
     */
    private String ruta =  System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"+File.separator
            +"imagenes"+ File.separator;
    private UsuarioCRUD cnUsuario;
    private VentaCRUD cnVenta;

    public generadorGraficos() {
        cnUsuario = new UsuarioCRUD();
        cnVenta = new VentaCRUD();
        initComponents();
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        etiqueLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        radioQuesito = new javax.swing.JRadioButton();
        radioBarras = new javax.swing.JRadioButton();
        botonGenerarGrafico = new javax.swing.JButton();
        botonGenerarGrafico.setEnabled(false);
        comboBox.setEnabled(false);
        buttonGroup1.add(radioBarras);
        buttonGroup1.add(radioQuesito);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("Generador de Estadísticas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(26, 16, 0, 16);
        jPanel1.add(jLabel1, gridBagConstraints);

        etiqueLogo.setIcon(new javax.swing.ImageIcon(ruta+"estadisticaLogo.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 16, 16);
        jPanel1.add(etiqueLogo, gridBagConstraints);

        jLabel2.setText("Concesionario Mercado Corral");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 26, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 250));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Contenido del gráfico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 14);
        jPanel2.add(jLabel3, gridBagConstraints);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cantidad de ventas por usuario", "Capital de venta por usuario"}));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(22, 19, 70, 11);
        jPanel2.add(comboBox, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Tipo de gráfico");
        jPanel2.add(jLabel4, new java.awt.GridBagConstraints());

        radioQuesito.setText("Diagrama de tarta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(25, 12, 25, 17);
        jPanel2.add(radioQuesito, gridBagConstraints);


        radioBarras.setText("Diagrama de barra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(25, 12, 0, 17);
        jPanel2.add(radioBarras, gridBagConstraints);

        botonGenerarGrafico.setText("Generar gráfico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel2.add(botonGenerarGrafico, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jPanel2, gridBagConstraints);
        anadirEventos();
        pack();
    }// </editor-fold>



    private void anadirEventos(){
        radioBarras.addActionListener(this);
        radioQuesito.addActionListener(this);
        botonGenerarGrafico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarGraficos();
            }
        });
    }

    private void generarGraficos(){
        JFreeChart tabla = new JFreeChart(cnUsuario.gesListaUsuarios(), cnVenta.getListaVentas());
        if(radioBarras.isSelected()){
            if(comboBox.getSelectedIndex() == 0){
                tabla.generarGraficoVentas();
            }else{
                tabla.dineroUsuarios();
            }
        }else{
            if(comboBox.getSelectedIndex() == 0){
                tabla.generarGraficoVentasTarta();
            }else{
                tabla.generarGraficoDineroTartas();
            }
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(generadorGraficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generadorGraficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generadorGraficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generadorGraficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generadorGraficos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton botonGenerarGrafico;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel etiqueLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton radioBarras;
    private javax.swing.JRadioButton radioQuesito;

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radio = (JRadioButton) e.getSource();
        if(radio.isSelected()){
            this.comboBox.setEnabled(true);
            this.botonGenerarGrafico.setEnabled(true);
        }
    }
    // End of variables declaration
}
