package leetcode.evaluate_reverse_polish_notation_0150;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void evalRPN1() {
        assertEquals(-8, solution.evalRPN(new String[]{"2", "4", "6", "+", "-"}));
    }

    @Test
    public void evalRPN2() {
        assertEquals(9, solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    @Test
    public void evalRPN3(){
        assertEquals(6,solution.evalRPN(new String[]{"4","13","5","/","+"}));
    }

    @Test
    public void evalPRN4(){
        assertEquals(22,solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}