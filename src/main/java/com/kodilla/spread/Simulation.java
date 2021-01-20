package com.kodilla.spread;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.*;
import java.util.stream.Collectors;

public class Simulation {


    private List<Cell> cells;
    private Pane world;
    Timeline timeline = new Timeline();

    public Simulation(Pane world) {
        cells = new ArrayList<>();
        this.world = world;
        for (double i = 0; i < world.getHeight(); i = i + 10.0) {
            for (double j = 0; j < world.getWidth(); j = j + 10.0) {
                cells.add(new Cell(j, i, 10, world));
            }
        }
    }

    public void draw() {
        for (Cell cell : cells) {
            cell.draw();
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setInitialSick() {
        Random random = new Random();
        cells.get(random.nextInt(cells.size())).setSick();
    }

    public void setNeighboursSick() {

        List<Cell> sickPeople = new ArrayList<>();
        for (Cell cell : cells) {
                if (cell.getState() == State.SICK) {
                    if (System.currentTimeMillis() - cell.getTimeWhenGotSick() >= cell.getSickTime()) {
                        cell.setCured();
                        continue;
                    }
                    sickPeople.add(cell);
                }
        }

        for (Cell sickCell : sickPeople) {
            for (Cell cell : cells) {
                if (cell == sickCell) continue;
                if (cell.getXPosition() == sickCell.getXPosition() - sickCell.getCellSize() && cell.getYPosition() ==
                        sickCell.getYPosition() - sickCell.getCellSize()) cell.setSick();

                if (cell.getXPosition() == sickCell.getXPosition() && cell.getYPosition() == sickCell.getYPosition() -
                        sickCell.getCellSize()) cell.setSick();

                if (cell.getXPosition() == sickCell.getXPosition() + sickCell.getCellSize() && cell.getYPosition() ==
                        sickCell.getYPosition() - sickCell.getCellSize()) cell.setSick();

                if (cell.getXPosition() == sickCell.getXPosition() - sickCell.getCellSize() && cell.getYPosition() ==
                        sickCell.getYPosition()) cell.setSick();

                if (cell.getXPosition() == sickCell.getXPosition() + sickCell.getCellSize() && cell.getYPosition() ==
                        sickCell.getYPosition()) cell.setSick();

                if (cell.getXPosition() == sickCell.getXPosition() - sickCell.getCellSize() && cell.getYPosition() ==
                        sickCell.getYPosition() + sickCell.getCellSize()) cell.setSick();

                if (cell.getXPosition() == sickCell.getXPosition() && cell.getYPosition() == sickCell.getYPosition() +
                        sickCell.getCellSize()) cell.setSick();

                if (cell.getXPosition() == sickCell.getXPosition() + sickCell.getCellSize() && cell.getYPosition() ==
                        sickCell.getYPosition() + sickCell.getCellSize()) cell.setSick();
            }
        }
    }
}
