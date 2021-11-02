package Interfaz;

import conexionbasedatos.MNGDB;
import conexionbasedatos.config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conexionbasedatos.Utilidades.*;

import static conexionbasedatos.Utilidades.jMensaje;
import static conexionbasedatos.Utilidades.reescalarImagen;

public class loginInterface extends JFrame implements ActionListener {

    private JPanel panelIndicador, panelLogin;
    private JButton botonConexion, botonLogin, botonConfig;
    private JTextField campousuario;
    private JPasswordField campoClave;
    private GridBagConstraints gestor;
    private final MNGDB conexion;
    private final config configuracion = new config();



    public loginInterface(){
        super("Iniciar sesion");
        conexion = new MNGDB(this);
        conexion.setRegistros(configuracion.getConfig());
        initComponents();
        addComponents();
        habilitar(false);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/4+d.width/6,d.height/3);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    private void initComponents(){
        panelIndicador = new JPanel();
        panelIndicador.setPreferredSize(new Dimension(300,5));
        panelIndicador.setBackground(Color.red);
        add(panelIndicador,BorderLayout.NORTH);
        panelLogin = new JPanel(new GridBagLayout());
        panelLogin.setPreferredSize(new Dimension(300,200));
        gestor = new GridBagConstraints();
        add(panelLogin, BorderLayout.SOUTH);
        panelLogin.setLayout(new GridBagLayout());
        gestor = new GridBagConstraints();
    }

    public void addComponents(){
        botonConexion = new JButton("Conectar con BBDD");
        botonConfig = new JButton();
        botonConfig.setIcon(reescalarImagen(new ImageIcon(MNGDB.RUTA_REC+"confIcon.png"),15,15));
        botonConfig.setToolTipText("Configuración de acceso a la base de datos");
        //El boton de configuración está pendiente de ver si se añade o no

        JLabel textoUsuario = new JLabel("Usuario");
        JLabel textoClave = new JLabel("Contraseña");
        botonLogin = new JButton("Iniciar sesion");
        campoClave = new JPasswordField();
        campousuario = new JTextField();
        botonConexion.addActionListener(this);
        botonLogin.addActionListener(this);
        botonConfig.addActionListener(this);
        botonConexion.setPreferredSize(new Dimension(160,20));
        botonLogin.setPreferredSize(new Dimension(120,30));
        campousuario.setPreferredSize(new Dimension(180,20));
        campoClave.setPreferredSize(new Dimension(180,20));

        /*Para añadir los componentes modo chevere hay que usar gridBagLayout con un gestor del tipo
        * GridBagConstraint. Cada vez que se añade un componente nuevo, hay que establecer las propiedades para que se
        * coloque de cierta manera, es por eso que cree el método anadir, donde se puede ver con las etiquetas del
        * intelliJ que propiedad del Constraint estamos modificando*/

        anadir(botonLogin,panelLogin,0,3,1,1,10,0,0,0,GridBagConstraints.LINE_START);
        anadir(botonConfig,panelLogin,1,0,1,1,0,30,10,0,GridBagConstraints.LINE_START);
        anadir(botonConexion,panelLogin,0,0,1,1,0,30,0,0,GridBagConstraints.LINE_START);

        anadir(textoUsuario,panelLogin,1,1,1,1,10,10,0,0,GridBagConstraints.LINE_START);
        anadir(textoClave,panelLogin,1,2,1,1,10,10,0,0,GridBagConstraints.LINE_START);

        anadir(campoClave,panelLogin,0,2,1,1,10,10,0,20,GridBagConstraints.LINE_START);
        anadir(campousuario,panelLogin,0,1,1,1,10,10,0,20,GridBagConstraints.LINE_START);



    }

    /**
     * @param comp Componente que queremos añadir
     * @param panel El panel al que vamos a añadir el componente
     * @param col Columna x (Izquiera a derecha) donde lo queremos añadir
     * @param row Fila Y (Arriba a abajo) donde lo queremos añadir
     * @param width Numero de columnas que va a ocupar
     * @param heigth Numero de filas qeu va a ocupar
     * @param top Margin superior
     * @param bottom Margin inferior
     * @param left Margin izquierdo
     * @param rigth Margin derecho
     * @param pos Posición, dentro de la propia malla (grid)
     *           donde se va a colocar el elemento. Son constantes de la clase GridBagConstraint
     */
    private void anadir(Component comp, JPanel panel,int col, int row, int width, int heigth, int top, int bottom, int left, int rigth, int pos){
        gestor.gridx = col;
        gestor.gridy = row;
        gestor.gridwidth = width;
        gestor.gridheight = heigth;
        gestor.insets = new Insets(top, left, bottom,rigth);
        gestor.anchor = pos;
        panel.add(comp,gestor);
    }

    public void habilitar(boolean estado){
        this.campousuario.setEnabled(estado);
        this.campoClave.setEnabled(estado);
        this.botonLogin.setEnabled(estado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals(botonConexion.getActionCommand())) {
            this.conexion.setRegistros(configuracion.getConfig());
            cambioIndicador();
        } else if(s.equals(botonLogin.getActionCommand())){
            login();
        }else{
            this.setEnabled(false);
            new configInterface(configuracion.getConfig(),configuracion, this);
            System.out.println("vuelta al principal");
            this.conexion.setRegistros(configuracion.getConfig());
        }
    }


    private void cambioIndicador() {
        if (!conexion.estado()) {
            if (conexion.establecerConexion()) {
                panelIndicador.setBackground(Color.green);
                habilitar(true);
                jMensaje(this,"Se ha conectado a la base de datos","Conexión establecida",1);
                botonConexion.setEnabled(false);
                botonConfig.setEnabled(false);
            } else {
                jMensaje(this,"No se ha podido establecer conexión","Error de conexión",0);
            }
        } else {
            if (conexion.cerrarConexion()) {
                panelIndicador.setBackground(Color.red);
                jMensaje(this,"Se ha desconectado de la base de datos","Conexión cerrada",1);
            }
        }
    }


    private void login(){
            String user = campousuario.getText();
            String pass = new String(campoClave.getPassword());
            if(user.isEmpty() | pass.isEmpty()){
                jMensaje(this,"Faltan campos por completar","Falta información",2);
            }else{
                int n = conexion.iniciarSesion(user,pass);
                System.out.println(n);
                switch (n){
                    case -2:
                        jMensaje(this,"Ha ocurrido un error","Error en la conexion",0);
                        System.exit(0);
                        break;
                    case -1:
                        jMensaje(this,"El usuario "+user+" no existe","Usuario incorrecto",2);
                        break;
                    case 0:
                        jMensaje(this,"La contraseña introducida no coincide con el usuario","Contraseña incorrecta",2);
                        break;
                    default:
                        new mainInterface(conexion.getConexion(),n,user);
                        //Esta ventana está en proceso
                        this.dispose();
                        break;
                }
            }
        }


}

