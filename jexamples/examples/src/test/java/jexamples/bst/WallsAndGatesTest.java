package jexamples.bst;

import org.junit.Test;

import static org.junit.Assert.*;

public class WallsAndGatesTest
{
    @Test public void testWallsAndGates () {
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        WallsAndGates.wallsAndGates (rooms);

        for (int[] room : rooms) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print (room[j] + " ");
            }
            System.out.println ();
        }
    }
}