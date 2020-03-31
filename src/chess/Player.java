package chess;

public class Player {
	
	private boolean turn;
	
	public Player() {
		this.turn = false;	
	}
	
	public void doTurn(boolean Turn){
		this.turn = Turn;
	}
}
