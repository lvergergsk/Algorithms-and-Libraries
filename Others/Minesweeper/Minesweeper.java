// URL: https://techdevguide.withgoogle.com/resources/coding-question-minesweeper/

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Minesweeper {
    private static final boolean DEV_MODE = true;
    int[][] board;
    int rowSize;
    int columnSize;
    int numOfMine;

    Minesweeper(int rowSize, int columnSize, int numOfMine) throws IllegalArgumentException {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.numOfMine = numOfMine;

        if (numOfMine > rowSize * columnSize)
            throw new IllegalArgumentException("numOfMine must less than rowSize * columnSize");
        board = new int[rowSize][columnSize];
        ArrayList<Coordinate> candidate = new ArrayList<>();
        for (int i = 0; i < rowSize; i++)
            for (int j = 0; j < columnSize; j++)
                candidate.add(new Coordinate(i, j));

        while (numOfMine > 0) {
            Coordinate mine = candidate.remove(ThreadLocalRandom.current().nextInt(0, rowSize * columnSize - numOfMine - 1));
            this.board[mine.row][mine.column] = 9;
            numOfMine--;
        }

        for (int i = 0; i < rowSize; i++)
            for (int j = 0; j < columnSize; j++)
                if (board[i][j] != 9) board[i][j] = this.countAdjacentMine(new Coordinate(i, j));

        if (DEV_MODE) {
            for (int[] integers : board) {
                for (int integer : integers) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }
    }

    private int countAdjacentMine(Coordinate coordinate) {
        boolean onTop = (coordinate.row == 0);
        boolean onBottom = (coordinate.row == rowSize - 1);
        boolean onLeft = (coordinate.column == 0);
        boolean onRight = (coordinate.column == columnSize - 1);

        int res = 0;

        if (!onTop && board[coordinate.row - 1][coordinate.column] == 9) res++;
        if (!onBottom && board[coordinate.row + 1][coordinate.column] == 9) res++;
        if (!onLeft && board[coordinate.row][coordinate.column - 1] == 9) res++;
        if (!onRight && board[coordinate.row][coordinate.column + 1] == 9) res++;
        if (!onTop && !onLeft && board[coordinate.row - 1][coordinate.column - 1] == 9) res++;
        if (!onTop && !onRight && board[coordinate.row - 1][coordinate.column + 1] == 9) res++;
        if (!onBottom && !onLeft && board[coordinate.row + 1][coordinate.column - 1] == 9) res++;
        if (!onBottom && !onRight && board[coordinate.row + 1][coordinate.column + 1] == 9) res++;

        return res;
    }

    class Coordinate {
        int row;
        int column;

        Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

    }
}
