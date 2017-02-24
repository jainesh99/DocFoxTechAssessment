package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/02/23.
 */
public class Data {

    private Rover rover;
    private Grid grid;
    private String actions;

    public void initialise(String filename) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line = reader.readLine();

        String[] splitLine = line.split(" ");

        grid = new Grid(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));

        line = reader.readLine();

        splitLine = line.split(" ");

        rover = new Rover(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), splitLine[2]);

        actions = reader.readLine();

    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }
}
