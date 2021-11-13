/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas.Interfaces;

import controllers.ControllerConexion;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import static java.awt.Cursor.HAND_CURSOR;
import static utils.Utilidades.jMensaje;

/**
 *
 * @author chris
 */
public class interfazLogin extends javax.swing.JFrame{

    private final modelo.config configuracion;
    private final ControllerConexion conexion;
    private javax.swing.JLabel configLabel;
    private javax.swing.JButton botonLogin;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JPasswordField campoClave;
    private javax.swing.JTextField campoUsuario;

    /*
    Constructor de la clase
     */
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
    
    
   /*
   Se encarga de inicializar cada uno de los componentes del frame, dándoles posición, tamaño y funcionalidad
    */
    private void initComponents() {
        setTitle("Concesonario Mercado Corral");
        Image icono = Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES+"icono.png");
        setIconImage(icono);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());


        java.awt.GridBagConstraints gridBagConstraints;
        jLabelSalir = new javax.swing.JLabel();
        JLabel jLabelLogo = new JLabel();
        configLabel = new javax.swing.JLabel();
        JLabel jLabel1 = new JLabel();
        campoUsuario = new javax.swing.JTextField();
        campoClave = new javax.swing.JPasswordField();
        botonLogin = new javax.swing.JButton();
        JLabel jLabel2 = new JLabel();
        JPanel jPanel1 = new JPanel();
        JLabel fondoPantalla = new JLabel();


        jLabelSalir.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"iconoSalir.png")); // NOI18N
        jLabelSalir.setToolTipText("Cerrar la aplicación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(jLabelSalir, gridBagConstraints);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"imagenLogo.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        getContentPane().add(jLabelLogo, gridBagConstraints);

        configLabel.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"iconoConfig.png")); // NOI18N
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
        botonLogin.setPreferredSize(new Dimension(190, 30));
        botonLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

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

        fondoPantalla.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"wallpaper (Pequeño) (1).jpg")); // NOI18N
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

        jLabelSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        configLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pack();
    }

    /*
    Añade los eventos a las etiquetas (Para cerrar la ventana y abrir la configuración)
    Además de añadir el evento al botón de login con una expresión lambda
     */
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
        botonLogin.addActionListener(e -> login());
    }

    /*
    Comprueba si existew la conexión con la BBDD
    Comprueba si existe el usuario y, en función del usaurio logeado, envía a mainInterface un valor, con el que
    se determinarán las acciones disponibles para dicho usuario
    Tiene control de errores para evitar logeos maliciosos
     */
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
                    case 1:
                    case 2:
                    case 3:
                        new mainInterface(n, user, new ControllerConexion());
                        conexion.cerrarCn();
                        this.dispose();
                        break;
                    default:
                        jMensaje(this, "La contraseña introducida no coincide con el usuario", "Contraseña incorrecta", 2);
                        break;

                }
            }
        }

    }


}
