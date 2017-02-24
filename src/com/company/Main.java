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

        for(int i = 0; i < actions.length();i++)
        {
            char temp = actions.charAt(i);

            if(temp == 'M')
            {
                r.move(g);
            }
            else
                if(temp == 'R' || temp == 'L')
                {
                    r.rotate(temp + "");
                }
        }


    }

}
