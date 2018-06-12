package leetcode.n_queens_0051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {


    private class Queens {
        final int n;

        Stack<Queen> queensStack;

        private boolean[] row;
        private boolean[] column;
        private boolean[] plusRow;
        private boolean[] minusRow;


        final List<List<Queen>> solutions;

        private class Queen {
            final int row;
            final int column;
            final int plusRow;
            final int minusRow;


            private Queen(int row, int column) {
                this.row = row;
                this.column = column;
                this.plusRow = column + row;
                this.minusRow = column - row;
            }

            @Override
            public String toString() {
                return "Queen{" +
                        "row=" + row +
                        ", column=" + column +
                        '}';
            }
        }


        private Queens(int n) {
            this.n = n;
            this.queensStack = new Stack<>();

            this.row = new boolean[n];
            this.column = new boolean[n];
            this.plusRow = new boolean[2 * n - 1];
            this.minusRow = new boolean[2 * n - 1];

            this.solutions = this.dfs();

        }

        private boolean isvalid(Queen q) {
            return !(row[q.row] || column[q.column] || plusRow[q.plusRow] || minusRow[n - 1 + q.minusRow]);
        }

        private void setFlag(Queen q) {
            this.row[q.row] = true;
            this.column[q.column] = true;
            this.plusRow[q.plusRow] = true;
            this.minusRow[n - 1 + q.minusRow] = true;
        }

        private void unsetFlag(Queen q) {
            this.row[q.row] = false;
            this.column[q.column] = false;
            this.plusRow[q.plusRow] = false;
            this.minusRow[n - 1 + q.minusRow] = false;
        }

        private void pushValidQueens(int i) {
            for (int j = 0; j < this.n; j++) {
                Queen queen = new Queen(i, j);
                if (isvalid(queen))
                    this.queensStack.add(queen);
            }
        }

        private List<List<Queen>> dfs() {
            List<List<Queen>> res = new ArrayList<>();
            ArrayList<Queen> sol = new ArrayList<>();
            pushValidQueens(0);
            while (!this.queensStack.empty()) {
                Queen queen = this.queensStack.pop();

                while (queen.row != (!sol.isEmpty() ? sol.get(sol.size() - 1).row + 1 : 0)) {
                    unsetFlag(sol.remove(sol.size() - 1));
                }
                sol.add(queen);
                setFlag(queen);

                if (queen.row == n - 1) {
                    res.add(new ArrayList<>(sol));
                } else pushValidQueens(queen.row + 1);
            }
            return res;
        }

        List<List<String>> getSolutions() {
            List<List<String>> res = new ArrayList<>();
            for (List<Queen> queens : solutions) {
                List<String> solution = Arrays.asList(new String[n]);
                for (Queen queen : queens) {
                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < n; i++) line.append(queen.column == i ? "Q" : ".");
                    solution.set(queen.row, line.toString());
                }
                res.add(solution);
            }

            return res;
        }

    }


    List<List<String>> solveNQueens(int n) {
        Queens queens = new Queens(n);
        return queens.getSolutions();
    }
}