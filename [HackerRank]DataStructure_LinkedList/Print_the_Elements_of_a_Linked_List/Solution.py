def print_list(head):
    node = head
    while True:
        print(node.data)
        if node.next:
            node = node.next
        else:
            break
