/*  Project to demonstrate game TicTacToe
 *  Date: 7 April 2016
 *  Author: Jigar Thakkar 
 *  Student id:800301
 */
package proA;

import java.util.Scanner;

public class TicTacToe {	
     // Name of constants used to represent the various states of the game		
	 public static final int PLAYING = 1;
	 public static final int DRAW = 2;
	 public static final int CROSS_WON = 3;
	 public static final int NOUGHT_WON = 4;
	 
	 private String player1,player2;           
	 private char[][] board = new char[3][3];  // game board 3*3	
	 	
	 	// Accessors and mutators methods for accessing private variables
	 	public String getPlayer1() {
			return player1;
		}
		public void setPlayer1(String player1) {
			this.player1 = player1;
		}
		public String getPlayer2() {
			return player2;
		}
		public void setPlayer2(String player2) {
			this.player2 = player2;
		}
               
	 public Scanner keybord = new Scanner(System.in); // the input Scanner
 
   /** The main method(or driver method for program) */
   public static void main(String[] args){
	   TicTacToe obj=new TicTacToe();
	   obj.run();
   }
   /** Entry method of the game */ 
   public void run() {
	  		System.out.println("Welcome to Tic Tac Toe!\n");
	  		
	  		// initialization of player name  
			System.out.println("Enter Player O's name:");
			setPlayer1(keybord.nextLine());            			
			System.out.println("Enter Player X's name:");
			setPlayer2(keybord.nextLine());
			
			int gamestate = PLAYING;          // start playing game
			char currentPlayer = 'O';         // Naught plays first 
		     
			printGrid(); //prints empty game board
						
			while (gamestate == PLAYING){  // repeat until game state is changed  
				    if (currentPlayer == 'O') {	    	  
				        System.out.print( getPlayer1() +"'s move:\n");
				    } else {
	                    System.out.print( getPlayer2() +"'s move:\n");  
				    }  
			 //  take next input move 	    
	         int row = keybord.nextInt() ;  
	         int col = keybord.nextInt() ;  
	         board[row][col] = currentPlayer;  // include new mov
	         printGrid();	//  prints updated game board	         
	         gamestate = getGameState(row, col,currentPlayer); //returns game state(PLAYING,DRAW,CROSS_WON,NOUGHT_WON)
	         
	         if(currentPlayer == 'O') {   // Switch player
	        	 currentPlayer='X';
	         } else {
	        	 currentPlayer='O';
	         }
	      }  
   }
   /** Returns if player is win the game,draw or game still continue*/    
   public int getGameState(int newRow, int newCol,char OorX) {
	   if(board[newRow][0] == OorX           // 3 OorX in same row
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
		   if(OorX=='O') {
			     System.out.println("Game over. "+ getPlayer1() +" won!"); 
	    		 return NOUGHT_WON;
		   } else {
			     System.out.println("Game over. "+ getPlayer2() +" won!");
	    		 return CROSS_WON;
	       }
	   } else {
    	   for (int row = 0; row < 3; row++) {
    		   for (int col = 0; col < 3; col++) {
    			   if (board[row][col] == '\u0000') {  // "\u0000" used for checking empty cell 
    				   return PLAYING;  // an empty cell found game can continue
    			   }
    		   }
    	   }
       }
	  System.out.println("Game over  It was a DRAW!");
      return DRAW; 
   }
 
   /** Print game board */
   public void printGrid() {
      for (int row = 0; row < 3; ++row) {
         for (int col = 0; col < 3; ++col) {
        	 if (board[row][col] == 'X') {
        		 System.out.print("X");
        	 } else if(board[row][col]=='O') {
        		 System.out.print("O");
        	 } else {
        		 System.out.print(" ");
        	 }
             if (col < 2) {
               System.out.print("|");   // print vertical partition
             }
         }
         System.out.println(); //prints next row of board in to next line
         if (row < 2 ) {
            System.out.println("-----"); // print horizontal partition
         }
      }
   }
}