package game;

import java.util.Arrays;

public class Kalaha {
	public int [] board = new int[14];
	public static Player player1;
	public static Player player2;
	public static int currentturn = 0;
	
	public int seeds; 
	
	public Kalaha (Player player1, Player player2) {
		Kalaha.player1 = player1;
		Kalaha.player2 = player2;
		
		setStatus(player1.field, player2.field);
	}
	/**
	 * gets curent game turn 1 or 2
	 * @return currentturn
	 */
	public static int getCurrentTurn() {
		return currentturn;
	}
	
	public static void setCurrentTurn(int currentturn) {
		System.out.println("Last turn was: " + getCurrentTurn());
		if (currentturn == 0) {
			Logics.game.currentturn = 1;
			System.out.println("Current turn set to: " + getCurrentTurn());
		} else if (currentturn == 1) {
			Logics.game.currentturn = 2;
			System.out.println("Current turn set to: " + getCurrentTurn());
		} else if (currentturn == 2) {
			Logics.game.currentturn = 1;
			System.out.println("Current turn: " + getCurrentTurn());
		}
	}
	
	/**
	 * gets seed number 
	 * takes the player and integer values from clickField in Gameplay
	 * @return
	 */
	public int getSeedNumber(Player player, int i) {
		int [] tmp = player.getField();
		seeds = tmp [i];
		System.out.println("Got seed number of: " + seeds);
		return seeds;
	}
	
	/**
	 * sets seed number in a pit
	 * @param seeds
	 */
	public void setSeedNumber (int seeds) {
		
	}
	/**
	 * gets the board status
	 * @return board
	 */
	public int[] getStatus() {
		return board;
	}
	/**
	 * sets the field status from current player boards
	 * player 1 field: 0 - 6, player 2 field: 7 - 13
	 * player 1 kalaha 6, player 2 kalaha 13
	 */
	public void setStatus(int [] field1, int [] field2) {
//			this.board[0] = field1[0];
//			this.board[1] = field1[1];
//			this.board[2] = field1[2];
//			this.board[3] = field1[3];
//			this.board[4] = field1[4];
//			this.board[5] = field1[5];
//			this.board[6] = field1[6];
//			this.board[7] = field2[0];
//			this.board[8] = field2[1];
//			this.board[9] = field2[2];
//			this.board[10] = field2[3];
//			this.board[11] = field2[4];
//			this.board[12] = field2[5];
//			this.board[13] = field2[6];
		int i = 0;
		while ( i <= 13) {
			if ( i >= 0 && i < 7 ) {
				this.board[i] = field1[i];
				System.out.println("First array write: " + board[i] + " takes " + field1[i]);
			} else if ( i >= 7 && i <13 ) {
				this.board[i] = field2[i-7];
				System.out.println("First array write: " + board[i] + " takes " + field1[i-7]);
			}
		i++;
		}
			//test if numbers ok
//
//			System.out.println(board[i]);
//			System.out.println(board[i+7]);
//			System.out.println(i);
//		i++;
//		}
    	System.out.println("Board set: " + Arrays.toString(board));
	}
		
}
