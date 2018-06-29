package leetcode.race_car_0818;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void before() {
        this.solution = new Solution();
    }

    @Test
    public void racecarAnalytical01() {
        assertEquals(2, solution.racecarAnalytical(3));
    }

    @Test
    public void racecarTopDown01() {
        assertEquals(2, solution.racecarTopDown(3));
    }

    @Test
    public void racecarBottomUp01() {
        assertEquals(2, solution.racecarButtomUp(3));
    }

    @Test
    public void racecarAnalytical02() {
        assertEquals(5, solution.racecarAnalytical(6));
    }

    @Test
    public void racecarTopDown02() {
        assertEquals(5, solution.racecarTopDown(6));
    }

    @Test
    public void racecarButtomUp02() {
        assertEquals(5, solution.racecarButtomUp(6));
    }

    @Test
    public void racecarAnalytical03(){
        solution.racecarAnalytical(9);
    }

}