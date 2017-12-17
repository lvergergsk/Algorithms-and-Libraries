import java.util.LinkedList;
import java.util.Scanner;

class DijkstraGraph {

    private static final boolean DEV_MODE = false;
    private static final boolean VERBOSE = false;

    private int[][] edges;
    private int numOfNode;
    private LinkedList<Integer> bfsStack;

    public DijkstraGraph(int numOfNode) {
        this.numOfNode = numOfNode;
        bfsStack = new LinkedList<>();
        this.edges = new int[this.numOfNode][this.numOfNode];
        for (int f0 = 0; f0 < this.numOfNode; f0++)
            for (int f1 = 0; f1 < this.numOfNode; f1++)
                edges[f0][f1] = Integer.MAX_VALUE;

        if (DEV_MODE) System.out.println("numOfNode = " + this.numOfNode);
    }

    public void setEdges(int x, int y, int r) {
        if (DEV_MODE && VERBOSE) System.out.println("INSERT: " + x + " -> " + y + ": " + r);
        if (this.edges[x][y] > r) {
            this.edges[x][y] = r;
        }
        if (this.edges[y][x] > r) {
            this.edges[y][x] = r;
        }
    }

    public int[] shortestDistance(int start) {
        if (DEV_MODE && VERBOSE) {
            for (int[] f1 : this.edges) {
                for (int f2 : f1) {
                    if (f2 == Integer.MAX_VALUE) {
                        System.out.print("--- ");
                    } else {
                        System.out.print(String.format("%03d", f2) + " ");
                    }
                }
                System.out.print("\n");
            }
        }


        // Boolean default is false in java.
        boolean[] visited = new boolean[this.numOfNode];
        int currentNode;

        // Prepare return value container
        int[] distance = new int[this.numOfNode];
        for (int f1 = 0; f1 < numOfNode; f1++) {
            distance[f1] = Integer.MAX_VALUE;
        }

        // set start node distance to 0,
        distance[start] = 0;
        bfsStack.addLast(start);

        // for all the rest nodes
        while (!bfsStack.isEmpty()) {
            if (DEV_MODE && VERBOSE) {
                for (int f2 : bfsStack) {
                    System.out.print(f2 + " ");
                }
                System.out.println();
            }
            currentNode = bfsStack.removeFirst();
            if (DEV_MODE) System.out.println("CURRENT NODE = " + currentNode);
            // update distance for neighbours.
            for (int f1 = 0; f1 < numOfNode; f1++) {
                int edgeLength = edges[currentNode][f1];
                if (edgeLength != Integer.MAX_VALUE) {
                    if (!visited[f1]) {
                        bfsStack.addLast(f1);
                    }

                    if (distance[currentNode] + edgeLength < distance[f1]) {
                        if (DEV_MODE && VERBOSE)
                            System.out.println("UPDATE: distance[" + f1 + "] = " +
                                    "distance[" + currentNode + "] + " + "edges[" + currentNode + "][" + f1 + "] = " +
                                    distance[currentNode] + " + " + edges[currentNode][f1] + " = " +
                                    (distance[currentNode] + edgeLength));
                        distance[f1] = distance[currentNode] + edgeLength;
                    }
                }

            }
            // mark current node to visited.
            visited[currentNode] = true;

            if (DEV_MODE) {
                for (int f1 : distance) {
                    if (f1 != Integer.MAX_VALUE)
                        System.out.print(String.format("%03d", f1) + " ");
                    else
                        System.out.print("--- ");
                }
                System.out.println();
                System.out.println("---------------------------------------");
            }
        }
        return distance;
    }

}

public class Solution {

    public static void main(String[] args) {
        // INPUT:
        // # of test case
        // # of node, # of edge
        // (node 1, node 2, length) * # of edge


        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int f0 = 0; f0 < t; f0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            DijkstraGraph dijkstraGraph = new DijkstraGraph(n);

            // Configure edges.
            for (int f1 = 0; f1 < m; f1++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int r = in.nextInt();
                dijkstraGraph.setEdges(x - 1, y - 1, r);
            }
            int s = in.nextInt();
            int[] ans = dijkstraGraph.shortestDistance(s - 1);

            for (int f1 = 0; f1 < ans.length; f1++) {
                if (ans[f1] != Integer.MAX_VALUE && ans[f1] != 0) {
                    System.out.print(ans[f1]);
                } else if (ans[f1] != 0) {
                    System.out.print("-1");
                }
                if (f1 != ans.length - 1 && ans[f1] != 0) {
                    System.out.print(" ");
                } else if (ans[f1] != 0) {
                    System.out.print("\n");
                }
            }
        }
    }
}
