package leetcode.insertion_sort_list_0147;

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode root = head;

        ListNode current = head.next;
        ListNode beforeCurrent = head;

        while (current != null) {
            if (current.val >= beforeCurrent.val) {
                beforeCurrent = current;
                current = current.next;
                continue;
            } else {
                if (root.val > current.val) {
                    beforeCurrent.next = current.next;
                    current.next = root;
                    root = current;
                    current = beforeCurrent.next;
                    continue;
                }

//                finding the first node with val greater or equal to val of current.
                ListNode searchBy = root;
                while (searchBy.next.val < current.val) {
                    searchBy = searchBy.next;
                }

                beforeCurrent.next = current.next;
                current.next = searchBy.next;
                searchBy.next = current;
                current = beforeCurrent.next;
            }
        }
        return root;
    }

}