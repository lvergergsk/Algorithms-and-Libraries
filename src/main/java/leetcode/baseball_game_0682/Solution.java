package leetcode.baseball_game_0682;

import java.util.ArrayList;
//import java.util.logging.Logger;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

//    private static boolean isNumeric(String str) {
//        return str.matches("-?\\d+(\\.\\d+)?");
//    }

    public int calPoints(String[] ops) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (String op : ops) {
            if (stack.size() >= 2 && op.equals("+")) {
                stack.add(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
            } else if (stack.size() >= 1 && op.equals("D")) {
                stack.add(2 * stack.get(stack.size() - 1));
            } else if (stack.size() >= 1 && op.equals("C")) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(Integer.valueOf(op));
            }
//            LOGGER.info(stack.toString());
        }

        int res = 0;
        for (int i : stack)
            res += i;

        return res;
    }
}
