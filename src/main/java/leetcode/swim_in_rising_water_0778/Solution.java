package leetcode.swim_in_rising_water_0778;

import java.util.HashSet;
import java.util.Objects;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private class Coordinate {
        final int i, j;

        Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "{i=" + i +
                    ", j=" + j +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return i == that.i &&
                    j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }


    //    BFS && hashset
    int swimInWater(int[][] grid) {

//        For safety, you may need to check whether grid is valid

        int sizeI = grid.length;
        int sizeJ = grid[0].length;

        HashSet<Coordinate> boundary = new HashSet<>();
        HashSet<Coordinate> newBoundary = new HashSet<>();
        newBoundary.add(new Coordinate(0, 0));
        int t = Math.max(grid[sizeI - 1][sizeJ - 1], grid[0][0]);

        while (true) {
            if (boundary.size() == newBoundary.size()) t++;
            boundary = newBoundary;
            newBoundary = new HashSet<>();
            for (Coordinate coordIter : boundary) {
                boolean onLeft = coordIter.j == 0;
                boolean onRight = coordIter.j == sizeJ - 1;
                boolean onTop = coordIter.i == 0;
                boolean onBot = coordIter.i == sizeI - 1;

//                LOGGER.info("i = " + coordIter.i + ", j = " + coordIter.j +
//                        "\nonRight = " + onRight + ", onBot = " + onBot);

                boolean rightOpen = !onRight && grid[coordIter.i][coordIter.j + 1] <= t;
                boolean leftOpen = !onLeft && grid[coordIter.i][coordIter.j - 1] <= t;
                boolean botOpen = !onBot && grid[coordIter.i + 1][coordIter.j] <= t;
                boolean topOpen = !onTop && grid[coordIter.i - 1][coordIter.j] <= t;

                boolean rightIsGoal = coordIter.i == sizeI - 1 && coordIter.j + 1 == sizeJ - 1;
                boolean botIsGoal = coordIter.i + 1 == sizeI - 1 && coordIter.j == sizeJ - 1;


                if (rightOpen) {
                    if (rightIsGoal) return t;
                    newBoundary.add(new Coordinate(coordIter.i, coordIter.j + 1));
                }
                if (leftOpen)
                    newBoundary.add(new Coordinate(coordIter.i, coordIter.j - 1));
                if (botOpen) {
                    if (botIsGoal) return t;
                    newBoundary.add(new Coordinate(coordIter.i + 1, coordIter.j));
                }
                if (topOpen)
                    newBoundary.add(new Coordinate(coordIter.i - 1, coordIter.j));

                if (!rightOpen || !leftOpen || !topOpen || !botOpen) newBoundary.add(coordIter);
            }
//            LOGGER.info("t = " + t + ", boundary = " + newBoundary);
        }
    }


    //    DFS && binarySearch
    int swimInWaterAlternative1(int[][] grid) {
        return 0;
    }

}
