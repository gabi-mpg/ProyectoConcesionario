package views.Ventanas.panelesMenu;

import controllers.ControllerConexion;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class generadorPDF extends javax.swing.JFrame implements ActionListener {

    private String ruta =  System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"+File.separator
            +"imagenes"+ File.separator;
    private String rutaGenerarPDF;
    private ControllerConexion conexion;

    public generadorPDF(){}

    public generadorPDF(ControllerConexion conexion) {
        this.conexion = conexion;
        setLocationRelativeTo(null);
        setResizable(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        radioVentasUsuario = new javax.swing.JRadioButton();
        radioVentasMarca = new javax.swing.JRadioButton();
        radioVentas = new javax.swing.JRadioButton();
        radioVentasCliente = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labeDirectorio = new javax.swing.JLabel();
        botonGenerarPDF = new javax.swing.JButton();
        botonSeleccionarDirectorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Generador de documentos PDF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 9, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        labelImagen.setIcon(new javax.swing.ImageIcon(ruta+"iconoPDF.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(labelImagen, gridBagConstraints);

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        jPanel2.setBackground(new java.awt.Color(165, 165, 165));
        jPanel2.setPreferredSize(new java.awt.Dimension(320, 179));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(radioVentasUsuario);
        radioVentasUsuario.setText("Ventas por usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(9, 4, 9, 4);
        jPanel2.add(radioVentasUsuario, gridBagConstraints);

        buttonGroup1.add(radioVentasMarca);
        radioVentasMarca.setText("Ventas por marca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(9, 4, 9, 4);
        jPanel2.add(radioVentasMarca, gridBagConstraints);

        buttonGroup1.add(radioVentas);
        radioVentas.setText("Ventas general");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(19, 4, 19, 13);
        jPanel2.add(radioVentas, gridBagConstraints);

        buttonGroup1.add(radioVentasCliente);
        radioVentasCliente.setText("Ventas por cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(19, 4, 19, 4);
        jPanel2.add(radioVentasCliente, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Selecciona el tipo de documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        jPanel2.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 180));
        jPanel3.setRequestFocusEnabled(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Selecciona dónde guardar el fichero");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        jPanel3.add(jLabel4, gridBagConstraints);

        labeDirectorio.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 7, 5);
        jPanel3.add(labeDirectorio, gridBagConstraints);

        botonGenerarPDF.setText("Generar documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(28, 11, 7, 11);
        jPanel3.add(botonGenerarPDF, gridBagConstraints);

        botonSeleccionarDirectorio.setText("Directorio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel3.add(botonSeleccionarDirectorio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jPanel3, gridBagConstraints);

        this.botonSeleccionarDirectorio.setEnabled(false);
        this.botonGenerarPDF.setEnabled(false);
        eventos();
        pack();
    }// </editor-fold>

    private void eventos(){
        radioVentas.addActionListener(this);
        radioVentasCliente.addActionListener(this);
        radioVentasMarca.addActionListener(this);
        radioVentasUsuario.addActionListener(this);
        this.botonSeleccionarDirectorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonMostarChooser();
                botonGenerarPDF.setEnabled(true);
            }
        });
        this.botonGenerarPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aquí hay que hacer lo de generar el PDF
            }
        });
    }

    private void botonMostarChooser(){
        JFileChooser directorios = new JFileChooser();
        directorios.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directorios.showDialog(this,"Seleccionar carpeta");
        rutaGenerarPDF = directorios.getSelectedFile().getAbsolutePath();
        this.labeDirectorio.setText(truncarRuta(rutaGenerarPDF));
    }

    public String truncarRuta(String ruta){
        if(ruta.length()>40){
            return ruta.substring(0,40)+"...";
        }else{
            return ruta;
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
            java.util.logging.Logger.getLogger(generadorPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generadorPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generadorPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generadorPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generadorPDF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton botonGenerarPDF;
    private javax.swing.JButton botonSeleccionarDirectorio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labeDirectorio;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JRadioButton radioVentas;
    private javax.swing.JRadioButton radioVentasCliente;
    private javax.swing.JRadioButton radioVentasMarca;
    private javax.swing.JRadioButton radioVentasUsuario;

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radio = (JRadioButton) e.getSource();
        if(radio.isSelected()){
            this.botonSeleccionarDirectorio.setEnabled(true);
        }
    }
    // End of variables declaration
}
