import java.util.Scanner;

public class Solution {

    static int diagonalDifference(int[][] a) {
        if (a.length == 0) return 0;
        int length = a[0].length;

        int l2rSum = 0;
        int r2lSum = 0;
        for (int i = 0, l2rPos = 0, r2lPos = length - 1; i < length; i++) {
            l2rSum += a[i][l2rPos++];
            r2lSum += a[i][r2lPos--];
        }
        int res = r2lSum - l2rSum;
        return (res >= 0 ? res : -res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
