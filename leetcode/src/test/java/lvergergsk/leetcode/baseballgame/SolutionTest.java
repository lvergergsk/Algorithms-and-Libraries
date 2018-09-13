package lvergergsk.leetcode.baseballgame;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    Solution solution;

    @Before
    public void before() {
        this.solution = new Solution();
    }

    @Test
    public void calPoints01() {
        int rep = solution.calPoints(new String[]{"2", "1", "4", "C", "D", "+"});
        System.out.println(rep);
    }

    @Test
    public void callPoints02(){
        int rep=solution.calPoints(new String[]{"5","2","C","D","+"});
        System.out.println(rep);
    }
}