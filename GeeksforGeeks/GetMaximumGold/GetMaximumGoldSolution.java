// Given a non-negative integer 2D matrix in which 0 means obstacle
// so no one can step on it and positive integer means the amount of gold.
// Find the maximum amount of gold you can collect.
// (You can start from any point you want.)
//
// Integers in the input matrix does not form a cycle. For example, there is no matrix like the following:
//        maze = [
//        [1,2]
//        [3,4]
//        ]
// From each cell, you can either move to four directions: left, right, up or down.
// You CANNOT move diagonally or move outside of the boundary or step on the cell whose value is 0.
// In addition, you CANNOT move back to where your come from.
// For example, we are now at maze[0][0], we go right to maze[0][1]. Then we CANNOT go back to maze[0][0].
//
// Example:
//        maze = [
//        [0, 1, 0, 3, 4]
//        [2, 2, 0, 7, 0]
//        [0, 4, 5, 6, 2]
//        [0, 0, 0, 0, 0]
//        [0, 2, 0, 0, 2]
//        ]
//        Return 33
//        The path is 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 3 -> 4 by which we can get 33 golds and this is the maximum amount.

// This source code will report error (stack overflow) if there is a loop in maze.

import java.util.Arrays;

public class GetMaximumGoldSolution {
    private static final boolean DEV_MODE = true;

    public static void main(String[] args) {

        int[][] maze = {
                {0, 1, 0, 3, 4},
                {2, 2, 0, 7, 0},
                {0, 4, 5, 6, 2},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 0, 2}
        };

        long startTime = System.currentTimeMillis();
        System.out.println(new GetMaximumGoldSolution().getMaxGold(maze));
        System.out.println("Using Time:" + (System.currentTimeMillis() - startTime) + " ms");
    }

    int getMaxGold(int[][] maze) {
        if (maze.length == 0)
            return 0;

        //memorize the max amount of gold on each cell toward four direction
        int[][][] memorization = new int[maze.length][maze[0].length][4];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++)
                Arrays.fill(memorization[i][j], -1);
        }

        int maxVal = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] != 0) {
                    //when arriving maze[i][j], which direction do you come from
                    if (DEV_MODE) System.out.println("----------------");
                    if (DEV_MODE) System.out.println("i = " + i + ", j = " + j);
                    for (int dir = 0; dir < 4; dir++) {
                        int dfsResult = DFS(maze, memorization, i, j, dir);
                        maxVal = Math.max(dfsResult, maxVal);
                        if (DEV_MODE) System.out.println("dir = " + dir + ", dfsResult = " + dfsResult);
                    }
                    if (DEV_MODE) System.out.println("maxVal = " + maxVal);
                }
            }
        }

        if (DEV_MODE) {
            System.out.println("--------------------");
            System.out.println("Memorization matrix:");
            for (int[][] row : memorization) {
                for (int[] grid : row) {
                    System.out.print("(");
                    for (int dir : grid) {
                        System.out.print(dir + " ");
                    }
                    System.out.print(") ");
                }
                System.out.println();
            }
        }

        return maxVal;
    }

//    above:0,left:1,right:2,under:3

    int DFS(int[][] maze, int[][][] memorization, int X, int Y, int from) {
        if (X < 0 || Y < 0 || X >= maze.length || Y >= maze[0].length || maze[X][Y] == 0)
            return 0;
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int maxVal = 0;

        if (DEV_MODE) System.out.println("DFS current position = (" + X + "," + Y + ")");

        //try to go to each direction when you are at maze[i][j]
        for (int dir = 0; dir < direction.length; dir++) {
            //we cannot go back to where we came from
            if (dir == from)
                continue;

            //if we already memorize this direction
            if (memorization[X][Y][dir] != -1)
                maxVal = Math.max(memorization[X][Y][dir], maxVal);

            else {
                int nextX = X + direction[dir][0];
                int nextY = Y + direction[dir][1];
                int temp = DFS(maze, memorization, nextX, nextY, 3 - dir);

                memorization[X][Y][dir] = temp;
                maxVal = Math.max(temp, maxVal);
            }
        }
        return maxVal + maze[X][Y];
    }
}

