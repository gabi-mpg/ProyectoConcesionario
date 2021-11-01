package Interfaz;

import conexionbasedatos.MNGDB;

import javax.swing.*;
import java.awt.*;
import java.net.ConnectException;
import java.sql.Connection;

import static conexionbasedatos.Utilidades.reescalarImagen;

public class mainInterface extends JFrame {

    private Connection conexion;
    private int nivelUsuario;
    private String user;
    private GridBagConstraints gestor;
    private JPanel panelUsuario,panelGeneral,panelClientes, panelMotos,panelVentas;
    private JTabbedPane pestana;

    public mainInterface(Connection conexion, int nivelUsuario, String user){
        this.conexion = conexion;
        this.nivelUsuario = nivelUsuario;
        this.user = user;
        gestor = new GridBagConstraints();
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/3,d.height/5); //Hay que centrar bien
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void initComponents(){
        panelUsuario = new JPanel();
        panelUsuario.setPreferredSize(new Dimension(590,70));
        panelUsuario.setBackground(Color.red); //para visualizar
        compPanelUsuario();
        panelGeneral = new JPanel();
        panelGeneral.setPreferredSize(new Dimension(600,700));
        pestana = new JTabbedPane();
        pestana.setPreferredSize(new Dimension(590,620));
        panelClientes = new JPanel();

        panelMotos = new JPanel();
        panelVentas = new JPanel();

        panelClientes.add(new JButton(""));
        panelVentas.add(new JButton(""));
        panelMotos.add(new JButton(""));
        pestana.addTab("Ventas",panelVentas);
        pestana.add("Motos",panelMotos);
        pestana.add("Clientes",panelClientes);
        panelGeneral.add(panelUsuario);
        panelGeneral.add(pestana);

        add(panelGeneral);
    }

    private void compPanelUsuario(){
        ImageIcon nuevaImagen = reescalarImagen(new ImageIcon(MNGDB.RUTA_REC+"BBDDError.png"),50,50);
        JLabel nick = new JLabel("Prueba nombre usuario");
        JLabel nombre = new JLabel("Prueba nombre y apellido");
        anadir(new JLabel(nuevaImagen),panelUsuario,0,0,20,1,10,10,10,200,GridBagConstraints.LINE_START);
        anadir(nick,panelUsuario,1,0,1,1,10,10,10,10,GridBagConstraints.LINE_START);
        anadir(nombre, panelUsuario,2,2,10,10,10,10,10,10,GridBagConstraints.LINE_START);
    }

    private void anadir(Component comp, JPanel panel, int col, int row, int width, int heigth, int top, int bottom, int left, int rigth, int pos){
        gestor.gridx = col;
        gestor.gridy = row;
        gestor.gridwidth = width;
        gestor.gridheight = heigth;
        gestor.insets = new Insets(top, left, bottom,rigth);
        gestor.anchor = pos;
        panel.add(comp,gestor);
    }

}
