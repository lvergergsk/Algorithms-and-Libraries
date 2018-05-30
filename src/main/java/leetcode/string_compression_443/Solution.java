package leetcode.string_compression_443;

//import java.util.Arrays;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public int compress(char[] chars) {
        if (chars.length < 2) return chars.length;
        char c = chars[0];
        int ptr = 0;
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt++;
            if (i == chars.length - 1||chars[i+1]!=chars[i]) {
                chars[ptr++]=chars[i];
                if(cnt>1) {
                    char[] cntCharArr = Integer.toString(cnt).toCharArray();
                    for (char cc : cntCharArr) {
                        chars[ptr++] = cc;
                    }
                }
                cnt = 0;
            }
//            LOGGER.info("i = " + String.valueOf(i) + ", ptr = " + String.valueOf(ptr) + ", cnt = " + String.valueOf(cnt) + ", c = " + c);
        }
//        LOGGER.info(String.valueOf(Arrays.copyOfRange(chars, 0, ptr)));
        return ptr;
    }
}
