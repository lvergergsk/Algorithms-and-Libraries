package leetcode.jump_game_0055;

//import java.util.logging.Logger;

// Greedy algorithm.
class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public boolean canJump(int[] nums) {
        for (int i = 0, j = nums[i]; j < nums.length-1; i++) {
            if (j < i) return false;
            else j = nums[i] + i > j ? nums[i] + i : j;
//            LOGGER.info("i = " + i + ", j = " + j);
        }

        return true;
    }
}
