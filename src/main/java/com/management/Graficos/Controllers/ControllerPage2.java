package com.management.Graficos.Controllers;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.WindowConstants;

import com.management.Inventario;
import com.management.Producto;
import com.management.Archivos.ArchivoInventario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
public class ControllerPage2 {
    private ControllerPage1 controllerPage1;
    private Stage stage;
    



    @FXML
    private Button MostrarCantidadesButton;

    @FXML
    private Button MostrarPerdidasButton;

    @FXML
    private Label LBName;


    // String id = LBName.getText();
    // Inventario data = ArchivoInventario.getInventario(id);
    ArrayList<Producto> lista = ArchivoInventario.recopilarProductosDelMomento();
    private int cantidadPerdida = new Analisis().cantidadPerdida(lista);
    private int cantidadRestante = new Analisis().cantidadRestante(lista);
    @FXML
    private PieChart chart;
    
    @FXML
    private BarChart<String, Number> barChart;
    
    @FXML
    void showGraphicBarras(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/ViewGraphicBarras.fxml"));
            Parent root = loader.load();
            
            // Get a reference to the controller for the new window
            ControllerGraphicBarras controller = loader.getController();
            
            // Initialize the chart with data
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Category");
                            
            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Value");
            barChart = new BarChart<>(xAxis, yAxis);

            XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
            dataSeries.getData().add(new XYChart.Data<>("Data 1", 10));
            dataSeries.getData().add(new XYChart.Data<>("Data 2", 20));
            dataSeries.getData().add(new XYChart.Data<>("Data 3", 30));
            dataSeries.getData().add(new XYChart.Data<>("Data 4", 40));

            barChart.getData().add(dataSeries);  // use the private field of the class here
                            
            barChart.setTitle("Alalisis Cantidades");
            
            // Set the chart in the controller and display the window
            controller.setChart(barChart);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }    

    @FXML
    void showGraphicPie(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/ViewGraphicPie.fxml"));
        Parent root = loader.load();
     
        // Get a reference to the controller
        ControllerGraphicPie controller = loader.getController();


        // Initialize the chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("ventas", 6),
            new PieChart.Data("Capital restante", cantidadRestante)
        );
        controller.chart.setData(pieChartData);
        
        // Customize other chart attributes as needed
        controller.chart.setTitle("My Pie Chart");
        controller.chart.setLegendVisible(false);

        // Create a new stage to display the chart
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void init(String text, Stage stage, ControllerPage1 controllerPage1) {
        LBName.setText(text);
        this.controllerPage1 = controllerPage1;
        this.stage = stage;
    }



}
