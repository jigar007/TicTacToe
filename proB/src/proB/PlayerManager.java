package proB;
import java.util.Arrays;

public class PlayerManager {

    public static final int MAX_PLAYER = 100;
    Player[] playerList = new Player[MAX_PLAYER];
    private static int objInPlayer = 0;

    Player player = new Player();

    /**
     * Checks user is exist in playerList Object array
     */
    public int checkUserName(String username) {
        for (int i = 0; i < objInPlayer; i++) {
            if (playerList[i] != null) {
                if (username.equals(playerList[i].getUserName())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Add new player to system
     */
    public void addPlayer(String userName, String familyName, String givenName) {
        Player player = new Player();
        if (checkUserName(userName) == -1) {
            player.setUserName(userName);
            player.setFamilyName(familyName);
            player.setGivenName(givenName);

            playerList[objInPlayer] = player;
            objInPlayer++;
        } else {
            System.out.println("The username has been used already.");
        }
    }

    /**
     * Remove supplied username of player from system
     */
    public void removePlayer(String userName) {
        int index = checkUserName(userName);
        if (index != -1) {

            while (index < objInPlayer) {
                playerList[index] = playerList[index + 1];
                index++;
            }
            objInPlayer--;

        } else {
            System.out.println("The player does not exist.");
        }
    }

    /**
     * Remove ALL players from system
     */
    public void removePlayer() {
        Arrays.fill(playerList, null);
    }

    /**
     * Edit player on username and set new family name and given name
     */
    public void editPlayer(String editName, String newFamilyName, String newGivenName) {
        if (checkUserName(editName) != -1) {
            playerList[checkUserName(editName)].setFamilyName(newFamilyName);
            playerList[checkUserName(editName)].setGivenName(newGivenName);
        } else {
            System.out.println("The player does not exist.");
        }
    }

    /**
     * Reset statistics of supplied player name from system
     */
    public void resetStates(String resetName) {
        if (checkUserName(resetName) != -1) {
            playerList[checkUserName(resetName)].setGamePlayed(0);
            playerList[checkUserName(resetName)].setGameWon(0);
            playerList[checkUserName(resetName)].setGameDraw(0);
        } else {
            System.out.println("The player does not exist.");
        }
    }

    /**
     * Reset statistics for ALL players from system
     */
    public void resetStates() {

        for (int i = 0; i < objInPlayer; i++) {
            if (playerList[i] != null) {
                playerList[i].setGamePlayed(0);
                playerList[i].setGameWon(0);
                playerList[i].setGameDraw(0);
            }
        }
    }

    /**
     * Display player information for supplied player from system
     */
    public void displayPlayer(String displayName) {
        if (checkUserName(displayName) != -1) {
            player = playerList[checkUserName(displayName)];
            System.out.println(player.getUserName() + "," +
                    player.getFamilyName() + "," +
                    player.getGivenName() + "," +
                    player.getGamePlayed() + " games," +
                    player.getGameWon() + " wins," +
                    player.getGameDraw() + " draws"

            );
        } else {
            System.out.println("The player does not exist.");
        }
    }

    /**
     * Display inforamtion for ALL players from system
     */
    public void displayPlayer() {

        String[] str = sortByUsername();

        for (int i = 0; i < str.length; i++) {
                displayPlayer(str[i]);
        }
    }

    /**
     * Sort By username of ALL player
     */
    public String[] sortByUsername() {
        int i = 0;
        String[] str = new String[objInPlayer];

        while (i < objInPlayer) {
                str[i] = playerList[i].getUserName();
                i++;

        }
        Arrays.sort(str);
        return str;
    }

    /**
     * Display ranking for Top 10 players from system
     */
    public void displayRankings() {

        Ranking[] rankObj = new Ranking[objInPlayer];

        for (int i = 0; i < objInPlayer; i++) {
            Ranking temp = new Ranking();
            temp.setUserName(playerList[i].getUserName());
            temp.setWinRatio(winRatio(i));
            temp.setDrawRatio(drawRatio(i));
            temp.setGamePlayed(playerList[i].getGamePlayed());
            rankObj[i]=temp;

        }

        Ranking temp = new Ranking();

        //sort ALL username by winning ratio
        boolean flag=true;
        while (flag){
            flag=false;
            for (int i=0;i<objInPlayer-1;i++){
                    if (rankObj[i].getWinRatio() < rankObj[i+1].getWinRatio()){
                    temp=rankObj[i];
                    rankObj[i]=rankObj[i+1];
                    rankObj[i+1]=temp;
                    flag = true;
                }
            }
        }

        //Sort ALL username whose winning ration is same using drawing ratio
        boolean flag2=true;
        while (flag2){
             flag2=false;
            for (int i=0;i<objInPlayer-1;i++){
                if(rankObj[i].getWinRatio() == rankObj[i+1].getWinRatio()){
                    if(rankObj[i].getDrawRatio() < rankObj[i+1].getDrawRatio()){

                        temp=rankObj[i];
                        rankObj[i]=rankObj[i+1];
                        rankObj[i+1]=temp;
                        flag2 = true;
                    }
                }
            }
        }

        // Sort ALL username whose drawing ration is same
        boolean flag3=true;
        while (flag3){
            flag3=false;
            for (int i=0;i<objInPlayer-1;i++){
                if(rankObj[i].getWinRatio()==rankObj[i+1].getWinRatio()){
                    if(rankObj[i].getDrawRatio() == rankObj[i+1].getDrawRatio()){
                        if(rankObj[i].getUserName().compareTo(rankObj[i+1].getUserName())>0){

                            temp=rankObj[i];
                            rankObj[i]=rankObj[i+1];
                            rankObj[i+1]=temp;
                            flag3 = true;
                        }
                    }
                }
            }
        }

        System.out.println(" WIN  | DRAW | GAME | USERNAME");
        //Display 10 Player 
        int winplay;
        if (10<objInPlayer)
            winplay=10;
        else
           winplay=objInPlayer;

        for (int i = 0; i < winplay ; i++) {
            System.out.println((String.format("%4s",Math.round(rankObj[i].getWinRatio())))+"% |" +
                               (String.format("%4s",Math.round(rankObj[i].getDrawRatio())))+"% | "+
                               (String.format("%2s",rankObj[i].getGamePlayed()))+"   | "+
                               (rankObj[i].getUserName()));
        }

    }
    
    /**
     * Return Winning Ratio of player
     */
    public double winRatio(int i) {

            double temp=(double) playerList[i].getGameWon() /  playerList[i].getGamePlayed() * 100;
            return Math.round(temp);
    }

    /**
     * Return Drawing Ratio of player
     */
    public double drawRatio(int i) {
            double temp=(double) playerList[i].getGameDraw() / playerList[i].getGamePlayed() * 100;
            return Math.round(temp);
    }

}
