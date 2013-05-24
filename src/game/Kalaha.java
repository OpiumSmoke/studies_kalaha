package game;

import java.util.Arrays;

import javax.swing.JLabel;

import gui.GameBoard;
import gui.Start;

public class Kalaha {
	public int [] board = new int[14];
	Player player1;
	Player player2;
	
	public Kalaha (Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		
		setStatus(player1.field, player2.field);
	}
	
//	public int[] whichPit(JLabel seeds) {
//		if (seeds == GameBoard.h11) {
//			return null;
//		}
//	}
	
	public void setSeedNumber (int seeds) {
		
	}
	
	public int[] getStatus() {
		return board;
	}
	/*
	 * player 1 field: 0 - 6, player 2 field: 7 - 13
	 * player 1 kalaha 6, player 2 kalaha 13
	 */
	public void setStatus(int [] field1, int [] field2) {
		int i = 0;
    	while (i <= 6) {
			this.board[i] = field1[i];
			this.board[i+6] = field2[i];
			System.out.println(board[i]);
			System.out.println(board[i+6]);
			System.out.println(i);
		i++;
		}
    	System.out.println(Arrays.toString(board));
	}
	
}
