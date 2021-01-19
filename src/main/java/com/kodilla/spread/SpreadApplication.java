package com.kodilla.spread;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SpreadApplication extends Application {

    @Override
    public void start(Stage window) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("/spreadSimGui.fxml"));
            window.setScene(new Scene(root));
            window.setTitle("Virus Spread Simulator");
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
