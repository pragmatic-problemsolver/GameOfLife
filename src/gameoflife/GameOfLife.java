package gameoflife;

public class GameOfLife{
    private static final int[][] POSSIBLE_DIRECTIONS = {
    {-1,-1}, {-1,0}, {-1, 1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

    /*
     * counts the number of live neightbors for a given cell
     */
     private int countLiveNeighbors(boolean[][] board, int row, int col) {
     int count = 0;
     int totalRows= board.length;
     int totalColumns = board[0].length;

     for (int[] direction : POSSIBLE_DIRECTIONS) {
        int newRow = row + direction[0];
        int newCol = col + direction[1];

        if (newRow >=0 && newRow < totalRows &&
            newCol >=0 && newCol < totalColumns &&
            board[newRow][newCol]) {
            count++;
            }
        }//end of if
        return count;
     }

     //computes next gen of the GOL grid
     public boolean[][] nextGeneration(boolean[][] board) {
     if (board == null ||
         board.length == 0 ||
         board[0].length == 0) { return board;
     }

         int totalRows = board.length;
         int totalColumns = board[0].length;

         boolean[][] next = new boolean[totalRows][totalColumns];

         for (int row =0; row < totalRows; row++) {
            for (int col =0; col < totalColumns; col++) {
                int liveNeighbors = countLiveNeighbors(board, row, col);

                if (board[row][col]) {
                    next[row][col] = (liveNeighbors == 2 || liveNeighbors == 3);
                    } else {
                        next[row][col] = (liveNeighbors == 3);
                        }
            }
         }
         return next;
     }//end of NG

     /*
      * util method to print the grid to console
      */
      public static void printBoardToConsole(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "1 " : "0 ");
            }
            System.out.println();
        }
        System.out.println();
      } //end of PB

      /*
       * main() to demonstrate the code
       */
        public static void main(String[] args) {
            GameOfLife gameInstance = new GameOfLife();

            boolean[][] board = {{false, false, false},
                                 {true, true, true},
                                 {false, false, false}};

            System.out.println("initial state:::");
            printBoardToConsole(board);

            board = gameInstance.nextGeneration(board);

            System.out.println("Next Generation:::");
            printBoardToConsole(board);
        }

}