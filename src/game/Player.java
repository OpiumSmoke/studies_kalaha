package game;

public class Player {
	public String name;
	public int identity;
	public int turn;
	
	public int [] field = new int[7];
	
	public int kalaha = field[0];
	public int pit1 = field[1];
	public int pit2 = field[2];
	public int pit3 = field[3];
	public int pit4 = field[4];
	public int pit5 = field[5];
	public int pit6 = field[6];
	
	public Player player;
	
	public void setName (String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public int getIdentity () {
		return identity;
	}
	
	public void setIdentity(int number) {
		this.identity = number;
	}
	
	public void setPlayer (String name, int identity, int turn, int[] field) {
		setName(name);
		setIdentity(identity);
		setTurn(turn);
		setField(field);
	}
	
	public Player getPlayer () {
		return player;
	}
	
	public void setTurn (int turn) {
		this.turn = turn;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public int[] getField() {
		return field;
	}
	
	public void setField (int[] newfield) {
		this.field = newfield;
	}
	
	public void makeMove() {
		
	}

}
