package chess;

public class Main {
	
	Board board;
	Player white, black;
	
	public void initMain(){
		board = new Board(this);
		
		white = new Player();
		white.doTurn(true);
		
		black = new Player();
		black.doTurn(false);
	}
	
	public Main() {
		initMain();
		
		
		
		board.drawBoard();
	}

	public static void main(String[] args) {
		new Main();
	}
}
