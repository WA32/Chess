package chess;

public class Player {
	private String name;
	private boolean turn;
	
	public Player() {
		this.turn = false;	
	}
	public Player(String name){
		this.turn = false;
		this.name = name;
	}
	
	public void setName(String nm){
		this.name = nm;
	}
	public String getName(){
		return this.name;
	}
	
	public void doTurn(boolean Turn){
		this.turn = Turn;
	}
	public boolean isTurn(){
		return this.turn;
	}
}
