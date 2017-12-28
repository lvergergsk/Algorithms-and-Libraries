import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public static final boolean DEV_MODE = false;

    static int N;
    static int M;
    static int[][] matrixNM;

    // This method has side effect w.r.t matrixNM.
    private static int neighbourDFS(int n, int m) {
        LinkedList<Pair<Integer, Integer>> stack = new LinkedList<>();
        int count = 0;
        stack.addLast(new Pair<>(n, m));
        matrixNM[n][m] = 0;
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> current = stack.removeLast();
            int currentN = current.getKey();
            int currentM = current.getValue();
            if (DEV_MODE) System.out.println("current indice: " + current + "-------------------------");
            if (currentN > 0 && matrixNM[currentN - 1][currentM] != 0) {
                stack.addLast(new Pair<>(currentN - 1, currentM));
                matrixNM[currentN - 1][currentM] = 0;
            }
            if (currentN < N - 1 && matrixNM[currentN + 1][currentM] != 0) {
                stack.addLast(new Pair<>(currentN + 1, currentM));
                matrixNM[currentN + 1][currentM] = 0;
            }
            if (currentM > 0 && matrixNM[currentN][currentM - 1] != 0) {
                stack.addLast(new Pair<>(currentN, currentM - 1));
                matrixNM[currentN][currentM - 1] = 0;
            }
            if (currentM < M - 1 && matrixNM[currentN][currentM + 1] != 0) {
                stack.addLast(new Pair<>(currentN, currentM + 1));
                matrixNM[currentN][currentM + 1] = 0;
            }
            if (currentN > 0 && currentM > 0 && matrixNM[currentN - 1][currentM - 1] != 0) {
                stack.addLast(new Pair<>(currentN - 1, currentM - 1));
                matrixNM[currentN - 1][currentM - 1] = 0;
            }
            if (currentN > 0 && currentM < M - 1 && matrixNM[currentN - 1][currentM + 1] != 0) {
                stack.addLast(new Pair<>(currentN - 1, currentM + 1));
                matrixNM[currentN - 1][currentM + 1] = 0;
            }
            if (currentN < N - 1 && currentM > 0 && matrixNM[currentN + 1][currentM - 1] != 0) {
                stack.addLast(new Pair<>(currentN + 1, currentM - 1));
                matrixNM[currentN + 1][currentM - 1] = 0;
            }
            if (currentN < N - 1 && currentM < M - 1 && matrixNM[currentN + 1][currentM + 1] != 0) {
                stack.addLast(new Pair<>(currentN + 1, currentM + 1));
                matrixNM[currentN + 1][currentM + 1] = 0;
            }

            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        M = Integer.parseInt(scanner.nextLine());
        matrixNM = new int[N][M];
        for (int n = 0; n < N; ++n) {
            for (int m = 0; m < M; ++m) {
                matrixNM[n][m] = Integer.parseInt(scanner.next());
            }
        }

        if (DEV_MODE) {
            for (int[] row : matrixNM) {
                for (int e : row) {
                    System.out.print(e + " ");
                }
                System.out.print("\n");
            }
        }

        int maxSize = 0;
        for (int n = 0; n < N; ++n) {
            for (int m = 0, groupSize; m < M; ++m) {
                if (matrixNM[n][m] != 0) {
                    groupSize = neighbourDFS(n, m);
                    maxSize = groupSize > maxSize ? groupSize : maxSize;
                }
            }
        }

        System.out.print(maxSize);
    }
}