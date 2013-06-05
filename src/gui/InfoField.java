package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoField extends Game{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2175042815827529894L;
	
	static private Dimension infosize = new Dimension(800, 200);
//	static private Dimension infomax = new Dimension(1900, 600);
//	static private Dimension fieldsize = new Dimension(800, 400);
//	static private Dimension fieldmax = new Dimension(1900, 800);
	static private Dimension stsize = new Dimension (400, 190);
	
	//test colors
//	static private Color green = new Color (0, 250, 0);
	static private Color red = new Color (250, 0, 0);
	static private Color blue = new Color (0, 0, 250);
//	static private Color purple = new Color (100, 0, 100);
	
	// status panel elements
	static JPanel info = new JPanel();
	public static JLabel player1 = new JLabel("Player 1");
	public static JLabel player2 = new JLabel("Player 2");
	
	static JPanel status = new JPanel();
	public static JLabel message = new JLabel();
	
	public static JPanel Info() {
//***		info field shows player names and a status field
//		info.setBackground(green);
		info.setSize(infosize);
		info.setPreferredSize(infosize);
		info.setMinimumSize(infosize);
		
		// status layout
		GridBagLayout statlayout = new GridBagLayout();
		statlayout.columnWidths = new int [] {0};
		statlayout.rowHeights = new int [] {0};
		statlayout.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		statlayout.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE }; 
		
		GridBagConstraints statcon = new GridBagConstraints();
		statcon.insets = new Insets(20, 20, 20, 20);
		statcon.gridwidth = 1;
		statcon.fill = GridBagConstraints.VERTICAL;
		statcon.anchor = GridBagConstraints.CENTER;
		statcon.gridx = 0;
		statcon.gridy = 0;
		
		message.setText("Kalaha game is built by Nicky =^.^=");
		message.setForeground(new Color ( 0, 0, 0 ));
		status.setPreferredSize(stsize);
		status.setLayout(statlayout);
//		status.setBackground(blue);
		status.setBorder(BorderFactory.createLoweredBevelBorder());
		status.add(message, statcon);
		
		player1.setForeground(red);
		player1.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		player1.setText("Player 1");
		
		player2.setForeground(blue);
		player2.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		player2.setText("Player 2");
		
//***		build a layout
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		layout.rowHeights = new int [] {0, 0, 0};
		layout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		layout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE }; 
		
		GridBagConstraints gbcpl1 = new GridBagConstraints();
		gbcpl1.insets = new Insets(10, 10, 10, 10); // ( top, left, bottom, right )
		gbcpl1.gridwidth = 2;
		gbcpl1.fill = GridBagConstraints.NONE;
		gbcpl1.anchor = GridBagConstraints.CENTER;
		gbcpl1.gridx = 0;
		gbcpl1.gridy = 1;	
		
		GridBagConstraints gbcpl2 = new GridBagConstraints();
		gbcpl2.insets = new Insets(10, 10, 10, 10); // ( top, left, bottom, right )
		gbcpl2.gridwidth = 2;
		gbcpl2.fill = GridBagConstraints.NONE;
		gbcpl2.anchor = GridBagConstraints.CENTER;
		gbcpl2.gridx = 0;
		gbcpl2.gridy = 1;	
		
		GridBagConstraints gbcstatus = new GridBagConstraints();
		gbcstatus.insets = new Insets(0, 0, 0, 0);
		gbcstatus.gridwidth = 4;
		gbcstatus.fill = GridBagConstraints.BOTH;
		gbcstatus.anchor = GridBagConstraints.CENTER;
		gbcstatus.gridx = 2;
		gbcstatus.gridy = 1;
		
//***		build info
		// disable stuff per default
		player1.setEnabled(false);
		player2.setEnabled(false);
		
		info.add(player1, gbcpl1);
		info.add(status, gbcstatus);
		info.add(player2, gbcpl2);
		
		return info;
	}

}
