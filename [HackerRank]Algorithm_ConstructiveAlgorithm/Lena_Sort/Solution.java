import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class BinaryTree {
    public static final boolean DEV_MODE = false;

    class Node {
        private int data;
        private int depth;
        private Node left;
        private Node right;
        private Node parent;

        public Node() {
            this.depth = 0;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        //        getter
        public int getDepth() {
            return depth;
        }

        //        setter
        public void setLeft(Node left) {
            this.left = left;
            left.setParent(this);
            left.setDepth(this.depth + 1);
        }

        //        getter
        public Node getLeft() {
            return left;
        }

        //        setter
        public void setRight(Node right) {
            this.right = right;
            right.setParent(this);
            right.setDepth(this.depth + 1);
        }

        //        getter
        public Node getRight() {
            return right;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        //        getter
        public int getData() {
            return data;
        }

        //        setter
        public void setData(int data) {
            this.data = data;
        }
    }

    enum ConstructRule {
        LeftAligned
    }

    Node root;

    public BinaryTree(Integer[] structure, ConstructRule constructRule) {
        // have to check structure is correct. assume correct for now.
        Integer[] structureCopy = Arrays.copyOf(structure, structure.length);
        switch (constructRule) {
            case LeftAligned:
                if (structureCopy[0] > 0) {
                    root = new Node();
                    structureCopy[root.depth]--;
                    leftAlignedConstruct(structureCopy, this.root);
                }
                if (DEV_MODE) {
                    System.out.println("After Tree Construction:");
                    for (int i : structureCopy) System.out.print(i + " ");
                    System.out.println();
                }
                break;
        }
    }

    private void leftAlignedConstruct(Integer[] structure, Node root) {
        if (root.depth + 1 < structure.length && structure[root.depth + 1] > 0) {
            structure[root.depth + 1]--;
            Node left = new Node();
            root.setLeft(left);
            leftAlignedConstruct(structure, left);
        }

        if (root.depth + 1 < structure.length && structure[root.depth + 1] > 0) {
            structure[root.depth + 1]--;
            Node right = new Node();
            root.setRight(right);
            leftAlignedConstruct(structure, right);
        }
    }
}


class Solution {
    public static final boolean DEV_MODE = false;
    static int counter = 1;

    static void inOrderAssign(BinaryTree.Node node) {
        if (node.getLeft() != null) inOrderAssign(node.getLeft());
        node.setData(counter++);
        if (node.getRight() != null) inOrderAssign(node.getRight());
    }

    static void preOrderPrint(BinaryTree.Node node) {
        System.out.print(node.getData() + " ");
        if (node.getLeft() != null) preOrderPrint(node.getLeft());
        if (node.getRight() != null) preOrderPrint(node.getRight());
    }


    private static ArrayList<Integer> generateStructure(int len, int c) {
        int[] numOfNodes = new int[100000];
        // numOfComparison record required number of comparison of the tree.
        long numOfComparison = 0;
        // All layer above filledLayerPtr is full.
        int filledLayerPtr = 1;
        for (int i = 0; i < len; i++) {
            numOfNodes[i] = 1;
            numOfComparison += i;
        }


        if (DEV_MODE){
            if (!(len - 1 > filledLayerPtr && numOfComparison > c)) {
                System.out.println("i = " + (len - 1));
                System.out.println("filledLayerPtr = " + filledLayerPtr);
                System.out.println("numOfComparison = " + numOfComparison);
                System.out.println("c = " + c);
            }
        }
        // if ith layer is not a filled layer
        // and numOfComparison is greater than required number of comparison,
        // then continue
        for (int i = len - 1; i > filledLayerPtr && numOfComparison > c; i--) {
            long diff = numOfComparison - c;
            long maxReduceCurrentStep = i - filledLayerPtr;
            long reduce = diff < maxReduceCurrentStep ? diff : maxReduceCurrentStep;

            // Move node up.
            numOfNodes[i]--;
            numOfNodes[(int)(i - reduce)]++;
            numOfComparison -= reduce;

            // update filled layer if necessary
            if (numOfNodes[filledLayerPtr] == 2 * numOfNodes[filledLayerPtr - 1]) filledLayerPtr++;

            if (DEV_MODE) {
                if (!(i > filledLayerPtr && numOfComparison > c)) {
                    System.out.println("i = " + i);
                    System.out.println("filledLayerPtr = " + filledLayerPtr);
                    System.out.println("numOfComparison = " + numOfComparison);
                    System.out.println("c = " + c);
                }
            }
        }

        if (numOfComparison != c) return null;

        ArrayList<Integer> rep = new ArrayList<>();
        for (int i : numOfNodes) {
            if (i != 0) {
                rep.add(i);
            } else {
                break;
            }
        }


        if (DEV_MODE) {
            int count = 0;
            for (int i : rep) {
                count += i;
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("Totally " + count + " nodes.");
        }
        return rep;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int a0 = 0; a0 < q; a0++) {
            int len = in.nextInt();
            int c = in.nextInt();
            counter = 1;

            ArrayList<Integer> structure = generateStructure(len, c);
            if (structure == null) {
                System.out.println("-1");
                continue;
            }
            BinaryTree tree = new BinaryTree(structure.toArray(new Integer[structure.size()]), BinaryTree.ConstructRule.LeftAligned);
            inOrderAssign(tree.root);
            preOrderPrint(tree.root);
            System.out.println();
        }
    }
}
