package lvergergsk.leetcode.additivenumber;

import java.math.BigInteger;
//import java.util.logging.Logger;

/**
 * 0306: Additive Number
 */
class Solution {

//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());


    private boolean validBreakpoint(String num, int end1Exclusive, int end2Exclusive) {
        if (end1Exclusive <= 0 || end1Exclusive >= end2Exclusive || end2Exclusive > num.length()) return false;
        if (Integer.max(end1Exclusive, end2Exclusive - end1Exclusive) > num.length() - end2Exclusive) return false;
        if (num.charAt(0) == '0' && end1Exclusive > 1) return false;
        if (num.charAt(end1Exclusive) == '0' && end2Exclusive - end1Exclusive > 1) return false;

        int sequenceStart = 0;
        while (end2Exclusive < num.length()) {
            if (num.charAt(end2Exclusive) == '0' && (num.charAt(sequenceStart) != '0' || num.charAt(end1Exclusive) != '0'))
                return false;
            BigInteger o1 = new BigInteger(num.substring(sequenceStart, end1Exclusive));
            BigInteger o2 = new BigInteger(num.substring(end1Exclusive, end2Exclusive));
            String sum = o1.add(o2).toString();
            if (sum.length() > (num.length() - end2Exclusive)) return false;
            if (!num.substring(end2Exclusive, end2Exclusive + sum.length()).equals(sum)) return false;

//            LOGGER.info("[" + sequenceStart + "," + end1Exclusive + "," + end2Exclusive + "," + (end2Exclusive + sum.length()) + "] successful.");

            sequenceStart = end1Exclusive;
            end1Exclusive = end2Exclusive;
            end2Exclusive = end2Exclusive + sum.length();
        }

        return true;
    }

    boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++)
            for (int j = i + 1; j < num.length(); j++) {
                if (validBreakpoint(num, i, j)) return true;
            }
        return false;
    }
}
