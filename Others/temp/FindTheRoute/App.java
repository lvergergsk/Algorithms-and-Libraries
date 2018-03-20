import java.util.ArrayList;
import java.util.Stack;

class FindTheRoute {
    private static final boolean DEV_MODE = true;
    private int numOfRows;
    private int numOfColumns;
    private boolean[] visited;

    FindTheRoute(int numOfRows, int numOfColumns) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.visited = new boolean[numOfRows * numOfColumns];
    }

    private boolean shortcut(Integer[] availableNextStep) {
        if (availableNextStep.length == 2) {
            Coordinate node0 = posToCoordinate(availableNextStep[0]);
            Coordinate node1 = posToCoordinate(availableNextStep[1]);
            return Math.abs(node0.rowNumber - node1.rowNumber) == 2 || Math.abs(node0.ColumnNumber - node1.ColumnNumber) == 2;
        }
        return false;
    }

    private Coordinate posToCoordinate(int pos) {
        int rowNum = pos / numOfColumns;
        int columnNum = pos - rowNum * numOfColumns;
        return new Coordinate(rowNum, columnNum);
    }

    private int coordinateToPos(Coordinate coordinate) {
        return (coordinate.rowNumber * numOfColumns + coordinate.ColumnNumber);
    }

    private Integer[] adjacentPos(int pos) {
        Coordinate coordinate = posToCoordinate(pos);

        boolean onTop = (coordinate.rowNumber == 0);
        boolean onBottom = (coordinate.rowNumber == (numOfRows - 1));
        boolean onLeft = (coordinate.ColumnNumber == 0);
        boolean onRight = (coordinate.ColumnNumber == (numOfColumns - 1));

        ArrayList<Integer> res = new ArrayList<>();
        if (!onTop) res.add(coordinateToPos(new Coordinate(coordinate.rowNumber - 1, coordinate.ColumnNumber)));
        if (!onBottom) res.add(coordinateToPos(new Coordinate(coordinate.rowNumber + 1, coordinate.ColumnNumber)));
        if (!onLeft) res.add(coordinateToPos(new Coordinate(coordinate.rowNumber, coordinate.ColumnNumber - 1)));
        if (!onRight) res.add(coordinateToPos(new Coordinate(coordinate.rowNumber, coordinate.ColumnNumber + 1)));

        return res.toArray(new Integer[res.size()]);
    }

    private Integer[] availableNextStep(int pos) {
        Integer[] adj = adjacentPos(pos);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : adj) if (!visited[i]) res.add(i);
        return res.toArray(new Integer[res.size()]);
    }

    int traceBack() {
        int counter = 0;

        ArrayList<Integer> trace = new ArrayList<>();
        Stack<TraceNode> stack = new Stack<>();

//        start at (0,0):
        int start = 0;
        stack.push(new TraceNode(trace.size(), start));

//        start trace-back looping.
        while (!stack.empty()) {
            if (DEV_MODE) {
                System.out.print("Current Stack: ");
                for (TraceNode node : stack) {
                    System.out.print("(" + node.tracePos + ", " + node.nodePos + ") ");
                }
                System.out.println();
            }
            TraceNode currentNode = stack.pop();
            if (DEV_MODE) System.out.println("Popped. Current Position = " + currentNode.nodePos);

//            backward:
            while (currentNode.tracePos != trace.size()) {
                Integer nodePos = trace.remove(trace.size() - 1);
                visited[nodePos] = false;
            }

//            forward:
            trace.add(currentNode.nodePos);
            visited[currentNode.nodePos] = true;
            Integer[] availableNextStep = availableNextStep(currentNode.nodePos);
            if (availableNextStep.length == 0 || shortcut(availableNextStep)) {
//                enter here if we have no way to go or shortcut condition is fulfilled.
                if (DEV_MODE && shortcut(availableNextStep)) System.out.println("Shortcut!!");
                if (trace.size() == numOfRows * numOfColumns) {
                    counter++;
                    if (DEV_MODE) {
                        System.out.print("Trace: ");
                        for (Integer i : trace) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                        System.out.println("-------------------");
                    }
                }

            } else {
//                enter here if current nodePos is NOT a "dead end".
                for (Integer nextPos : availableNextStep) {
                    stack.push(new TraceNode(trace.size(), nextPos));
                }
            }

        }
        return counter;
    }

    class Coordinate {
        Integer rowNumber;
        Integer ColumnNumber;

        Coordinate(Integer rowNumber, Integer columnNumber) {
            this.rowNumber = rowNumber;
            ColumnNumber = columnNumber;
        }
    }

    class TraceNode {
        //        tracePos represent that this node is xth node in the entire trace.
        Integer tracePos;
        //        nodePos position in matrix (the given map).
        Integer nodePos;

        TraceNode(Integer tracePos, Integer nodePos) {
            this.tracePos = tracePos;
            this.nodePos = nodePos;
        }
    }
}


public class App {

    public static void main(String[] args) {
        FindTheRoute findTheRoute = new FindTheRoute(4,3);
        System.out.println(findTheRoute.traceBack());

//        FindTheRoute findTheRoute = new FindTheRoute(new Integer(args[0]), new Integer(args[1]));
//        System.out.println(findTheRoute.traceBack());
    }
}
