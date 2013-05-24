package game;

import java.awt.Color;
import java.util.Arrays;

import actions.Gameplay;
import gui.InfoField;
import gui.Start;

public class Logics {
	private static Color red = new Color (250, 0, 0);
	private static Color blue = new Color (0, 0, 250);
	public static double coin;
	private static int turn1;
	private static int turn2;
	
	public static Kalaha newGame () {
		Player player1 = new Player();
		Player player2 = new Player();
		
		coinToss();
		int [] field = { 6, 6, 6, 6, 6, 6, 0 };
		
		player1.setPlayer(Start.name1.getText(), 1, turn1, field);
		player2.setPlayer(Start.name2.getText(), 2, turn2, field);
				
		Kalaha game = new Kalaha(player1, player2);
		
		// test
//		System.out.println(Arrays.toString(field));
//		System.out.println(player2.getField().toString());
		
		return game;
	}
	

	
	public int getTurn (Player player) {
		return player.turn;
	}
	
	public void makeMove() {
		
	}
	
	/*
	 * choose who starts
	 */
	public static void coinToss () {
		coin = (int) (Math.random() + .5);
		if (coin == 0) {
			InfoField.message.setForeground(red);
			InfoField.message.setText("Heads!   " + 
										InfoField.player1.getText() +
										"   starts first!");
			turn1 = 1;
			turn2 = 2;
		} else {
			InfoField.message.setForeground(blue);
			InfoField.message.setText("Tails!   " + 
										InfoField.player2.getText() +
										"   starts first!");
			turn2 = 1;
			turn1 = 2;
		}
	}
}
