package game;

import gui.InfoField;

import java.awt.Color;
import java.util.Arrays;

public class Kalaha {
	private static Color red = new Color (250, 0, 0);
	private static Color blue = new Color (0, 0, 250);
	
	public static int [] board = new int[14];
	public Player player1;
	public Player player2;
	public static Player activePlayer;
	private int coin;
	
	public int seeds; 
	
	public Kalaha (Player player1, Player player2, int [] board) {
		this.player1 = player1;
		this.player2 = player2;
				
		
		setStatus(board);
	}
	
	public void setActivePlayer(Player player) {
		Kalaha.activePlayer = player;
		System.out.println("Active player set: " + activePlayer.getName());
	}
	/**
	 * changes the active player
	 * 
	 * @param player1
	 * @param player2
	 * @param activePlayer
	 */
	public void changeActivePlayer(Player activePlayer) {
		System.out.println("Setting active player.");
		Logics.clearSelections();
		if (activePlayer == player1) {
			setActivePlayer(player2);
			InfoField.message.setForeground(blue);
			InfoField.message.setText(player2.getName() + ",   your turn!");
			System.out.println("P2 gets turn");
			Logics.writeMoveArray(player2);
		} else if (activePlayer == player2) {
			setActivePlayer(player1);
			InfoField.message.setForeground(red);
			InfoField.message.setText(player1.getName() + ",   your turn!");
			System.out.println("P1 gets turn");
			Logics.writeMoveArray(player1);
		}
		Logics.enableFields(player1, player2, Kalaha.activePlayer);
	}
	/**
	 * gets seed number 
	 * takes the player and integer values from clickField in Gameplay
	 * @return
	 */
	public int getSeedNumber(Player player, int i) {
		int [] tmp = board;
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
	public static int[] getStatus() {
		return board;
	}
	/**
	 * sets the field status from current player boards
	 * player 1 field: 0 - 6, player 2 field: 7 - 13
	 * player 1 kalaha 6, player 2 kalaha 13
	 * 
	 */
	public void setStatus(int [] newboard) {
		Kalaha.board = newboard;
		System.out.println("Game status set: " + Arrays.toString(getStatus()));
//		int i = 0;
//		while ( i <= 13) {
//			if ( i >= 0 && i < 7 ) {
//				this.board[i] = field1[i];
////				System.out.println("First array write: " + board[i] + " takes " + field1[i]);
//			} else if ( i >= 7 && i <13 ) {
//				this.board[i] = field2[i-7];
////				System.out.println("First array write: " + board[i] + " takes " + field1[i-7]);
//			}
//		i++;
//		}
//			//test if numbers ok
////
////			System.out.println(board[i]);
////			System.out.println(board[i+7]);
////			System.out.println(i);
////		i++;
////		}
//    	System.out.println("Board set: " + Arrays.toString(board));
	}
	
	
	/**
	 * choose who starts
	 */
	public Player coinToss () {
		coin = (int) (Math.random() + .5);
		System.out.println("Coin toss!");
		
		if (coin == 0) {
			InfoField.message.setForeground(red);
			InfoField.message.setText("Heads!   " + 
										InfoField.player1.getText() +
										"   starts first!");
			System.out.println("Heads!");
			setActivePlayer(player1);
		} else {
			InfoField.message.setForeground(blue);
			InfoField.message.setText("Tails!   " + 
										InfoField.player2.getText() +
										"   starts first!");
			System.out.println("Tails!");
			setActivePlayer(player2);
		}
		return activePlayer;
	}
		
}
