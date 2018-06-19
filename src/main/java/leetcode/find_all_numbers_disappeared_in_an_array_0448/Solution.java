package leetcode.find_all_numbers_disappeared_in_an_array_0448;

import java.util.ArrayList;
import java.util.List;

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
