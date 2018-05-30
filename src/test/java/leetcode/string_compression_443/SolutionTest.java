package leetcode.string_compression_443;

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
    public void testCompress1() {
        int res = solution.compress(new char[]{'a', 'a', 'a'});
        assertEquals(2, res);
    }

    @Test
    public void testCompress2() {
        int res = solution.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        assertEquals(6, res);
    }

    @Test
    public void testCompress3() {
        int res = solution.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'});
        assertEquals(4, res);
    }

    @Test
    public void testCompress4() {
        int res = solution.compress(new char[]{'a', 'b', 'c', 'd', 'e'});
        assertEquals(5, res);
    }
}