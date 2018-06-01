import java.util.*;

public class Tree<T> {
    private static final boolean DEV_MODE = true;

    TreeNode<T> root;
    HashSet<TreeNode<T>> treeNodes;

    Tree(T data) {
        treeNodes = new HashSet<>();
        root = new TreeNode<>();
        root.setData(data);
        treeNodes.add(root);
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(1);
        tree.getRoot().addChild(2);
        tree.getRoot().addChild(3);
        tree.getRoot().getChildAt(0).addChild(4);
        tree.getRoot().getChildAt(0).addChild(5);
        tree.getRoot().getChildAt(0).addChild(6);
        tree.preorder(tree.getRoot());
        tree.postOrderIterative(tree.getRoot());
    }

    ArrayList<TreeNode<T>> preorder(TreeNode<T> node) {
        ArrayList<TreeNode<T>> list = new ArrayList<>();

        if (node == null) {
            return list;
        }

        Stack<TreeNode<T>> FILO = new Stack<>();
        FILO.push(root);

        while (FILO.empty() == false) {
            if (DEV_MODE) {
                System.out.print("Pre-order, Stack: ");
                Iterator<TreeNode<T>> iter = FILO.iterator();
                while (iter.hasNext()) {
                    System.out.print(iter.next().data + " ");
                }
                System.out.println();
            }
            // Pop the top item from stack and print it
            TreeNode current = FILO.peek();
            list.add(current);
            FILO.pop();

            for (int i = current.getChildCount() - 1; i >= 0; i--) {
                FILO.push(current.getChildAt(i));
            }
        }

        if (DEV_MODE) {
            System.out.print("Pre-order, Result: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).data + " ");
            }
            System.out.println();
        }

        return list;
    }

    ArrayList<TreeNode<T>> postOrderIterative(TreeNode<T> node) {
        Stack<TreeNode<T>> FILO = new Stack<>();
        ArrayList<TreeNode<T>> list = new ArrayList<>();
        if (node == null)
            return list;

        FILO.push(node);
        TreeNode previous = null;

        while (!FILO.isEmpty()) {
            if (DEV_MODE) {
                System.out.print("Post-order, Stack: ");
                for (TreeNode<T> aFILO : FILO) {
                    System.out.print(aFILO.data + " ");
                }
                System.out.println();
            }
            TreeNode current = FILO.peek();

            if (previous == null || current.getParent() == previous) {
                if (current.isLeaf()) {
                    FILO.pop();
                    list.add(current);
                } else {
                    FILO.push(current.getChildAt(0));
                }
            } else {
                for (int i = 0; i < current.getChildCount(); i++) {
                    if (current.getChildAt(i) == previous) {
                        if ((i + 1) < current.getChildCount()) {
                            FILO.push(current.getChildAt(i + 1));
                        } else {
                            FILO.pop();
                            list.add(current);
                        }
                    }
                }
            }
            previous = current;
        }

        if (DEV_MODE) {
            System.out.print("Post-order, Result: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).data + " ");
            }
            System.out.println();
        }
        return list;
    }


    public TreeNode<T> getRoot() {
        return root;
    }

    class TreeNode<T> {
        T data;
        ArrayList<TreeNode<T>> children;
        TreeNode parent;

        TreeNode() {
            this.children = new ArrayList<>();
        }

        public void addChild(T data) {
            TreeNode<T> treeNode = new TreeNode<>();
            treeNode.setData(data);
            treeNode.setParent(this);
            this.children.add(treeNode);
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<T> getChildAt(int i) {
            return children.get(i);
        }

        public int getChildCount() {
            return children.size();
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public int getIndex(TreeNode treeNode) {
//            TODO
            return 0;
        }

        public boolean getAllowsChildren() {
//            TODO
            return false;
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }

        public Enumeration children() {
            return Collections.enumeration(children);
        }
    }
}
