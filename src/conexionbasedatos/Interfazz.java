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
       panelLogin.setBackground(Color.blue);
        gestor = new GridBagConstraints();
        add(panelLogin, BorderLayout.SOUTH);

        panelLogin.setLayout(new GridBagLayout());
        gestor = new GridBagConstraints();

    }

    public void addComponents(){
        botonConexion = new JButton("Conectar con BBDD");
        textoUsuario = new JLabel("Usuario");
        textoClave = new JLabel("Contraseña");
        botonLogin = new JButton("Iniciar sesion");
        campoClave = new JPasswordField();
        campousuario = new JTextField();
        botonConexion.setPreferredSize(new Dimension(160,20));
        botonLogin.setPreferredSize(new Dimension(120,30));
        campousuario.setPreferredSize(new Dimension(180,20));
        campoClave.setPreferredSize(new Dimension(180,20));

        /*Para añadir los componentes como hace falta hay que usar este gridBagLayout con un gestor del tipo
        * GridBagConstraint. Cada vez que se añade un componente, hay que establecer las propiedades para que se
        * coloque de cierta manera, es por eso que cree el método anadir, donde se puede ver con las etiquetas del
        * intelliJ que propiedad del Constraint estamos modificando*/

        anadir(botonLogin,panelLogin,0,3,1,1,0,0,0,0,GridBagConstraints.LINE_START);
        anadir(botonConexion,panelLogin,0,0,1,1,0,10,0,0,GridBagConstraints.LINE_START);

        anadir(textoUsuario,panelLogin,1,1,1,1,0,0,0,0,GridBagConstraints.LINE_START);
        anadir(textoClave,panelLogin,1,2,1,1,0,0,0,0,GridBagConstraints.LINE_START);

        anadir(campoClave,panelLogin,0,2,1,1,0,0,0,20,GridBagConstraints.LINE_START);
        anadir(campousuario,panelLogin,0,1,1,1,0,0,0,20,GridBagConstraints.LINE_START);



    }

    /**
     *
     * @param comp Componente que queremos añadir
     * @param panel El panel al que lo vamos a añadir
     * @param col Columna x (Izquiera a derecha) donde lo queremos añadir
     * @param row Fila Y (Arriba a abajo) donde lo queremos añadir
     * @param width Numero de columnas que va a ocupar
     * @param heigth Numero de filas qeu va a ocupar
     * @param top Margin superior
     * @param bottom Margin inferior
     * @param left Margin izquierdo
     * @param rigth Margin derechi
     * @param pos Posición, dentro del panel, donde se va a colocar el elemento, son constantes de la clase GridBagConstraint
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



}
