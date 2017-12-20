import java.util.Scanner;

public class Solution {

    static long solve(long n) {
        long c = 0;
        while (n != 0) {
            c += n % 2 == 1 ? 0 : 1;
            n /= 2;
        }
        c = (long)Math.pow(2, c);

        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }
}
