package proC;

public class GameManager {
    // Name of constants used to represent the various states of the game		
    public static final int PLAYING = 1; //2
    public static final int DRAW = 2;  //3
    public static final int CROSS_WON = 3; // 1
    public static final int NOUGHT_WON = 4; // 0
    public static final int boardRow = 3;
    public static final int boardCol = 3;
    public static final int zero=0;

    private String player1, player2;
    private char[][] board = new char[boardRow][boardCol];  // game board 3*3

    PlayerManager pm = new PlayerManager();

    /**
     *Entry method for GameManager class
     */
    public void playGame(Player player1obj, Player player2obj) {
        player1 = player1obj.getGivenName();
        player2 = player2obj.getGivenName();
        player1obj.increaseGamePlay();
        player2obj.increaseGamePlay();

        Move move = new Move();
        int gamestate = PLAYING;          // start playing game
        char currentPlayer = 'O';         // Naught plays first

        printGrid(); //prints empty game board

        while (gamestate == PLAYING) {  // repeat until game state is changed
            if (currentPlayer == 'O') {
                System.out.print(player1 + "'s move:\n");
                move = player1obj.makeMove(board);
            } else {
                System.out.print(player2 + "'s move:\n");
                move = player2obj.makeMove(board);
            }
            //  take next input move
            int row = move.getRow();
            int col = move.getCol();

            if (row < boardRow && col < boardCol && row >= zero && col >= zero ) {
                if (board[row][col] == '\u0000') {
                    board[row][col] = currentPlayer;  // include new mov

                    printGrid();    //  prints updated game board

                    gamestate = getGameState(row, col, currentPlayer);

                    if (gamestate == NOUGHT_WON) { //increase winning counter
                        player1obj.increaseWinner();
                    } else if (gamestate == CROSS_WON) { //increase winning counter
                        player2obj.increaseWinner();
                    } else if (gamestate == DRAW) { // increase game counter
                        player1obj.increaseDraw();
                        player2obj.increaseDraw();
                    }

                    if (currentPlayer == 'O') {   // Switch player
                        currentPlayer = 'X';
                    } else {
                        currentPlayer = 'O';
                    }

                } else {
                    System.out.println("Invalid move. The cell has been occupied.");
                }

            } else {
                System.out.println("Invalid move. You must place at a cell within {0,1,2} {0,1,2}.");
            }

        }
    }

    /**
     * Returns if player is win the game,draw or game still continue
     */
    public int getGameState(int newRow, int newCol, char OorX) {
        if (board[newRow][0] == OorX           // 3 OorX in same row
                && board[newRow][1] == OorX
                && board[newRow][2] == OorX
                || board[0][newCol] == OorX        // 3 OorX in same column
                && board[1][newCol] == OorX
                && board[2][newCol] == OorX
                || newRow == newCol            // 3 OorX in the diagonal
                && board[0][0] == OorX
                && board[1][1] == OorX
                && board[2][2] == OorX
                || newRow + newCol == 2        // 3 OorX in opposite diagonal
                && board[0][2] == OorX
                && board[1][1] == OorX
                && board[2][0] == OorX) {
            if (OorX == 'O') {
                System.out.println("Game over. " + player1 + " won!");
                return NOUGHT_WON;
            } else {
                System.out.println("Game over. " + player2 + " won!");
                return CROSS_WON;
            }
        } else {
            for (int row = 0; row < boardRow; row++) {
                for (int col = 0; col < boardCol; col++) {
                    if (board[row][col] == '\u0000') {  // "\u0000" used for checking empty cell
                        return PLAYING;  // an empty cell found game can continue
                    }
                }
            }
        }
        System.out.println("Game over  It was a DRAW!");
        return DRAW;
    }

    /**
     * Print game board
     */
    public void printGrid() {
        for (int row = 0; row < boardRow; ++row) {
            for (int col = 0; col < boardCol; ++col) {
                if (board[row][col] == 'X') {
                    System.out.print("X");
                } else if (board[row][col] == 'O') {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
                if (col < boardCol - 1) {
                    System.out.print("|");   // print vertical partition
                }
            }
            System.out.println(); //prints next row of board in to next line
            if (row < boardRow - 1) {
                System.out.println("-----"); // print horizontal partition
            }
        }
    }
}
