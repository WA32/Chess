package chess;

import java.util.Scanner;

public class Main {
	Scanner scan;
	Board board;
	Player white, black;
	boolean finish = false;
	
	public void initMain(){
		scan = new Scanner(System.in);
		
		board = new Board(this);
		
		white = new Player("WHITE");
		white.doTurn(true);
		
		black = new Player("BLACK");
		black.doTurn(false);
	}
	
	public Main() {
		initMain();
		
		System.out.println("1. Algebraic");
		System.out.println("2. Coordinate");
		System.out.print("Choose move notation [1-2] : ");
		int moveNotation = scan.nextInt(); scan.nextLine();

		switch(moveNotation){
			case 1:
				algebraicNotation();
				break;
			case 2:
				coordinateNotation();
				break;
			default:
				break;
		}
	}
	
	private void algebraicNotation() {
		do {
			System.out.println("\n\n\n");
			
			board.drawBoard();
			System.out.println("Algebraic Notation");
			String turn = (white.isTurn()) ? "white" : "black";
			System.out.print(turn + " move : ");
			
			String inputMove = scan.nextLine();
			
			if(!board.moves(inputMove, turn, "algebraic")) continue;
			
			if(white.isTurn()){
				white.doTurn(false);
				black.doTurn(true);
			}else{
				white.doTurn(true);
				black.doTurn(false);
			}
			
		} while (!finish);
		
	}
	
	private void coordinateNotation() {
		do {
			System.out.println("\n\n\n");
			
			board.drawBoard();
			System.out.println("Coordinate Notation");
			String turn = (white.isTurn()) ? "white" : "black";
			System.out.print(turn + " move : ");
			
			String inputMove = scan.nextLine();
			
			if(!board.moves(inputMove, turn, "coordinate")) 
				continue;
			
			if(white.isTurn()){
				white.doTurn(false);
				black.doTurn(true);
			}else{
				white.doTurn(true);
				black.doTurn(false);
			}
			
		} while (!finish);

	}


	public static void main(String[] args) {
		new Main();
	}
}
