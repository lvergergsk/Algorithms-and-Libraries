package lvergergsk.leetcode.accountsmerge;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private List<List<String>> accounts;
    private Solution solution;

    @Before
    public void before() {
        accounts = new ArrayList<>();
        solution = new Solution();
    }

    @Test
    public void testAccountsMerge1() {
        accounts.add(Arrays.asList("name1", "email1@mail.com", "email3@mail.com"));
        accounts.add(Arrays.asList("name1", "email1@mail.com", "email2@mail.com"));

        List<List<String>> rep = solution.accountsMerge(accounts);
        assertEquals(1, rep.size());
        assertEquals(4, rep.get(0).size());
    }

    @Test
    public void testAccountsMerge2() {
        accounts.add(Arrays.asList("cname1", "email1@mail.com"));
        accounts.add(Arrays.asList("aname2", "email2@mail.com"));
        accounts.add(Arrays.asList("bname3", "email3@mail.com"));
        List<List<String>> rep = solution.accountsMerge(accounts);
        assertEquals(3, rep.size());
        assertEquals(2, rep.get(0).size());
        assertEquals(2, rep.get(1).size());
        assertEquals(2, rep.get(2).size());
    }

    @Test
    public void testAccountMerge3() {
        accounts.add(Arrays.asList("name", "email1@mail.com", "email2@mail.com"));
        accounts.add(Arrays.asList("name", "email3@mail.com", "email4@mail.com"));
        accounts.add(Arrays.asList("name", "email2@mail.com", "email3@mail.com"));
        List<List<String>> rep = solution.accountsMerge(accounts);
        assertEquals(1, rep.size());
        assertEquals(5, rep.get(0).size());
    }
}
