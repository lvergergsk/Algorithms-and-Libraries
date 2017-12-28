import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    private static final boolean DEV_MODE=false;
    public static void main(String args[]) {
        BigInteger ans;
        Scanner in = new Scanner(System.in);
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int n = in.nextInt();

        BigInteger bigInteger1 = BigInteger.valueOf(t1);
        BigInteger bigInteger2 = BigInteger.valueOf(t2);

        if (n == 1) {
            System.out.println(bigInteger1.toString());
            return;
        }

        if (n == 2) {
            System.out.println(bigInteger2.toString());
            return;
        }

        for (int f1 = 3; f1 <= n; f1++) {

            if (f1 % 2 == 0) {
                bigInteger2 = bigInteger2.add(bigInteger1.multiply(bigInteger1));
            } else {
                bigInteger1 = bigInteger1.add(bigInteger2.multiply(bigInteger2));
            }
            if (DEV_MODE)System.out.println("-----------------------------");
            if (DEV_MODE)System.out.println("bigInteger1 = "+bigInteger1.toString());
            if (DEV_MODE)System.out.println("bigInteger2 = "+bigInteger2.toString());
        }
        if (n % 2 == 0) {
            ans = bigInteger2;
        } else {
            ans = bigInteger1;
        }
        System.out.println(ans.toString());

    }
}
