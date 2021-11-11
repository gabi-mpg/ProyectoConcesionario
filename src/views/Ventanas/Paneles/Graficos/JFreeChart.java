package views.Ventanas.Paneles.Graficos;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class JFreeChart extends JFrame {

    org.jfree.chart.JFreeChart grafico; //Objeto grafica
    private DefaultCategoryDataset datos; //Objeto q almacena los datos

    public JFreeChart(){
        datos = new DefaultCategoryDataset();

        //El valor a graficar, identificador, etiqutea de la comulmna
        datos.addValue(1, "Prueba1","Lunes");
        datos.addValue(2, "Prueba1","Martes");
        datos.addValue(4, "Prueba1","Miercoles");
        datos.addValue(4, "Prueba1","Jueves");

        grafico = ChartFactory.createBarChart("Diagrama de barras","Prueba x","Prueba y",
                datos, PlotOrientation.HORIZONTAL, true, true, false);

        //Esto es com un Jpanel pero de puras graficas
        ChartPanel panel = new ChartPanel(grafico);
        add(panel);
        setVisible(true);
        pack();
    }


   // Genera la cantidad de ventas que ha hecho un usuario
    public void generarGraficoVentas(String[] nombreUsuarios, int[] numeroVentas){
        //La posición del usuario en Stiring[] nombreUsuario debe ser la misma que el número de sus ventas
        // en int[] numero ventas, por ejemplo, nombreUsuarios[0] = fenixabi, numeroVentas[0] = ventasFenixabi
        datos = new DefaultCategoryDataset();
        for(int i = 0 ; i< nombreUsuarios.length ; i++){
            datos.addValue(numeroVentas[i], "Usuarios", nombreUsuarios[i]);
        }
        grafico = ChartFactory.createBarChart("Ventas por usuario","Nombre de usuario","Numero de ventas",
                datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(grafico);
        get
    }

    public static void main(String[] args){
        new JFreeChart();
    }

}
