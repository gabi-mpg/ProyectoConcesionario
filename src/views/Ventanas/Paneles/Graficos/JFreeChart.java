package views.Ventanas.Paneles.Graficos;


import entidades.Usuario;
import entidades.Venta;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFreeChart extends JFrame {

    org.jfree.chart.JFreeChart grafico; //Objeto grafica
    private DefaultCategoryDataset datos; //Objeto q almacena los datos
    private JButton botonCerrar;

    public JFreeChart(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(false);
        pack();

//        datos = new DefaultCategoryDataset();
//
//        //El valor a graficar, identificador, etiqutea de la comulmna
//        datos.addValue(1, "Prueba1","Lunes");
//        datos.addValue(2, "Prueba1","Martes");
//        datos.addValue(4, "Prueba1","Miercoles");
//        datos.addValue(4, "Prueba1","Jueves");
//
//        grafico = ChartFactory.createBarChart("Diagrama de barras","Prueba x","Prueba y",
//                datos, PlotOrientation.HORIZONTAL, true, true, false);
//
//        //Esto es com un Jpanel pero de puras graficas
//        ChartPanel panel = new ChartPanel(grafico);
//        add(panel);
//        setVisible(true);
//        pack();
    }


   // Genera la cantidad de ventas que ha hecho un usuario
    public void generarGraficoVentas(ArrayList<String> nombreUsuarios, ArrayList<Integer> numeroVentas){
        //La posición del usuario en Stiring[] nombreUsuario debe ser la misma que el número de sus ventas
        // en int[] numero ventas, por ejemplo, nombreUsuarios[0] = fenixabi, numeroVentas[0] = ventasFenixabi
        botonCerrar = new JButton("Cerrar la gráfica");

        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        datos = new DefaultCategoryDataset();
        for(int i = 0 ; i < nombreUsuarios.size() ; i++){
            datos.addValue(numeroVentas.get(i), "Usuarios", nombreUsuarios.get(i));
        }
        grafico = ChartFactory.createBarChart("Ventas por usuario","Nombre de usuario","Numero de ventas",
                datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(grafico);
        add(panel, BorderLayout.CENTER);
        add(botonCerrar,BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }



    public void dineroUsuarios(ArrayList<String> nombreUsuario, ArrayList<Float> ventaTotal){
        botonCerrar = new JButton("Cerrar la gráfica");

        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        datos = new DefaultCategoryDataset();
        for(int i = 0 ; i < nombreUsuario.size() ; i++){
            datos.addValue(ventaTotal.get(i), "Usuarios", nombreUsuario.get(i));
        }
        grafico = ChartFactory.createBarChart("Total capital de ventas","Nombre de usuario","Total de ventas",
                datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(grafico);
        add(panel, BorderLayout.CENTER);
        add(botonCerrar,BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }




}
