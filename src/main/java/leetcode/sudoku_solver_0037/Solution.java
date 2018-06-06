package leetcode.sudoku_solver_0037;

import java.util.*;
//import java.util.logging.Logger;

class Solution {

//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    class SudokuSolver {

        final int[][] board;
        final BoardPos[] blanks;
        LinkedList<StackNode> trace;

        boolean row[][];
        boolean column[][];
        boolean grid[][];

        SudokuSolver(int[][] board) {
            this.board = board;

            this.row = new boolean[9][9];
            this.column = new boolean[9][9];
            this.grid = new boolean[9][9];
            this.trace = new LinkedList<>();

            ArrayList<BoardPos> blanksTemp = new ArrayList<>();
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++) {
                    BoardPos pos = new BoardPos(i, j);
                    if (board[i][j] == 0) blanksTemp.add(pos);
                    else {
                        this.setUsed(pos, board[i][j]);
                    }
                }
            this.blanks = blanksTemp.toArray(new BoardPos[blanksTemp.size()]);

            this.solve();
        }

        void pushStackNode(Stack<StackNode> stack, int pos) {
            int rowNum = blanks[pos].rowNum;
            int columnNum = blanks[pos].columnNum;
            int gridNum = blanks[pos].gridNum;
            for (int i = 0; i < 9; i++) {
                if (!row[rowNum][i] && !column[columnNum][i] && !grid[gridNum][i]) {
                    stack.push(new StackNode(pos, i + 1));
                }
            }
        }

        private void setUsed(BoardPos pos, int value) {
            this.row[pos.rowNum][value - 1] = true;
            this.column[pos.columnNum][value - 1] = true;
            this.grid[pos.gridNum][value - 1] = true;
        }

        private void unsetUsed(BoardPos pos, int value) {
            this.row[pos.rowNum][value - 1] = false;
            this.column[pos.columnNum][value - 1] = false;
            this.grid[pos.gridNum][value - 1] = false;
        }

        private void solve() {
            Stack<StackNode> dfsStack = new Stack<>();

            int pos = 0;
            pushStackNode(dfsStack, pos);

            while (true) {
//                back-tracking
                StackNode currentStep = dfsStack.pop();
                while (currentStep.posInTape != pos) {
                    StackNode prev = this.trace.pop();
                    unsetUsed(this.blanks[prev.posInTape], prev.value);
                    pos--;
                }
                pos++;

//                Record current step.
                trace.push(currentStep);
                setUsed(blanks[currentStep.posInTape], currentStep.value);

//                LOGGER.info("\nBlanks: " + Arrays.toString(blanks) + "\nTrace: " + trace.toString());

//                Break if all filled.
                if (pos == blanks.length) break;
                pushStackNode(dfsStack, pos);
            }


        }

        void getSolAsCharArray(char[][] board, boolean solutionOnly) {
            if (!solutionOnly) {
//                fill the given numbers.
            }

            ListIterator<StackNode> iter=trace.listIterator(trace.size());
            int posInBlanks=0;
            while(iter.hasPrevious()){
                StackNode node=iter.previous();
                board[blanks[posInBlanks].rowNum][blanks[posInBlanks].columnNum]=(char)('0'+node.value);
                posInBlanks++;
            }
        }

        private class BoardPos {
            final int rowNum;
            final int columnNum;
            final int gridNum;

            public BoardPos(int rowNum, int columnNum) {
                this.rowNum = rowNum;
                this.columnNum = columnNum;
                this.gridNum = (rowNum / 3) * 3 + columnNum / 3;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                BoardPos boardPos = (BoardPos) o;
                return rowNum == boardPos.rowNum &&
                        columnNum == boardPos.columnNum;
            }

            @Override
            public int hashCode() {

                return Objects.hash(rowNum, columnNum);
            }

            @Override
            public String toString() {
                return "BoardPos{" +
                        "rowNum=" + rowNum +
                        ", columnNum=" + columnNum +
                        ", gridNum=" + gridNum +
                        '}';
            }
        }

        private class StackNode {
            final int posInTape;
            final int value;

            StackNode(int posInTape, int value) {
                this.posInTape = posInTape;
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                StackNode stackNode = (StackNode) o;
                return posInTape == stackNode.posInTape &&
                        value == stackNode.value;
            }

            @Override
            public int hashCode() {

                return Objects.hash(posInTape, value);
            }

            @Override
            public String toString() {
                return "StackNode{" +
                        "posInTape=" + posInTape +
                        ", value=" + value +
                        '}';
            }
        }
    }

    public void solveSudoku(char[][] board) {
        int[][] quiz = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                quiz[i][j] = board[i][j] == '.' ? 0 : board[i][j] - '0';

        SudokuSolver solver = new SudokuSolver(quiz);
       solver.getSolAsCharArray(board,true);
    }
}
