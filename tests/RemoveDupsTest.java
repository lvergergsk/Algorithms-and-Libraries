import org.junit.Test;

public class RemoveDupsTest {

    @Test
    public void removeDups() {
        RemoveDups removeDups = new RemoveDups();
        SimpleDoubleLinkedListNode<Integer> root = new SimpleDoubleLinkedListNode<>(0);
        SimpleDoubleLinkedListNode<Integer> node3 = new SimpleDoubleLinkedListNode<>(3);
        SimpleDoubleLinkedListNode<Integer> node3Dup = new SimpleDoubleLinkedListNode<>(3);
        SimpleDoubleLinkedListNode<Integer> node5 = new SimpleDoubleLinkedListNode<>(5);
        root.append(node3);
        node3.append(node5);
        node5.append(node3Dup);
        removeDups.removeDups(root);
        SimpleDoubleLinkedListNode<Integer> currentNode = root;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode=currentNode.next;
        }
        System.out.println();
    }
}