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

        if(new_pos <= max_size && new_pos > 0)
        {
            return true;
        }
        else {
            return false;
        }
    }


    public int getGrid_x() {
        return grid_x;
    }

    public void setGrid_x(int grid_x) {
        this.grid_x = grid_x;
    }

    public int getGrid_y() {
        return grid_y;
    }

    public void setGrid_y(int grid_y) {
        this.grid_y = grid_y;
    }

    public int getMax_size() {
        return max_size;
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }
}
