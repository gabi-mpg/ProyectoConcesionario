package views.crudClientes;

import controllers.ClienteCRUD;
import controllers.MotoCRUD;
import entidades.Cliente;
import entidades.Moto;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelModificarCliente extends JDialog {


    /**
     *
     * @param dni El DNI se pasa por parámetro y se busca en la base de datos. Si existe en la base de datos
     *            se autocompletan los campos. Si no, envía un mensaje
     */
    public PanelModificarCliente(String dni) {
            setModal(true);
            initComponents();
            this.dni = (dni);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);
            rellenarCampos();
        }


        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">

        /**
         * Método que se encarga de inciializar todos los componentes de la interfaz graifca
         */
        private void initComponents() {

            setTitle("Modificar cliente");
            setIconImage(Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES+"iconoMod.png"));
            GridBagConstraints gridBagConstraints;

            panelTitulo = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            labelImagen = new javax.swing.JLabel();
            labelVariable = new javax.swing.JLabel();
            labelDNI = new javax.swing.JLabel();
            panelCuerpo = new javax.swing.JPanel();
            textoNombre = new javax.swing.JTextField();
            textoApellido = new javax.swing.JTextField();
            textoDireccion = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            panelBotton = new javax.swing.JPanel();
            botonModificar = new javax.swing.JButton();
            checkLimpiar = new javax.swing.JCheckBox();
            cnCliente = new ClienteCRUD();

            panelTitulo = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            labelImagen = new javax.swing.JLabel();
            labelVariable = new javax.swing.JLabel();
            labelDNI = new javax.swing.JLabel();
            panelCuerpo = new javax.swing.JPanel();
            textoNombre = new javax.swing.JTextField();
            textoApellido = new javax.swing.JTextField();
            textoDireccion = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            panelBotton = new javax.swing.JPanel();
            botonModificar = new javax.swing.JButton();
            checkLimpiar = new javax.swing.JCheckBox();

            getContentPane().setLayout(new java.awt.GridBagLayout());

            panelTitulo.setPreferredSize(new java.awt.Dimension(270, 100));
            panelTitulo.setLayout(new java.awt.GridBagLayout());

            jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel1.setText("Modificar cliente");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(jLabel1, gridBagConstraints);

            labelImagen.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"iconoMod.png")); // NOI18N
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(labelImagen, gridBagConstraints);

            labelVariable.setText("Modificar cliente con DNI:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
            panelTitulo.add(labelVariable, gridBagConstraints);

            labelDNI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            labelDNI.setText(" - ");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            panelTitulo.add(labelDNI, gridBagConstraints);

            getContentPane().add(panelTitulo, new java.awt.GridBagConstraints());

            panelCuerpo.setPreferredSize(new java.awt.Dimension(270, 270));
            panelCuerpo.setLayout(new java.awt.GridBagLayout());

            textoNombre.setPreferredSize(new java.awt.Dimension(130, 24));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(32, 13, 32, 13);
            panelCuerpo.add(textoNombre, gridBagConstraints);

            textoApellido.setPreferredSize(new java.awt.Dimension(130, 24));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.insets = new java.awt.Insets(32, 13, 32, 13);
            panelCuerpo.add(textoApellido, gridBagConstraints);

            textoDireccion.setPreferredSize(new java.awt.Dimension(130, 24));

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.insets = new java.awt.Insets(32, 13, 32, 13);
            panelCuerpo.add(textoDireccion, gridBagConstraints);

            jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel3.setText("Nombre");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(32, 19, 32, 19);
            panelCuerpo.add(jLabel3, gridBagConstraints);

            jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel4.setText("Apellidos");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(32, 19, 32, 19);
            panelCuerpo.add(jLabel4, gridBagConstraints);

            jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel5.setText("Direccion");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(32, 19, 32, 19);
            panelCuerpo.add(jLabel5, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            getContentPane().add(panelCuerpo, gridBagConstraints);

            panelBotton.setPreferredSize(new java.awt.Dimension(270, 100));
            panelBotton.setLayout(new java.awt.GridBagLayout());

            botonModificar.setText("Modificar registro");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelBotton.add(botonModificar, gridBagConstraints);

            checkLimpiar.setText("Limpiar campos");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelBotton.add(checkLimpiar, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            getContentPane().add(panelBotton, gridBagConstraints);
            pack();
            agregarListeners();
        }// </editor-fold>


    /**
     * Eventos que se encargan de dar funcionalidad al botón y al checkbox. El checkbox limpia todos
     * Modificar hace un update a la base de datos
     */
    private void agregarListeners(){
        checkLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkLimpiarActionPerformed(evt);
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modificar(actionEvent);
            }
        });
    }

    /**
     * Recoge el dni del constructor y con este hace una llamada a la base de datos para completar los campos de
     * la ventanas
     */
    public void rellenarCampos(){
            if (cnCliente.clienteExiste(dni)){
                if (cnCliente.buscarCliente(dni).getExiste() == 1){
                    Cliente cliente = cnCliente.buscarCliente(dni);
                    labelDNI.setText(dni);
                    textoNombre.setText(cliente.getNombre());
                    textoApellido.setText(cliente.getApellido());
                    textoDireccion.setText(cliente.getDireccion());
                    setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Los datos de este cliete no están disponibles");
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "EL cliente no existe en la BD");
                this.dispose();
            }

        }

    /**
     *
     * @param evt Evento recibido del checkbox. Limpia todos los campos de textxo de la ventana
     */
    private void checkLimpiarActionPerformed(ActionEvent evt) {
        textoApellido.setText("");
        textoDireccion.setText("");
        textoNombre.setText("");
        checkLimpiar.setSelected(false);
    }

    /**
     *
     * @param evt Recoge el evento del boton. Recoge los valores de todos los campos y hace el update a la base de datos
     */
    private void modificar(ActionEvent evt) {
        String apellidos = textoApellido.getText();
        String nombre = textoNombre.getText();
        String direccion = textoDireccion.getText();
        if (!apellidos.equalsIgnoreCase("") && !nombre.equalsIgnoreCase("") && !direccion.equalsIgnoreCase("")){
            Cliente cliente = new Cliente(dni, nombre, apellidos, direccion, 1);
            cnCliente.updateCliente(cliente);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Rellene los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    // Variables declaration - do not modify
        private JButton botonModificar;
        private JCheckBox checkLimpiar;
        private JLabel jLabel1;
        private JLabel jLabel3;
        private JLabel jLabel4;
        private JLabel labelImagen;
        private JTextField textoNombre;
        private JTextField textoDireccion;
        private String dni;
        private ClienteCRUD cnCliente;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel labelDNI;
        private javax.swing.JLabel labelVariable;
        private javax.swing.JPanel panelBotton;
        private javax.swing.JPanel panelCuerpo;
        private javax.swing.JTextField textoApellido;
        private javax.swing.JPanel panelTitulo;

        // End of variables declaration
    }


