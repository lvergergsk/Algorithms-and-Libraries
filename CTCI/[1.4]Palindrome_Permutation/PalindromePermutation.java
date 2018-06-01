// Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phrase that is the same forwards and backwards.
// A permutation is a rearrangement of letters.
// The palindrome does not need to be limited to just dictionary words.

import java.util.HashSet;

public class PalindromePermutation {
    private static final boolean DEV_MODE=true;
    boolean parlindromePermutation(String str) {
        HashSet<Character> record = new HashSet<>();
        char[] strArr = str.toCharArray();
        for (Character c : strArr) {
            if (record.contains(c)) record.remove(c);
            else record.add(c);
        }
        if (record.size() <= 1) return true;
        else return false;
    }
}
