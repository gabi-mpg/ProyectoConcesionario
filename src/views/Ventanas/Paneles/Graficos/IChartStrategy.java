package views.Ventanas.Paneles.Graficos;

import javax.swing.*;
import java.util.ArrayList;

public interface IChartStrategy {
    Object createDataset(ArrayList<String> valoresX, ArrayList<String> valoresY);
    void buildChart(ArrayList<String> valoresX, ArrayList<String> valoresY, String xAxisName, String yAxisName);
    JPanel getChartPanel();
}
