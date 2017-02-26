package unitTests;

import com.company.Data;
import com.company.Grid;
import com.company.Rover;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2017/02/26.
 */
public class UnitTestCases {

    //Data Unit Tests

    @Test
    public void testDataInitialiseSuccess()
    {
        Data d = new Data();

        try {
            d.initialise("src/resources/commands.txt");

            Rover r = d.getRover();
            Grid g = d.getGrid();

            assertEquals(r.getDirection(), "E");
            assertEquals(r.getX_coordinate(), 1);
            assertEquals(r.getY_coordinate(), 2);

            assertEquals(g.getGrid_x(), 8);
            assertEquals(g.getGrid_y(), 8);
            assertEquals(g.getMax_size(), 64);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test (expected = IOException.class)
    public void testDataInitialiseFailure() throws IOException {
        Data d = new Data();

        d.initialise("test");
    }


    //Rover Unit Tests

    @Test
    public void testMoveSuccessInBoundsXDirection()
    {
        Rover r = new Rover (1,2,"E");
        Grid g = new Grid(8,8);
        r.move(g);

        assertEquals(r.getX_coordinate(), 2);
        assertEquals(r.getY_coordinate(), 2);
    }

    @Test
    public void testMoveSuccessInBoundsYDirection()
    {
        Rover r = new Rover (1,2,"N");
        Grid g = new Grid(8,8);
        r.move(g);

        assertEquals(r.getX_coordinate(), 1);
        assertEquals(r.getY_coordinate(), 3);
    }


    @Test
    public void testMoveSuccessOutBoundsXDirection()
    {
        Rover r = new Rover (2,2,"E");
        Grid g = new Grid(2,2);
        r.move(g);

        assertEquals(r.getX_coordinate(), 2);
        assertEquals(r.getY_coordinate(), 2);
    }

    @Test
    public void testMoveSuccessOutBoundsYDirection()
    {
        Rover r = new Rover (2,0,"S");
        Grid g = new Grid(2,2);
        r.move(g);

        assertEquals(r.getX_coordinate(), 2);
        assertEquals(r.getY_coordinate(), 0);
    }

    @Test
    public void testRotateR()
    {
        Rover r = new Rover(1,1,"E");
        r.rotate("R");

        assertEquals(r.getDirection(), "S");
    }

    @Test
    public void testRotateL()
    {
        Rover r = new Rover(1,2, "E");
        r.rotate("L");

        assertEquals(r.getDirection(), "N");
    }

    @Test
    public void testRotateRAround()
    {
        Rover r = new Rover(1,1,"W");
        r.rotate("R");

        assertEquals(r.getDirection(), "N");
    }

    @Test
    public void testRotateLAround()
    {
        Rover r = new Rover(1,1,"N");
        r.rotate("L");

        assertEquals(r.getDirection(), "W");
    }

    @Test
    public void testRotateInvalidCommand()
    {
        Rover r = new Rover(1,1,"N");
        r.rotate("X");

        assertEquals(r.getDirection(), "N");
    }

    @Test
    public void testdoActionsSuccess()
    {
        Rover r = new Rover(1,2,"E");
        String actions = "MML";
        Grid g = new Grid(8,8);

        r.doActions(actions, g);

        assertEquals(r.getDirection(), "N");
        assertEquals(r.getX_coordinate(), 3);
        assertEquals(r.getY_coordinate(), 2);
    }

    @Test
    public void testdoActionsInvalidCommand()
    {
        Rover r = new Rover(1,2,"E");
        String actions = "MMX";
        Grid g = new Grid(8,8);

        r.doActions(actions, g);

        assertEquals(r.getDirection(), "E");
        assertEquals(r.getX_coordinate(), 3);
        assertEquals(r.getY_coordinate(), 2);
    }
    //Grid Unit Tests

    @Test
    public void testCheckGridTrue()
    {
        Grid g = new Grid(8,8);

        assertEquals(g.checkGrid(1,2), true);
    }

    @Test
    public void testCheckGridFalse()
    {
        Grid g = new Grid(8,8);

        assertEquals(g.checkGrid(9,9), false);
    }
}
