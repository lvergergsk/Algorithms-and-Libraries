//amotized O(r*n)

import java.util.Scanner;

public class Solution {

    public static final boolean DEV_MODE = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();

//        for each query:
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
//            [1,...,n]
            boolean[] numbers = new boolean[n + 1];
//            1 is not prime number. exclude it at beginning
//            true is for deleted
            numbers[0] = true;
            numbers[1] = true;
//            true for Alice, false for Bob.
            boolean winner = false;
//            firstFalse is pointer to current first false in numbers
//            firstFalse is the first prime number in numbers
            for (int firstFalse = 2; firstFalse <= n; ) {
                for (int index = firstFalse; index <= n; index += firstFalse)
//                    amortized O(r*n)
                    numbers[index] = true;
//                amotized O(r*n)
//                update firstFalse
                while (++firstFalse < n + 1 && numbers[firstFalse]) ;
                winner = !winner;
                if (DEV_MODE) for (boolean b : numbers) System.out.print(b + " ");
                if (DEV_MODE) System.out.println();
            }

//            print out answer
            if (winner) System.out.println("Alice");
            else System.out.println("Bob");
        }
    }
}
