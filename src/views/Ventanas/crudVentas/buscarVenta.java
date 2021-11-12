package views.Ventanas.crudVentas;


import controllers.VentaCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class buscarVenta extends javax.swing.JFrame implements ActionListener{

    private String valorBusqueda;
    private final String RUTA_REC =  System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"
            +File.separator+"Imagenes"+File.separator;

    public buscarVenta(VentaCRUD cnVenta) {
        this.cnVenta = cnVenta;
        setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void procesarCampoDNI(){
        campoBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(campoBusqueda.getText().matches("[0-9]{7,8}[A-Za-z]")){
                    campoBusqueda.setForeground(new Color(0,143,57));
                    campoCorrecto = true;
                }else{
                    campoBusqueda.setForeground(Color.RED);
                    campoCorrecto = false;
                }
            }
        });

        if (campoCorrecto){
            botonBusqueda.setEnabled(true);
        }
    }

    private void procesarCampoMatricula(){
        campoBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(campoBusqueda.getText().matches("^[0-9]{4}[A-Za-z]{3}$")){
                    campoBusqueda.setForeground(new Color(0,143,57));
                    campoCorrecto = true;
                }else{
                    campoBusqueda.setForeground(Color.RED);
                    campoCorrecto = false;
                }
            }
        });

        if (campoCorrecto){
            botonBusqueda.setEnabled(true);
        }
    }

    public void busquedaVenta(){
        if(!campoBusqueda.getText().isEmpty()){
            if(rbDNI.isSelected()){
                procesarCampoDNI();
            }else if(rbMatricula.isSelected()){
                valorBusqueda = campoBusqueda.getText();
                procesarCampoMatricula();
            }else{
                valorBusqueda = campoBusqueda.getText();
                botonBusqueda.setEnabled(true);
            }
            dispose();
        }else{
            JOptionPane.showMessageDialog(this,"No se ha introducido información", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
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
        labelTitulo = new javax.swing.JLabel();
        labelIcono = new javax.swing.JLabel();
        rbDNI = new javax.swing.JRadioButton();
        rbMatricula = new javax.swing.JRadioButton();
        rbIDVenta = new javax.swing.JRadioButton();
        campoBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonBusqueda = new javax.swing.JButton();
        rbIDVendedor = new javax.swing.JRadioButton();
        campoCorrecto = false;
        campoBusqueda.setEnabled(false);
        botonBusqueda.setEnabled(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelTitulo.setText("Buscar registros de venta");
        labelTitulo.setFont(new Font("Serif",Font.BOLD,16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(25, 26, 18, 26);
        getContentPane().add(labelTitulo, gridBagConstraints);

        labelIcono.setIcon(new javax.swing.ImageIcon(RUTA_REC +"iconoBuscar.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(13, 14, 6, 14);
        getContentPane().add(labelIcono, gridBagConstraints);

        buttonGroup1.add(rbDNI);
        rbDNI.setText("DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(rbDNI, gridBagConstraints);

        buttonGroup1.add(rbMatricula);
        rbMatricula.setText("Matrícula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(rbMatricula, gridBagConstraints);

        buttonGroup1.add(rbIDVenta);
        rbIDVenta.setText("ID Venta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(rbIDVenta, gridBagConstraints);

        campoBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoBusqueda.setPreferredSize(new java.awt.Dimension(140, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        getContentPane().add(campoBusqueda, gridBagConstraints);

        jLabel1.setText("Buscar por...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 10, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        botonBusqueda.setText("Buscar registro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(22, 19, 19, 19);
        getContentPane().add(botonBusqueda, gridBagConstraints);

        buttonGroup1.add(rbIDVendedor);
        rbIDVendedor.setText("ID Vendedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(rbIDVendedor, gridBagConstraints);

        pack();
        agregarListeners();
    }// </editor-fold>

    private void agregarListeners(){
        botonBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarArray();
            }
        });

        rbDNI.addActionListener(this);
        rbMatricula.addActionListener(this);
        rbIDVenta.addActionListener(this);
        rbIDVendedor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radio = (JRadioButton) e.getSource();
        if(radio.isSelected()){
            this.campoBusqueda.setEnabled(true);
            busquedaVenta();
        }
    }

    private void enviarArray(){

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
            java.util.logging.Logger.getLogger(buscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new buscarVenta().setVisible(true);
//            }
//        });
    }



    public String getValorBusqueda(){
        return this.valorBusqueda;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton botonBusqueda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rbDNI;
    private javax.swing.JRadioButton rbMatricula;
    private javax.swing.JRadioButton rbIDVenta;
    private javax.swing.JRadioButton rbIDVendedor;
    private javax.swing.JLabel labelIcono;
    private javax.swing.JLabel labelTitulo;
    private VentaCRUD cnVenta;
    boolean campoCorrecto;


    // End of variables declaration
}
