package conexionbasedatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfazz extends JFrame implements ActionListener {

    private JPanel panelIndicador, panelLogin;
    private JButton botonConexion, botonLogin;
    private JTextField campousuario;
    private JLabel textoUsuario, textoClave;
    private JPasswordField campoClave;
    private GridBagConstraints gestor;
    private MNGDB conexion;


    public Interfazz(){
        super("Iniciar sesion");
        conexion = new MNGDB(this);
        initComponents();
        addComponents();
        habilitar(false);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/4+d.width/6,d.height/3);
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
        botonConexion.addActionListener(this);
        botonLogin.addActionListener(this);
        botonConexion.setPreferredSize(new Dimension(160,20));
        botonLogin.setPreferredSize(new Dimension(120,30));
        campousuario.setPreferredSize(new Dimension(180,20));
        campoClave.setPreferredSize(new Dimension(180,20));

        /*Para añadir los componentes modo chevere hay que usar gridBagLayout con un gestor del tipo
        * GridBagConstraint. Cada vez que se añade un componente nuevo, hay que establecer las propiedades para que se
        * coloque de cierta manera, es por eso que cree el método anadir, donde se puede ver con las etiquetas del
        * intelliJ que propiedad del Constraint estamos modificando*/

        anadir(botonLogin,panelLogin,0,3,1,1,10,0,0,0,GridBagConstraints.LINE_START);
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
        if(s.equals(botonConexion.getActionCommand())){
            if(!conexion.estado()){
                if(conexion.establecerConexion()){
                    panelIndicador.setBackground(Color.green);
                    habilitar(true);
                    JOptionPane.showMessageDialog(this, "Se ha conectado a la base de datos");
                    botonConexion.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(this,"No se ha podido establecer conexión");
                }
            }else{
                if(conexion.cerrarConexion()){
                    panelIndicador.setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Se ha desconectado de la base de datos");
                }
            }
        }else{
            String user = campousuario.getText();
            String pass = new String(campoClave.getPassword());
            if(user.isEmpty() | pass.isEmpty()){
                JOptionPane.showMessageDialog(this,"Faltan campos por completar");
            }else{
                int n = conexion.iniciarSesion(user,pass);
                System.out.println(n);
                switch (n){
                    case 1:
                        //Aquí van las diferentes ventanas que vamos a programar en futuras versiones :p
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    default:
                        break;
                }

            }
        }
    }
}
