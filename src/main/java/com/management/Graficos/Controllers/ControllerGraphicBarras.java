package com.management.Graficos.Controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;

public class ControllerGraphicBarras {

    @FXML BarChart<String, Number> barChart;

    public void setChart(BarChart<String, Number> barChart2) {
        this.barChart = barChart2;
    }




    // Add any additional methods as needed

}
