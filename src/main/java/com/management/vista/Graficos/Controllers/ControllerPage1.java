package com.management.vista.Graficos.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class ControllerPage1 {
    private Stage stage;


    @FXML
    private TextField txtName;



    @FXML
    void showWindow2(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Page2View.fxml"));
        Parent root = loader.load();
        ControllerPage2 controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(txtName.getText(),stage,this);
        stage.show();
    }



    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }



}
