package sub;

public class Ranking {
    private String userName;
    private double winRatio;
    private double drawRatio;
    private int gamePlayed;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(double winRatio) {
        this.winRatio = winRatio;
    }

    public double getDrawRatio() {
        return drawRatio;
    }

    public void setDrawRatio(double drawRatio) {
        this.drawRatio = drawRatio;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

}
