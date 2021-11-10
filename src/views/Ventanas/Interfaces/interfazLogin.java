/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas.Interfaces;

import controllers.ControllerConexion;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import static utils.Utilidades.jMensaje;

/**
 *
 * @author chris
 */
public class interfazLogin extends javax.swing.JFrame{

    private modelo.config configuracion;
    private ControllerConexion conexion;

    private String ruta = System.getProperty("user.dir")+
            File.separator+"src"+File.separator+"views"+File.separator
            +"imagenes"+ File.separator;

    public interfazLogin() {
        conexion = new ControllerConexion();
        configuracion = new modelo.config();
        initComponents();
        conexion.setRegistros();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        anadirEvento();
        pack();
    }
    
    
    private void anadirEvento(){
        this.jLabelSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
               System.exit(0); 
            }
        });
        this.configLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] configuracionIncial = new modelo.config().getConfig();
                new interfazConfig(configuracionIncial,configuracion);

            }
        });
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

        jLabelSalir = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        configLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        campoClave = new javax.swing.JPasswordField();
        botonLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelSalir.setIcon(new javax.swing.ImageIcon(ruta+"iconoSalir.png")); // NOI18N
        jLabelSalir.setToolTipText("Cerrar la aplicación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(jLabelSalir, gridBagConstraints);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(ruta+"imagenLogo.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        getContentPane().add(jLabelLogo, gridBagConstraints);

        configLabel.setIcon(new javax.swing.ImageIcon(ruta+"iconoConfig.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(configLabel, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(255, 51, 102));
        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel1, gridBagConstraints);

        campoUsuario.setColumns(15);
        campoUsuario.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        campoUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        getContentPane().add(campoUsuario, gridBagConstraints);

        campoClave.setColumns(15);
        campoClave.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        campoClave.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        getContentPane().add(campoClave, gridBagConstraints);

        botonLogin.setBackground(new java.awt.Color(102, 102, 102));
        botonLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonLogin.setForeground(new java.awt.Color(255, 255, 255));
        botonLogin.setText("Iniciar sesión");
        botonLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        getContentPane().add(botonLogin, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(255, 51, 102));
        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel2, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());

        fondoPantalla.setIcon(new javax.swing.ImageIcon(ruta+"wallpaper (Pequeño) (1).jpg")); // NOI18N
        fondoPantalla.setMinimumSize(new java.awt.Dimension(0, 0));
        fondoPantalla.setPreferredSize(new java.awt.Dimension(250, 400));
        jPanel1.add(fondoPantalla, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login();
    }//GEN-LAST:event_jButton1ActionPerformed


    private void login() {
        conexion.setRegistros();
        if(!conexion.conectarComprobar()){
            JOptionPane.showMessageDialog(this,"No hay conexión con la BBDD, revisa la configuración");
        }else{
            String user = campoUsuario.getText();
            String pass = new String(campoClave.getPassword());
            conexion.setRegistros();
            //hay que primero leer los registros antes de hacer el login y despues hacer lo que sea que tal
            if (user.isEmpty() | pass.isEmpty()) {
                jMensaje(this, "Faltan campos por completar", "Falta información", 2);
            } else {
                int n = conexion.login(user, pass);
                System.out.println(n);
                switch (n) {
                    case -4:
                        jMensaje(this, "Ha ocurrido un error", "Error en la conexion", 0);
                        break;
                    case -2:
                        jMensaje(this, "Ha ocurrido un error", "Error en la conexion", 0);
                        System.exit(0);
                        break;
                    case -1:
                    case 0:
                        jMensaje(this, "El usuario " + user + " no existe", "Usuario incorrecto", 2);
                        break;
                    case-3:
                        jMensaje(this, "La contraseña introducida no coincide con el usuario", "Contraseña incorrecta", 2);
                        break;
                    default:
                        new mainInterface(n, new ControllerConexion());
                        conexion.cerrarCn();
                        this.dispose();
                        break;
                }
            }
        }

    }


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
            java.util.logging.Logger.getLogger(interfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfazLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel configLabel;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JButton botonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField campoClave;
    private javax.swing.JTextField campoUsuario;
    // End of variables declaration//GEN-END:variables

}
