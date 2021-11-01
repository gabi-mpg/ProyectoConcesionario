package Interfaz;

import conexionbasedatos.config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class configInterface extends JFrame implements ActionListener {

    private String[] configuracionRecogida;
    private JPanel panelGeneral;
    private JTextField textoRuta, textoUser, textoClave;
    private JLabel labelUser, labelClave, labelRuta;
    private JButton boton;
    private GridBagConstraints gestor;
    private config configuracion;

    public configInterface(String[] config, config configuracion){
        super("Panel de configuracion");
        this.configuracionRecogida = config;
        this.configuracion = configuracion;
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

    private void initComponents(){
        gestor = new GridBagConstraints();
        panelGeneral = new JPanel();
        panelGeneral.setLayout(new GridBagLayout());
        panelGeneral.setPreferredSize(new Dimension(240,200));
        labelUser = new JLabel("User");
        labelClave = new JLabel("Clave");
        labelRuta = new JLabel("Ruta BBDD");
        boton  = new JButton("Guardar informacion");
        boton.setPreferredSize(new Dimension(170,20));
        boton.addActionListener(this);
        modificarTexto();
        textoRuta.setPreferredSize(new Dimension(120,20));
        textoClave.setPreferredSize(new Dimension(120,20));
        textoUser.setPreferredSize(new Dimension(120,20));
        anadir(textoRuta, panelGeneral,0,0,1,1,0,5,5,5,GridBagConstraints.LINE_START);
        anadir(labelRuta, panelGeneral,1,0,1,1,0,5,5,5,GridBagConstraints.LINE_START);
        anadir(textoUser, panelGeneral,0,1,1,1,10,5,5,5,GridBagConstraints.LINE_START);
        anadir(labelUser, panelGeneral,1,1,1,1,10,5,5,5,GridBagConstraints.LINE_START);
        anadir(textoClave, panelGeneral,0,2,1,5,10,5,5,1,GridBagConstraints.LINE_START);
        anadir(labelClave, panelGeneral,1,2,1,5,10,5,5,1,GridBagConstraints.LINE_START);
        anadir(boton, panelGeneral,0,3,2,5,50,5,5,1,GridBagConstraints.LINE_START);

        add(panelGeneral);

    }

    private void modificarTexto(){
        textoRuta  = new JTextField();
        textoClave = new JTextField();
        textoUser = new JTextField();
        textoRuta.setText(configuracionRecogida[0]);
        textoUser.setText(configuracionRecogida[1]);
        textoClave.setText(configuracionRecogida[2]);
    }

    private void anadir(Component comp, JPanel panel,int col, int row, int width, int heigth, int top, int bottom, int left, int rigth, int pos){
        gestor.gridx = col;
        gestor.gridy = row;
        gestor.gridwidth = width;
        gestor.gridheight = heigth;
        gestor.insets = new Insets(top, left, bottom,rigth);
        gestor.anchor = pos;
        panel.add(comp,gestor);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String s1,s2,s3;
        s1 = textoRuta.getText();
        s2 = textoUser.getText();
        s3 = textoClave.getText();
        if(s1.isEmpty() | s2.isEmpty()){
            JOptionPane.showMessageDialog(this,"Faltan campos por completar");
        }else{
            String[] devuelta = {s1,s2,s3};
             configuracion.setConfig(devuelta);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}
