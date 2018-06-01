package leetcode.merge_k_sorted_lists_0023;


import java.util.ArrayList;
//import java.util.logging.Logger;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


class Solution {
//    Logger LOGGER = Logger.getLogger(Solution.class.getName());

    ListNode merge2Lists(ListNode list1, ListNode list2) {
//        O(N)
//        Handle null cases;
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;

        ListNode res, ptr0, ptr1, ptr2;

//        Initialize:
        ptr1 = list1;
        ptr2 = list2;
        if (ptr1.val < ptr2.val) {
            ptr0 = ptr1;
            res = ptr0;
            ptr1 = ptr1.next;
        } else {
            ptr0 = ptr2;
            res = ptr0;
            ptr2 = ptr2.next;
        }


//        Merge:
        while (true) {
//            LOGGER.info("\nptr0 = " + ptr0 + "\nptr1.value = " + ptr1 + "\nptr2 = " + ptr2);

            if (ptr1 == null) {
                ptr0.next = ptr2;
                break;
            } else if (ptr2 == null) {
                ptr0.next = ptr1;
                break;
            } else {
                if (ptr1.val < ptr2.val) {
                    ptr0.next = ptr1;
                    ptr0 = ptr0.next;
                    ptr1 = ptr1.next;
                } else {
                    ptr0.next = ptr2;
                    ptr0 = ptr0.next;
                    ptr2 = ptr2.next;
                }
            }

        }

        return res;
    }

    public ListNode mergeKLists(ListNode[] lists) {
//        O(log(N))*O(merge2Lists)
        if (lists.length==0) return null;

        while (lists.length!=1){
            ArrayList<ListNode> newLists=new ArrayList<>();
            for (int i=0;i<lists.length;i+=2){
                if (i==lists.length-1){
                    newLists.add(lists[i]);
                    continue;
                }
                newLists.add(merge2Lists(lists[i],lists[i+1]));
            }
            lists=newLists.toArray(new ListNode[newLists.size()]);
        }

        return lists[0];
    }
}