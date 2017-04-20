package sub;
/*  Project to demonstrate game TicTacToe
 *  Date: 9 May 2016
 *  Author: Jigar Thakkar 
 *  Student id:800301
 */
import java.util.*;

public class TicTacToe {

    public static Scanner keybord = new Scanner(System.in); // the input Scanner
    PlayerManager manage = new PlayerManager();
    private int player1Index, player2Index;
    /**
     * The main method(or driver method for program)
     */
    public static void main(String[] args) {
        TicTacToe gameSystem = new TicTacToe();
        gameSystem.run();
    }
    /**
     * Entry method of the game
     */
    public void run() {

        int system_state = 1;
        String inputcom;
        String yOrN;

        System.out.println("Welcome to Tic Tac Toe!");

        while (system_state == 1) {
            System.out.println();
            System.out.print(">");
            inputcom = keybord.nextLine();

            if(inputcom.equals(""))
            {
                inputcom = keybord.nextLine();
            }

            StringTokenizer tokens = new StringTokenizer(inputcom, "/[ ,]+/");
            String[] splitStrs = new String[tokens.countTokens()];
            int numberOfWords = 0;
            while (tokens.hasMoreTokens()) {
                splitStrs[numberOfWords] = tokens.nextToken();
                ++numberOfWords;
            }

            if (numberOfWords == 1) {
                switch (splitStrs[0]) {
                    case "exit":
                        System.out.println();
                        System.exit(0);
                        break;

                    case "removeplayer":
                        System.out.println("Are you sure you want to remove all players? (y/n)");
                        yOrN = keybord.nextLine();
                        if (yOrN.equals("y"))
                            manage.removePlayer();     // removeplayer
                        continue;

                    case "resetstats":
                        System.out.println("Are you sure you want to reset all player statistics? (y/n)");
                        yOrN = keybord.nextLine();
                        if (yOrN.equals("y"))
                            manage.resetStates();     // resetstats
                        continue;

                    case "displayplayer":
                        manage.displayPlayer();
                        continue;

                    case "rankings":
                        manage.displayRankings(); // >rankings
                        continue;

                }
            } else if (numberOfWords > 1) {
                switch (splitStrs[0]) {
                    case "addplayer":
                        manage.addPlayer(splitStrs[1], splitStrs[2], splitStrs[3]);
                        //addplayer username,family_name,given_name
                        continue;

                    case "removeplayer":
                        manage.removePlayer(splitStrs[1]); // removeplayer [username]
                        continue;

                    case "editplayer":
                        manage.editPlayer(splitStrs[1], splitStrs[2], splitStrs[3]);
                        // editplayer username,new_family_name,new_given_name
                        continue;

                    case "resetstats":
                        manage.resetStates(splitStrs[1]);// resetstats [username]
                        continue;

                    case "displayplayer":
                        manage.displayPlayer(splitStrs[1]); // displayplayer [username]
                        continue;

                    case "playgame":
                        player1Index = manage.checkUserName(splitStrs[1]);
                        player2Index = manage.checkUserName(splitStrs[2]);
                        if (player1Index != -1 && player2Index != -1) {
                            GameManager play = new GameManager();
                            play.playGame(manage.playerList[player1Index], manage.playerList[player2Index]);
                            //playgame username1,username2
                        } else {
                            System.out.println("Player does not exist.");
                        }
                        continue;
                }
            }
            System.out.println();
        }

    }

}