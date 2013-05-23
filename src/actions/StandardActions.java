package actions;

import gui.GameBoard;
import gui.InfoField;
import gui.Start;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class StandardActions {
	
	private static Color green = new Color (0, 250, 0);
	private static Color red = new Color (250, 0, 0);
	private static Color blue = new Color (0, 0, 250);
	private static Color purple = new Color (100, 0, 100);

//***		main menu listeners
	public static ActionListener exit = new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	public static ActionListener help = new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			GameBoard.hmsg.setText("You're on your own!");
			GameBoard.hmsg.setForeground(red);
		}
	};
	
	public static ActionListener newgame = new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			Start newStart = new Start();
			newStart.showWindow();
		}
	};
	
//***		start new game listeners
	public static ActionListener choosec1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Start.pl1.setSelected(false);
			Start.name1.setEnabled(false);
			if (Start.pl2.isSelected() == true ) {
					Start.name1.setText("Computer");
					if (Start.name2.getText() != "Player 2" ||
										Start.name2.getText() != "Computer 2" ) {
						Start.name1.setText("Computer");
					}
			} else if (Start.c2.isSelected() == true ) {
				Start.name1.setText("Computer 1");
				Start.name2.setText("Computer 2");
			}
		}
	};
	
	public static ActionListener choosep1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Start.c2.setSelected(false);
			Start.name1.setText("Player 1");
			Start.name1.setEnabled(true);
		}
	};
	
	public static ActionListener choosec2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Start.pl2.setSelected(false);
			Start.name2.setText("Computer 2");
			Start.name2.setEnabled(false);
		}
	};
	
	public static ActionListener choosep2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Start.c2.setSelected(false);
			Start.name2.setText("Player 2");
			Start.name2.setEnabled(true);
		}
	};
	
	public static ActionListener play = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			InfoField.player1.setEnabled(true);
			InfoField.player2.setEnabled(true);
			InfoField.player1.setText(Start.name1.getText());
			InfoField.player2.setText(Start.name2.getText());
		}
	};
	
}
