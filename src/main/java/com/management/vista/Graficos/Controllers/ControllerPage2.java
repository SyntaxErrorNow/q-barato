package com.management.vista.Graficos.Controllers;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.WindowConstants;

import com.management.modelo.schema.Inventario;
import com.management.modelo.schema.Producto;

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
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private int cantidadVendida = new Analisis().cantidadVendida(lista);
    private int cantidadRestante = new Analisis().cantidadRestante(lista);

    @FXML
    private PieChart chart;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    void showGraphicBarras(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/ViewGraphicBarras.fxml"));
        Parent root = loader.load();

        ControllerGraphicBarras controller = loader.getController();

        Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Enero", 85));
        series.getData().add(new XYChart.Data("Febrero", 68));
        series.getData().add(new XYChart.Data("Marzo", 110));
        series.getData().add(new XYChart.Data("Abril", 114));
        series.getData().add(new XYChart.Data("Mayo", 14));
        series.getData().add(new XYChart.Data("Junio", 74));
        controller.barChart.getData().add(series);

        controller.barChart.setTitle("Cantidad de ventas por mes");

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void showGraphicPie(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/ViewGraphicPie.fxml"));
        Parent root = loader.load();

        // Get a reference to the controller
        ControllerGraphicPie controller = loader.getController();

        // Initialize the chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Cantidad vendida", cantidadVendida),
            new PieChart.Data("Capital restante", cantidadRestante)
        );
        controller.chart.setData(pieChartData);
        // Customize other chart attributes as needed
        controller.chart.setTitle("Capital actual");
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
