# Body
"""
 Get Node data of the Nth Node from the end.
 head could be None as well for empty list
 Node is defined as

 class Node(object):

   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node

 return back the node data of the linked list in the below method.
"""

def GetNode(head, position):
    values = []
    current_node = head
    values.append(current_node.data)
    while current_node.next:
        current_node = current_node.next
        values.append(current_node.data)
    n = len(values) - 1 - position
    return values[n]
