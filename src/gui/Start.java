package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.StandardActions;

public class Start extends JFrame {
	
	// initializing main variables: size and color
	private Dimension winsize = new Dimension(400, 200);
	
	private Color green = new Color (0, 250, 0);
	private Color red = new Color (250, 0, 0);
	private Color blue = new Color (0, 0, 250);
	private Color purple = new Color (100, 0, 100);
	
	// initialize main parts
	JFrame start = new JFrame("Start new game");
	JPanel container = new JPanel();
	JLabel player1 = new JLabel("Player 1:");
	JLabel player2 = new JLabel("Player 2:");
	JLabel human = new JLabel ("Human");
	JLabel human2 = new JLabel("Human");
	JLabel computer = new JLabel("Computer");
	JLabel computer2 = new JLabel ("Computer");
	JLabel name = new JLabel("Name:");
	JLabel name_ = new JLabel("Name:");
	
	public static JTextField name1 = new JTextField(25);
	public static JTextField name2 = new JTextField(25);
	public static JCheckBox pl1 = new JCheckBox();
	public static JCheckBox pl2 = new JCheckBox();
	public static JCheckBox c1 = new JCheckBox();
	public static JCheckBox c2 = new JCheckBox();
	public static JButton play = new JButton("Play");
	
	public void Start() {
		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		start.setPreferredSize(winsize);
		start.setIconImage(new ImageIcon("bin/gui/kalaha.gif").getImage());
		start.setSize(winsize);
		start.setLocationRelativeTo(null);
		start.setResizable(false);
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		layout.rowHeights = new int [] {0, 0, 0, 0, 0};
		layout.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		layout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE }; 
		
		container.setPreferredSize(winsize);
		container.setLayout(layout);
//		container.setBackground(green);
		
		player1.setForeground(red);
		player2.setForeground(blue);
		
		// Player 1
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(10, 5, 0, 0); // ( top, left, bottom, right )
		gbc_player1.gridwidth = 3;
		gbc_player1.fill = GridBagConstraints.NONE;
		gbc_player1.anchor = GridBagConstraints.LINE_START;
		gbc_player1.gridx = 0;
		gbc_player1.gridy = 0;		
		
		// Player 1 Human check box
		GridBagConstraints gbc_pl1 = new GridBagConstraints();
		gbc_pl1.insets = new Insets(10, 20, 0, 0);
		gbc_pl1.gridwidth = 0;
		gbc_pl1.anchor = GridBagConstraints.LINE_START;
		gbc_pl1.gridx = 3;
		gbc_pl1.gridy = 0;
		
		// Player 1 human label
		GridBagConstraints gbc_human1 = new GridBagConstraints();
		gbc_human1.insets = new Insets (10, 0, 0, 0);
		gbc_human1.gridwidth = 1;
		gbc_human1.anchor = GridBagConstraints.LINE_START;
		gbc_human1.gridx = 4;
		gbc_human1.gridy = 0;
		
		// Player 1 computer check box
		GridBagConstraints cp1 = new GridBagConstraints();
		cp1.insets =new Insets( 10, 15, 0, 0);
		cp1.gridwidth = 1;
		cp1.anchor = GridBagConstraints.LINE_START;
		cp1.gridx = 6;
		cp1.gridy = 0;
		
		// Player 1 computer label
		GridBagConstraints cpname = new GridBagConstraints();
		cpname.insets = new Insets(10, 0, 0, 0);
		cpname.gridwidth = 1;
		cpname.anchor = GridBagConstraints.LINE_START;
		cpname.gridx = 7;
		cpname.gridy = 0;
		
		// Player 1 row 2 Name:
		GridBagConstraints gbc_name1 = new GridBagConstraints();
		gbc_name1.insets = new Insets (5, 10, 0, 0);
		gbc_name1.gridwidth = 2;
		gbc_name1.anchor = GridBagConstraints.LINE_START;
		gbc_name1.gridx = 0;
		gbc_name1.gridy = 1;
		
		// Player 1 row 2 text field
		GridBagConstraints txt1 = new GridBagConstraints();
		txt1.insets = new Insets( 5, 5, 0, 0);
		txt1.gridwidth = 6;
		txt1.fill = GridBagConstraints.NONE;
		txt1.anchor = GridBagConstraints.LINE_START;
		txt1.gridx = 2;
		txt1.gridy = 1;
		
		// Player 2
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(20, 5, 0, 0); // ( top, left, bottom, right )
		gbc_player2.gridwidth = 2;
		gbc_player2.fill = GridBagConstraints.NONE;
		gbc_player2.anchor = GridBagConstraints.LINE_START;
		gbc_player2.gridx = 0;
		gbc_player2.gridy = 2;
		
		// Player 2 human check box
		GridBagConstraints gbc_pl2 = new GridBagConstraints();
		gbc_pl2.insets = new Insets(20, 20, 0, 0);
		gbc_pl2.gridwidth = 1;
		gbc_pl2.anchor = GridBagConstraints.LINE_START;
		gbc_pl2.gridx = 3;
		gbc_pl2.gridy = 2;
		
		// Player 2 human label
		GridBagConstraints gbc_human2 = new GridBagConstraints();
		gbc_human2.insets = new Insets (20, 5, 0, 0);
		gbc_human2.gridwidth = 1;
		gbc_human2.anchor = GridBagConstraints.LINE_START;
		gbc_human2.gridx = 4;
		gbc_human2.gridy = 2;
		
		// Player 2 computer check box
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.insets =new Insets( 20, 15, 0, 0);
		cp2.gridwidth = 1;
		cp2.anchor = GridBagConstraints.LINE_START;
		cp2.gridx = 6;
		cp2.gridy = 2;
		
		// Player 2 computer label
		GridBagConstraints cpname2 = new GridBagConstraints();
		cpname2.insets = new Insets(20, 5, 0, 0);
		cpname2.gridwidth = 1;
		cpname2.anchor = GridBagConstraints.LINE_START;
		cpname2.gridx = 7;
		cpname2.gridy = 2;
		
		// Player 2 row 2 Name:
		GridBagConstraints gbc_name2 = new GridBagConstraints();
		gbc_name2.insets = new Insets (5, 5, 0, 0);
		gbc_name2.gridwidth = 2;
		gbc_name2.anchor = GridBagConstraints.LINE_START;
		gbc_name2.gridx = 0;
		gbc_name2.gridy = 3;
		
		// Player 2 row 2 text field
		GridBagConstraints txt2 = new GridBagConstraints();
		txt2.insets = new Insets( 5, 5, 0, 0);
		txt2.gridwidth = 6;
		txt2.fill = GridBagConstraints.NONE;
		txt2.anchor = GridBagConstraints.LINE_START;
		txt2.gridx = 2;
		txt2.gridy = 3;
		
		//setting default look for the elements
		pl1.setSelected(true);
		name1.setText("Player 1");
		
		c2.setSelected(true);
		name2.setText("Computer");
		name2.setEnabled(false);
		
		//setting element actions
		c1.addActionListener(StandardActions.choosec1);
		pl1.addActionListener(StandardActions.choosep1);
		c2.addActionListener(StandardActions.choosec2);
		pl2.addActionListener(StandardActions.choosep2);
		play.addActionListener(StandardActions.play);
			
		GridBagConstraints button = new GridBagConstraints();
		button.insets = new Insets( 20, 5, 5, 5);
		button.gridwidth = 8;
		button.fill = GridBagConstraints.NONE;
		button.anchor = GridBagConstraints.PAGE_END;
		button.gridx = 0;
		button.gridy = 4;	
		
		container.add(player1, gbc_player1);
		container.add(human, gbc_human1);
		container.add(pl1, gbc_pl1);
		container.add(computer, cpname);
		container.add(c1, cp1);
		container.add(name, gbc_name1);
		container.add(name1, txt1);
		container.add(player2, gbc_player2);
		container.add(human2, gbc_human2);
		container.add(pl2, gbc_pl2);
		container.add(computer2, cpname2);
		container.add(c2, cp2);
		container.add(name_, gbc_name2);
		container.add(name2, txt2);
		container.add(play, button);
		
		start.add(container);
		
		start.pack();
		start.setVisible(true);	
	}
	public void showWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Start();
			}
		});
	}
}
