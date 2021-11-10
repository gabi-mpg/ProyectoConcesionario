package views.Ventanas.crudUsuarios;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;

/**
 *
 * @author chris
 */
public class insertarUsuario extends javax.swing.JFrame {

    private String ruta =  System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"+File.separator
            +"imagenes"+ File.separator;

    public insertarUsuario() {
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
        textoTanque = new javax.swing.JTextField();
        textoMatricula = new javax.swing.JTextField();
        textoMarca = new javax.swing.JTextField();
        textoColor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonInsertar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(230, 390));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Insertar un nuevo usuario");
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

        textoTanque.setMinimumSize(new java.awt.Dimension(130, 24));
        textoTanque.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoTanque, gridBagConstraints);

        textoMatricula.setMinimumSize(new java.awt.Dimension(130, 24));
        textoMatricula.setPreferredSize(new java.awt.Dimension(130, 24));
        textoMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoMatriculaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoMatricula, gridBagConstraints);

        textoMarca.setMinimumSize(new java.awt.Dimension(130, 24));
        textoMarca.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoMarca, gridBagConstraints);

        textoColor.setMinimumSize(new java.awt.Dimension(130, 24));
        textoColor.setPreferredSize(new java.awt.Dimension(130, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(22, 14, 16, 14);
        add(textoColor, gridBagConstraints);

        jLabel3.setText("Nick");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Apellidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Contraseña");
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
    }// </editor-fold>

    private void textoMatriculaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JButton botonInsertar;
    private javax.swing.JLabel iconoInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textoColor;
    private javax.swing.JTextField textoMarca;
    private javax.swing.JTextField textoMatricula;
    private javax.swing.JTextField textoTanque;
    // End of variables declaration
}
