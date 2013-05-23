package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import actions.StandardActions;

public class Game extends JFrame{
	
	// initializing main variables: size and color
	private Dimension winsize = new Dimension(800, 600);
	
	private Color green = new Color (0, 250, 0);
	private Color red = new Color (250, 0, 0);
	private Color blue = new Color (0, 0, 250);
	private Color purple = new Color (100, 0, 100);
	
	// initialize main parts	
	JFrame window = new JFrame("Kalaha");
	JMenuBar menubar = new JMenuBar();
	JMenu game = new JMenu("Game");
	JMenuItem newgame = new JMenuItem("New game");
	JMenuItem help = new JMenuItem("Help");
	JMenuItem exit = new JMenuItem ("Exit");
	
	JPanel container = new JPanel();

	public void Game() {
//***		window properties
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(winsize);
		window.setIconImage(new ImageIcon("bin/gui/kalaha.gif").getImage());
		window.setSize(winsize);
		window.setLocationRelativeTo(null);
		
//***		build menu bar		
		menubar.setPreferredSize(new Dimension(800, 20));
		menubar.setOpaque(true);
		
		exit.setMnemonic(KeyEvent.VK_C);
		exit.setToolTipText("Exit application");
		exit.addActionListener(StandardActions.exit);
		
		help.setMnemonic(KeyEvent.VK_C);
		help.setToolTipText("Get help");
		help.addActionListener(StandardActions.help);
		
		newgame.setMnemonic(KeyEvent.VK_C);
		newgame.setToolTipText("Start a new game of kalaha");
		newgame.addActionListener(StandardActions.newgame);
		menubar.add(game);
		game.add(newgame);
		game.add(help);
		game.addSeparator();
		game.add(exit);
		
//***		main container holds all elements	
		container.setMinimumSize(winsize);
//		container.setBackground(purple);

//***		build field
		container.add(InfoField.Info());
		container.add(GameBoard.Field());
		
//***		build window	
		window.setJMenuBar(menubar);
		window.add(container);
		window.pack();
		window.setVisible(true);
	}
	
	public void showWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Game();
			}
		});
	}
}
