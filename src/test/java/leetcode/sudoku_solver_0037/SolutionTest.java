package leetcode.sudoku_solver_0037;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    private char[][] validSudokuQuiz0;
    private leetcode.sudoku_solver_0037.Solution solution;
//    private leetcode.valid_sudoku_0036.Solution validator;

    @Before
    public void before() {
        this.validSudokuQuiz0 = new char[][]{
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        this.solution = new leetcode.sudoku_solver_0037.Solution();
//        this.validator = new leetcode.valid_sudoku_0036.Solution();
    }

    private void printSudoku(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

//    @Test
//    public void prerequisite0() {
//        assertTrue(this.validator.isValidSudoku(this.validSudokuQuiz0));
//    }

    @Test
    public void solveSudoku1() {
        this.validSudokuQuiz0[2][2] = '.';
        this.validSudokuQuiz0[3][3] = '.';
        this.validSudokuQuiz0[3][4] = '.';
        this.validSudokuQuiz0[4][3] = '.';
        this.validSudokuQuiz0[4][4] = '.';
        this.solution.solveSudoku(this.validSudokuQuiz0);
//        assertTrue(this.validator.isValidSudoku(this.validSudokuQuiz0));
        this.printSudoku(this.validSudokuQuiz0);
    }

    @Test
    public void solveSudoku2() {
        this.validSudokuQuiz0 = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        this.solution.solveSudoku(this.validSudokuQuiz0);
//        assertTrue(this.validator.isValidSudoku(this.validSudokuQuiz0));
        this.printSudoku(this.validSudokuQuiz0);

    }
}