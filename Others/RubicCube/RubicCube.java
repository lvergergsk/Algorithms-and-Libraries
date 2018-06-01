public class RubicCube {
    int[][][] facets;

//    facets:
//      4
//    0 1 2 3
//      5

//    0,0 0,1 0,2
//    1,0 1,1 1,2
//    2,0 2,1 2,2

    RubicCube() {
        facets = new int[][][]{
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
                {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}},
                {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}},
                {{4, 4, 4}, {4, 4, 4}, {4, 4, 4}},
                {{5, 5, 5}, {5, 5, 5}, {5, 5, 5}}};
    }

    RubicCube(int[][][] facets) {
//        TODO: ERROR HANDLING: check dimension here and num of color.
        this.facets = facets;
    }

    public static void main(String[] args) {
        RubicCube rubicCube = new RubicCube(new int[][][]{
                {{0, 4, 0}, {3, 0, 1}, {0, 5, 0}},
                {{1, 4, 1}, {0, 1, 2}, {1, 5, 1}},
                {{2, 4, 2}, {1, 2, 3}, {2, 5, 2}},
                {{3, 4, 3}, {2, 3, 0}, {3, 5, 3}},
                {{4, 3, 4}, {0, 4, 2}, {4, 1, 4}},
                {{5, 1, 5}, {0, 5, 2}, {5, 3, 5}}});
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.UP);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.REVUP);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.DOWN);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.REVDOWN);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.LEFT);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.REVLEFT);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.RIGHT);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.REVRIGHT);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.FACE);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.REVFACE);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.BACK);
        System.out.println(rubicCube.toString());
        rubicCube.rotate(Rotation.REVBACK);
        System.out.println(rubicCube.toString());
    }

    void rotateFacet(int[][] facet, boolean clockwise) {
//        TODO: ERROR HANDLING: check size.
//        if clockwise is true rotate to right, else to left.
//        1 1 1 1
//        1 2 2 1
//        1 2 2 1
//        1 1 1 1
//        Consider all squares one by one

        int dimension = facet.length;

        if (clockwise) {
//            clockwise
            for (int x = 0; x < dimension / 2; x++) {
                for (int y = x; y < dimension - x - 1; y++) {
//                    System.out.println("x = " + x + ", y = " + y);
                    int temp = facet[x][y];

                    facet[x][y] = facet[dimension - 1 - y][x];
                    facet[dimension - 1 - y][x] = facet[dimension - 1 - x][dimension - 1 - y];
                    facet[dimension - 1 - x][dimension - 1 - y] = facet[y][dimension - 1 - x];
                    facet[y][dimension - 1 - x] = temp;
                }
            }
        } else {
//            anti-clockwise
            for (int x = 0; x < dimension / 2; x++) {
                for (int y = x; y < dimension - x - 1; y++) {
//                    System.out.println("x = " + x + ", y = " + y);
                    int temp = facet[x][y];

                    facet[x][y] = facet[y][dimension - 1 - x];
                    facet[y][dimension - 1 - x] = facet[dimension - 1 - x][dimension - 1 - y];
                    facet[dimension - 1 - x][dimension - 1 - y] = facet[dimension - 1 - y][x];
                    facet[dimension - 1 - y][x] = temp;

                }
            }
        }
    }

    void rotate(Rotation rotation) {
        int[] temp = new int[3];
        switch (rotation) {
            case UP:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][0][i];
                    facets[0][0][i] = facets[1][0][i];
                    facets[1][0][i] = facets[2][0][i];
                    facets[2][0][i] = facets[3][0][i];
                    facets[3][0][i] = temp[i];
                }
                rotateFacet(facets[4], true);
                break;
            case REVUP:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][0][i];
                    facets[0][0][i] = facets[3][0][i];
                    facets[3][0][i] = facets[2][0][i];
                    facets[2][0][i] = facets[1][0][i];
                    facets[1][0][i] = temp[i];
                }
                rotateFacet(facets[4], false);
                break;
            case DOWN:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][2][i];
                    facets[0][2][i] = facets[1][2][i];
                    facets[1][2][i] = facets[2][2][i];
                    facets[2][2][i] = facets[3][2][i];
                    facets[3][2][i] = temp[i];
                }
                rotateFacet(facets[5], false);
                break;
            case REVDOWN:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][2][i];
                    facets[0][2][i] = facets[3][2][i];
                    facets[3][2][i] = facets[2][2][i];
                    facets[2][2][i] = facets[1][2][i];
                    facets[1][2][i] = temp[i];
                }
                rotateFacet(facets[5], true);
                break;
            case LEFT:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[1][i][0];
                    facets[1][i][0] = facets[4][i][0];
                    facets[4][i][0] = facets[3][i][0];
                    facets[3][i][0] = facets[5][i][0];
                    facets[5][i][0] = temp[i];
                }
                rotateFacet(facets[0], true);
                break;
            case REVLEFT:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[1][i][0];
                    facets[1][i][0] = facets[5][i][0];
                    facets[5][i][0] = facets[3][i][0];
                    facets[3][i][0] = facets[4][i][0];
                    facets[4][i][0] = temp[i];
                }
                rotateFacet(facets[0], false);
                break;
            case RIGHT:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[1][i][2];
                    facets[1][i][2] = facets[5][i][2];
                    facets[5][i][2] = facets[3][i][2];
                    facets[3][i][2] = facets[4][i][2];
                    facets[4][i][2] = temp[i];
                }
                rotateFacet(facets[2], true);
                break;
            case REVRIGHT:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[1][i][2];
                    facets[1][i][2] = facets[4][i][2];
                    facets[4][i][2] = facets[3][i][2];
                    facets[3][i][2] = facets[5][i][2];
                    facets[5][i][2] = temp[i];
                }
                rotateFacet(facets[2], false);
                break;
            case FACE:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][i][2];
                    facets[0][i][2] = facets[5][0][i];
                    facets[5][0][i] = facets[2][2 - i][0];
                    facets[2][2 - i][0] = facets[4][2][2 - i];
                    facets[4][2][2 - i] = temp[i];
                }
                rotateFacet(facets[1], true);
                break;
            case REVFACE:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][i][2];
                    facets[0][i][2] = facets[4][2][2 - i];
                    facets[4][2][2 - i] = facets[2][2 - i][0];
                    facets[2][2 - i][0] = facets[5][0][i];
                    facets[5][0][i] = temp[i];
                }
                rotateFacet(facets[1], false);
                break;
            case BACK:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][i][0];
                    facets[0][i][0] = facets[5][2][i];
                    facets[5][2][i] = facets[2][2 - i][2];
                    facets[2][2 - i][2] = facets[4][0][2 - i];
                    facets[4][0][2 - i] = temp[i];
                }
                rotateFacet(facets[3], false);
                break;
            case REVBACK:
                for (int i = 0; i < 3; i++) {
                    temp[i] = facets[0][i][0];
                    facets[0][i][0] = facets[4][0][2 - i];
                    facets[4][0][2 - i] = facets[2][2 - i][2];
                    facets[2][2 - i][2] = facets[5][2][i];
                    facets[5][2][i] = temp[i];
                }
                rotateFacet(facets[3], true);
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("" +
                        "        %d %d %d\n" +
                        "        %d %d %d\n" +
                        "        %d %d %d\n" +
                        "%d %d %d | %d %d %d | %d %d %d | %d %d %d\n" +
                        "%d %d %d | %d %d %d | %d %d %d | %d %d %d\n" +
                        "%d %d %d | %d %d %d | %d %d %d | %d %d %d\n" +
                        "        %d %d %d\n" +
                        "        %d %d %d\n" +
                        "        %d %d %d\n",
                facets[4][0][0], facets[4][0][1], facets[4][0][2],
                facets[4][1][0], facets[4][1][1], facets[4][1][2],
                facets[4][2][0], facets[4][2][1], facets[4][2][2],
                facets[0][0][0], facets[0][0][1], facets[0][0][2],
                facets[1][0][0], facets[1][0][1], facets[1][0][2],
                facets[2][0][0], facets[2][0][1], facets[2][0][2],
                facets[3][0][0], facets[3][0][1], facets[3][0][2],
                facets[0][1][0], facets[0][1][1], facets[0][1][2],
                facets[1][1][0], facets[1][1][1], facets[1][1][2],
                facets[2][1][0], facets[2][1][1], facets[2][1][2],
                facets[3][1][0], facets[3][1][1], facets[3][1][2],
                facets[0][2][0], facets[0][2][1], facets[0][2][2],
                facets[1][2][0], facets[1][2][1], facets[1][2][2],
                facets[2][2][0], facets[2][2][1], facets[2][2][2],
                facets[3][2][0], facets[3][2][1], facets[3][2][2],
                facets[5][0][0], facets[5][0][1], facets[5][0][2],
                facets[5][1][0], facets[5][1][1], facets[5][1][2],
                facets[5][2][0], facets[5][2][1], facets[5][2][2]
        );


    }

    enum Rotation {
        UP, DOWN, LEFT, RIGHT, FACE, BACK,
        REVUP, REVDOWN, REVLEFT, REVRIGHT, REVFACE, REVBACK
    }
}
