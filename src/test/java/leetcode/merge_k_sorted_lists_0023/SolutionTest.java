package leetcode.merge_k_sorted_lists_0023;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private void printList(ListNode root){
        while (root!=null){
            System.out.print(root.val+", ");
            root=root.next;
        }
        System.out.println();
    }

    @Test
    public void merge2Lists() {
//        1,4,9
//        2,9

        ListNode listRoot1=new ListNode(1);
        listRoot1.next=new ListNode(4);
        listRoot1.next.next=new ListNode(9);
        printList(listRoot1);

        ListNode listRoot2= new ListNode(2);
        listRoot2.next=new ListNode(9);
        printList(listRoot2);

        Solution solution=new Solution();
        ListNode mergedRoot= solution.merge2Lists(listRoot1,listRoot2);
        printList(mergedRoot);

    }

    @Test
    public void mergeKLists() {
        ListNode listRoot1=new ListNode(1);
        listRoot1.next=new ListNode(4);
        listRoot1.next.next=new ListNode(9);
        printList(listRoot1);

        ListNode listRoot2= new ListNode(2);
        listRoot2.next=new ListNode(9);
        printList(listRoot2);

        ListNode listRoot3=new ListNode(2);
        listRoot3.next=new ListNode(6);
        listRoot3.next.next=new ListNode(12);
        listRoot3.next.next.next=new ListNode(21);
        printList(listRoot3);

        Solution solution=new Solution();
        ListNode mergedRoot= solution.mergeKLists(new ListNode[]{listRoot1,listRoot2,listRoot3});
        printList(mergedRoot);

    }
}