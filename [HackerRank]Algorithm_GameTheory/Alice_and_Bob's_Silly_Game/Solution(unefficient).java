// O(g*n^2)

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static final boolean DEV_MODE = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();

//        for each query:
        O *= r
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            LinkedList<Integer> numbers = new LinkedList<>();
//            1 is not prime number. exclude it at beginning
            for (int number = 2; number < n + 1; number++)
                numbers.addLast(number);
//            true for Alice, false for Bob.
            boolean winner = false;
            while (!numbers.isEmpty()) {
                if (DEV_MODE) for (Integer number : numbers) System.out.print(number + " ");
                if (DEV_MODE) System.out.println();
                for (Integer number = numbers.removeFirst(), interval = number; number <= n; number += interval) {
//                    amotized O(g*n)
                    if (DEV_MODE) System.out.println("REMOVE: " + number);
//                    O(g*n^2)
                    numbers.remove(number);
                }
                winner = !winner;
            }
            if (winner) System.out.println("Alice");
            else System.out.println("Bob");
        }
    }
}
