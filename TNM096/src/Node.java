import java.util.*;
//import java.lang.System.*
//import java.lang.String.*
public class Node {
        private int notInPlace = 0;
        private int[] boardSetup;
        private final int[] goalBoard = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };


        public Node(int[] currentBoardSettup) {
            boardSetup = currentBoardSettup;
            setOutOfPlace();
        }

        public void setOutOfPlace() {
            for (int i = 0; i < boardSetup.length; i++) {
                if(boardSetup[i] != goalBoard[i]) {
                    notInPlace++;
                }
            }
        }

        public ArrayList<Node> makeMoves() {
            ArrayList<Node> moves = new ArrayList<Node>();

            //Need first position

            return moves;
        }



        public int getNotInPlace() {
            return notInPlace;
        }

        public int getZeroPosition() {
            int zeroPosition = -1;
            for (int i = 0; i < boardSetup.length; i++) {
                if (boardSetup[i] == 0)
                    zeroPosition = i;
            }
            return zeroPosition;
        }

        public boolean doneBoard() {
            if (Arrays.equals(boardSetup, goalBoard)) {
                return true;
            }
            return false;
        }

        public int[] getBoardSetup() {
            return boardSetup;
        }

        public int findCostMan() {
            return setManhattanDist();
        }

        public int setManhattanDist() {

            int count = 0;
            int expected = 0;
            Boards finalState = goalBoard();

            for (int row = 0; row < tiles.length; row++) {
                for (int col = 0; col < tiles[row].length; col++) {
                    int value = tiles[row][col];
                    expected++;
                    if (value != 0 && value != expected) {
                        count += Math.abs(row
                                - getRow(finalState.tiles, value))
                                + Math.abs(col
                                - getCol(finalState.tiles, value));
                    }
                }
            }
            return count;
            int index = -1;
            int manhattanDistance = 0;

            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    index++;
                    int val = (boardSetup[index] - 1);

                    if (val != -1) {
                        int h = val % 3;
                        int v = val / 3;

                        manhattanDistance += Math.abs(v - y) + Math.abs(h - x);
                    }
                }
            }

            return manhattanDistance;
        }

    }

