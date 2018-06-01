# # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    @staticmethod
    def get_carry_on(num):
        if num >= 10:
            return num - 10, 1
        else:
            return num, 0

    @staticmethod
    def next_digit(node, node1, node2):
        next_node = None
        next_node1 = None
        next_node2 = None
        if node is not None:
            next_node = node.next
        if node1 is not None:
            next_node1 = node1.next
        if node2 is not None:
            next_node2 = node2.next
        return next_node, next_node1, next_node2

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        node1 = l1
        node2 = l2

        n = node1.val + node2.val
        n, carry_on = self.get_carry_on(n)

        root = ListNode(n)
        node = root

        if node1 is not None:
            node1 = node1.next
        if node2 is not None:
            node2 = node2.next

        while True:
            if (node1 is not None) & (node2 is not None):
                n = node1.val + node2.val + carry_on
            elif node1 is not None:
                n = node1.val + carry_on
            elif node2 is not None:
                n = node2.val + carry_on
            elif carry_on != 0:
                n = carry_on
            else:
                break

            n, carry_on = self.get_carry_on(n)
            new_node = ListNode(n)
            node.next = new_node

            node, node1, node2 = self.next_digit(node, node1, node2)

        return root
