import java.util.ArrayList;

class LightsOut {
    public static final boolean DEV_MODE = true;
    public static final double eps = 0.001;
    double[][] A;
    double[] y;
    int nSize, mSize;

    double[] x;


    public double[] lSolve(double[][] A, double[] y) {
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
                if (A[k][k] == 0) factor = 0;
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

        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++)
                sum += A[i][j] * solution[j];
            if (A[i][i] < eps) solution[i] = 0;
            else {
                solution[i] = (y[i] - sum) / A[i][i];
                solution[i] = (((solution[i] % 2) + 2) % 2);
            }
        }


        return solution;
    }

    public void printRowEchelonForm(double[][] A, double[] B) {
        int N = B.length;
        System.out.println("Row Echelon form:----------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%.3f ", A[i][j]);
            System.out.printf("| %.3f\n", B[i]);
        }
    }

    LightsOut(int nSize, int mSize, double[] y) {
        this.nSize = nSize;
        this.mSize = mSize;
        this.y = y;
        if (y.length != mSize * nSize)
            throw new IllegalArgumentException("Size of input is not correct.");
    }

    private double[][] generateMatrixA() {
        int numOfGrid = mSize * nSize;
        double[][] A = new double[numOfGrid][numOfGrid];
        for (int i = 0; i != numOfGrid; i++) {
            Integer[] inferredGrid = getInferredGrid(i);
            for (int j : inferredGrid) A[i][j] = 1;
        }
        return A;
    }

    private Integer[] getInferredGrid(int gridPos) {
        ArrayList<Integer> pos = new ArrayList<>();
        boolean onLeft = (gridPos % mSize == 0);
        boolean onRight = (gridPos % mSize == mSize - 1);
        boolean onTop = (gridPos < mSize);
        boolean onBottom = (gridPos >= mSize * (nSize - 1));

        pos.add(gridPos);
        if (!onLeft) pos.add(gridPos - 1);
        if (!onRight) pos.add(gridPos + 1);
        if (!onTop) pos.add(gridPos - mSize);
        if (!onBottom) pos.add(gridPos + mSize);
        return pos.toArray(new Integer[pos.size()]);
    }

    double[] solve() {
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
            System.out.println("x:-------------------------------");
            for (double d : x) {
                System.out.println(d);
            }
        }
        return x;
    }
}

public class Main {

    public static void main(String[] args) {
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
//        int Counter = 0;
//
//        ArrayList<String> board = new ArrayList<>();
//        String line;
//        while ((line = in.readLine()) != null) {
//            board.add(line);
//        }

//
//        double[] y = {0, 1, 0, 1, 1, 0, 0, 1, 1};
//        LightOut lightOut = new LightOut(3, 3, y);

        double[] y = {1, 1, 1, 1, 1, 1};
        LightsOut lightsOut = new LightsOut(2, 3, y);
        double[] x = lightsOut.solve();

        int minStep = 0;
        for (double d : x) if (d > 0.5) minStep++;
        System.out.println("minimum Step = " + minStep);
    }
}
