// Remove Dups: Write code to remove duplicates from an unsorted linked list.
// How would you solve this problem if a temporary buffer is not allowed?

import java.util.HashSet;

class SimpleDoubleLinkedListNode<T> {
    final T data;
    SimpleDoubleLinkedListNode<T> next;
    SimpleDoubleLinkedListNode<T> previous;

    SimpleDoubleLinkedListNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        T previousData = previous == null ? null : previous.data;
        T nextData = next == null ? null : next.data;
        return String.format("Previous: %s, Data: %s, next: %s", previousData, data.toString(), nextData);
    }

    void append(SimpleDoubleLinkedListNode<T> node) {
        this.next = node;
        if (node != null)
            node.previous = this;
    }
}

public class RemoveDups {
    private static final boolean DEV_MODE = true;

    SimpleDoubleLinkedListNode<Integer> removeDups(SimpleDoubleLinkedListNode<Integer> root) {
        SimpleDoubleLinkedListNode<Integer> currentNode = root;
        HashSet<Integer> buffer = new HashSet<>();
        while (currentNode != null) {
            if (DEV_MODE)
                System.out.println(currentNode.toString());
            if (buffer.contains(currentNode.data))
                if (currentNode.previous == null)
                    root = currentNode.next;
                else
                    currentNode.previous.append(currentNode.next);
            buffer.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return root;
    }

}
