package com.kodilla.spread;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.awt.*;

public class Cell {

    private int x;
    private int y;
    private State state;
    private final Rectangle rectangle;
    private Pane world;

    public Cell (int x, int y, Pane world) {
        this.x = x;
        this.y = y;
        state = State.HEALTHY;
        rectangle = new Rectangle(10, 10);
        rectangle.setX(x);
        rectangle.setY(y);
//        rectangle.setHeight(10);
//        rectangle.setWidth(10);
        rectangle.setFill(Color.RED);
        this.world = world;
        rectangle.setStroke(Color.BLACK);
        world.getChildren().add(rectangle);
    }

    public void draw() {
        rectangle.setTranslateX(x);
        rectangle.setTranslateY(y);
    }

}
