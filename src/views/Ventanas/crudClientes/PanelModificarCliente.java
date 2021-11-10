package views.Ventanas.crudClientes;

import controllers.ClienteCRUD;
import controllers.MotoCRUD;
import entidades.Cliente;
import entidades.Moto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificarCliente extends JFrame {


        private String ruta = System.getProperty("user.dir")+"\\src\\views\\Imagenes\\";
        /**
         * Creates new form panelModificar
         */
        //Para meter motos, {matricula,marca,gasolina,etc}
        // y así reutilizar el panel
        public PanelModificarCliente() {
            initComponents();
            setSize(350, 500);
            setLocationRelativeTo(null);
            setResizable(false);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
            GridBagConstraints gridBagConstraints;

            labelTitulo = new JLabel();
            textoDireccion = new JTextField();
            textoApellidos = new JTextField();
            textoNombre = new JTextField();
            labelImagen = new JLabel();
            jLabel1 = new JLabel();
            jLabel2 = new JLabel();
            jLabel3 = new JLabel();
            jLabel4 = new JLabel();
            botonModificar = new JButton();
            checkLimpiar = new JCheckBox();
            dni = "";
            cnCliente = new ClienteCRUD();

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new GridBagLayout());

            labelTitulo.setFont(new Font("Dialog", 0, 18)); // NOI18N
            labelTitulo.setText("Modificar cliente");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(8, 60, 8, 50);
            add(labelTitulo, gridBagConstraints);

            textoDireccion.setPreferredSize(new Dimension(75, 25));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 5;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.ipadx = 59;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(20, 25, 20, 28);
            add(textoDireccion, gridBagConstraints);

            textoApellidos.setPreferredSize(new Dimension(75, 25));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.ipadx = 59;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(20, 25, 20, 28);
            add(textoApellidos, gridBagConstraints);

            textoNombre.setPreferredSize(new Dimension(75, 25));
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.ipadx = 59;
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.insets = new Insets(20, 25, 20, 28);
            add(textoNombre, gridBagConstraints);

            labelImagen.setIcon(new ImageIcon(ruta + "iconoModificar.png")); // NOI18N
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.insets = new Insets(4, 0, 3, 0);
            add(labelImagen, gridBagConstraints);

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.weighty = 0.5;
            add(jLabel1, gridBagConstraints);

            jLabel2.setText("Nombre");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.weighty = 0.5;
            add(jLabel2, gridBagConstraints);

            jLabel3.setText("Apellidos");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.weighty = 0.5;
            add(jLabel3, gridBagConstraints);

            jLabel4.setText("Direccion");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 5;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.weighty = 0.5;
            add(jLabel4, gridBagConstraints);

            botonModificar.setText("Modificar");

            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 7;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(18, 25, 18, 0);
            add(botonModificar, gridBagConstraints);

            checkLimpiar.setText("Limpiar campos");
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 7;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = GridBagConstraints.EAST;
            gridBagConstraints.insets = new Insets(0, 0, 0, 13);
            add(checkLimpiar, gridBagConstraints);

            agregarListeners();
        }// </editor-fold>

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
        public void rellenarCampos(){
            if (cnCliente.clienteExiste(dni)){
                Cliente cliente = cnCliente.buscarCliente(dni);
                jLabel1.setText("Modificar cliente con DNI " + dni);
                textoNombre.setText(cliente.getNombre());
                textoApellidos.setText(cliente.getApellido());
                textoDireccion.setText(cliente.getDireccion());
                setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "EL cliente no existe en la BD");
                this.dispose();
            }

        }
        private void checkLimpiarActionPerformed(ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void modificar(ActionEvent evt) {
            String apellidos = textoApellidos.getText();
            String nombre = textoNombre.getText();
            String direccion = textoDireccion.getText();
            Cliente cliente = new Cliente(dni, nombre, apellidos, direccion);
            cnCliente.updateCliente(cliente);
            dispose();
        }

        public void setDNI(String dni) {
            this.dni = dni;
        }

    // Variables declaration - do not modify
        private JButton botonModificar;
        private JCheckBox checkLimpiar;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JLabel jLabel3;
        private JLabel jLabel4;
        private JLabel labelImagen;
        private JLabel labelTitulo;
        private JTextField textoNombre;
        private JTextField textoApellidos;
        private JTextField textoDireccion;
        private String dni;
        private ClienteCRUD cnCliente;
        // End of variables declaration
    }


