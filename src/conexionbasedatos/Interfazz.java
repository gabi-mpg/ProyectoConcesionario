package conexionbasedatos;

import javax.swing.*;
import java.awt.*;

public class Interfazz extends JFrame {

    private JPanel panelIndicador, panelGeneral, panelLogin;
    private JButton botonConexion, botonLogin;
    private JTextField campousuario;
    private JLabel textoUsuario, textoClave;
    private JPasswordField campoClave;
    private GridBagConstraints gestor;


    public Interfazz(){
        super("Iniciar sesion");
        initComponents();
        addComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        pack();
    }

    private void initComponents(){
        panelIndicador = new JPanel();
        panelIndicador.setPreferredSize(new Dimension(300,5));
        panelIndicador.setBackground(Color.red);
        add(panelIndicador,BorderLayout.NORTH);
        panelLogin = new JPanel(new GridBagLayout());
        panelLogin.setPreferredSize(new Dimension(300,200));
//        panelLogin.setBackground(Color.blue);
        gestor = new GridBagConstraints();
        add(panelLogin, BorderLayout.SOUTH);

        panelLogin.setLayout(new GridBagLayout());
        gestor = new GridBagConstraints();

    }

    public void addComponents(){
        botonConexion = new JButton("Conectar con BBDD");
        add(botonConexion);
        textoUsuario = new JLabel("Usuario");
        textoClave = new JLabel("Contraseña");
        botonLogin = new JButton("Iniciar sesion");
        campoClave = new JPasswordField();
        campousuario = new JTextField();
        panelLogin.setLayout(new GridLayout(2,2));
        botonConexion.setPreferredSize(new Dimension(160,20));
        botonLogin.setPreferredSize(new Dimension(120,30));
        campousuario.setPreferredSize(new Dimension(180,20));
        campoClave.setPreferredSize(new Dimension(180,20));
        panelLogin.add(campousuario);
        panelLogin.add(textoUsuario);
        panelLogin.add(campoClave);
        panelLogin.add(textoClave);




    }



}
