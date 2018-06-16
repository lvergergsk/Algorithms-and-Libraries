package leetcode.restore_ip_address_0093;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

class Solution {
    private class StackNode {
        final int endExcluded;
        final int group;

        StackNode(int endExcluded, int group) {
            this.endExcluded = endExcluded;
            this.group = group;
        }

        @Override
        public String toString() {
            return "StackNode{" +
                    "endExcluded=" + endExcluded +
                    ", group=" + group +
                    '}';
        }
    }

    private void pushAvailable(Stack<StackNode> stack, String s, int startIncluded, int group) {
        if (group >= 4) return;
        for (int endExcluded = startIncluded + 1; endExcluded <= s.length(); endExcluded++) {
            int val = Integer.valueOf(s.substring(startIncluded, endExcluded));
            if (s.charAt(startIncluded) == '0' && (endExcluded - startIncluded != 1 || val != 0)) return;
            else if (val >= 0 && val < 256) stack.push(new StackNode(endExcluded, group));
            else return;
        }
    }

    public List<String> restoreIpAddresses(String s) {
        Stack<StackNode> stack = new Stack<>();

        List<String> res = new LinkedList<>();
        LinkedList<StackNode> sol = new LinkedList<>();
        StringBuilder sb;

        pushAvailable(stack, s, 0, sol.size());
        while (!stack.empty()) {
            StackNode stackNode = stack.pop();

            while (sol.size() > stackNode.group) sol.removeLast();

            sol.addLast(stackNode);


            if (sol.size() == 4 && sol.peekLast().endExcluded == s.length()) {
                sb = new StringBuilder(s);
                ListIterator<StackNode> iter = sol.listIterator(sol.size() - 1);
                while (iter.hasPrevious()) {
                    StackNode sn = iter.previous();
                    sb.insert(sn.endExcluded, '.');
                }
                res.add(sb.toString());
            } else {
                pushAvailable(stack, s, stackNode.endExcluded, sol.size());
            }
        }


        return res;
    }

}