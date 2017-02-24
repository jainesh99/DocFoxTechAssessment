package com.company;

/**
 * Created by Administrator on 2017/02/23.
 */
public class Grid {

    private int grid_x;
    private int grid_y;
    private int max_size;

    public Grid(int gx, int gy)
    {
        grid_x = gx;
        grid_y = gy;
        max_size = gx*gy;
    }

    public boolean checkGrid(int x, int y)
    {
        int new_pos = x*y;

        if(new_pos <= max_size)
        {
            return true;
        }
        else {
            return false;
        }
    }

}
