package lvergergsk.leetcode.findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.List;


/**
 * 0448: find all numbers disappeared in an array.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            int index=Math.abs(i)-1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) res.add(i + 1);
        return res;
    }
}
