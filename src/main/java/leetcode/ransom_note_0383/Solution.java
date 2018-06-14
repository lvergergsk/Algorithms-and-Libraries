package leetcode.ransom_note_0383;

import java.util.HashMap;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> letters = new HashMap<>();

        char[] magazineArr = magazine.toCharArray();
        for (char c : magazineArr) {
//            letters.merge(c, 1, (a, b) -> a + b);
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }
//        LOGGER.info(letters.toString());

        char[] ransomArr = ransomNote.toCharArray();
        for (char c : ransomArr) {
            if (letters.containsKey(c)) {
//                letters.merge(c, 1, (a, b) -> a - 1 == 0 ? null : a - 1);
                int v = letters.get(c);
                if (v == 1) letters.remove(c);
                else letters.put(c, v - 1);

            } else return false;
//            LOGGER.info(letters.toString());
        }
        return true;
    }
}
