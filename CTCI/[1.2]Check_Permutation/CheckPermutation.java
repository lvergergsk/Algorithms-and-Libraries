//Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

import java.util.HashMap;

public class CheckPermutation {
    boolean checkPermutation(String str1, String str2) {
        HashMap<Character, Integer> require = new HashMap<>();
        if (str1.length() != str2.length()) return false;
        char[] str1Arr = str1.toCharArray();
        for (Character c : str1Arr) {
            Integer previousNumber = require.containsKey(c) ? require.get(c) : 0;
            require.put(c, previousNumber + 1);
        }

        char[] str2Arr = str2.toCharArray();
        for (Character c : str2Arr) {
            if (!require.containsKey(c)) return false;
            Integer previousNumber = require.get(c);
            if (previousNumber - 1 == 0) require.remove(c);
            else require.put(c, previousNumber - 1);
        }
        return true;
    }
}
