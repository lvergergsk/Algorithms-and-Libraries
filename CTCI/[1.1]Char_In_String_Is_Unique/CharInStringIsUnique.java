// Is Unique: Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

import java.util.HashSet;

public class CharInStringIsUnique {
    public static final boolean DEV_MODE = true;

    boolean isUniqueCharsUsingBitArray(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
            if (DEV_MODE) {
                System.out.println("char: " + str.charAt(i));
                System.out.println("checker:" + String.format("%32s", Integer.toBinaryString(checker)).replace(' ', '0'));
            }
        }
        return true;
    }

    boolean isUniqueCharUsingHashSet(String str) {
        HashSet<Character> characters = new HashSet<>();
        char[] chars = str.toCharArray();
        for (Character c : chars) {
            if (characters.contains(c)) return false;
            characters.add(c);
        }
        return true;
    }

}
