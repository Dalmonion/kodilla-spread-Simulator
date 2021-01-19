package com.kodilla.spread;

import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    Pane world;

    private Cell singleCell;

    @FXML
    public void initialize() {
        world.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
    }

    @FXML
    public void start() {
        singleCell = new Cell(55, 55, world);
        singleCell.draw();
    }

}
