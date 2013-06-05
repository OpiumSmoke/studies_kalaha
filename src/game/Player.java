package game;

public class Player {
	public String name;
	public int identity;
	public boolean computer;
	
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
	
	public void setComputer(boolean computer) {
		this.computer = computer;
	}
	
	public boolean isComputer() {
		return computer;
	}
	
	
	public void setPlayer (String name, int identity ) {
		setName(name);
		setIdentity(identity);
	}
	
	public Player getPlayer () {
		return player;
	}
	
//	public void setTurn (int turn) {
//		this.turn = turn;
//	}
//	
//	public int getTurn() {
//		return turn;
//	}

}
