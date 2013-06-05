/**
 * 
 */
package actions;

import game.Kalaha;
import game.Logics;
import game.Player;
import gui.GameBoard;
import gui.InfoField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * The class contains gameplay actions.
 * @author nicky
 *
 */
public class Gameplay {
	
	//player field colors
	static private Color color1 = new Color (205, 38, 38);
	static private Color color2 = new Color (24, 116, 205);
	static private Color selected1 = new Color (255, 215, 0);
	static private Color selected2 = new Color (0, 238, 118);
	
	private static Color red = new Color (250, 0, 0);
	private static Color blue = new Color (0, 0, 250);
	
	public static JLabel pit = new JLabel();
	public static int pitnumber = 0;
	
	/**
	 * accept move
	 */
	public static ActionListener yes = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			GameBoard.undo.setEnabled(true);
			GameBoard.go.setEnabled(false);
			Logics.makeMove(pit, pitnumber);	
//			Logics.game.setCurrentTurn(Logics.game.getCurrentTurn());
//			Logics.giveTurn(Kalaha.player1, Kalaha.player2, Kalaha.currentturn);
//			Logics.writeMoveOnField(Kalaha.player1, Kalaha.player2, Kalaha.currentturn, Logics.movearray);
		}
	};
	
	/**
	 * undo move
	 */	
	public static ActionListener undo = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			InfoField.message.setText("Move undone");
			Logics.undoMove();
			GameBoard.go.setEnabled(false);
		}	
	};	
	/**
	 * triggers actions clicking red fields
	 */
	public static MouseListener clickRed = new MouseListener () {

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton selectedfield = (JButton) e.getSource();
			int i = 0;
			Player player = null;
			System.out.println("Mouse clicked on red: ");
			
			if ( selectedfield.isEnabled() == true ) {
				if (selectedfield == GameBoard.pl1h1) {
					selectedfield.setBackground(selected1);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					
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
					InfoField.message.setForeground(red);
					InfoField.message.setText(InfoField.player1.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h11;
					player = Logics.game.player1;
					i = 0;
					pitnumber = 0;
					GameBoard.hmsg.setForeground(red);
					GameBoard.hmsg.setText("Click yes to make your move!");
				} else if (selectedfield == GameBoard.pl1h2 ) {
					selectedfield.setBackground(selected1);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl1h1.setBackground(color1);
					GameBoard.pl1h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h3.setBackground(color1);
					GameBoard.pl1h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h4.setBackground(color1);
					GameBoard.pl1h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h5.setBackground(color1);
					GameBoard.pl1h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h6.setBackground(color1);
					GameBoard.pl1h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
					InfoField.message.setForeground(red);
					InfoField.message.setText(InfoField.player1.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h12;
					player = Logics.game.player1;
					i = 1;
					pitnumber = 1;
					GameBoard.hmsg.setForeground(red);
					GameBoard.hmsg.setText("Click yes to make your move!");
				} else if ( selectedfield == GameBoard.pl1h3 ) {
					selectedfield.setBackground(selected1);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl1h1.setBackground(color1);
					GameBoard.pl1h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h2.setBackground(color1);
					GameBoard.pl1h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h4.setBackground(color1);
					GameBoard.pl1h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h5.setBackground(color1);
					GameBoard.pl1h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h6.setBackground(color1);
					GameBoard.pl1h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
					InfoField.message.setForeground(red);
					InfoField.message.setText(InfoField.player1.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h13;
					player = Logics.game.player1;
					i = 2;
					pitnumber = 2;
					GameBoard.hmsg.setForeground(red);
					GameBoard.hmsg.setText("Click yes to make your move!");
				} else if (selectedfield == GameBoard.pl1h4) {
					selectedfield.setBackground(selected1);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl1h1.setBackground(color1);
					GameBoard.pl1h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h2.setBackground(color1);
					GameBoard.pl1h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h3.setBackground(color1);
					GameBoard.pl1h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h5.setBackground(color1);
					GameBoard.pl1h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h6.setBackground(color1);
					GameBoard.pl1h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
					InfoField.message.setForeground(red);
					InfoField.message.setText(InfoField.player1.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h14;
					player = Logics.game.player1;
					i = 3;
					pitnumber = 3;
					GameBoard.hmsg.setForeground(red);
					GameBoard.hmsg.setText("Click yes to make your move!");
				} else if (selectedfield == GameBoard.pl1h5) {
					selectedfield.setBackground(selected1);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl1h1.setBackground(color1);
					GameBoard.pl1h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h2.setBackground(color1);
					GameBoard.pl1h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h3.setBackground(color1);
					GameBoard.pl1h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h4.setBackground(color1);
					GameBoard.pl1h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl1h6.setBackground(color1);
					GameBoard.pl1h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					InfoField.message.setForeground(red);
					InfoField.message.setText(InfoField.player1.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h15;
					player = Logics.game.player1;
					i = 4;
					pitnumber = 4;
					GameBoard.hmsg.setForeground(red);
					GameBoard.hmsg.setText("Click yes to make your move!");
				} else if ( selectedfield == GameBoard.pl1h6 ) {
					selectedfield.setBackground(selected1);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
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
					InfoField.message.setForeground(red);
					InfoField.message.setText(InfoField.player1.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h16;
					player = Logics.game.player1;
					i = 5;
					pitnumber = 5;
					GameBoard.hmsg.setForeground(red);
					GameBoard.hmsg.setText("Click yes to make your move!");
					} 
			} else if ( selectedfield.isEnabled() == false &&
						( selectedfield == GameBoard.pl2h1 ||
						selectedfield == GameBoard.pl2h2 ||
						selectedfield == GameBoard.pl2h3 ||
						selectedfield == GameBoard.pl2h4 ||
						selectedfield == GameBoard.pl2h5 ||
						selectedfield == GameBoard.pl2h6 )) {				
					GameBoard.hmsg.setForeground(red);
					GameBoard.hmsg.setText("Click your own fields! :P");
					System.out.println("Player 1 fields disabled");
				}	
//			} 
//			Logics.game.getSeedNumber(givePit(pit));
			givePit(pit);
			Logics.game.getSeedNumber(player, i);
			
			if (Logics.game.getSeedNumber(player, i) == 0) {
				System.out.println("Oops, no seeds!");
				
				GameBoard.go.setEnabled(false);
				GameBoard.hmsg.setText("Oops, you have no seeds in that pit, choose another one!");
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
		
		}

		@Override
		public void mouseExited(MouseEvent e) {

		};
	};
	/**
	 * blue field click actions
	 */
	public static MouseListener clickBlue = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton selectedfield = (JButton) e.getSource();
			int i = 0;
			Player player = null;
//			System.out.println("Mouse clicked: ");
//			System.out.println("Player 2 true");
			if (selectedfield.isEnabled() == true) {
				if (selectedfield == GameBoard.pl2h1) {
					selectedfield.setBackground(selected2);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					
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
					InfoField.message.setForeground(blue);
					InfoField.message.setText(InfoField.player2.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit= GameBoard.h21;
					player = Logics.game.player2;
					i = 7;
					pitnumber = 0;
				} else if (selectedfield == GameBoard.pl2h2 ) {
					selectedfield.setBackground(selected2);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl2h1.setBackground(color2);
					GameBoard.pl2h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h3.setBackground(color2);
					GameBoard.pl2h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h4.setBackground(color2);
					GameBoard.pl2h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h5.setBackground(color2);
					GameBoard.pl2h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h6.setBackground(color2);
					GameBoard.pl2h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
					InfoField.message.setForeground(blue);
					InfoField.message.setText(InfoField.player2.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h22;
					player = Logics.game.player2;
					i = 8;
					pitnumber = 1;
				} else if ( selectedfield == GameBoard.pl2h3 ) {
					selectedfield.setBackground(selected2);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl2h1.setBackground(color2);
					GameBoard.pl2h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h2.setBackground(color2);
					GameBoard.pl2h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h4.setBackground(color2);
					GameBoard.pl2h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h5.setBackground(color2);
					GameBoard.pl2h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h6.setBackground(color2);
					GameBoard.pl2h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
					InfoField.message.setForeground(blue);
					InfoField.message.setText(InfoField.player2.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h23;
					player = Logics.game.player2;
					i = 9;
					pitnumber = 2;
				} else if (selectedfield == GameBoard.pl2h4) {
					selectedfield.setBackground(selected2);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl2h1.setBackground(color2);
					GameBoard.pl2h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h2.setBackground(color2);
					GameBoard.pl2h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h3.setBackground(color2);
					GameBoard.pl2h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h5.setBackground(color2);
					GameBoard.pl2h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h6.setBackground(color2);
					GameBoard.pl2h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
					InfoField.message.setForeground(blue);
					InfoField.message.setText(InfoField.player2.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h24;
					player = Logics.game.player2;
					i = 10;
					pitnumber = 3;
				} else if (selectedfield == GameBoard.pl2h5) {
					selectedfield.setBackground(selected2);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
					GameBoard.pl2h1.setBackground(color2);
					GameBoard.pl2h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h2.setBackground(color2);
					GameBoard.pl2h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h3.setBackground(color2);
					GameBoard.pl2h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h4.setBackground(color2);
					GameBoard.pl2h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
					GameBoard.pl2h6.setBackground(color2);
					GameBoard.pl2h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
					InfoField.message.setForeground(blue);
					InfoField.message.setText(InfoField.player2.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h25;	
					player = Logics.game.player2;
					i = 11;
					pitnumber = 4;
				} else if ( selectedfield == GameBoard.pl2h6 ) {
					selectedfield.setBackground(selected2);
					selectedfield.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
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
					InfoField.message.setForeground(blue);
					InfoField.message.setText(InfoField.player2.getText() +
							"  are you sure?");
					GameBoard.undo.setEnabled(true);
					GameBoard.go.setEnabled(true);
					pit = GameBoard.h26;
					player = Logics.game.player2;
					i = 12;
					pitnumber = 5;
				} 
			} else if ( selectedfield.isEnabled() == false &&
					( selectedfield == GameBoard.pl1h1 ||
					selectedfield == GameBoard.pl1h2 ||
					selectedfield == GameBoard.pl1h3 ||
					selectedfield == GameBoard.pl1h4 ||
					selectedfield == GameBoard.pl1h5 ||
					selectedfield == GameBoard.pl1h6 )) {
				GameBoard.hmsg.setForeground(blue);
				GameBoard.hmsg.setText("Click your own fields! :P");
			}
			
			GameBoard.hmsg.setForeground(blue);
			GameBoard.hmsg.setText("Click yes to make your move!");
			givePit(pit);
			Logics.game.getSeedNumber(player, i);
			if (Logics.game.getSeedNumber(player, i) == 0) {
				System.out.println("Oops, no seeds!");
				
				GameBoard.go.setEnabled(false);
				GameBoard.hmsg.setText("Oops, you have no seeds in that pit, choose another one!");
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			
		}
		
	};

	
	/**
	 * returns the JLabel from clicked JPanel (field)
	 */
	public static JLabel givePit(JLabel pit) {
		if (pit == GameBoard.h11) {
			System.out.println("Clicked: red 1");
		} else if (pit == GameBoard.h12) {
			System.out.println("Clicked: red 2");
		} else if (pit == GameBoard.h13) {
			System.out.println("Clicked: red 3");
		} else if (pit == GameBoard.h14) {
			System.out.println("Clicked: red 4");
		} else if (pit == GameBoard.h15) {
			System.out.println("Clicked: red 5");
		} else if (pit == GameBoard.h16) {
			System.out.println("Clicked: red 6");	
		} else if (pit == GameBoard.h21) {
			System.out.println("Clicked: blue 1");
		} else if (pit == GameBoard.h22) {
			System.out.println("Clicked: blue 2");
		} else if (pit == GameBoard.h23) {
			System.out.println("Clicked: blue 3");
		} else if (pit == GameBoard.h24) {
			System.out.println("Clicked: blue 4");
		} else if (pit == GameBoard.h25) {
			System.out.println("Clicked: blue 5");
		} else if (pit == GameBoard.h26) {
			System.out.println("Clicked: blue 6");	
		}
		return pit;
	}
}



	

