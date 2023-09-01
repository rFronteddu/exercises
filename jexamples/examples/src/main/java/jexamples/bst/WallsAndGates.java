package jexamples.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * -1 represents a wall.
 * 0 represents a gate.
 * INF represents an empty room.
 *
 * Fill each empty room with the distance to its nearest gate.
 *
 * If it is impossible to reach a gate, it should be filled with INF.
 *
 * m and n are the height and the width of the input 2D array respectively. Q
 * is used to perform BFS exploration. Direction array is used to get the four possible
 * directions from current cell.
 *
 * First we enqueue all the gates into the queue. Then for each gate cell, we continue until q is
 * empty. In each iteration we deque a room from q and explore its four possible directions. If the
 * cell is not a wall and its distance is greater than the current distance, we update the distance
 * to be one more than the current and enqueue the cell.
 *
 * After traversal, rooms will contain the distance to the nearest gate for each cell or max value
 * for rooms that are not reachable form any gate.
 *
 * BFS ensures wee explore rooms level by level. So the distance to the nearest gate will be the
 * minimum distance.
 *
 */
public class WallsAndGates
{
    private WallsAndGates () {}

    public static void wallsAndGates (final int[][] rooms) {
        // basic validation
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        final int m = rooms.length;
        final int n = rooms[0].length;

        Queue<int[]> q = new LinkedList<> ();
        // up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // add all gates to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer (new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty ()) {
            int[] current = q.poll ();
            int x = current[0];
            int y = current[1];

            for (final int[] dir : directions) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 ||
                        nextX >= m ||
                        nextY < 0 ||
                        nextY >= n ||
                        rooms[nextX][nextY] != Integer.MAX_VALUE) {
                    continue;
                }

                rooms[nextX][nextY] = rooms[x][y] + 1;
                q.offer (new int[]{nextX, nextY});
            }
        }
    }
}
