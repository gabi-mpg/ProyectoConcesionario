package views.Ventanas.Paneles.Graficos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BarChartStrategy  extends ApplicationFrame implements IChartStrategy {

    private HashMap<String, Integer> motosDisponibles = new HashMap<>();

    String chartTitle;
    String etiqueta;
    private String tipoGrafico;

    private JPanel grafica = new JPanel();
    private final boolean ORIENTATION;

    public BarChartStrategy(String applicationTitle, String chartTitle, String xAxisName, String yAxisName, boolean orientation) {
        super(applicationTitle);
        this.chartTitle = chartTitle;
        this.tipoGrafico = tipoGrafico;
        this.etiqueta = xAxisName;
        this.ORIENTATION = orientation;

    }

    public DefaultCategoryDataset createDataset(ArrayList<String> valoresX, ArrayList<String> valoresY) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /*for(Trend trend : trendList){
            dataset.addValue((double)trend.getTweetVolume(),this.country,trend.getName());
        }*/
        int index = 0;
        for (String str : valoresX) {
            System.out.println(str);
            System.out.println(valoresY.get(index));
            dataset.addValue(Double.parseDouble(str), this.etiqueta, valoresY.get(index));
            index++;
        }
        return dataset;
    }

    @Override
    public void buildChart(ArrayList<String> valoresX, ArrayList<String> valoresY, String xAxisName, String yAxisName) {
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                xAxisName, yAxisName,
                createDataset(valoresX, valoresY),
                ORIENTATION ? PlotOrientation.HORIZONTAL : PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = barChart.getCategoryPlot();
        Font fontAxis = new Font("Dialog", Font.PLAIN, 25);
        Font fontItems = new Font("Dialog", Font.PLAIN, 12);
        plot.getDomainAxis().setLabelFont(fontAxis);
        plot.getRangeAxis().setLabelFont(fontAxis);
        plot.getDomainAxis().setTickLabelFont(fontItems);

        grafica = new ChartPanel(barChart);
        setContentPane(grafica);

    }

    @Override
    public JPanel getChartPanel() {
        System.out.println(grafica);
        return this.grafica;
    }
}
