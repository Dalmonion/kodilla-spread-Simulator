package com.kodilla.spread;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Controller {
    @FXML
    Pane world;

    private Cell singleCell;
    private Simulation simulation;
    private Timeline timeline;

    @FXML
    public void initialize() {

        world.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));


        timeline = new Timeline(new KeyFrame(Duration.millis(1000), x -> {
            simulation.setNeighboursSick();
        }));


    }

    @FXML
    public void start() {

        simulation = new Simulation(world);
        simulation.draw();
        simulation.setInitialSick();
        timeline.setCycleCount(-1);
        timeline.play();
    }

}
