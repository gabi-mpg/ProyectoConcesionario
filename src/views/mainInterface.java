package views;

import controllers.MNGDB;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

import static controllers.Utilidades.reescalarImagen;

public class mainInterface extends JFrame {

    private Connection conexion;
    private int nivelUsuario;
    private String user;
    private GridBagConstraints gestor;
    private JPanel panelUsuario,panelGeneral,panelClientes, panelMotos,panelVentas;
    private JTabbedPane pestana;

    public mainInterface(Connection conexion, int nivelUsuario, String user){
        super("Concesionario Gaby Chris");
        this.conexion = conexion;
        this.nivelUsuario = nivelUsuario;
        this.user = user;
        gestor = new GridBagConstraints();
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/3,d.height/5); //Hay que centrar bien
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
    }

    private void initComponents(){
        panelUsuario = new JPanel();
        panelUsuario.setPreferredSize(new Dimension(590,70));
        panelUsuario.setLayout(new GridBagLayout());
        compPanelUsuario();
        panelGeneral = new JPanel();
        panelGeneral.setPreferredSize(new Dimension(600,700));
        pestana = new JTabbedPane();
        pestana.setPreferredSize(new Dimension(590,620));
        panelClientes = new JPanel();

        panelMotos = new JPanel();
        panelVentas = new JPanel();
        pestana.addTab("Ventas",panelVentas);
        pestana.add("Motos",panelMotos);
        pestana.add("Clientes",panelClientes);
        panelGeneral.add(panelUsuario);
        panelGeneral.add(pestana);
        initPanelComponents(panelVentas);
        initPanelComponents(panelClientes);
        initPanelComponents(panelMotos);
        add(panelGeneral);
    }

    private void initPanelComponents(JPanel panel){
        panel.setLayout(new GridLayout(2,2));
        JPanel panelConsultar = new JPanel();
        panelConsultar.setBorder(BorderFactory.createLineBorder(Color.gray));
        JPanel panelModificar = new JPanel();
        panelModificar.setBorder(BorderFactory.createLineBorder(Color.gray));
        JPanel panelInsertar = new JPanel();
        panelInsertar.setBorder(BorderFactory.createLineBorder(Color.gray));
        JPanel panelEliminar = new JPanel();
        panelEliminar.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.add(panelInsertar);
        panel.add(panelConsultar);
        panel.add(panelModificar);
        panel.add(panelEliminar);
        String[] valores = {"Matricula","Marca","Color","Direccion"};
        panelInsertar(panelInsertar,"Motos",valores);
    }

    private void compPanelUsuario(){
        ImageIcon nuevaImagen = reescalarImagen(new ImageIcon(MNGDB.RUTA_REC+"BBDDError.png"),50,50);
        JLabel nick = new JLabel("Prueba nombre usuario");
        JLabel nombre = new JLabel("Prueba nombre y apellido");
        anadir(new JLabel(nuevaImagen),panelUsuario,0,1,1,2,10,10,10,10,GridBagConstraints.CENTER);
        anadir(nick,panelUsuario,1,1,1,1,20,10,0,340,GridBagConstraints.CENTER);
        anadir(nombre, panelUsuario,1,2,1,1,0,20,10,340,GridBagConstraints.CENTER);
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

    private void panelInsertar(JPanel panelPadre, String campo, String[] valores){
        panelPadre.setLayout(new GridBagLayout());
        JLabel titulo = new JLabel("Insertar "+campo);
        JLabel etiqueta1 = new JLabel(valores[0]);
        JLabel etiqueta2 = new JLabel(valores[1]);
        JLabel etiqueta3 = new JLabel(valores[2]);
        JLabel etiqueta4 = new JLabel(valores[3]);
        JTextField campo1 = new JTextField();
        JTextField campo2 = new JTextField();
        JTextField campo3 = new JTextField();
        JTextField campo4 = new JTextField();
        titulo.setPreferredSize(new Dimension(50,80));
        etiqueta1.setPreferredSize(new Dimension(80,50));
        etiqueta2.setPreferredSize(new Dimension(80,50));
        etiqueta3.setPreferredSize(new Dimension(80,50));
        etiqueta4.setPreferredSize(new Dimension(80,50));
        campo1.setPreferredSize(new Dimension(120,20));
        campo2.setPreferredSize(new Dimension(120,20));
        campo3.setPreferredSize(new Dimension(120,20));
        campo4.setPreferredSize(new Dimension(120,20));
        anadir(titulo,panelPadre,0,0,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(campo1,panelPadre,0,1,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(campo2,panelPadre,0,2,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(campo3,panelPadre,0,3,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(campo4,panelPadre,0,4,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(etiqueta1,panelPadre,1,1,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(etiqueta2,panelPadre,1,2,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(etiqueta3,panelPadre,1,3,1,1,5,5,5,5,GridBagConstraints.LINE_START);
        anadir(etiqueta4,panelPadre,1,4,1,1,5,5,5,5,GridBagConstraints.LINE_START);



    }

}
