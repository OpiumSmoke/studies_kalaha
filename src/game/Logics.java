package game;

import gui.GameBoard;
import gui.InfoField;
import gui.Start;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import actions.Gameplay;

public class Logics {
	private static Color red = new Color (250, 0, 0);
	private static Color blue = new Color (0, 0, 250);
	static private Color color1 = new Color (205, 38, 38);
	static private Color color2 = new Color (24, 116, 205);
	public static double coin;
	private static int turn1;
	private static int turn2;
	public static Kalaha game;
	public static Player player1;
	public static Player player2;
	public static int [] movearray = new int [13];
	public static int [] movecopy = new int [13];
	public static boolean win = false;
	public boolean empty = false;
	public static int [] boardcopy = new int [14];
	
	public static Kalaha newGame () {
		player1 = new Player();
		player2 = new Player();
		
		int [] field = { 3, 3, 3, 3, 3, 3, 0 };
//		int [] testfield = { 0, 0, 0, 0, 0, 0, 2 }; 
		//testing
//		int [] newfield = { 1, 2, 3, 4 , 5, 6 };
//		int [] newfield1 = { 10, 20, 30, 40, 50, 60 };
		
		coinToss();
//		player1.setPlayer("Nicky", 1, turn1, newfield);
//		player1.setPlayer("Ulli", 2, turn2, newfield1);
		
		player1.setPlayer(Start.name1.getText(), 1, turn1, field);
		player2.setPlayer(Start.name2.getText(), 2, turn2, field);
				
		game = new Kalaha(player1, player2);
//		game.currentturn = currentturn;
		
		// test output
		System.out.println("New game started");
		System.out.println("Field is set\n" + Arrays.toString(game.getStatus()));
		System.out.println("P1: " + player1.getName() + " vs P2: " + player2.getName() );
		System.out.println("P1 starts " + player1.getTurn()+ " P2 starts " + player2.getTurn());
		System.out.println("P1: " + Arrays.toString(player1.getField()));
		System.out.println("P2: " + Arrays.toString(player2.getField()));
			
		showBoard();
		
		System.out.println("P1's Kalaha has " + player1.getKalaha());
		System.out.println("P2's Kalaha has " + player2.getKalaha());
		
		game.setCurrentTurn(0);
				
		return game;
	}	

	/**
	 * determines whose turn it is. Initialize after getCurrentTurn()
	 */
	public static void whoseTurn(int currentturn) {
		System.out.println("Initialize whoseTurn()");
		
		if (Logics.game.player1.getTurn() == currentturn) {
			System.out.println("P1's turn (" + player1.getTurn()+ ")");
		} else if (Logics.game.player2.getTurn() == currentturn) {
			System.out.println("P2's turn (" + player2.getTurn()+ ")");
		}
	}
	
	/**
	 * gives player their turn and sets the field clickable.
	 * 
	 * @param player
	 * @param currentturn
	 */
	public static void giveTurn(Player player1, Player player2,  int currentturn) {
		System.out.println("Initialize giveTurn");
		clearSelections();
		if (player1.getTurn() == currentturn) {
			InfoField.message.setForeground(red);
			InfoField.message.setText(player1.getName() + ",   your turn!");
			System.out.println("P1 gets turn");
			writeMoveArray(player1);
		} else if (player2.getTurn() == currentturn) {
			InfoField.message.setForeground(blue);
			InfoField.message.setText(player2.getName() + ",   your turn!");
			System.out.println("P2 gets turn");
			writeMoveArray(player2);
		}
		enableFields(player1, player2, currentturn);
	}
	/**
	 * makes a move, filling move array.
	 * make move also accepts last made move and writes it to player fields.
	 * @param pitnumber is an integer indicating which pit was clicked.
	 * it can be from 0 to 5. it is used to address the array element
	 * from where it should be read.
	 * 
	 */
	public static void makeMove(JLabel pit, int pitnumber) {
		writeMoveOnField(movecopy);
		
		movecopy = movearray;
		boardcopy = game.getStatus();
		int tmp = movecopy[pitnumber];
		movecopy[pitnumber] = 0;		
		
		System.out.println("tmp: " + tmp + " movecopy[pitnumber]: " + movecopy[pitnumber]);
		System.out.println("Board copied: " + Arrays.toString(boardcopy));
		
		if ( tmp != 0 ) {
			while ( tmp > 0 ) {
				if ( pitnumber >= 12) pitnumber = 0;
				else pitnumber++;
	
				movecopy[pitnumber]++;
				tmp--;
			}
			showMove();
			System.out.println("Move made: " + Arrays.toString(movecopy));
			GameBoard.undo.setEnabled(true);
			
			if ( gameWon(game.player1, game.player1) == false ) {
				game.setCurrentTurn(game.currentturn);
				giveTurn(game.player1, game.player1, game.currentturn);
			}
		} else {
			GameBoard.hmsg.setText("You have to empty a full pit!");
			System.out.println("Pit is empty!");		
		}
	}
	/**
	 * shows move and writes a board copy to use
	 * if the move wasn't undone.
	 */
	public static void showMove() {
		if (game.player1.getTurn() == game.getCurrentTurn()) {
			GameBoard.h11.setText(Integer.toString(movecopy[0]));
			GameBoard.h12.setText(Integer.toString(movecopy[1]));
			GameBoard.h13.setText(Integer.toString(movecopy[2]));
			GameBoard.h14.setText(Integer.toString(movecopy[3]));
			GameBoard.h15.setText(Integer.toString(movecopy[4]));
			GameBoard.h16.setText(Integer.toString(movecopy[5]));
			GameBoard.k1.setText(Integer.toString(movecopy[6]));
			GameBoard.h21.setText(Integer.toString(movecopy[7]));
			GameBoard.h22.setText(Integer.toString(movecopy[8]));
			GameBoard.h23.setText(Integer.toString(movecopy[9]));
			GameBoard.h24.setText(Integer.toString(movecopy[10]));
			GameBoard.h25.setText(Integer.toString(movecopy[11]));
			GameBoard.h26.setText(Integer.toString(movecopy[12]));
			boardcopy[0] = movecopy[0];
			boardcopy[1] = movecopy[1];
			boardcopy[2] = movecopy[2];
			boardcopy[3] = movecopy[3];
			boardcopy[4] = movecopy[4];
			boardcopy[5] = movecopy[5];
			boardcopy[6] = movecopy[6];
			boardcopy[7] = movecopy[7];
			boardcopy[8] = movecopy[8];
			boardcopy[9] = movecopy[9];
			boardcopy[10] = movecopy[10];
			boardcopy[11] = movecopy[11];
			boardcopy[12] = movecopy[12];
		} else if (game.player2.getTurn() == game.getCurrentTurn()) {
			GameBoard.h21.setText(Integer.toString(movecopy[0]));
			GameBoard.h22.setText(Integer.toString(movecopy[1]));
			GameBoard.h23.setText(Integer.toString(movecopy[2]));
			GameBoard.h24.setText(Integer.toString(movecopy[3]));
			GameBoard.h25.setText(Integer.toString(movecopy[4]));
			GameBoard.h26.setText(Integer.toString(movecopy[5]));
			GameBoard.k2.setText(Integer.toString(movecopy[6]));
			GameBoard.h11.setText(Integer.toString(movecopy[7]));
			GameBoard.h12.setText(Integer.toString(movecopy[8]));
			GameBoard.h13.setText(Integer.toString(movecopy[9]));
			GameBoard.h14.setText(Integer.toString(movecopy[10]));
			GameBoard.h15.setText(Integer.toString(movecopy[11]));
			GameBoard.h16.setText(Integer.toString(movecopy[12]));
			boardcopy[6] = movecopy[0];
			boardcopy[7] = movecopy[1];
			boardcopy[8] = movecopy[2];
			boardcopy[9] = movecopy[3];
			boardcopy[19] = movecopy[4];
			boardcopy[11] = movecopy[5];
			boardcopy[12] = movecopy[6];
			boardcopy[0] = movecopy[7];
			boardcopy[1] = movecopy[8];
			boardcopy[2] = movecopy[9];
			boardcopy[3] = movecopy[10];
			boardcopy[4] = movecopy[11];
			boardcopy[5] = movecopy[12];
		}
	}
	
	public void captureStones() {
		//TODO and this too!
	}
	/**
	 * checks opposite pit has stones in it.
	 * Triggers captureStones() method
	 * opposites are: 
	 * 0 - 5
	 * 1 - 4
	 * 2 - 3
	 * 3 - 2
	 * 4 - 1
	 * 5 - 0
	 * field 6 is the players' kalaha and should not be compared.
	 */
	public boolean isOppositeFull(JLabel pit) {
		if (pit == GameBoard.h11) {
			//TODO: blaaaah, write it! has to check stuff
		}
		return empty;
	}
	
	public static void undoMove() {
		game.board = boardcopy;
		//TODO eventually, if undo should be enabled in next turn, change to !=
		
		if (game.player1.getTurn() == game.getCurrentTurn()) {
			int [] field = { movecopy[0],
					boardcopy[1],
					boardcopy[2],
					boardcopy[3],
					boardcopy[4],
					boardcopy[5],
					boardcopy[6]};
			game.player1.setField(field);
			game.player2.field[0] = movecopy[7];
			game.player2.field[1] = boardcopy[8];
			game.player2.field[2] = boardcopy[9];
			game.player2.field[3] = boardcopy[10];
			game.player2.field[4] = boardcopy[11];
			game.player2.field[5] = boardcopy[12];
		} else if (game.player2.getTurn() == game.getCurrentTurn()) {
			int [] field = { movecopy[0],
					boardcopy[1],
					boardcopy[2],
					boardcopy[3],
					boardcopy[4],
					boardcopy[5],
					boardcopy[6]};
			game.player2.setField(field);
			game.player1.field[0] = movecopy[7];
			game.player1.field[1] = boardcopy[8];
			game.player1.field[2] = boardcopy[9];
			game.player1.field[3] = boardcopy[10];
			game.player1.field[4] = boardcopy[11];
			game.player1.field[5] = boardcopy[12];
		}
		game.setStatus(game.player1.field, game.player2.field);
	}
	
	public static void writeMoveOnField(int[] movecopy) {
		System.out.println("Writing made move to field");
		
	}
	
	public static int[] writeMoveArray(Player player) {
		int [] tmp = game.getStatus();
		if (player.getIdentity() == 1) {
			movearray[0] = tmp[0];
			movearray[1] = tmp[1];
			movearray[2] = tmp[2];
			movearray[3] = tmp[3];
			movearray[4] = tmp[4];
			movearray[5] = tmp[5];
			movearray[6] = tmp[6]; // p1 kalaha
			movearray[7] = tmp[7]; 
			movearray[8] = tmp[8];
			movearray[9] = tmp[9];
			movearray[10] = tmp[10];
			movearray[11] = tmp[11];
			movearray[12] = tmp[12];
		} else if (player.getIdentity() == 2) {
			movearray[0] = tmp[7];
			movearray[1] = tmp[8];
			movearray[2] = tmp[9];
			movearray[3] = tmp[10];
			movearray[4] = tmp[11];
			movearray[5] = tmp[12];
			movearray[6] = tmp[13]; // p2 kalaha
			movearray[7] = tmp[0];
			movearray[8] = tmp[1];
			movearray[9] = tmp[2];
			movearray[10] = tmp[3];
			movearray[11] = tmp[4];
			movearray[12] = tmp[5];
		}
		System.out.println("Move array: " + Arrays.toString(movearray));
		return movearray;
	}
	/**
	 * this one checks if one of the players has no more available seeds
	 * it also shows who the winner is
	 */
	public static boolean gameWon(Player player1, Player player2) {
		int [] tmp1 = player1.getField();
		int [] tmp2 = player2.getField();
		if (tmp1 [0] == 0 &&
				tmp1[1] == 0 &&
				tmp1[2] == 0 &&
				tmp1[3] == 0 &&
				tmp1[4] == 0 &&
				tmp1[5] == 0) {
			if (player1.getIdentity() == 1) {
				System.out.println("P2 won with " + player2.getKalaha());
				InfoField.message.setForeground(blue);
				GameBoard.hmsg.setForeground(blue);
				InfoField.message.setText("Congratulations,   " + player2.getName() +
							"!   You've won the game!");
				GameBoard.hmsg.setText(player2.getName() + " won with " +
							Integer.toString(player2.field[6]) + " stines in their Kalaha!");
			} else if (player1.getIdentity() == 2) {
				System.out.println("P1 won with " + player1.getKalaha());
				InfoField.message.setForeground(red);
				GameBoard.hmsg.setForeground(red);
				InfoField.message.setText("Congratulations,   " + player1.getName() +
							"!   You've won the game!");
				GameBoard.hmsg.setText(player1.getName() + " won with " +
						Integer.toString(player1.field[6]) + " stines in their Kalaha!");
			}
		} else 	if (tmp2 [0] == 0 &&
					tmp2[1] == 0 &&
					tmp2[2] == 0 &&
					tmp2[3] == 0 &&
					tmp2[4] == 0 &&
					tmp2[5] == 0) {
				if (player2.getIdentity() == 1) {
					System.out.println("P2 won with " + player2.getKalaha());
					InfoField.message.setForeground(blue);
					GameBoard.hmsg.setForeground(blue);
					InfoField.message.setText("Congratulations,   " + player2.getName() +
								"!   You've won the game!");
					GameBoard.hmsg.setText(player2.getName() + " won with " +
							Integer.toString(player2.field[6]) + " stines in their Kalaha!");
				} else if (player2.getIdentity() == 2) {
					System.out.println("P1 won with " + player1.getKalaha());
					InfoField.message.setForeground(red);
					GameBoard.hmsg.setForeground(red);
					InfoField.message.setText("Congratulations,   " + player1.getName() +
								"!   You've won the game!");
					GameBoard.hmsg.setText(player1.getName() + " won with " +
							Integer.toString(player1.field[6]) + " stines in their Kalaha!");
				}
			win = true;
		} else {
			win = false;
		}
		return win;
	}
	/**
	 * sets all labels, actually. As test, prints both player field arrays
	 */
	public static void showBoard() {
		int [] tmp = game.getStatus();
		GameBoard.h11.setText(Integer.toString(tmp[0]));
		GameBoard.h12.setText(Integer.toString(tmp[1]));
		GameBoard.h13.setText(Integer.toString(tmp[2]));
		GameBoard.h14.setText(Integer.toString(tmp[3]));
		GameBoard.h15.setText(Integer.toString(tmp[4]));
		GameBoard.h16.setText(Integer.toString(tmp[5]));
		GameBoard.k1.setText(Integer.toString(tmp[6]));
		GameBoard.h21.setText(Integer.toString(tmp[7]));
		GameBoard.h22.setText(Integer.toString(tmp[8]));
		GameBoard.h23.setText(Integer.toString(tmp[9]));
		GameBoard.h24.setText(Integer.toString(tmp[10]));
		GameBoard.h25.setText(Integer.toString(tmp[11]));
		GameBoard.h26.setText(Integer.toString(tmp[12]));
		GameBoard.k2.setText(Integer.toString(tmp[13]));
		System.out.println("P1's board: " + Arrays.toString(player1.getField()));
		System.out.println("P2's board: " + Arrays.toString(player2.getField()));
	}
	
	public void setPlayerFields (int [] currentfield) {
		game.getStatus();
		
		int [] p1field = new int [7];
		int [] p2field = new int [7];

		
		player1.setField(p1field);
		player2.setField(p2field);
	}
	
	/**
	 * choose who starts
	 */
	public static void coinToss () {
		coin = (int) (Math.random() + .5);
		System.out.println("Coin toss!");
		
		if (coin == 0) {
			InfoField.message.setForeground(red);
			InfoField.message.setText("Heads!   " + 
										InfoField.player1.getText() +
										"   starts first!");
			turn1 = 1;
			turn2 = 2;
			System.out.println("Heads!");
		} else {
			InfoField.message.setForeground(blue);
			InfoField.message.setText("Tails!   " + 
										InfoField.player2.getText() +
										"   starts first!");
			turn2 = 1;
			turn1 = 2;
			System.out.println("Tails!");
		}
	}
	/**
	 * clears all selected JPanels on field for the new move
	 */
	public static void clearSelections() {
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
		
		GameBoard.hmsg.setForeground(new Color( 0, 0, 0 ));
		GameBoard.hmsg.setText("Choose a field by clicking on it");

		GameBoard.go.setEnabled(false);
	}
	/**
	 * enables field for player whose turn it is
	 */
	public static void enableFields(Player player1, Player player2, int currentturn) {
		System.out.println("enableFields initialized. Turn: " + currentturn);
		if (player1.getTurn() == currentturn) {
			System.out.println(" Player 1 turn is current");
			GameBoard.pl1h1.setEnabled(true);
			GameBoard.pl1h2.setEnabled(true);
			GameBoard.pl1h3.setEnabled(true);
			GameBoard.pl1h4.setEnabled(true);
			GameBoard.pl1h5.setEnabled(true);
			GameBoard.pl1h6.setEnabled(true);
			GameBoard.pl2h1.setEnabled(false);
			GameBoard.pl2h2.setEnabled(false);
			GameBoard.pl2h3.setEnabled(false);
			GameBoard.pl2h4.setEnabled(false);
			GameBoard.pl2h5.setEnabled(false);
			GameBoard.pl2h6.setEnabled(false);
			System.out.println("P1 fields enabled");
		} else if (player2.getTurn() == currentturn) {
			System.out.println(" Player 2 turn is current");
			GameBoard.pl1h1.setEnabled(false);
			GameBoard.pl1h2.setEnabled(false);
			GameBoard.pl1h3.setEnabled(false);
			GameBoard.pl1h4.setEnabled(false);
			GameBoard.pl1h5.setEnabled(false);
			GameBoard.pl1h6.setEnabled(false);
			GameBoard.pl2h1.setEnabled(true);
			GameBoard.pl2h2.setEnabled(true);
			GameBoard.pl2h3.setEnabled(true);
			GameBoard.pl2h4.setEnabled(true);
			GameBoard.pl2h5.setEnabled(true);
			GameBoard.pl2h6.setEnabled(true);
			System.out.println("P2 fields enabled");				
		}
	}
	
	public static void playGame(Kalaha game) {
//		while (gameWon(game.player1, game.player2) == false) {
//			game.setCurrentTurn(game.currentturn);
			whoseTurn(game.currentturn);
			giveTurn(game.player1, game.player2, game.currentturn);
//		}
	}
}