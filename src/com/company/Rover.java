package com.company;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/02/23.
 */
public class Rover {

    private int x_coordinate;
    private int y_coordinate;
    private String direction;
    private String[] compass = {"N","E","S","W"};

    public Rover(int x, int y, String dir)
    {
        x_coordinate = x;
        y_coordinate = y;
        direction = dir;
    }

    public void move(Grid g)
    {
        int temp_x = 0;
        int temp_y = 0;

        switch (direction)
        {
            case "W":
                temp_x = x_coordinate - 1;
                temp_y = y_coordinate;
                break;
            case "E":
                temp_x = x_coordinate + 1;
                temp_y = y_coordinate;
                break;
            case "N":
                temp_y = y_coordinate + 1;
                temp_x = x_coordinate;
                break;
            case "S":
                temp_y = y_coordinate - 1;
                temp_x = x_coordinate;
                break;
        }

        if(g.checkGrid(temp_x, temp_y) == true)
        {
            x_coordinate = temp_x;
            y_coordinate = temp_y;
        }

        printAction("M");
    }

    public void rotate(String rotation)
    {
        int index = Arrays.asList(compass).indexOf(direction);

        if(rotation.equals("R"))
        {
            index++;

        }
        else
        {
            index--;
        }

        if(index > (compass.length-1))
        {
            index = 0;
        }
        else
            if(index < 0)
            {
                index = 3;
            }

        direction = compass[index];
        printAction(rotation);

    }

    private void printAction(String action)
    {
        System.out.println(action + ":" + x_coordinate + " " + y_coordinate + " " + direction);
    }

}
