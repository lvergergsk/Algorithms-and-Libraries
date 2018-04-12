import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

// DFS using stack.
// No memorization because available grid is depend on the path to current position.

public class Q2 {

    private char[][] labyrinth;
    private Coordinate start;
    private boolean[][] visited;
    private int numOfRows;
    private int numOfColumns;

//    Constructor
    private Q2(int H, int W, char[][] labyrinth) {
        this.numOfRows = H;
        this.numOfColumns = W;
        this.labyrinth = labyrinth;
        this.visited = new boolean[numOfRows][numOfColumns];
        findStart();
    }

//    Driver
    public static void main(String[] args) {
        Q2 q2;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            in.nextLine();
            int H = in.nextInt();
            int W = in.nextInt();
            in.nextLine();

            char[][] labyrinth = new char[H][W];
            for (int j = 0; j < H; j++) {
                String line = in.nextLine();
                labyrinth[j] = line.toCharArray();
            }
            q2 = new Q2(H, W, labyrinth);
            System.out.println("Case #" + i + ": " + q2.DFS());
        }


    }

//    This method find the position of S
    private void findStart() {
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (labyrinth[i][j] == 'S') start = new Coordinate(i, j);
            }
        }
    }

//    This method return the number of ``dead end'' by performing DFS.
    private int DFS() {
        int count = 0;

        ArrayList<Coordinate> trace = new ArrayList<>();
        Stack<TraceNode> stack = new Stack<>();

        // Push the start position.
        stack.push(new TraceNode(trace.size(), start));

        while (!stack.isEmpty()) {
            TraceNode currentNode = stack.pop();

            // BackTracking
            while (currentNode.tracePos != trace.size()) {
                Coordinate nodePos = trace.remove(trace.size() - 1);
                visited[nodePos.rowNumber][nodePos.columnNumber] = false;
            }

            trace.add(currentNode.nodePos);
            visited[currentNode.nodePos.rowNumber][currentNode.nodePos.columnNumber] = true;
            Coordinate[] availableNextStep = availableNextStep(currentNode.nodePos);

            if (availableNextStep.length == 0) {
                count++;
            }
            for (Coordinate c : availableNextStep)
                stack.push(new TraceNode(trace.size(), c));
        }
        return count;
    }

//    This method return the coordinate of avaliable next step,
//    Grid of ``#'' and visited grid is not a decent ``next step''.
    private Coordinate[] availableNextStep(Coordinate pos) {
        Coordinate[] adj = adjacentPos(pos);
        ArrayList<Coordinate> res = new ArrayList<>();

        for (Coordinate c : adj)
            if (!visited[c.rowNumber][c.columnNumber] && labyrinth[c.rowNumber][c.columnNumber] != '#') res.add(c);
        return res.toArray(new Coordinate[res.size()]);
    }

//    This method return coordinate of adjacent grid.
//    Boundary condition is concerned.
    private Coordinate[] adjacentPos(Coordinate coordinate) {
        boolean onTop = (coordinate.rowNumber == 0);
        boolean onBottom = (coordinate.rowNumber == (numOfRows - 1));
        boolean onLeft = (coordinate.columnNumber == 0);
        boolean onRight = (coordinate.columnNumber == (numOfColumns - 1));

        ArrayList<Coordinate> res = new ArrayList<>();
        if (!onTop) res.add(new Coordinate(coordinate.rowNumber - 1, coordinate.columnNumber));
        if (!onBottom) res.add(new Coordinate(coordinate.rowNumber + 1, coordinate.columnNumber));
        if (!onLeft) res.add(new Coordinate(coordinate.rowNumber, coordinate.columnNumber - 1));
        if (!onRight) res.add(new Coordinate(coordinate.rowNumber, coordinate.columnNumber + 1));

        return res.toArray(new Coordinate[res.size()]);
    }

//    This class present pair of x-coordinate and y-coordinate.
    class Coordinate {
        Integer rowNumber;
        Integer columnNumber;

        Coordinate(Integer rowNumber, Integer columnNumber) {
            this.rowNumber = rowNumber;
            this.columnNumber = columnNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return Objects.equals(rowNumber, that.rowNumber) &&
                    Objects.equals(columnNumber, that.columnNumber);
        }

        @Override
        public int hashCode() {

            return Objects.hash(rowNumber, columnNumber);
        }
    }

//    This class represent element in stack.
//    I avoid using recursion in case it get too deep and cause stack overflow.
    class TraceNode {
        //        tracePos represent that this node is xth node in the entire trace.
        Integer tracePos;
        //        nodePos position in matrix (the given map).
        Coordinate nodePos;

        TraceNode(Integer tracePos, Coordinate nodePos) {
            this.tracePos = tracePos;
            this.nodePos = nodePos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TraceNode)) return false;
            TraceNode traceNode = (TraceNode) o;
            return Objects.equals(tracePos, traceNode.tracePos) &&
                    Objects.equals(nodePos, traceNode.nodePos);
        }

        @Override
        public int hashCode() {

            return Objects.hash(tracePos, nodePos);
        }
    }
}
