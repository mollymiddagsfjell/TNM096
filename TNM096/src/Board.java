import java.util.*;

public class Board {
    /*private Node board;
    int totalCost;
    private Boards parent;

    public Boards(int[] boardSetup) {
        board = new Node(boardSetup);
        totalCost = 0;
        parent = null;
    }

    public Boards(Node b) {
        board = b;
        totalCost = 0;
        parent = null;
    }

    public Boards(Boards prev, Node b, int g, int h) {
        parent = prev;
        board = b;
        totalCost = g + h;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public Node getBoard() {
        return board;
    }

    public Boards getParent() {
        return parent;
    }*/

        private int[][] tiles;
        private int N;

        // construct a board from an N-by-N array of tiles
        public Board(int[][] tiles) {
            this.tiles = tiles;
            N = tiles.length;
        }

        // return sum of Manhattan distances between blocks and goal
        public int manhattanDistance() {
            int theDistance = 0;
            int expected = 0;
            Board finalState = getFinalState();

            for (int row = 0; row < tiles.length; row++) {
                for (int col = 0; col < tiles[row].length; col++) {

                    int value = tiles[row][col];
                    expected++;
                    if (value != 0 && value != expected) {
                        // Manhattan distance is the sum of the absolute values of
                        // the horizontal and the vertical distance
                        theDistance += Math.abs(row
                                - getRow(finalState.tiles, value))
                                + Math.abs(col
                                - getCol(finalState.tiles, value));
                    }
                }
            }

            return theDistance;
        }

        // get a board in final state
        public Board getFinalState() {
            int[][] finalArray = new int[N][N];
            int value = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    value++;
                    if ((col + 1 == N) && (row + 1 == N)) {
                        finalArray[row][col] = 0;
                    } else {
                        finalArray[row][col] = value;
                    }

                }
            }

            Board finalState = new Board(finalArray);

            return finalState;
        }

        // helper to get the column of a value.
        public int getCol(int[][] a, int value) {
            for (int row = 0; row < a.length; row++) {
                for (int col = 0; col < a[row].length; col++) {
                    if (a[row][col] == value) {
                        return col;
                    }
                }
            }
            return -1;
        }

        // helper to get the row of a value.
        public int getRow(int[][] a, int value) {
            for (int row = 0; row < a.length; row++) {
                for (int col = 0; col < a[row].length; col++) {
                    if (a[row][col] == value) {
                        return row;
                    }
                }
            }
            return -1;
        }


    public void printBoard() {

        }
    }


