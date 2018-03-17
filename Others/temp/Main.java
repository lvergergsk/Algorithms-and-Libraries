import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class LightsOut {
    // Turn DEV_MODE to true to switch on verbose mode.
    private static final boolean DEV_MODE = true;

    private static final double eps = 0.001;
    private double[][] A;
    private ArrayList<Double[]> x; // this is solution.
    private double[] y;
    private int numOfRows;
    private int numOfColumn;

    LightsOut(int numOfRows, int numOfColumn, double[] y) {
        this.numOfRows = numOfRows;
        this.numOfColumn = numOfColumn;
        this.y = y;
        if (y.length != numOfColumn * numOfRows)
            throw new IllegalArgumentException("Size of input is not correct.");
    }

    private void permutation(Double[] perm, int pos, ArrayList<Double[]> res) {
        if (pos == perm.length) {
            res.add(perm.clone());
        } else {
            for (int i = 0; i < 2; i++) {
                perm[pos] = new Double(i);
                permutation(perm, pos + 1, res);
            }
        }
    }

    private ArrayList<Double[]> lSolve(double[][] A, double[] y) {

        int N = y.length;
        for (int k = 0; k < N; k++) {
            int max = k;
            for (int i = k + 1; i < N; i++)
                if (Math.abs(A[i][k]) > Math.abs(A[max][k]))
                    max = i;

            double[] temp = A[k];
            A[k] = A[max];
            A[max] = temp;

            double t = y[k];
            y[k] = y[max];
            y[max] = t;

            for (int i = k + 1; i < N; i++) {
                double factor;
                if (Math.abs(A[k][k]) < eps) factor = 0;
                else factor = A[i][k] / A[k][k];
                y[i] -= factor * y[k];
                y[i] %= 2;
                for (int j = k; j < N; j++) {
                    A[i][j] -= factor * A[k][j];
                    A[i][j] %= 2;
                }
            }
        }

        if (DEV_MODE) printRowEchelonForm(A, y);

        int degreeOfFreedom = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (Math.abs(A[i][i]) < eps && y[i] < eps) {
                degreeOfFreedom++;
            } else if (Math.abs(A[i][i]) < eps && y[i] > eps) {
                throw new ArithmeticException("No solution for this linear system.");
            }
        }

        ArrayList<Double[]> solutions = new ArrayList<>();

        if (degreeOfFreedom == 0) {
            solutions.add(new Double[N]);
        } else permutation(new Double[N], N - degreeOfFreedom, solutions);

        if (DEV_MODE) {
            System.out.println("Bases for x-------------------");
            for (Double[] ds : solutions) {
                for (Double d : ds) {
                    System.out.print(d + " ");
                }
                System.out.println();
            }
        }

        for (Double[] solution : solutions) {
            double[][] Atemp = A;
            double[] ytemp = y;
            for (int i = N - 1 - degreeOfFreedom; i >= 0; i--) {
                double sum = 0.0;
                for (int j = i + 1; j < N; j++)
                    sum += Atemp[i][j] * solution[j];
                if (Math.abs(Atemp[i][i]) < eps && ytemp[i] < eps) solution[i] = new Double(0);
                else {
                    solution[i] = (ytemp[i] - sum) / Atemp[i][i];
                    solution[i] = (((solution[i] % 2) + 2) % 2);
                }
            }

        }

        return solutions;
    }

    private void printRowEchelonForm(double[][] A, double[] B) {
        int N = B.length;
        System.out.println("Row Echelon form:----------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%.3f ", A[i][j]);
            System.out.printf("| %.3f\n", B[i]);
        }
    }

    private double[][] generateMatrixA() {
        int numOfGrid = numOfColumn * numOfRows;
        double[][] A = new double[numOfGrid][numOfGrid];
        for (int i = 0; i != numOfGrid; i++) {
            Integer[] inferredGrid = getInferredGrid(i);
            for (int j : inferredGrid) A[i][j] = 1;
        }
        return A;
    }

    private Integer[] getInferredGrid(int gridPos) {
        ArrayList<Integer> pos = new ArrayList<>();
        boolean onLeft = (gridPos % numOfColumn == 0);
        boolean onRight = (gridPos % numOfColumn == numOfColumn - 1);
        boolean onTop = (gridPos < numOfColumn);
        boolean onBottom = (gridPos >= numOfColumn * (numOfRows - 1));

        pos.add(gridPos);
        if (!onLeft) pos.add(gridPos - 1);
        if (!onRight) pos.add(gridPos + 1);
        if (!onTop) pos.add(gridPos - numOfColumn);
        if (!onBottom) pos.add(gridPos + numOfColumn);
        return pos.toArray(new Integer[pos.size()]);
    }

    ArrayList<Double[]> solve() {
        this.A = generateMatrixA();

        if (DEV_MODE) {
            System.out.println("A:-------------------------------");
            for (double[] row : A) {
                for (double d : row) {
                    System.out.print(d);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

        if (DEV_MODE) {
            System.out.println("y:-------------------------------");
            for (double d : y) {
                System.out.println(d);
            }
        }

        this.x = lSolve(A, y);
        if (DEV_MODE) {
            for (int i = 0; i < x.size(); i++) {
                System.out.print("x" + i + ":-------------------------------");
                for (int j = 0; j < x.get(i).length; j++) {
                    if (j % numOfColumn == 0) System.out.println();
                    System.out.print(x.get(i)[j] + " ");
                }
                System.out.println();
            }
        }
        return x;
    }
}

public class Main {
    // Example Input:
    // .O.
    // OO.
    // .OO
    // ctrl+D (EOF)

    // Example Input for no solution:
    // O..
    // ...
    // ctrl+D (EOF)

//    Turn DEV_MODE of LightsOut on to see detailed solution of the puzzle.

    private static final boolean DEV_MODE = false;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);

        ArrayList<String> input = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null) {
            input.add(line);
        }

        int numOfRows = input.size();
        if (numOfRows == 0) {
            System.out.println(0);
            return;
        }
        int numOfColumns = input.get(0).length();
        double[] y = new double[numOfRows * numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            if (input.get(i).length() != numOfColumns)
                throw new IllegalArgumentException("Input is not valid.");
            for (int j = 0; j < numOfColumns; j++) {
                if (input.get(i).charAt(j) == 'O') y[i * numOfColumns + j] = 1;
                else y[i * numOfColumns + j] = 0;
            }
        }

        LightsOut lightsOut = new LightsOut(numOfRows, numOfColumns, y);
        try {
            ArrayList<Double[]> solutions = lightsOut.solve();
            int minNumOfStep = Integer.MAX_VALUE;
            for (Double[] solution : solutions) {
                // If the solution is unique, then numOfStep is also minimum step.
                int numOfStep = 0;
                for (double d : solution) if (d > 0.5) numOfStep++;
                minNumOfStep = numOfStep < minNumOfStep ? numOfStep : minNumOfStep;
            }
            if (DEV_MODE) System.out.println("Minimum number of Step = " + minNumOfStep);
            else System.out.println(minNumOfStep);
        } catch (ArithmeticException e) {
            System.out.println("There is no solution for this puzzle.");
        }
    }
}
