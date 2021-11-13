/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Ventanas.Interfaces;

import controllers.ControllerConexion;

import utils.estaticas;
import views.Ventanas.Paneles.*;
import views.Ventanas.panelesMenu.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import static utils.estaticas.*;

/**
 *
 * @author chris
 */
public class mainInterface extends javax.swing.JFrame implements ActionListener{

    private final String nombreUsuario;
    private JMenuItem abrirBBDD,generarPDF,estadistica, cambiarTema,
            verConexion,cerrarSesion, quienesSomos, contactoNosotros;
    private javax.swing.JButton botonClientes, botonMotos, botonUsuarios, botonVentas;
    private javax.swing.JPanel jPanel1,panelSecundario;
    private final int nivelUsuario;
    private final ControllerConexion conexion;
    boolean modoOscuro = false;

    //Paneles propios
    private Motos panelMotos;
    private Ventas panelVentas;
    private Usuarios panelUsuario;
    private Clientes panelClientes;


    public mainInterface(int nivelUsuario, String nombreUsuario, ControllerConexion conexion){
        this.nivelUsuario = nivelUsuario;
        this.conexion = conexion;
        this.nombreUsuario = nombreUsuario;
        initComponents();
        setResizable(false);
        setVisible(true);
        pack();
    }

    /*
    Se encarga de inicializar cada uno de los componentes del frame, dándoles posición, tamaño y funcionalidad
     */
    private void initComponents() {
        setTitle("Concesionario Mercado Corral");
        Image icono = Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES+"icono.png");
        setIconImage(icono);

        java.awt.GridBagConstraints gridBagConstraints;
        jPanel1 = new javax.swing.JPanel();
        JLabel logoMain = new JLabel();
        botonVentas = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonMotos = new javax.swing.JButton();
        botonUsuarios = new javax.swing.JButton();
        botonUsuarios.setEnabled(false);
        panelSecundario = new panelPrincipal();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 450));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        logoMain.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"imagenLogo (Personalizado)_1.png")); // NOI18N
        logoMain.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 3;
        jPanel1.add(logoMain, gridBagConstraints);

        botonVentas.setText("Ventas");
        botonVentas.setPreferredSize(new Dimension(90, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(37, 2, 19, 2);
        jPanel1.add(botonVentas, gridBagConstraints);

        botonClientes.setText("Clientes");
        botonClientes.setPreferredSize(new Dimension(90, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(25, 2, 26, 2);
        jPanel1.add(botonClientes, gridBagConstraints);

        botonMotos.setText("Motos");
        botonMotos.setPreferredSize(new Dimension(90, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(15, 2, 26, 2);
        jPanel1.add(botonMotos, gridBagConstraints);

        botonUsuarios.setText("Usuarios");
        botonUsuarios.setPreferredSize(new Dimension(90, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(15, 2, 26, 2);
        jPanel1.add(botonUsuarios, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        JLabel nuevaFoto = new JLabel();
        nuevaFoto.setIcon(new ImageIcon(estaticas.RUTA_IMAGENES+"fotoPrincipal.jpg"));
        panelSecundario.setPreferredSize(new java.awt.Dimension(600, 300));
        panelSecundario.setLayout(new java.awt.BorderLayout());
        panelSecundario.add(nuevaFoto);
        getContentPane().add(panelSecundario, java.awt.BorderLayout.CENTER);

        this.panelClientes = new Clientes(nivelUsuario);
        this.panelMotos = new Motos(nivelUsuario);
        this.panelUsuario = new Usuarios(nivelUsuario);
        this.panelVentas = new Ventas(nivelUsuario, nombreUsuario);

        botonVentas.addActionListener(this);
        botonVentas.addActionListener(this);
        botonClientes.addActionListener(this);
        botonMotos.addActionListener(this);
        botonUsuarios.addActionListener(this);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/4+ d.width/32, d.height/4);

        anadirMenu();
        anadirPaneles();
        cambiarTema();
        eventos();
        alterarPermisos();

    }

    /*
    Añade eventos a cada uno de los botones, con su predeterminado
     */
    private void eventos(){
        //Se hace uso de expresiones lambda para acortar el códidog
        generarPDF.addActionListener(e -> new generadorPDF());
        abrirBBDD.addActionListener(e -> abrirBBDD());
        verConexion.addActionListener(e -> mostrarConexionActual());
        cerrarSesion.addActionListener(e -> cerrarSesion());
        cambiarTema.addActionListener(e -> cambiarTema());
        estadistica.addActionListener(e -> new generadorGraficos());
        contactoNosotros.addActionListener(e -> new contacto());
        quienesSomos.addActionListener(e -> new frameNosotros());
    }

    /*
    Mediante el uso de la variable booleana "modoOscuro", establece el tema tanto del JFrame como
    de los paneles secundarios que este va a utilizar
     */
    private void cambiarTema(){
        if (modoOscuro){
            botonVentas.setBackground(new Color(246, 231, 23));
            botonClientes.setBackground(new Color(246, 231, 23));
            botonMotos.setBackground(new Color(246, 231, 23));
            botonUsuarios.setBackground(new Color(246, 231, 23));
            jPanel1.setBackground(new Color(118, 118, 118));
            panelSecundario.setBackground(new Color(53, 52, 53));
            panelSecundario.setForeground(new Color(128, 128, 128));
            panelMotos.cambiarTema();
            panelClientes.cambiarTema();
            panelUsuario.cambiarTema();
            panelVentas.cambiarTema();
            modoOscuro = false;
        } else {
            botonVentas.setBackground(new Color(218, 218, 218));
            botonClientes.setBackground(new Color(218, 218, 218));
            botonMotos.setBackground(new Color(218, 218, 218));
            botonUsuarios.setBackground(new Color(218, 218, 218));
            panelSecundario.setBackground(new java.awt.Color(153, 255, 153));
            panelSecundario.setForeground(new java.awt.Color(204, 255, 204));
            jPanel1.setBackground(new java.awt.Color(255, 153, 204));
            panelMotos.cambiarTema();
            panelClientes.cambiarTema();
            panelUsuario.cambiarTema();
            panelVentas.cambiarTema();
            modoOscuro = true;
        }
    }

    /*
    Hace un dispose de este Frame y vuelve a mostrar el JFrame del login anterior
     */
    private void cerrarSesion(){
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> new interfazLogin().setVisible(true));

    }

    /*
    Mediante el uso de la clase Desktop, accede a la ruta predeterminada de instalación del MySql Workbench
    y lo inicializa. Siempre que esta ruta no sea diferente a la predeterminada, se abrirá el programa
     */
    private void abrirBBDD(){
        JOptionPane.showMessageDialog(null,"Se abrirá SQL Workbench si lo tiene insalado");
        try {
            Desktop.getDesktop().open(new File("C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\MySQLWorkbench.exe"));
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null,"No está instalado MySQL Workbench o se ha cambiado su ruta");
        }
    }

    /*
    Muestra, utilizando un JOptionPane, la información de la dirección, usuario y clave con la que nos hemos conectado
    a la BBDD, además del nombre
     */
    private void mostrarConexionActual(){
        String[] datosConexion = conexion.getRegistros();
        String s = "BBDD: \"Concesionario\"\nRuta: "+datosConexion[0]
                +"\nUsuario: "+datosConexion[1]+"\nClave: "+datosConexion[2];
        JOptionPane.showMessageDialog(this,s,"Datos sobre la conexion", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
    Altera el estado habilitado/inhabilitado en función del nivel de usuario que le ha llegao después del login.
    Sólo los usuarios con ID == 1 tendrán acceso a las funcionalidades del panel "Usuarios"
     */
    private void alterarPermisos(){
        if(nivelUsuario == 1){
            this.botonUsuarios.setEnabled(true);
        }
    }

    /*
    Crea, inicializa y añade tanto el menuBar, como sus componentes, y los añade al Jframe
     */
    private void anadirMenu(){
        JMenuBar barra = new JMenuBar();

        //Código para la pestaña de archivo
        JMenu menu_archivo = new JMenu("Archivo");
        barra.add(menu_archivo);
        abrirBBDD = new JMenuItem("Abrir BBDD");
        generarPDF = new JMenuItem("Generar PDF");
        estadistica = new JMenuItem("Ver estadísticas");
        menu_archivo.add(abrirBBDD);
        menu_archivo.add(generarPDF);
        menu_archivo.add(estadistica);

        //Código para la pestaña de opciones
        JMenu menu_opciones = new JMenu("Opciones");
        barra.add(menu_opciones);
        cambiarTema = new JMenuItem("Cambiar tema");
        verConexion = new JMenuItem("Datos sobre la conexión");
        cerrarSesion = new JMenuItem("Cerrar la sesión");
        menu_opciones.add(verConexion);
        menu_opciones.add(cambiarTema);
        menu_opciones.add(cerrarSesion);

        //Código del menu acerca de
        JMenu menu_acerca = new JMenu("Acerca de");
        barra.add(menu_acerca);
        quienesSomos = new JMenuItem("¿Quiénes somos?");
        contactoNosotros = new JMenuItem("¡Contacta con nosotros!");
        menu_acerca.add(quienesSomos);
        menu_acerca.add(contactoNosotros);

        //Añadir el menu al frame principal
        setJMenuBar(barra);
    }

    /*
    Este método se ejcuta al inicializar la aplicación, crea todos los paneles y los establece como
    visibles para después, en el método "cambiarPanel" sólo se tengan que poner Visibles
     */
    private void anadirPaneles(){
        panelSecundario.add(panelClientes);
        panelSecundario.add(panelMotos);
        panelSecundario.add(panelVentas);
        panelSecundario.add(panelUsuario);
        panelClientes.setVisible(false);
        panelMotos.setVisible(false);
        panelVentas.setVisible(false);
        panelUsuario.setVisible(false);
    }


    /*
    Mediante el uso de la variable String (Cuyo valor vendrá dado por variables estáticas de la clase utils.estaticas,
    mostrará un panel determinado, eliminando los demás
     */
    public void cambiarPanel(String panelCambio){
        ocultar();
        anadirPaneles();
        switch(panelCambio){
            case PANEL_CLIENTE:
                panelClientes.fillTable();
                panelSecundario.add(panelClientes);
                this.panelClientes.setVisible(true);
                mostrar();
                break;
            case PANEL_MOTO:
                panelMotos.fillTable();
                panelSecundario.add(panelMotos);
                this.panelMotos.setVisible(true);
                mostrar();
                break;
            case PANEL_USUARIO:
                panelUsuario.fillTable();
                panelSecundario.add(panelUsuario);
                this.panelUsuario.setVisible(true);
                mostrar();
                break;
            case PANEL_VENTA:
                panelVentas.fillTable();
                panelSecundario.add(panelVentas);
                this.panelVentas.setVisible(true);
                mostrar();
                break;
        }
        panelSecundario.repaint();
    }

    /*
    Haciendo uso de un Hilo, reduce el tamaño del JFrame. Ver comentario de la clase
     */
    public void ocultar(){
        Thread t = new Thread(new esconderPanel(this));
        t.start();

    }

    /*
    Haciendo uso de un Hilo, aumenta el tamaño del JFrame. Ver comentario de la clase
     */
    public void mostrar(){
        Thread o = new Thread(new mostrarPanel(this));
        o.start();
    }

    /*
    Método heredado de ActionListener. Se utiliza para cambiar los paneles, enviando al método cambiarPanel
    un final static String en función de qué botón se ha pulsado, cambiando un panel u otro
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        remove(panelClientes);
        remove(panelMotos);
        remove(panelVentas);
        remove(panelUsuario);
        JButton boton = (JButton) ae.getSource();
        if(boton == botonClientes){
            cambiarPanel(PANEL_CLIENTE);
            setTitle("Concesionario Mercado Corral - Clientes");
        }else if(boton == botonMotos){
            cambiarPanel(PANEL_MOTO);
            setTitle("Concesionario Mercado Corral - Motos");
        }else if(boton == botonVentas){
            panelVentas.setVisible(false);
            cambiarPanel(PANEL_VENTA);
            setTitle("Concesionario Mercado Corral - Ventas");
        }else if(boton == botonUsuarios){
            cambiarPanel(PANEL_USUARIO);
            setTitle("Concesionario Mercado Corral - Usuarios");
        }
    }

    /*
    Mediante el uso de un hilo, reduce el tamaño del JFrame principal
    hasta dejarlo del tamaño del panel donde están los botones
    Ventas, Clientes, Motos y Usuarios
     */
    static class esconderPanel implements Runnable{

        private final JFrame panel;

        public esconderPanel(JFrame panelCambio){
            this.panel = panelCambio;
        }

        @Override
        public void run() {
            int n = panel.getWidth();
            while(n > 255){
                panel.setSize(n, panel.getHeight());
                n-=30;
                try{
                    Thread.sleep(1);
                }catch(InterruptedException io){
                    System.out.println(io.getMessage());
                }
            }
            panel.repaint();
        }
    }


    /*
    Mediante el uso de un hilo, aumenta el tamaño del JFrame principal
    hasta dejarlo con el tamaño original. Ocurre después de "class esconderPanel"
     */
    static class mostrarPanel implements Runnable{

        private final JFrame panel;

        public mostrarPanel(JFrame panelCambio){
            this.panel = panelCambio; //Panel que va a sufrir el cambio
        }

        @Override
        public void run() {
            try{
                Thread.sleep(100);
                int n = panel.getWidth();
                while(n < 850){
                    panel.setSize(n,panel.getHeight());
                    n += 25;
                    panel.repaint();
                    Thread.sleep(1);
                }
            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            panel.repaint();
        }
    }
}


    
    
    
    
    


