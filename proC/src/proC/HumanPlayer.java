package proC;

import java.io.Serializable;

public class HumanPlayer extends Player implements Serializable {

    /**
     *Return move which taken by user
     */
    public Move makeMove(char[][] gameBoard) {

        Move move = new Move();
        int row = TicTacToe.keybord.nextInt();
        int col = TicTacToe.keybord.nextInt();
        move.setRow(row);
        move.setCol(col);

        return move;
    }
}
