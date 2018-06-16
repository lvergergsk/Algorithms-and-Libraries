package leetcode.restore_ip_address_0093;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    private Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void restoreIpAddresses01() {
        List<String> rep = solution.restoreIpAddresses("25525511135");
        assertEquals(2, rep.size());
    }

    @Test
    public void restoreIpAddress02() {
        List<String> rep = solution.restoreIpAddresses("010010");
        System.out.println(rep);
        assertEquals(2, rep.size());
    }
}