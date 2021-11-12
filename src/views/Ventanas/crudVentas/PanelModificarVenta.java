package views.Ventanas.crudVentas;

import controllers.VentaCRUD;
import entidades.Venta;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class PanelModificarVenta extends JFrame {




        /**
         * Creates new form panelModificar
         */
        //Para meter motos, {matricula,marca,gasolina,etc}
        // y así reutilizar el panel
        public PanelModificarVenta(String ID) {
            initComponents();
            setLocationRelativeTo(null);
            setResizable(false);
            this.ID = ID;
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
            GridBagConstraints gridBagConstraints;

            setTitle("Modificar venta");
            setIconImage(Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES+"iconoMod.png"));

            panelTitulo = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            labelImagen = new javax.swing.JLabel();
            labelVariable = new javax.swing.JLabel();
            labelIDVenta = new javax.swing.JLabel();
            panelCuerpo = new javax.swing.JPanel();
            textoMatricula = new javax.swing.JTextField();
            textoDNI = new javax.swing.JTextField();
            textoPrecio = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            textoVendedor = new javax.swing.JTextField();
            jLabel2 = new javax.swing.JLabel();
            panelBotton = new javax.swing.JPanel();
            botonModificar = new javax.swing.JButton();
            checkLimpiar = new javax.swing.JCheckBox();
            cnVentas = new VentaCRUD();




            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new java.awt.GridBagLayout());

            panelTitulo.setPreferredSize(new java.awt.Dimension(290, 120));
            panelTitulo.setLayout(new java.awt.GridBagLayout());

            jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
            jLabel1.setText("Modificar venta");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(jLabel1, gridBagConstraints);

            labelImagen.setIcon(new javax.swing.ImageIcon(estaticas.RUTA_IMAGENES + "iconoMod.png")); // NOI18N
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelTitulo.add(labelImagen, gridBagConstraints);

            labelVariable.setText("Modificar venta con ID: ");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
            panelTitulo.add(labelVariable, gridBagConstraints);

            labelIDVenta.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
            labelIDVenta.setText("-");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            panelTitulo.add(labelIDVenta, gridBagConstraints);

            getContentPane().add(panelTitulo, new java.awt.GridBagConstraints());

            panelCuerpo.setPreferredSize(new java.awt.Dimension(300, 320));
            panelCuerpo.setLayout(new java.awt.GridBagLayout());

            textoMatricula.setPreferredSize(new java.awt.Dimension(130, 24));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(18, 10, 18, 10);
            panelCuerpo.add(textoMatricula, gridBagConstraints);

            textoDNI.setPreferredSize(new java.awt.Dimension(130, 24));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.insets = new java.awt.Insets(18, 10, 18, 10);
            panelCuerpo.add(textoDNI, gridBagConstraints);

            textoPrecio.setPreferredSize(new java.awt.Dimension(130, 24));

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.insets = new java.awt.Insets(18, 10, 18, 10);
            panelCuerpo.add(textoPrecio, gridBagConstraints);

            jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel3.setText("Matricula");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(18, 19, 18, 19);
            panelCuerpo.add(jLabel3, gridBagConstraints);

            jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel4.setText("DNI");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(18, 19, 18, 19);
            panelCuerpo.add(jLabel4, gridBagConstraints);

            jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel5.setText("Precio");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(18, 19, 18, 19);
            panelCuerpo.add(jLabel5, gridBagConstraints);

            textoVendedor.setPreferredSize(new java.awt.Dimension(130, 24));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = new java.awt.Insets(18, 0, 18, 0);
            panelCuerpo.add(textoVendedor, gridBagConstraints);

            jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            jLabel2.setText("Vendedor");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = new java.awt.Insets(18, 0, 18, 0);
            panelCuerpo.add(jLabel2, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            getContentPane().add(panelCuerpo, gridBagConstraints);

            panelBotton.setPreferredSize(new java.awt.Dimension(290, 100));
            panelBotton.setLayout(new java.awt.GridBagLayout());

            botonModificar.setText("Modificar registro");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelBotton.add(botonModificar, gridBagConstraints);
            botonModificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    modificar();
                }
            });

            checkLimpiar.setText("Limpiar campos");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
            panelBotton.add(checkLimpiar, gridBagConstraints);
            checkLimpiar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    checkLimpiarActionPerformed(actionEvent);
                }
            });

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            getContentPane().add(panelBotton, gridBagConstraints);

            pack();
        }// </editor-fold>

        public void rellenarCampos() {
                try{
                    if(ID != null) {
                        int IDint = Integer.parseInt(ID);
                        if (cnVentas.ventaExiste(IDint)) {
                            Venta venta = cnVentas.buscarVenta(IDint);
                            labelIDVenta.setText(ID);
                            textoMatricula.setText(venta.getMatricula());
                            textoDNI.setText(venta.getDni());
                            textoPrecio.setText(String.valueOf(venta.getPrecio()));
                            textoVendedor.setText(String.valueOf(venta.getIdVendedor()));
                            setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "La venta no existe en la BD");
                            this.dispose();
                        }
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(this,"No se ha introducido un numero","Error en la entrada",JOptionPane.ERROR_MESSAGE);
                }
            }

        private void checkLimpiarActionPerformed(ActionEvent evt) {
            textoDNI.setText("");
            textoMatricula.setText("");
            textoPrecio.setText("");
            checkLimpiar.setSelected(false);
        }

        private void modificar() {
            Venta venta = cnVentas.buscarVenta(Integer.parseInt(ID));
            venta.setDni(textoDNI.getText());
            venta.setMatricula(textoDNI.getText());
            venta.setPrecio(Float.parseFloat(textoPrecio.getText()));
            venta.setIdVendedor(textoVendedor.getText());
            cnVentas.updateVenta(venta);
            dispose();
        }

    // Variables declaration - do not modify
    private javax.swing.JButton botonModificar;
    private javax.swing.JCheckBox checkLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelIDVenta;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelVariable;
    private javax.swing.JPanel panelBotton;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoMatricula;
    private javax.swing.JTextField textoPrecio;
    private javax.swing.JTextField textoVendedor;
        private String ID;
        private VentaCRUD cnVentas;
        // End of variables declaration
    }


