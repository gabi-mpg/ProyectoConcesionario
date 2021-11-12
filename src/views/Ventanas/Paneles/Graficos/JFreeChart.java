package views.Ventanas.Paneles.Graficos;


import entidades.Usuario;
import entidades.Venta;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import utils.estaticas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class JFreeChart extends JDialog {

    org.jfree.chart.JFreeChart grafico; //Objeto grafica
    private DefaultCategoryDataset datos; //Objeto q almacena los datos
    private DefaultPieDataset datosTarta;
    private JButton botonCerrar;
    private ArrayList<Usuario> listaUsers;
    private ArrayList<Venta> listaVentas;


    public JFreeChart(ArrayList<Usuario> listaUsers, ArrayList<Venta> listaVentas){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Image imagen = Toolkit.getDefaultToolkit().getImage(estaticas.RUTA_IMAGENES+"estadisticaLogo.png");
        setUndecorated(false);

        setLocationRelativeTo(null);
        setVisible(false);
        pack();

        this.listaUsers = listaUsers;
        this.listaVentas = listaVentas;

    }

    private void rellenarArraysNumV(ArrayList<String> nombreUsuarios, ArrayList<Integer> numeroVentas){
        int cont = 0;
        for (Usuario u : listaUsers){
            nombreUsuarios.add(u.getNick());
            for (Venta v : listaVentas){
                if (v.getIdVendedor().equalsIgnoreCase(u.getNick())){
                    cont++;
                }
            }
            numeroVentas.add(cont);
            cont = 0;
        }
    }

    private void rellenarArraysCapitalV(ArrayList<String> nombreUsuarios, ArrayList<Float> numeroVentas){
        float cont = 0;
        for (Usuario u : listaUsers){
            nombreUsuarios.add(u.getNick());
            for (Venta v : listaVentas){
                if (v.getIdVendedor().equalsIgnoreCase(u.getNick())){
                    cont = cont + v.getPrecio();
                }
            }
            numeroVentas.add(cont);
            cont = 0;
        }
    }

   // Genera la cantidad de ventas que ha hecho un usuario
    public void generarGraficoVentas(){
        //La posición del usuario en Stiring[] nombreUsuario debe ser la misma que el número de sus ventas
        // en int[] numero ventas, por ejemplo, nombreUsuarios[0] = fenixabi, numeroVentas[0] = ventasFenixabi
        setTitle("Cantidad de ventas por usuario (Barras)");
        ArrayList<String> nombreUsuarios = new ArrayList<>();
        ArrayList<Integer> numeroVentas = new ArrayList<>();

        rellenarArraysNumV(nombreUsuarios, numeroVentas);

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



    public void dineroUsuarios(){

        ArrayList<String> nombreUsuario = new ArrayList<>();
        ArrayList<Float> ventaTotal = new ArrayList<>();
        setTitle("Capital de ventas por usuario (Barras)");
        rellenarArraysCapitalV(nombreUsuario, ventaTotal);
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


    public void generarGraficoVentasTarta(){
        ArrayList<String> nombreUsuarios = new ArrayList<>();
        ArrayList<Integer> numeroVentas = new ArrayList<>();
        setTitle("Cantidad de ventas por usuario (Tarta)");
        rellenarArraysNumV(nombreUsuarios, numeroVentas);

        botonCerrar = new JButton("Cerrar la gráfica");

        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        datosTarta = new DefaultPieDataset();
        for(int i = 0 ; i < nombreUsuarios.size() ; i++){
            datosTarta.setValue(nombreUsuarios.get(i),numeroVentas.get(i));
        }
        org.jfree.chart.JFreeChart chart = ChartFactory.createPieChart("Ventas por usuario",datosTarta, true, true, false);
        ChartPanel panel = new ChartPanel(chart);
        add(panel, BorderLayout.CENTER);
        add(botonCerrar,BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }

    public void generarGraficoDineroTartas(){
        ArrayList<String> nombreUsuarios = new ArrayList<>();
        ArrayList<Float> numeroVentas = new ArrayList<>();
        setTitle("Capital de ventas por usuario (Tarta)");
        rellenarArraysCapitalV(nombreUsuarios, numeroVentas);

        botonCerrar = new JButton("Cerrar la gráfica");

        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        datosTarta = new DefaultPieDataset();
        for(int i = 0 ; i < nombreUsuarios.size() ; i++){
            datosTarta.setValue(nombreUsuarios.get(i),numeroVentas.get(i));
        }
        org.jfree.chart.JFreeChart chart = ChartFactory.createPieChart("Total capital de ventas",datosTarta, true, true, false);
        ChartPanel panel = new ChartPanel(chart);
        add(panel, BorderLayout.CENTER);
        add(botonCerrar,BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }




}
