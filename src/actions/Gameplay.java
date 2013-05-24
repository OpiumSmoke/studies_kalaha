/**
 * 
 */
package actions;

import game.Player;
import gui.GameBoard;
import gui.InfoField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
	
	/*
	 * accept move
	 */
	public static ActionListener yes = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			InfoField.message.setText("says yes");
		}
	};
	
	/*
	 * undo move
	 */	
	public static ActionListener undo = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			InfoField.message.setText("should undo");
		}	
	};
	/*
	 * click a field
	 */
	public static MouseListener clickField = new MouseListener () {

		@Override
		public void mouseClicked(MouseEvent e) {
			JPanel selectedfield = (JPanel) e.getSource();
			
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
			}
			
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
}



	

