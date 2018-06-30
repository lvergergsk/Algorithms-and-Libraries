package leetcode.insertion_sort_list_0147;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;
    ListNode input1;

    @Before
    public void before() {
        solution = new Solution();
        input1 = new ListNode(4);
        input1.next = new ListNode(3);
        input1.next.next = new ListNode(5);
        input1.next.next.next = new ListNode(1);
        input1.next.next.next.next = new ListNode(6);
    }

    @Test
    public void insertionSortList() {
        ListNode rep = solution.insertionSortList(input1);
        assertEquals(1, rep.val);
        assertEquals(3, rep.next.val);
        assertEquals(4, rep.next.next.val);
        assertEquals(5, rep.next.next.next.val);
        assertEquals(6, rep.next.next.next.next.val);
    }
}