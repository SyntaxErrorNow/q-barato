package com.management.Graficos;

import org.jfree.chart.util.Args;

import com.management.Graficos.Controllers.ControllerPage1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnalystRoot extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/Page1View.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            ControllerPage1 controller = new ControllerPage1();
            controller.setStage(primaryStage);
            primaryStage.show();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void initApplicationFXML() {
        launch();
    }

}
