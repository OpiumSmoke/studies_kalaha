package actions;

import game.Logics;
import game.Player;
import gui.Game;
import gui.GameBoard;
import gui.InfoField;
import gui.Start;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
	
public class StandardActions {
	
	private static Color green = new Color (0, 250, 0);
	private static Color red = new Color (250, 0, 0);
	private static Color blue = new Color (0, 0, 250);
	private static Color purple = new Color (100, 0, 100);
	
	static private Color color1 = new Color (205, 38, 38);
	static private Color color2 = new Color (24, 116, 205);

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
			clearField();
			Start.showWindow();
		}
	};
	
//***		start new game listeners
	/* 
	 * choose computer 1
	 */
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
	
	/* 
	 * choose player 1
	 */
	public static ActionListener choosep1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Start.c2.setSelected(false);
			Start.name1.setText("Player 1");
			Start.name1.setEnabled(true);
		}
	};
	
	/*
	 * choose computer 2
	 */
	public static ActionListener choosec2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Start.pl2.setSelected(false);
			Start.name2.setText("Computer 2");
			Start.name2.setEnabled(false);
			
			if (Start.pl1.isSelected() == true ) {
				Start.name2.setText("Computer");
				if (Start.name1.getText() != "Player 1" ||
									Start.name2.getText() != "Computer 1" ) {
					Start.name2.setText("Computer");
				}
			} else if (Start.c1.isSelected() == true ) {
				Start.name1.setText("Computer 1");
				Start.name2.setText("Computer 2");
			}
		}
	};
	
	/*
	 * choose player 2
	 */
	public static ActionListener choosep2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			Start.c2.setSelected(false);
			Start.name2.setText("Player 2");
			Start.name2.setEnabled(true);
		}
	};
	
	/* 
	 * accept set options
	 */
	public static ActionListener play = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			setField();
//			Gameplay.coinToss();
			Logics.newGame();
			Start.start.dispose();
			}
	};	
	
	/* 
	 * clears field for new game
	 */
	private static void clearField() {
		InfoField.message.setText("Kalaha game is built by Nicky =^.^=");
		InfoField.message.setForeground(new Color (0,0,0));
		InfoField.player1.setEnabled(false);
		InfoField.player2.setEnabled(false);
		InfoField.player1.setText("Player 1");
		InfoField.player2.setText("Player 2");
		
		GameBoard.pl1h1.setBackground(color1);
		GameBoard.pl1h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl1h2.setBackground(color1);
		GameBoard.pl1h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl1h3.setBackground(color1);
		GameBoard.pl1h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl1h4.setBackground(color1);
		GameBoard.pl1h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl1h5.setBackground(color1);
		GameBoard.pl1h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl1h6.setBackground(color1);
		GameBoard.pl1h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
		
		GameBoard.pl2h1.setBackground(color2);
		GameBoard.pl2h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl2h2.setBackground(color2);
		GameBoard.pl2h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl2h3.setBackground(color2);
		GameBoard.pl2h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl2h4.setBackground(color2);
		GameBoard.pl2h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl2h5.setBackground(color2);
		GameBoard.pl2h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		GameBoard.pl2h6.setBackground(color2);
		GameBoard.pl2h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
		
		GameBoard.undo.setEnabled(false);
		GameBoard.go.setEnabled(false);
	}
	
	/*
	 * sets field for a game
	 */
	private static void setField () {
		InfoField.player1.setEnabled(true);
		InfoField.player2.setEnabled(true);
		Start.name1.setEnabled(true);
		Start.name1.setEnabled(true);
		InfoField.player1.setText(Start.name1.getText());
		InfoField.player2.setText(Start.name2.getText());
		GameBoard.hmsg.setText("Click a hole to choose it"); 
		
		GameBoard.pl1h1.addMouseListener(Gameplay.clickField);
		GameBoard.pl1h2.addMouseListener(Gameplay.clickField);
		GameBoard.pl1h3.addMouseListener(Gameplay.clickField);
		GameBoard.pl1h4.addMouseListener(Gameplay.clickField);
		GameBoard.pl1h5.addMouseListener(Gameplay.clickField);
		GameBoard.pl1h6.addMouseListener(Gameplay.clickField);
		GameBoard.pl2h1.addMouseListener(Gameplay.clickField);
		GameBoard.pl2h2.addMouseListener(Gameplay.clickField);
		GameBoard.pl2h3.addMouseListener(Gameplay.clickField);
		GameBoard.pl2h4.addMouseListener(Gameplay.clickField);
		GameBoard.pl2h5.addMouseListener(Gameplay.clickField);
		GameBoard.pl2h6.addMouseListener(Gameplay.clickField);
		
		GameBoard.kalaha1.setEnabled(true);
		GameBoard.kalaha2.setEnabled(true);		
		GameBoard.pl1h1.setEnabled(true);
		GameBoard.pl1h2.setEnabled(true);
		GameBoard.pl1h3.setEnabled(true);
		GameBoard.pl1h4.setEnabled(true);
		GameBoard.pl1h5.setEnabled(true);
		GameBoard.pl1h6.setEnabled(true);		
		GameBoard.pl2h1.setEnabled(true);
		GameBoard.pl2h2.setEnabled(true);
		GameBoard.pl2h3.setEnabled(true);
		GameBoard.pl2h4.setEnabled(true);
		GameBoard.pl2h5.setEnabled(true);
		GameBoard.pl2h6.setEnabled(true);
		
		GameBoard.k1.setText("0");
		GameBoard.h11.setText("6");
		GameBoard.h12.setText("6");
		GameBoard.h13.setText("6");
		GameBoard.h14.setText("6");
		GameBoard.h15.setText("6");
		GameBoard.h16.setText("6");
		
		GameBoard.k2.setText("0");
		GameBoard.h21.setText("6");
		GameBoard.h22.setText("6");
		GameBoard.h23.setText("6");
		GameBoard.h24.setText("6");
		GameBoard.h25.setText("6");
		GameBoard.h26.setText("6");
		// testing
//		GameBoard.undo.setEnabled(true);
//		GameBoard.go.setEnabled(true);
	}
	
}
