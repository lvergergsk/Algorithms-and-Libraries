import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static final Boolean DEV_MODE = false;

    public static void main(String[] args) {

        // Input, O(1);
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if (DEV_MODE) System.out.println("s: " + s);

        // Prepare answer array, O(1);
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < 10000001; i++) {
            ans.add(false);
        }
        ans.set(0, true);

        // prepare answer, O(|s|);
        char previousChar = '-';
        int previousCharWeight = 0;
        int currentWeight = 0;
        for (int i = 0; i < s.length(); i++) {
            // If need safety, need to check whether input is valid.
            if (s.charAt(i) != previousChar) {
                if (DEV_MODE) System.out.println(s.charAt(i) + "!=" + previousChar);
                previousChar = s.charAt(i);
                currentWeight = 0;
            }
            previousCharWeight = s.charAt(i) - 'a' + 1;
            currentWeight += previousCharWeight;
            ans.set(currentWeight, true);
            if (DEV_MODE) System.out.println("ans[" + currentWeight + "] -> true");
        }

        if (DEV_MODE) {
            for (int i = 0; i != 10; i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }

        // Output answer, O(n);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            int x = in.nextInt();
            if (DEV_MODE) System.out.print("ans[" + a0 + "]:");
            if (ans.get(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
