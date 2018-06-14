package leetcode.ransom_note_0383;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void before(){
        solution=new Solution();
    }

    @Test
    public void canConstruct() {
        boolean rep=solution.canConstruct("dfff","deffff");
        assertTrue(rep);
    }
}