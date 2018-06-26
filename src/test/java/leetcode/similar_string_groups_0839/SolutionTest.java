package leetcode.similar_string_groups_0839;

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
    public void numSimilarGroups() {
        int rep = solution.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"});
        assertEquals(2, rep);
    }

    @Test
    public void numSimilarGroups02() {
        int rep = solution.numSimilarGroups(new String[]{"blw", "bwl", "wlb"});
        assertEquals(1, rep);
    }

    @Test
    public void numSimilarGroup03() {
        int rep = solution.numSimilarGroups(new String[]{"kccomwcgcs", "socgcmcwkc", "sgckwcmcoc", "coswcmcgkc", "cowkccmsgc", "cosgmccwkc", "sgmkwcccoc", "coswmccgkc", "kowcccmsgc", "kgcomwcccs"});
        assertEquals(5, rep);
    }

    @Test
    public void numSimilarGroup04() {
        int rep = solution.numSimilarGroups(new String[]{"ajdidocuyh", "djdyaohuic", "ddjyhuicoa", "djdhaoyuic", "ddjoiuycha", "ddhoiuycja", "ajdydocuih", "ddjiouycha", "ajdydohuic", "ddjyouicha"});
        assertEquals(2, rep);
    }

    @Test
    public void numSimilarGroup05() {
        int rep = solution.numSimilarGroups(new String[]{"aaa", "aaa", "aaa", "aaa", "aaa", "aaa"});
        assertEquals(1, rep);
    }
}