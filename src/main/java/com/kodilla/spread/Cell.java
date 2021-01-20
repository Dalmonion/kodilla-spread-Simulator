package com.kodilla.spread;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.util.Random;

public class Cell {

    private State state;
    private final Rectangle rectangle;
    private Pane world;
    private double cellSize = 10.0;
    private Color cellColor;
    private double sickTime;
    private long timeWhenGotSick;
    private boolean wasSick = false;

    public Cell(double x, double y, double size, Pane world) {
        state = State.HEALTHY;
        this.cellSize = size;
        rectangle = new Rectangle(x, y, size, size);
        rectangle.setFill(Color.GREEN);
        this.world = world;
        sickTime = Math.random() * (10000 - 7000) + 7000;
        rectangle.setStroke(Color.BLACK);
        world.getChildren().add(rectangle);
    }

    public double getXPosition() {
        return rectangle.getX();
    }

    public double getYPosition() {
        return rectangle.getY();
    }

    public double getCellSize() {
        return cellSize;
    }

    public State getState() {
        return this.state;
    }

    public void setSick() {
        if (!wasSick) {
            setState(State.SICK);
            timeWhenGotSick = System.currentTimeMillis();
            wasSick = true;
        }
    }

    public void setCured() {
        setState(State.CURED);
    }

    public double getSickTime() {
        return sickTime;
    }

    public long getTimeWhenGotSick() {
        return timeWhenGotSick;
    }

    private void setState(State state) {
        this.state = state;

        switch (state) {
            case HEALTHY:
                rectangle.setFill(Color.GREEN);
                break;
            case SICK:
                rectangle.setFill(Color.RED);
                break;
            case CURED:
                rectangle.setFill(Color.BLUE);
                break;
            case DECEASED:
                rectangle.setFill(Color.BLACK);
                break;
            default:
                rectangle.setFill(Color.WHITE);
        }
    }

    public void draw() {
        rectangle.setTranslateX(rectangle.getX());
        rectangle.setTranslateY(rectangle.getY());
    }

}
