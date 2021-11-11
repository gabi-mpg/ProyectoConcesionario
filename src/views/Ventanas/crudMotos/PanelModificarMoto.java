package views.Ventanas.crudMotos;

import controllers.MotoCRUD;
import entidades.Moto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelModificarMoto extends javax.swing.JDialog {


        private String ruta = System.getProperty("user.dir")+
                File.separator+"src"+File.separator+"views"+File.separator
                +"imagenes"+ File.separator;
        /**
         * Creates new form panelModificar
         */
        //Para meter motos, {matricula,marca,gasolina,etc}
        // y así reutilizar el panel
        public PanelModificarMoto(String matricula) {
            setModal(true);
            this.matricula = matricula;
            initComponents();
            setLocationRelativeTo(null);
            setResizable(false);
            rellenarCampos();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
            java.awt.GridBagConstraints gridBagConstraints;

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
            cnMoto = new MotoCRUD();

            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new java.awt.GridBagLayout());

            panelTitulo.setPreferredSize(new java.awt.Dimension(270, 100));
            panelTitulo.setLayout(new java.awt.GridBagLayout());

            jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            jLabel1.setText("Modificar moto");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(jLabel1, gridBagConstraints);

            labelImagen.setIcon(new javax.swing.ImageIcon(ruta+"iconoMod.png")); // NOI18N
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(labelImagen, gridBagConstraints);

            labelVariable.setText("Moto con matricula: ");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
            panelTitulo.add(labelVariable, gridBagConstraints);

            labelDNI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            labelDNI.setText("-");
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
            jLabel3.setText("Marca");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(32, 19, 32, 19);
            panelCuerpo.add(jLabel3, gridBagConstraints);

            jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel4.setText("Color");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(32, 19, 32, 19);
            panelCuerpo.add(jLabel4, gridBagConstraints);

            jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel5.setText("Tanque");
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
            checkLimpiar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                       textoApellido.setText("");
                       textoDireccion.setText("");
                       textoNombre.setText("");
                       checkLimpiar.setSelected(false);
                   }
               });
                    gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            getContentPane().add(panelBotton, gridBagConstraints);

            pack();

            agregarListeners();
        }// </editor-fold>

        public void rellenarCampos(){
            if (cnMoto.motoExiste(matricula)){
                Moto moto = cnMoto.buscarMoto(matricula);
                labelDNI.setText(matricula);
                textoApellido.setText(moto.getColor());
                textoNombre.setText(moto.getMarca());
                textoDireccion.setText(String.valueOf(moto.getTanque()));
                setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "La moto no existe en la BD");
                this.dispose();
            }

        }

    private void agregarListeners(){

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modificar(actionEvent);
            }
        });
    }

        private void checkLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void modificar(java.awt.event.ActionEvent evt) {
            String marca = textoNombre.getText();
            String color = textoApellido.getText();
            int tanque = Integer.parseInt(textoDireccion.getText());
            Moto moto = cnMoto.buscarMoto(matricula);
            moto.setMarca(marca);
            moto.setColor(color);
            moto.setTanque(tanque);
            cnMoto.updateMoto(moto);
            dispose();
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
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
        private String matricula;
        private MotoCRUD cnMoto;
        // End of variables declaration
    }


