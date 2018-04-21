public class ValidSudoku {
    public static final boolean DEV_MODE = true;

    public boolean isValidSudoku(char[][] board) {
        if (DEV_MODE) System.out.println("Row, Column,Grid");
        for (int i = 0; i < 9; i++) {
            boolean[] usedInGrid = new boolean[9];
            boolean[] usedInRow = new boolean[9];
            boolean[] usedInColumn = new boolean[9];
            if (DEV_MODE) System.out.println("----------------");
            for (int j = 0; j < 9; j++) {

                int valueInRow = board[i][j] == '.' ? -1 : board[i][j] - '1';
                int valueInColumn = board[j][i] == '.' ? -1 : board[j][i] - '1';
                char charInGrid = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];
                int valueInGrid = charInGrid == '.' ? -1 : charInGrid - '1';

                if (DEV_MODE) {
                    System.out.println("(" + i + "," + j + "," + board[i][j] + ")" +
                            "(" + j + "," + i + "," + board[j][i] + ")" +
                            "(" + ((i / 3) * 3 + j / 3) + "," + ((i % 3) * 3 + j % 3) + "," +
                            board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] + ")");
                }

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
