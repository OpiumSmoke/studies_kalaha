package game;

import gui.GameBoard;
import gui.InfoField;
import gui.Start;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Logics {
	private static Color red = new Color (250, 0, 0);
	private static Color blue = new Color (0, 0, 250);
	static private Color color1 = new Color (205, 38, 38);
	static private Color color2 = new Color (24, 116, 205);
	public static double coin;
	public static Kalaha game;
	public Player player1;
	public Player player2;
	public Player activePlayer;
	public static int [] movearray = new int [13];
	public static boolean win = false;
	public boolean full = false;
	public static int [] boardcopy = new int [14];
	
	public Kalaha newGame () {
		this.player1 = new Player();
		this.player2 = new Player();
		this.activePlayer = new Player();
		
		int [] board = { 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 0 };
//		int [] board = { 0, 0, 0, 0, 0, 10, 1, 1, 1, 1, 1, 1, 10 };
				
		player1.setPlayer(Start.name1.getText(), 1);
		player2.setPlayer(Start.name2.getText(), 2);
				
		game = new Kalaha(player1, player2, board);
		
		game.setActivePlayer(game.coinToss());
		enableFields(game.player1, game.player2, Kalaha.activePlayer);
		writeMoveArray(Kalaha.activePlayer);
		
		// test output
		System.out.println("New game started");
//		System.out.println("Field is set\n" + Arrays.toString(Kalaha.getStatus()));
//		System.out.println("P1: " + player1.getName() + " vs P2: " + player2.getName() );
//		System.out.println("P1 starts " + player1.getTurn()+ " P2 starts " + player2.getTurn());
//		System.out.println("P1: " + Arrays.toString(player1.getField()));
//		System.out.println("P2: " + Arrays.toString(player2.getField()));
			
		showBoard();
		
//		System.out.println("P1's Kalaha has " + player1.getKalaha());
//		System.out.println("P2's Kalaha has " + player2.getKalaha());
		
//		game.setActivePlayer(activePlayer);
				
		return game;
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
//		writeMoveOnField(Kalaha.player1, Kalaha.player2, Kalaha.currentturn, movearray);
		
//		boardcopy = Kalaha.getStatus();
		int tmp = movearray[pitnumber];
		movearray[pitnumber] = 0;		
		
		System.out.println("tmp: " + tmp + " movearray[pitnumber]: " + movearray[pitnumber]);
//		System.out.println("Board copied: " + Arrays.toString(boardcopy));
	
		if ( tmp != 0 ) {
			while ( tmp > 0 ) {
				if ( pitnumber >= 12) pitnumber = 0;
				else pitnumber++;
	
				movearray[pitnumber]++;
				tmp--;
												
				/*
				 * gives a player an extra turn if the last seed landed into kalaha
				 */
				if ( Kalaha.activePlayer == game.player1  && tmp == 0 && pitnumber == 6) {
					System.out.println("P1: Last seed into own kalaha!");
					showMove(game.player1);
					clearSelections();
					game.setActivePlayer(game.player1);
					System.out.println("Active player is " + Kalaha.activePlayer.getName());
					InfoField.message.setText("You get an extra turn!");					
				} else if ( Kalaha.activePlayer ==  game.player2 && tmp == 0 && pitnumber == 6) {
					System.out.println("P2: Last seed into own kalaha!");
					showMove(game.player2);
					clearSelections();
					game.setActivePlayer(game.player2);
					System.out.println("Active player is " + Kalaha.activePlayer.getName());
					InfoField.message.setText("You get an extra turn!");
				} else if ( (Kalaha.activePlayer == game.player1 ||
						Kalaha.activePlayer == game.player2 ) && tmp == 0 && pitnumber !=6 ){			
					/*
					 * try to capture stones
					 */
					if ( Kalaha.activePlayer == game.player1 ) {
						if ( pitnumber == 0 && Kalaha.board[0] == 0 && Kalaha.board[12] != 0 ) {
							movearray[6] = movearray[6] + movearray[0] + movearray[12];
							movearray[0] = 0;
							movearray[12] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 1 && Kalaha.board[1] == 0 && Kalaha.board[11] != 0 ) {
							movearray[6] = movearray[6] + movearray[1] + movearray[11];
							movearray[1] = 0;
							movearray[11] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 2 && Kalaha.board[2] == 0 && Kalaha.board[10] != 0 ) {
							movearray[6] = movearray[6] + movearray[2] + movearray[10];
							movearray[2] = 0;
							movearray[10] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 3 && Kalaha.board[3] == 0 && Kalaha.board[9] != 0 ) {
							movearray[6] = movearray[6] + movearray[3] + movearray[9];
							movearray[3] = 0;
							movearray[9] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 4 && Kalaha.board[4] == 0 && Kalaha.board[8] != 0 ) {
							movearray[6] = movearray[6] + movearray[4] + movearray[8];
							movearray[4] = 0;
							movearray[8] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 5 && Kalaha.board[5] == 0 && Kalaha.board[7] != 0 ) {
							movearray[6] = movearray[6] + movearray[5] + movearray[7];
							movearray[5] = 0;
							movearray[7] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						}
					} else if ( Kalaha.activePlayer == game.player2 ) {
						if ( pitnumber == 0 && Kalaha.board[7] == 0 && Kalaha.board[5] != 0 ) {
							movearray[6] = movearray[6] + movearray[0] + movearray[12];
							movearray[0] = 0;
							movearray[12] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 1 && Kalaha.board[8] == 0 && Kalaha.board[4] != 0 ) {
							movearray[6] = movearray[6] + movearray[1] + movearray[11];
							movearray[1] = 0;
							movearray[11] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 2 && Kalaha.board[9] == 0 && Kalaha.board[3] != 0 ) {
							movearray[6] = movearray[6] + movearray[2] + movearray[10];
							movearray[2] = 0;
							movearray[10] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 3 && Kalaha.board[10] == 0 && Kalaha.board[2] != 0 ) {
							movearray[6] = movearray[6] + movearray[3] + movearray[9];
							movearray[3] = 0;
							movearray[9] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 4 && Kalaha.board[11] == 0 && Kalaha.board[1] != 0 ) {
							movearray[6] = movearray[6] + movearray[4] + movearray[8];
							movearray[4] = 0;
							movearray[8] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						} else if ( pitnumber == 5 && Kalaha.board[12] == 0 && Kalaha.board[0] != 0 ) {
							movearray[6] = movearray[6] + movearray[5] + movearray[7];
							movearray[5] = 0;
							movearray[7] = 0;
							System.out.println("Captured: " + Arrays.toString(movearray));
						}
					}
					
					showMove(Kalaha.activePlayer);
					System.out.println("Made regular move");
					game.changeActivePlayer(Kalaha.activePlayer);
				}
			}		
//			showMove(game.activePlayer);
			
			System.out.println("Move made: " + Arrays.toString(movearray));
			System.out.println("Board: " + Arrays.toString(Kalaha.board));
			GameBoard.undo.setEnabled(true);
			
			gameWon( game.player1, game.player2 );
		
		} else {
			System.out.println("Pit is empty!");	
		}
	}
	/**
	 * shows move and writes a board copy to use
	 * if the move wasn't undone.
	 */
	public static void showMove(Player player) {
		System.out.println("Show move from " + Kalaha.activePlayer.getName());
		if ( player == game.player1 ) {
			System.out.println("Showing P1's move.");
			GameBoard.h11.setText(Integer.toString(movearray[0]));
			GameBoard.h12.setText(Integer.toString(movearray[1]));
			GameBoard.h13.setText(Integer.toString(movearray[2]));
			GameBoard.h14.setText(Integer.toString(movearray[3]));
			GameBoard.h15.setText(Integer.toString(movearray[4]));
			GameBoard.h16.setText(Integer.toString(movearray[5]));
			GameBoard.k1.setText(Integer.toString(movearray[6]));
			GameBoard.h21.setText(Integer.toString(movearray[7]));
			GameBoard.h22.setText(Integer.toString(movearray[8]));
			GameBoard.h23.setText(Integer.toString(movearray[9]));
			GameBoard.h24.setText(Integer.toString(movearray[10]));
			GameBoard.h25.setText(Integer.toString(movearray[11]));
			GameBoard.h26.setText(Integer.toString(movearray[12]));
			Kalaha.board[0] = movearray[0];
			Kalaha.board[1] = movearray[1];
			Kalaha.board[2] = movearray[2];
			Kalaha.board[3] = movearray[3];
			Kalaha.board[4] = movearray[4];
			Kalaha.board[5] = movearray[5];
			Kalaha.board[6] = movearray[6];
			Kalaha.board[7] = movearray[7];
			Kalaha.board[8] = movearray[8];
			Kalaha.board[9] = movearray[9];
			Kalaha.board[10] = movearray[10];
			Kalaha.board[11] = movearray[11];
			Kalaha.board[12] = movearray[12];			
		} else if ( player == game.player2 ) {
			System.out.println("Showing P2's move.");			
			GameBoard.h21.setText(Integer.toString(movearray[0]));
			GameBoard.h22.setText(Integer.toString(movearray[1]));
			GameBoard.h23.setText(Integer.toString(movearray[2]));
			GameBoard.h24.setText(Integer.toString(movearray[3]));
			GameBoard.h25.setText(Integer.toString(movearray[4]));
			GameBoard.h26.setText(Integer.toString(movearray[5]));
			GameBoard.k2.setText(Integer.toString(movearray[6]));
			GameBoard.h11.setText(Integer.toString(movearray[7]));
			GameBoard.h12.setText(Integer.toString(movearray[8]));
			GameBoard.h13.setText(Integer.toString(movearray[9]));
			GameBoard.h14.setText(Integer.toString(movearray[10]));
			GameBoard.h15.setText(Integer.toString(movearray[11]));
			GameBoard.h16.setText(Integer.toString(movearray[12]));			
			Kalaha.board[7] = movearray[0];
			Kalaha.board[8] = movearray[1];
			Kalaha.board[9] = movearray[2];
			Kalaha.board[10] = movearray[3];
			Kalaha.board[11] = movearray[4];
			Kalaha.board[12] = movearray[5];
			Kalaha.board[13] = movearray[6];
			Kalaha.board[0] = movearray[7];
			Kalaha.board[1] = movearray[8];
			Kalaha.board[2] = movearray[9];
			Kalaha.board[3] = movearray[10];
			Kalaha.board[4] = movearray[11];
			Kalaha.board[5] = movearray[12];
		}
		System.out.println(Arrays.toString(Kalaha.board));
	}
	/**
	 * pitnumber is got out of movearray.
	 * Opposites:
	 * 0 - 12
	 * 1 - 11
	 * 2 - 10
	 * 3 - 9
	 * 4 - 8
	 * 5 - 7
	 */
	public static void captureStones( int [] movearray, int pitnumber, int i) {
		//TODO finish capture stones
		System.out.println("Try to capture stones");
		if ( i == 0 && pitnumber == 0 && movearray[0] == 0 && movearray[12] != 0 ) {
			movearray[6] = movearray[6] + movearray[0] + movearray[12];
			movearray[0] = 0;
			System.out.println("Captured: " + Arrays.toString(movearray));
		} else if ( i == 0 && pitnumber == 1 && movearray[1] == 0 && movearray[11] != 0 ) {
			movearray[6] = movearray[6] + movearray[1] + movearray[11];
			movearray[1] = 0;
			System.out.println("Captured: " + Arrays.toString(movearray));
		} else if ( i == 0 && pitnumber == 2 && movearray[2] == 0 && movearray[10] != 0 ) {
			movearray[6] = movearray[6] + movearray[2] + movearray[10];
			movearray[2] = 0;
			System.out.println("Captured: " + Arrays.toString(movearray));
		} else if ( i == 0 && pitnumber == 3 && movearray[3] == 0 && movearray[9] != 0 ) {
			movearray[6] = movearray[6] + movearray[3] + movearray[9];
			movearray[3] = 0;
			System.out.println("Captured: " + Arrays.toString(movearray));
		} else if ( i == 0 && pitnumber == 4 && movearray[4] == 0 && movearray[8] != 0 ) {
			movearray[6] = movearray[6] + movearray[4] + movearray[8];
			movearray[4] = 0;
			System.out.println("Captured: " + Arrays.toString(movearray));
		} else if ( i == 0 && pitnumber == 5 && movearray[5] == 0 && movearray[7] != 0 ) {
			movearray[6] = movearray[6] + movearray[5] + movearray[7];
			movearray[5] = 0;
			System.out.println("Captured: " + Arrays.toString(movearray));
		}
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
		//TODO: blaaaah, write it! has to check stuff
		if (pit == GameBoard.h11 && Kalaha.board[7] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[7]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h12 && Kalaha.board[8] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[8]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h13 && Kalaha.board[9] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[9]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h14 && Kalaha.board[10] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[10]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h15 && Kalaha.board[11] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[11]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h16 && Kalaha.board[12] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[12]) + "stones.");
			full = true;
		} 		if (pit == GameBoard.h21 && Kalaha.board[0] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[0]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h22 && Kalaha.board[1] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[1]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h23 && Kalaha.board[2] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[2]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h24 && Kalaha.board[3] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[3]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h25 && Kalaha.board[4] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[4]) + "stones.");
			full = true;
		} else if (pit == GameBoard.h26 && Kalaha.board[5] != 0) {
			System.out.println("Opposite has " + Integer.toString(Kalaha.board[5]) + "stones.");
			full = true;
		} 
		return full;
	}
	
	public static void undoMove() {
		System.out.println("Undo move");
		Kalaha.board = boardcopy;
		//TODO eventually, if undo should be enabled in next turn, change to !=
		//TODO does not work properly
		System.out.println("Board status set to: " + Arrays.toString(Kalaha.board));
		
		GameBoard.h11.setText(Integer.toString(boardcopy[0]));
		GameBoard.h12.setText(Integer.toString(boardcopy[1]));
		GameBoard.h13.setText(Integer.toString(boardcopy[2]));
		GameBoard.h14.setText(Integer.toString(boardcopy[3]));
		GameBoard.h15.setText(Integer.toString(boardcopy[4]));
		GameBoard.h16.setText(Integer.toString(boardcopy[5]));
		GameBoard.k1.setText(Integer.toString(boardcopy[6]));
		GameBoard.h21.setText(Integer.toString(boardcopy[7]));
		GameBoard.h22.setText(Integer.toString(boardcopy[8]));
		GameBoard.h23.setText(Integer.toString(boardcopy[9]));
		GameBoard.h24.setText(Integer.toString(boardcopy[10]));
		GameBoard.h25.setText(Integer.toString(boardcopy[11]));
		GameBoard.h26.setText(Integer.toString(boardcopy[12]));
		GameBoard.k2.setText(Integer.toString(boardcopy[13]));
		
//		if (Kalaha.player1.getTurn() != Kalaha.getCurrentTurn()) {
//			int [] field = { movearray[0],
//					boardcopy[1],
//					boardcopy[2],
//					boardcopy[3],
//					boardcopy[4],
//					boardcopy[5],
//					boardcopy[6]};
//			Kalaha.player1.setField(field);
//			Kalaha.player2.field[0] = movearray[7];
//			Kalaha.player2.field[1] = boardcopy[8];
//			Kalaha.player2.field[2] = boardcopy[9];
//			Kalaha.player2.field[3] = boardcopy[10];
//			Kalaha.player2.field[4] = boardcopy[11];
//			Kalaha.player2.field[5] = boardcopy[12];
//		} else if (Kalaha.player2.getTurn() != Kalaha.getCurrentTurn()) {
//			int [] field = { movearray[0],
//					boardcopy[1],
//					boardcopy[2],
//					boardcopy[3],
//					boardcopy[4],
//					boardcopy[5],
//					boardcopy[6]};
//			Kalaha.player2.setField(field);
//			Kalaha.player1.field[0] = movearray[7];
//			Kalaha.player1.field[1] = boardcopy[8];
//			Kalaha.player1.field[2] = boardcopy[9];
//			Kalaha.player1.field[3] = boardcopy[10];
//			Kalaha.player1.field[4] = boardcopy[11];
//			Kalaha.player1.field[5] = boardcopy[12];
//		}
//		game.setStatus(Kalaha.player1.field, Kalaha.player2.field);
	}
	
	public static void writeMoveOnField(Player player1, Player player2, Player activePlayer, int[] movearray) {
		System.out.println("Writing made move to field");
		//TODO is writeMoveOnField used?
		if (player1 == activePlayer) {
			Kalaha.board[0] = movearray[0];
			Kalaha.board[1] = movearray[1];
			Kalaha.board[2] = movearray[2];
			Kalaha.board[3] = movearray[3];
			Kalaha.board[4] = movearray[4];
			Kalaha.board[5] = movearray[5];
			Kalaha.board[6] = movearray[6];
			Kalaha.board[7] = movearray[7];
			Kalaha.board[8] = movearray[8];
			Kalaha.board[9] = movearray[9];
			Kalaha.board[10] = movearray[10];
			Kalaha.board[11] = movearray[11];
			Kalaha.board[12] = movearray[12];		
		} else if (player2 == activePlayer) {
			Kalaha.board[0] = movearray[7];
			Kalaha.board[1] = movearray[8];
			Kalaha.board[2] = movearray[9];
			Kalaha.board[3] = movearray[10];
			Kalaha.board[4] = movearray[11];
			Kalaha.board[5] = movearray[12];
			Kalaha.board[7] = movearray[0];
			Kalaha.board[8] = movearray[1];
			Kalaha.board[9] = movearray[2];
			Kalaha.board[10] = movearray[3];
			Kalaha.board[11] = movearray[4];
			Kalaha.board[12] = movearray[5];
			Kalaha.board[13] = movearray[6];
		}
		System.out.println("Board status: " + Arrays.toString(Kalaha.board));
	}
	
	public static int[] writeMoveArray(Player player) {
		int [] tmp = Kalaha.getStatus();
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
		// when all of one player's pits are empty, take all stones from the field
		// to player's (whose pits are full) kalaha
		// player with most seeds wins
		int [] tmpfield = Kalaha.getStatus();
		int [] tmp1 = {tmpfield[0],
				tmpfield[1],
				tmpfield[2],
				tmpfield[3],
				tmpfield[4],
				tmpfield[5],
				tmpfield[6]	};
		int [] tmp2 = {tmpfield[7],
				tmpfield[8],
				tmpfield[9],
				tmpfield[10],
				tmpfield[11],
				tmpfield[12],
				tmpfield[13] };
		if (tmp1 [0] == 0 &&
				tmp1[1] == 0 &&
				tmp1[2] == 0 &&
				tmp1[3] == 0 &&
				tmp1[4] == 0 &&
				tmp1[5] == 0) {
			Kalaha.board[13] = tmp2[0] + tmp2[1] + tmp2[2] + tmp2[3] + tmp2[4] + tmp2[5] + tmp2[6];
			Kalaha.board[7] = 0;
			Kalaha.board[8] = 0;
			Kalaha.board[9] = 0;
			Kalaha.board[10] = 0;
			Kalaha.board[11] = 0;
			Kalaha.board[12] = 0;
			if ( Kalaha.board[13] > Kalaha.board[6]) {
				System.out.println("P2 won with " + Integer.toString(Kalaha.board[13]));
				InfoField.message.setForeground(blue);
				GameBoard.hmsg.setForeground(blue);
				InfoField.message.setText("Congratulations,   " + player2.getName() +
							"!   You've won the game!");
				GameBoard.hmsg.setText(player2.getName() + " won with " +
							Integer.toString(Kalaha.board[13]) + " stones in their Kalaha!");
			} else if ( Kalaha.board[13] < Kalaha.board[6]) {
				System.out.println("P1 won with " + Integer.toString(Kalaha.board[6]));
				InfoField.message.setForeground(red);
				GameBoard.hmsg.setForeground(red);
				InfoField.message.setText("Congratulations,   " + player1.getName() +
							"!   You've won the game!");
				GameBoard.hmsg.setText(player1.getName() + " won with " +
						Integer.toString(Kalaha.board[6]) + " stones in their Kalaha!");
			} else if ( Kalaha.board[13] == Kalaha.board[6] ) {
				System.out.println("It's a draw!");
				InfoField.message.setForeground( new Color ( 0, 0, 0 ));
				InfoField.message.setText("It's a draw!   Both players have " +
						Integer.toString(Kalaha.board[13]) + " stones!");
			}

		} else 	if (tmp2 [0] == 0 &&
					tmp2[1] == 0 &&
					tmp2[2] == 0 &&
					tmp2[3] == 0 &&
					tmp2[4] == 0 &&
					tmp2[5] == 0) {
			Kalaha.board[6] = tmp1[0] + tmp1[1] + tmp1[2] + tmp1[3] + tmp1[4] + tmp1[5] + tmp1[6];
			Kalaha.board[0] = 0;
			Kalaha.board[1] = 0;
			Kalaha.board[2] = 0;
			Kalaha.board[3] = 0;
			Kalaha.board[4] = 0;
			Kalaha.board[5] = 0;
			if ( Kalaha.board[13] > Kalaha.board[6]) {
				System.out.println("P2 won with " + Integer.toString(Kalaha.board[13]));
				InfoField.message.setForeground(blue);
				GameBoard.hmsg.setForeground(blue);
				InfoField.message.setText("Congratulations,   " + player2.getName() +
							"!   You've won the game!");
				GameBoard.hmsg.setText(player2.getName() + " won with " +
							Integer.toString(Kalaha.board[13]) + " stones in their Kalaha!");
			} else if ( Kalaha.board[13] < Kalaha.board[6]) {
				System.out.println("P1 won with " + Integer.toString(Kalaha.board[6]));
				InfoField.message.setForeground(red);
				GameBoard.hmsg.setForeground(red);
				InfoField.message.setText("Congratulations,   " + player1.getName() +
							"!   You've won the game!");
				GameBoard.hmsg.setText(player1.getName() + " won with " +
						Integer.toString(Kalaha.board[6]) + " stones in their Kalaha!");
			} else if ( Kalaha.board[13] == Kalaha.board[6] ) {
				System.out.println("It's a draw!");
				InfoField.message.setForeground( new Color ( 0, 0, 0 ));
				InfoField.message.setText("It's a draw!   Both players have " +
						Integer.toString(Kalaha.board[13]) + " stones!");
			}
			win = true;
		} else {
			win = false;
		}
		System.out.println(Arrays.toString(Kalaha.board));
		return win;
	}
	/**
	 * sets all labels, actually. As test, prints both player field arrays
	 * is used to show board at the start of the new game.
	 */
	public static void showBoard() {
		int [] tmp = Kalaha.getStatus();
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
		System.out.println("Show board:");
		System.out.println(Arrays.toString(Kalaha.board));
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
	public static void enableFields(Player player1, Player player2, Player activePlayer) {
//		System.out.println("enableFields initialized");
		if ( activePlayer == player1 ) {
//			System.out.println(" Player 1 turn is current");
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
//			System.out.println("P1 fields enabled");
		} else if ( activePlayer == player2 ) {
//			System.out.println(" Player 2 turn is current");
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
//			System.out.println("P2 fields enabled");				
		}
	}
	
	public void playGame(Kalaha game) {
//			game.changeActivePlayer(Kalaha.activePlayer);
	}
}