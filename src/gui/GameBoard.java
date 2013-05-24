package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actions.Gameplay;

public class GameBoard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4389563803973947050L;
	
	private static Dimension fieldsize = new Dimension(800, 400);
	private static Dimension fieldmax = new Dimension(1900, 800);
	private static Dimension kalaha = new Dimension (100, 200);
	private static Dimension hole = new Dimension (80, 80);
	private static Dimension spsize = new Dimension (400, 30);
	
	//test colors
	static private Color green = new Color (0, 250, 0);
	static private Color red = new Color (250, 0, 0);
	static private Color blue = new Color (0, 0, 250);
	static private Color purple = new Color (100, 0, 100);
	
	//player field colors
	static private Color color1 = new Color (205, 38, 38);
	static private Color color2 = new Color (24, 116, 205);
	static private Color selected1 = new Color (255, 215, 0);
	static private Color selected2 = new Color (0, 238, 118);
	
	// Field elements
	static JPanel field = new JPanel();
	
	public static JPanel kalaha1 = new JPanel();
	public static JPanel kalaha2 = new JPanel();
	
	public static JPanel pl1h1 = new JPanel();
	public static JPanel pl1h2 = new JPanel();
	public static JPanel pl1h3 = new JPanel();
	public static JPanel pl1h4 = new JPanel();
	public static JPanel pl1h5 = new JPanel();
	public static JPanel pl1h6 = new JPanel();
	
	public static JLabel k1 = new JLabel("0");
	public static JLabel h11 = new JLabel("1");
	public static JLabel h12 = new JLabel("2");
	public static JLabel h13 = new JLabel("3");
	public static JLabel h14 = new JLabel("4");
	public static JLabel h15 = new JLabel("5");
	public static JLabel h16 = new JLabel("6");
	
	public static JPanel pl2h1 = new JPanel();
	public static JPanel pl2h2 = new JPanel();
	public static JPanel pl2h3 = new JPanel();
	public static JPanel pl2h4 = new JPanel();
	public static JPanel pl2h5 = new JPanel();
	public static JPanel pl2h6 = new JPanel();
	
	public static JLabel k2 = new JLabel("0");
	public static JLabel h21 = new JLabel("1");
	public static JLabel h22 = new JLabel("2");
	public static JLabel h23 = new JLabel("3");
	public static JLabel h24 = new JLabel("4");
	public static JLabel h25 = new JLabel("5");
	public static JLabel h26 = new JLabel("6");
	
	static JPanel spacer = new JPanel();
	static JPanel hint = new JPanel();
	public static JLabel hmsg = new JLabel("Go to game menu to start a new game");
	public static JButton undo = new JButton("Undo");
	public static JButton go = new JButton("Yes!");
		
	public static JPanel Field() {
//***		build layouts
		// kalaha layout
		GridBagLayout klayout = new GridBagLayout();	
		klayout.columnWidths = new int [] {0};
		klayout.rowHeights = new int [] {0};
		klayout.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		klayout.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE }; 
		
		GridBagConstraints gbck = new GridBagConstraints();
		gbck.insets = new Insets(20, 20, 20, 20);
		gbck.gridwidth = 1;
		gbck.fill = GridBagConstraints.NONE;
		gbck.anchor = GridBagConstraints.CENTER;
		gbck.gridx = 0;
		gbck.gridy = 0;
		
		// hole layout similar to klayout
		GridBagLayout hlayout = new GridBagLayout();	
		hlayout.columnWidths = new int [] {0};
		hlayout.rowHeights = new int [] {0};
		hlayout.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		hlayout.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE }; 
		
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.insets = new Insets(20, 20, 20, 20);
		gbch.gridwidth = 1;
		gbch.fill = GridBagConstraints.NONE;
		gbch.anchor = GridBagConstraints.CENTER;
		gbch.gridx = 0;
		gbch.gridy = 0;
		
		// field layout
		GridBagLayout flayout = new GridBagLayout();
		flayout.columnWidths = new int [] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		flayout.rowHeights = new int [] { 0, 0, 0, 0, 0 };
		flayout.columnWeights = new double [] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE};
		flayout.rowWeights = new double [] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE};
		
		// button constraints
		GridBagConstraints gbcb1 = new GridBagConstraints();
		gbcb1.insets = new Insets ( 0, 0, 10, 0);
		gbcb1.gridwidth = 5;
		gbcb1.fill = GridBagConstraints.NONE
				;
		gbcb1.anchor = GridBagConstraints.CENTER;
		gbcb1.gridx = 0;
		gbcb1.gridy = 0;
		
		GridBagConstraints gbcb2 = new GridBagConstraints();
		gbcb2.insets = new Insets ( 0, 0, 10, 0);
		gbcb2.gridwidth = 5;
		gbcb2.fill = GridBagConstraints.NONE;
		gbcb2.anchor = GridBagConstraints.CENTER;
		gbcb2.gridx = 5;
		gbcb2.gridy = 0;
		
		// kalaha and holes
		//Player 2
		GridBagConstraints gbck2 = new GridBagConstraints(); // kalaha
		gbck2.insets = new Insets ( 5, 5, 5, 5 );
		gbck2.gridwidth = 2;
		gbck2.gridheight = 3;
		gbck2.fill = GridBagConstraints.BOTH;
		gbck2.anchor = GridBagConstraints.CENTER;
		gbck2.gridx = 0;
		gbck2.gridy = 1;
		
		// holes		
		GridBagConstraints gbcp2h1 = new GridBagConstraints();
		gbcp2h1.insets = new Insets ( 5, 5, 5, 5 );
		gbcp2h1.gridwidth = 1;
		gbcp2h1.gridheight = 1;
		gbcp2h1.fill = GridBagConstraints.BOTH;
		gbcp2h1.anchor = GridBagConstraints.CENTER;
		gbcp2h1.gridx = 7;
		gbcp2h1.gridy = 1;
		
		GridBagConstraints gbcp2h2 = new GridBagConstraints();
		gbcp2h2.insets = new Insets ( 5, 5, 5, 5 );
		gbcp2h2.gridwidth = 1;
		gbcp2h2.gridheight = 1;
		gbcp2h2.fill = GridBagConstraints.BOTH;
		gbcp2h2.anchor = GridBagConstraints.CENTER;
		gbcp2h2.gridx = 6;
		gbcp2h2.gridy = 1;
		
		GridBagConstraints gbcp2h3 = new GridBagConstraints();
		gbcp2h3.insets = new Insets ( 5, 5, 5, 5 );
		gbcp2h3.gridwidth = 1;
		gbcp2h3.gridheight = 1;
		gbcp2h3.fill = GridBagConstraints.BOTH;
		gbcp2h3.anchor = GridBagConstraints.CENTER;
		gbcp2h3.gridx = 5;
		gbcp2h3.gridy = 1;
		
		GridBagConstraints gbcp2h4 = new GridBagConstraints();
		gbcp2h4.insets = new Insets ( 5, 5, 5, 5 );
		gbcp2h4.gridwidth = 1;
		gbcp2h4.gridheight = 1;
		gbcp2h4.fill = GridBagConstraints.BOTH;
		gbcp2h4.anchor = GridBagConstraints.CENTER;
		gbcp2h4.gridx = 4;
		gbcp2h4.gridy = 1;
		
		GridBagConstraints gbcp2h5 = new GridBagConstraints();
		gbcp2h5.insets = new Insets ( 5, 5, 5, 5 );
		gbcp2h5.gridwidth = 1;
		gbcp2h5.gridheight = 1;
		gbcp2h5.fill = GridBagConstraints.BOTH;
		gbcp2h5.anchor = GridBagConstraints.CENTER;
		gbcp2h5.gridx = 3;
		gbcp2h5.gridy = 1;
		
		GridBagConstraints gbcp2h6 = new GridBagConstraints();
		gbcp2h6.insets = new Insets ( 5, 5, 5, 5 );
		gbcp2h6.gridwidth = 1;
		gbcp2h6.gridheight = 1;
		gbcp2h6.fill = GridBagConstraints.BOTH;
		gbcp2h6.anchor = GridBagConstraints.CENTER;
		gbcp2h6.gridx = 2;
		gbcp2h6.gridy = 1;
		
		pl2h1.setLayout(hlayout);
		pl2h1.setPreferredSize(hole);
		pl2h1.setBackground(color2);
		pl2h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl2h1.add(h21, gbch);
		
		pl2h2.setLayout(hlayout);
		pl2h2.setPreferredSize(hole);
		pl2h2.setBackground(color2);
		pl2h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl2h2.add(h22, gbch);
		
		pl2h3.setLayout(hlayout);
		pl2h3.setPreferredSize(hole);
		pl2h3.setBackground(color2);
		pl2h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl2h3.add(h23, gbch);
		
		pl2h4.setLayout(hlayout);
		pl2h4.setPreferredSize(hole);
		pl2h4.setBackground(color2);
		pl2h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl2h4.add(h24, gbch);
		
		pl2h5.setLayout(hlayout);
		pl2h5.setPreferredSize(hole);
		pl2h5.setBackground(color2);
		pl2h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl2h5.add(h25, gbch);
		
		pl2h6.setLayout(hlayout);
		pl2h6.setPreferredSize(hole);
		pl2h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl2h6.setBackground(color2);
		pl2h6.add(h26, gbch);
		
		// Player 1
		GridBagConstraints gbck1 = new GridBagConstraints();
		gbck1.insets = new Insets ( 5, 5, 5, 5 );
		gbck1.gridwidth = 2;
		gbck1.gridheight = 3;
		gbck1.fill = GridBagConstraints.BOTH;
		gbck1.anchor = GridBagConstraints.CENTER;
		gbck1.gridx = 8;
		gbck1.gridy = 1;
		
		GridBagConstraints gbcp1h1 = new GridBagConstraints();
		gbcp1h1.insets = new Insets ( 5, 5, 5, 5 );
		gbcp1h1.gridwidth = 1;
		gbcp1h1.gridheight = 1;
		gbcp1h1.fill = GridBagConstraints.BOTH;
		gbcp1h1.anchor = GridBagConstraints.CENTER;
		gbcp1h1.gridx = 2;
		gbcp1h1.gridy = 3;
		
		GridBagConstraints gbcp1h2 = new GridBagConstraints();
		gbcp1h2.insets = new Insets ( 5, 5, 5, 5 );
		gbcp1h2.gridwidth = 1;
		gbcp1h2.gridheight = 1;
		gbcp1h2.fill = GridBagConstraints.BOTH;
		gbcp1h2.anchor = GridBagConstraints.CENTER;
		gbcp1h2.gridx = 3;
		gbcp1h2.gridy = 3;
		
		GridBagConstraints gbcp1h3 = new GridBagConstraints();
		gbcp1h3.insets = new Insets ( 5, 5, 5, 5 );
		gbcp1h3.gridwidth = 1;
		gbcp1h3.gridheight = 1;
		gbcp1h3.fill = GridBagConstraints.BOTH;
		gbcp1h3.anchor = GridBagConstraints.CENTER;
		gbcp1h3.gridx = 4;
		gbcp1h3.gridy = 3;
		
		GridBagConstraints gbcp1h4 = new GridBagConstraints();
		gbcp1h4.insets = new Insets ( 5, 5, 5, 5 );
		gbcp1h4.gridwidth = 1;
		gbcp1h4.gridheight = 1;
		gbcp1h4.fill = GridBagConstraints.BOTH;
		gbcp1h4.anchor = GridBagConstraints.CENTER;
		gbcp1h4.gridx = 5;
		gbcp1h4.gridy = 3;
		
		GridBagConstraints gbcp1h5 = new GridBagConstraints();
		gbcp1h5.insets = new Insets ( 5, 5, 5, 5 );
		gbcp1h5.gridwidth = 1;
		gbcp1h5.gridheight = 1;
		gbcp1h5.fill = GridBagConstraints.BOTH;
		gbcp1h5.anchor = GridBagConstraints.CENTER;
		gbcp1h5.gridx = 6;
		gbcp1h5.gridy = 3;
		
		GridBagConstraints gbcp1h6 = new GridBagConstraints();
		gbcp1h6.insets = new Insets ( 5, 5, 5, 5 );
		gbcp1h6.gridwidth = 1;
		gbcp1h6.gridheight = 1;
		gbcp1h6.fill = GridBagConstraints.BOTH;
		gbcp1h6.anchor = GridBagConstraints.CENTER;
		gbcp1h6.gridx = 7;
		gbcp1h6.gridy = 3;
		
		//hint field
		GridBagConstraints gbchint = new GridBagConstraints();
		gbchint.insets = new Insets ( 5, 5, 5, 5 );
		gbchint.gridwidth = 10;
		gbchint.gridheight = 1;
		gbchint.fill = GridBagConstraints.BOTH;
		gbchint.anchor = GridBagConstraints.CENTER;
		gbchint.gridx = 0;
		gbchint.gridy = 4;
		
		pl1h1.setLayout(hlayout);
		pl1h1.setPreferredSize(hole);
		pl1h1.setBackground(color1);
		pl1h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl1h1.add(h11, gbch);
		
		pl1h2.setLayout(hlayout);
		pl1h2.setPreferredSize(hole);
		pl1h2.setBackground(color1);
		pl1h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl1h2.add(h12, gbch);
	
		pl1h3.setLayout(hlayout);
		pl1h3.setPreferredSize(hole);
		pl1h3.setBackground(color1);
		pl1h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl1h3.add(h13, gbch);
		
		pl1h4.setLayout(hlayout);
		pl1h4.setPreferredSize(hole);
		pl1h4.setBackground(color1);
		pl1h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl1h4.add(h14, gbch);
		
		pl1h5.setLayout(hlayout);
		pl1h5.setPreferredSize(hole);
		pl1h5.setBackground(color1);
		pl1h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl1h5.add(h15, gbch);
		
		pl1h6.setLayout(hlayout);
		pl1h6.setPreferredSize(hole);
		pl1h6.setBackground(color1);
		pl1h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		pl1h6.add(h16, gbch);
		
		//spacer
		GridBagConstraints gbcs = new GridBagConstraints();
		gbcs.insets = new Insets ( 5, 5, 5, 5 );
		gbcs.gridwidth = 6;
		gbcs.gridheight = 1;
		gbcs.fill = GridBagConstraints.BOTH;
		gbcs.anchor = GridBagConstraints.CENTER;
		gbcs.gridx = 2;
		gbcs.gridy = 2;
		
		// disable stuff per default
		undo.setEnabled(false);
		go.setEnabled(false);	
		kalaha1.setEnabled(false);
		kalaha2.setEnabled(false);		
		pl1h1.setEnabled(false);
		pl1h2.setEnabled(false);
		pl1h3.setEnabled(false);
		pl1h4.setEnabled(false);
		pl1h5.setEnabled(false);
		pl1h6.setEnabled(false);		
		pl2h1.setEnabled(false);
		pl2h2.setEnabled(false);
		pl2h3.setEnabled(false);
		pl2h4.setEnabled(false);
		pl2h5.setEnabled(false);
		pl2h6.setEnabled(false);
		
				
//***		game field shows holes and both kalaha
//		field.setBackground(blue);
		field.setPreferredSize(fieldsize);
		field.setMinimumSize(fieldsize);
		field.setLayout(flayout);
		
//***		decorating kalahas and holes
		// Player 1
		kalaha1.setLayout(klayout);
		kalaha1.setPreferredSize(kalaha);
		kalaha1.setBackground(color1);
		kalaha1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		kalaha1.add(k1, gbck);
		
		kalaha2.setLayout(klayout);
		kalaha2.setPreferredSize(kalaha);
		kalaha2.setBackground(color2);
		kalaha2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		kalaha2.add(k2, gbck);
		
//***		add actions to elements
		undo.setMnemonic(KeyEvent.VK_C);
		undo.addActionListener(Gameplay.undo);
		go.setMnemonic(KeyEvent.VK_C);
		go.addActionListener(Gameplay.yes);
			
//***		build field
		field.add(undo, gbcb1);
		field.add(go, gbcb2);
		
		field.add(kalaha2, gbck2);
		field.add(pl2h1, gbcp2h1);
		field.add(pl2h2, gbcp2h2);
		field.add(pl2h3, gbcp2h3);
		field.add(pl2h4, gbcp2h4);
		field.add(pl2h5, gbcp2h5);
		field.add(pl2h6, gbcp2h6);
		
		field.add(spacer, gbcs);
		
		field.add(kalaha1, gbck1);
		field.add(pl1h1, gbcp1h1);
		field.add(pl1h2, gbcp1h2);
		field.add(pl1h3, gbcp1h3);
		field.add(pl1h4, gbcp1h4);
		field.add(pl1h5, gbcp1h5);
		field.add(pl1h6, gbcp1h6);
		
		hint.add(hmsg);
		field.add(hint, gbchint);
				
		return field;
	}

}
