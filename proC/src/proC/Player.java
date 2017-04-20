package proC;

import java.io.Serializable;

/**
 * Created by jamesMAC on 22/05/2016.
 */
public abstract class Player implements Serializable {

    private String userName;
    private String familyName;
    private String givenName;
    private int gamePlayed;
    private int gameWon;
    private int gameDraw;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    public int getGameWon() {
        return gameWon;
    }

    public void setGameWon(int gameWon) {
        this.gameWon = gameWon;
    }

    public int getGameDraw() {
        return gameDraw;
    }

    public void setGameDraw(int gameDraw) {
        this.gameDraw = gameDraw;
    }

    public void increaseWinner() {
        this.gameWon++;
    }

    public void increaseDraw() {
        this.gameDraw++;
    }

    public void increaseGamePlay() {
        this.gamePlayed++;
    }

    abstract Move makeMove(char[][] gameBoard);


//    protected Move mySeed;    // computer's seed
//    protected Move oppSeed;   // opponent's seed

    /** Constructor with reference to game board */
//    public AIPlayer1(Board[][] board) {
//        cells = board.cells;
//    }
//
//    /** Set/change the seed used by computer and opponent */
//    public void setSeed(Move seed) {
//        this.mySeed = seed;
//        oppSeed = (mySeed == Move.CROSS) ? Seed.NOUGHT : Seed.CROSS;
//    }


}
