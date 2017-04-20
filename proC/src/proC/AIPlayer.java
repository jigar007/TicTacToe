package proC;

import java.io.Serializable;

/**
 * Created by jamesMAC on 22/05/2016.
 */
public class AIPlayer extends Player implements Serializable {

    /**
     *Return Automatic moves
     */
    public Move makeMove(char[][] gameBoard) {
        Move move = new Move();
        int row, column;
        for (row = 0; row < GameManager.boardRow; row++) {
            for (column = 0; column < GameManager.boardCol; column++) {
                if (gameBoard[row][column] == '\u0000') {
                    move.setRow(row);
                    move.setCol(column);
                    return move;
                }
            }
        }
        return null;
    }

//    public AIPlayer(int PlayerType){
//        super(PlayerType);
//    }


//    public Move makeMove(char[][]gameBoard, char aiSymbol, char humanSymbol){
//        Move mv=new Move();
//        int valueBoard[][]=new int[3][3];
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                valueBoard[i][j]=-1;//initialization every value as -1 which mean this cell has been occupied
//            }
//        }
//        GameManager gm=new GameManager();
//        int biggestValue=0;
//        int row=0;
//        int standbyRow=0;
//        int column=0;
//        int standbyColumn=0;
//        boolean firstValueEqualZero=true;
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                int value=0;
//                if(gameBoard[i*2][j*2]==' '){
//                    gameBoard[i*2][j*2]=aiSymbol;
//                    int state=gm.getGameState(gameBoard);
//                    if(aiSymbol=='O'&&state==0){
//                        value=10000;////////////magic number
//                        gameBoard[i*2][j*2]=' ';
//                    }else if(aiSymbol=='X'&&state==1){
//                        value=10000;
//                        gameBoard[i*2][j*2]=' ';
//                    }else if(state==3){
//                        value=500;
//                        gameBoard[i*2][j*2]=' ';
//                    }else if(state==2) {
//                        gameBoard[i*2][j*2]=' ';
//                        int returnValue=opponent(gameBoard,humanSymbol,i,j);
//                        if(returnValue>value){
//                            value=returnValue;
//                        }else{
//                            value=0;
//                        }
//                    }
//                    valueBoard[i][j]=value;
//                }
//            }
//        }
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                if(valueBoard[i][j]>biggestValue){
//                    biggestValue=valueBoard[i][j];
//                    row=i;
//                    column=j;
//                }else if(valueBoard[i][j]==0&&firstValueEqualZero){
//                    standbyRow=i;
//                    standbyColumn=j;
//                    firstValueEqualZero=false;
//                }
//            }
//            if(i==2&&biggestValue==0&&valueBoard[1][1]==0){
//                row=1;
//                column=1;
//            }else if(i==2&&biggestValue==0&&valueBoard[1][1]!=0) {
//                row=standbyRow;
//                column=standbyColumn;
//            }
//        }
//        mv.setRow(row);
//        mv.setCol(column);
//        return mv;
//    }
//
//    public int opponent(char[][]gameBoard, char opponentSymbol,int row, int column){
//        GameManager gm=new GameManager();
//        int value=0;
//        gameBoard[row*2][column*2]=opponentSymbol;
//        int state= gm.getGameState(gameBoard);
//        if(opponentSymbol=='O'&&state==0){
//            value=1000;
//            gameBoard[row*2][column*2]=' ';
//            return value;
//        }else if(opponentSymbol=='X'&&state==1){
//            value=1000;
//            gameBoard[row*2][column*2]=' ';
//            return value;
//        }else if(state==3){
//            value=500;
//            gameBoard[row*2][column*2]=' ';
//            return value;
//        }else if(state==2){
//            value=0;
//            gameBoard[row*2][column*2]=' ';
//            return value;
//        }
//        return 0;
//    }


//    /** Minimax (recursive) at level of depth for maximizing or minimizing player
//     with alpha-beta cut-off. Return int[3] of {score, row, col}  */
//    private int[] minimax(int depth, Seed player, int alpha, int beta) {
//        // Generate possible next moves in a list of int[2] of {row, col}.
//        List<int[]> nextMoves = generateMoves();
//
//        // mySeed is maximizing; while oppSeed is minimizing
//        int score;
//        int bestRow = -1;
//        int bestCol = -1;
//
//        if (nextMoves.isEmpty() || depth == 0) {
//            // Gameover or depth reached, evaluate score
//            score = evaluate();
//            return new int[] {score, bestRow, bestCol};
//        } else {
//            for (int[] move : nextMoves) {
//                // try this move for the current "player"
//                cells[move[0]][move[1]].content = player;
//                if (player == mySeed) {  // mySeed (computer) is maximizing player
//                    score = minimax(depth - 1, oppSeed, alpha, beta)[0];
//                    if (score > alpha) {
//                        alpha = score;
//                        bestRow = move[0];
//                        bestCol = move[1];
//                    }
//                } else {  // oppSeed is minimizing player
//                    score = minimax(depth - 1, mySeed, alpha, beta)[0];
//                    if (score < beta) {
//                        beta = score;
//                        bestRow = move[0];
//                        bestCol = move[1];
//                    }
//                }
//                // undo move
//                cells[move[0]][move[1]].content = Seed.EMPTY;
//                // cut-off
//                if (alpha >= beta) break;
//            }
//            return new int[] {(player == mySeed) ? alpha : beta, bestRow, bestCol};
//        }
//
//}
}
