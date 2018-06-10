package leetcode.additive_number_0306;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution;

    @Before
    public void before() {
        this.solution = new Solution();
    }

    @Test
    public void isAdditiveNumber01() {
        boolean rep = solution.isAdditiveNumber("112358");
        assertTrue(rep);
    }

    @Test
    public void isAdditiveNumber02() {
        boolean rep = solution.isAdditiveNumber("199100199");
        assertTrue(rep);
    }

    @Test
    public void isAdditiveNumber03() {
        boolean rep = solution.isAdditiveNumber("014786974297");
        assertFalse(rep);
    }

    @Test
    public void isAdditiveNumber04(){
        boolean rep=solution.isAdditiveNumber("101");
        assertTrue(rep);
    }
}