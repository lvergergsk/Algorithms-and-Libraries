// Given a smaller string 5 and a bigger string b,
// design an algorithm to find all permutations of the shorter string within the longer one.
// Print the location of each permutation.

// O(N).

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PermutatedStringContainment {
    public static final boolean DEV_MODE = true;

    ArrayList<Integer> solve(String shorter, String longer) {
        if (shorter.length() > longer.length()) {
            String temp = longer;
            longer = shorter;
            shorter = temp;
        }

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> require = new HashMap<>();
        HashSet<Character> unsatisfy = new HashSet<>();

        char[] shorterString = shorter.toCharArray();
        char[] longerString = longer.toCharArray();

        for (Character c : shorterString) {
            Integer previousValue = require.containsKey(c) ? require.get(c) : 0;
            require.put(c, previousValue + 1);
            unsatisfy.add(c);
        }

        if (DEV_MODE) {
            System.out.println("Initial state:");
            System.out.println("Require: " + require.toString());
            System.out.println("Unsatisfy: " + require.toString());
        }

        for (int i = 0; i < longerString.length; i++) {
            Character cin = longerString[i];
            if (DEV_MODE) System.out.println("--------------------------\ncin: " + cin);
            if (require.containsKey(cin)) {
                Integer previousValue = require.get(cin);
                require.put(cin, previousValue - 1);
                if (previousValue - 1 == 0) unsatisfy.remove(cin);
                else unsatisfy.add(cin);
            }
            if (i >= shorter.length() && require.containsKey(longerString[i - shorter.length()])) {
                Character cout = longerString[i - shorter.length()];
                if (DEV_MODE) System.out.println("cout: " + cout);
                Integer previousValue = require.get(cout);
                require.put(cout, previousValue + 1);
                if (previousValue + 1 == 0) unsatisfy.remove(cout);
                else unsatisfy.add(cout);
            }
            if (DEV_MODE) {
                System.out.println("Require: " + require.toString());
                System.out.println("Unsatisfy: " + require.toString());
            }
            if (unsatisfy.isEmpty())
                res.add(i - shorter.length() + 1);
        }
        return res;
    }
}
