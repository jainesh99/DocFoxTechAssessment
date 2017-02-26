package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Data d = new Data();
        try {
            d.initialise("src/resources/commands.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Rover r = d.getRover();
        Grid g = d.getGrid();
        String actions = d.getActions();

        r.doActions(actions,g);

    }

}
