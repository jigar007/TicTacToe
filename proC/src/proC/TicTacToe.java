package proC;

/*  Project to demonstrate game TicTacToe
 *  Date: 25 May 2016
 *  Author: Jigar Thakkar 
 *  Student id:800301
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class TicTacToe extends Exception {

    public static Scanner keybord = new Scanner(System.in); // the input Scanner
    PlayerManager manage = new PlayerManager();
    int player1Index, player2Index;

    public static final int fourWords=4;
    public static final int twoWords=2;
    public static final int threeWords=3;

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
        try {
            manage.getDataFromFile();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (system_state == 1) {
            System.out.println();
            System.out.print(">");
            inputcom = keybord.nextLine();

            if (inputcom.equals("")) {
                inputcom = keybord.nextLine();
            }

            StringTokenizer tokens = new StringTokenizer(inputcom, "/[ ,]+/");
            String[] splitStrs = new String[tokens.countTokens()];
            int numberOfWords = 0;
            while (tokens.hasMoreTokens()) {
                splitStrs[numberOfWords] = tokens.nextToken();
                ++numberOfWords;
            }

            try {
                switch (splitStrs[0]) {
                    case "exit":
                        System.out.println();
                        manage.saveIntoFile();
                        System.exit(0);
                        break;

                    case "rankings":
                        manage.displayRankings(); // >rankings
                        continue;

                    case "addplayer":
                        if (numberOfWords == fourWords)
                            manage.addPlayer(splitStrs[1], splitStrs[2], splitStrs[3]);
                            //addplayer username,family_name,given_name
                        else
                            throw new InvalidNumberOfArgumentsException();
                        continue;

                    case "addaiplayer":
                        if (numberOfWords == fourWords)
                            manage.addAIPlayer(splitStrs[1], splitStrs[2], splitStrs[3]);
                            //addaiplayer username,family_name,given_name
                        else
                            throw new InvalidNumberOfArgumentsException();
                        continue;

                    case "removeplayer":
                        if (numberOfWords == twoWords) {
                            manage.removePlayer(splitStrs[1]);
                        } // removeplayer [username]
                        else if (numberOfWords == 1) {
                            System.out.println("Are you sure you want to remove all players? (y/n)");
                            yOrN = keybord.nextLine();
                            if (yOrN.equals("y"))
                                manage.removePlayer();     // removeplayer
                        } else {
                            throw new InvalidNumberOfArgumentsException();
                        }
                        continue;

                    case "editplayer":
                        if (numberOfWords == twoWords) {
                            manage.editPlayer(splitStrs[1], splitStrs[2], splitStrs[3]);
                            // editplayer username,new_family_name,new_given_name
                        } else {
                            throw new InvalidNumberOfArgumentsException();
                        }
                        continue;

                    case "resetstats":
                        if (numberOfWords == twoWords) {
                            manage.resetStates(splitStrs[1]);// resetstats [username]
                        } else if (numberOfWords == 1) {
                            System.out.println("Are you sure you want to reset all player statistics? (y/n)");
                            yOrN = keybord.nextLine();
                            if (yOrN.equals("y"))
                                manage.resetStates();     // resetstats
                        } else {

                        }
                        continue;

                    case "displayplayer":
                        if (numberOfWords == twoWords) {
                            manage.displayPlayer(splitStrs[1]); // displayplayer [username]
                        } else if (numberOfWords == 1) {
                            manage.displayPlayer();
                        } else {
                            throw new InvalidNumberOfArgumentsException();
                        }
                        continue;

                    case "playgame":
                        if (numberOfWords == threeWords) {
                            player1Index = manage.checkUserName(splitStrs[1]);
                            player2Index = manage.checkUserName(splitStrs[2]);
                            if (player1Index != -1 && player2Index != -1) {
                                GameManager play = new GameManager();
                                play.playGame(manage.playerList[player1Index], manage.playerList[player2Index]);
                                //playgame ObjectOfPlayer1,ObjectOfPlayer1
                            } else {
                                System.out.println("Player does not exist.");
                            }
                        } else {
                            throw new InvalidNumberOfArgumentsException();
                        }
                        continue;
                    default:
                        throw new InvalidCommandException(splitStrs[0]);
                }
            } catch (InvalidNumberOfArgumentsException e) {
                System.out.println(e.getMessage());
                System.out.println();
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
                System.out.println();
            } catch (IOException e) {
            }
        }
        System.out.println();
    }
}

