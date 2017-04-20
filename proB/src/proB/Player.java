package proB;
public class Player extends Object {
    private String userName;
    private String familyName;
    private String givenName;
    private int gamePlayed;
    private int gameWon;
    private int gameDraw;

    Player() {
        gamePlayed = 0;
        gameWon = 0;
        gameDraw = 0;
    }

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

    public void increaseGameplay() {
        this.gamePlayed++;
    }

}
