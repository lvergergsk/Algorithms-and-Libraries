package leetcode.valid_sudoku_0036;

//import java.util.logging.Logger;

public class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public boolean isValidSudoku(char[][] board) {
//        LOGGER.info("Row, Column,Grid");
        for (int i = 0; i < 9; i++) {
            boolean[] usedInGrid = new boolean[9];
            boolean[] usedInRow = new boolean[9];
            boolean[] usedInColumn = new boolean[9];
            for (int j = 0; j < 9; j++) {

                int valueInRow = board[i][j] == '.' ? -1 : board[i][j] - '1';
                int valueInColumn = board[j][i] == '.' ? -1 : board[j][i] - '1';
                char charInGrid = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];
                int valueInGrid = charInGrid == '.' ? -1 : charInGrid - '1';
//                LOGGER.info("(" + i + "," + j + "," + board[i][j] + ")" +
//                        "(" + j + "," + i + "," + board[j][i] + ")" +
//                        "(" + ((i / 3) * 3 + j / 3) + "," + ((i % 3) * 3 + j % 3) + "," +
//                        board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] + ")");

                if (valueInRow != -1) {
                    if (usedInRow[valueInRow]) return false;
                    else usedInRow[valueInRow] = true;
                }
                if (valueInColumn != -1) {
                    if (usedInColumn[valueInColumn]) return false;
                    else usedInColumn[valueInColumn] = true;
                }
                if (valueInGrid != -1) {

                    if (usedInGrid[valueInGrid]) return false;
                    else usedInGrid[valueInGrid] = true;
                }

            }
        }
        return true;
    }
}
