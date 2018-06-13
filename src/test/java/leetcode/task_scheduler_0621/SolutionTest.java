package leetcode.task_scheduler_0621;

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
    public void leastInterval01() {
        int rep = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        assertEquals(8, rep);
    }

    @Test
    public void leastInterval02() {
        int rep = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E', 'E'}, 3);
        assertEquals(13, rep);
    }

    @Test
    public void leastInterval03() {
        int rep = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'F', 'F'}, 3);
        assertEquals(17, rep);
    }

    @Test
    public void leastInterval04() {
        int rep = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0);
        assertEquals(6, rep);
    }

    @Test
    public void leastInterval05() {
        int rep = solution.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);
        assertEquals(16,rep);
    }

}