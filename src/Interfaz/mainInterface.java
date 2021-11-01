package Interfaz;

import conexionbasedatos.MNGDB;

import javax.swing.*;
import java.awt.*;
import java.net.ConnectException;
import java.sql.Connection;

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
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void initComponents(){
        panelGeneral = new JPanel();
        panelGeneral.setPreferredSize(new Dimension(600,700));
        pestana = new JTabbedPane();
        pestana.setPreferredSize(new Dimension(500,600));
        panelClientes = new JPanel();

        panelMotos = new JPanel();
        panelVentas = new JPanel();

        panelClientes.add(new JButton(""));
        panelVentas.add(new JButton(""));
        panelMotos.add(new JButton(""));
        pestana.addTab("Ventas",panelVentas);
        pestana.add("Motos",panelMotos);
        pestana.add("Clientes",panelClientes);
        panelGeneral.add(pestana);
        add(panelGeneral);
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
