package views.crudUsuarios;

import controllers.UsuarioCRUD;
import entidades.Moto;
import entidades.Usuario;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelModificarUsuario extends JDialog {


    /**
     * Crea un nuevo panel de modificar
     * @param nick Utiliza el nick del usuario para recuperar la información del mismo desde la base de datos
     */
    public PanelModificarUsuario(String nick) {
            setModal(true);
            initComponents();
            this.nick = (nick);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);
            rellenarCampos();
        }

        /**
         * A este método se le llama desde el constructor para inicializar todos los componentes de la ventana
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
            setTitle("Modificar usuario");
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
            cnUser = new UsuarioCRUD();

            getContentPane().setLayout(new java.awt.GridBagLayout());

            panelTitulo.setPreferredSize(new java.awt.Dimension(270, 100));
            panelTitulo.setLayout(new java.awt.GridBagLayout());

            jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel1.setText("Modificar usuario");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(jLabel1, gridBagConstraints);

            labelImagen.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES+"iconoMod.png")); // NOI18N
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(labelImagen, gridBagConstraints);

            labelVariable.setText("Modificar usuario con Nick:");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
            panelTitulo.add(labelVariable, gridBagConstraints);

            labelDNI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            labelDNI.setText("43836936V");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            panelTitulo.add(labelDNI, gridBagConstraints);

            getContentPane().add(panelTitulo, new java.awt.GridBagConstraints());

            panelCuerpo.setPreferredSize(new java.awt.Dimension(270, 270));
            panelCuerpo.setLayout(new java.awt.GridBagLayout());

            textoNombre.setPreferredSize(new java.awt.Dimension(120, 24));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(32, 13, 32, 13);
            panelCuerpo.add(textoNombre, gridBagConstraints);

            textoApellido.setPreferredSize(new java.awt.Dimension(120, 24));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.insets = new java.awt.Insets(32, 13, 32, 13);
            panelCuerpo.add(textoApellido, gridBagConstraints);

            textoDireccion.setPreferredSize(new java.awt.Dimension(120, 24));

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
            jLabel5.setText("Permiso");
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


        public void
        rellenarCampos(){
            if (cnUser.usuarioExiste(nick)){
                Usuario usuario = cnUser.buscarUsuario(nick);
                labelDNI.setText(nick);
                textoApellido.setText(usuario.getApellidos());
                textoNombre.setText(usuario.getNombre());
                textoDireccion.setText(String.valueOf(usuario.getPermiso()));
                setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "El usuario no existe en la BD");
                this.dispose();
            }

        }


    /**
     * Añade los eventos a los componentes de la ventana
     */
    private void agregarListeners(){
        checkLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                textoApellido.setText("");
                textoDireccion.setText("");
                textoNombre.setText("");
                checkLimpiar.setSelected(false);
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modificar(actionEvent);
            }
        });
    }

        private void checkLimpiarActionPerformed(ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void modificar(ActionEvent evt) {
                String nombre = textoNombre.getText();
                String apellidos = textoApellido.getText();
                Usuario usuario = cnUser.buscarUsuario(nick);
                //String contra = usuario.getContra();
                int permiso = Integer.parseInt(textoDireccion.getText());
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setPermiso(permiso);
                //Usuario usuario = new Usuario(nick, nombre, apellidos, contra, permiso, true);
                cnUser.updateUsuario(usuario);
                dispose();
        }


        public void setNick(String nick) {
            this.nick = nick;
        }

    // Variables declaration - do not modify
    private javax.swing.JButton botonModificar;
    private javax.swing.JCheckBox checkLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelVariable;
    private javax.swing.JPanel panelBotton;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField textoApellido;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoNombre;
        private String nick;
        private UsuarioCRUD cnUser;
        // End of variables declaration
    }


