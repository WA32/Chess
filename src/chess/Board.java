package chess;


/**
 * Board
 * @author StephanV
 * 0 : 0 1 2 3 4 5 6 7
 * 1 : 0 1 2 3 4 5 6 7
 * 2 : 0 1 2 3 4 5 6 7
 * 3 : 0 1 2 3 4 5 6 7
 * 4 : 0 1 2 3 4 5 6 7
 * 5 : 0 1 2 3 4 5 6 7
 * 6 : 0 1 2 3 4 5 6 7
 * 7 : 0 1 2 3 4 5 6 7
 */
public class Board {
	private Main main;
	private Piece[][] board = new Piece[8][8];
	private Move move;
	
	public Board(Main game) {
		initBoard();	
		this.main = game;
		this.move = new Move(board, game);
	}
	
	private void initBoard(){
		setBoardDefault();
		setBlockColor();
		setWhitePlayer();
		setBlackPlayer();
	}
	
	private void clearBoard(){
	}
	
	private void setBoardDefault(){
		for(int i = 7 ; i >= 0 ; i--){
			for(int j = 0; j < 8 ; j++){
				board[i][j] = new Piece("X");
			}
		}
	}
	
	private void setBlockColor(){
		// Kotak Putih = -
		// Kotak Hitam = +
		String firstRow = "WHITE";
		for(int i = 7 ; i >= 0 ; i--){
			String current = "";
			for(int j = 0; j < 8 ; j++){
				if (j == 0) current = firstRow;
				
				board[i][j].setBlock(current);
				
				if(current.equals("BLACK")) current = "WHITE";
				else current = "BLACK";
			}
			if(firstRow.equals("BLACK")) firstRow = "WHITE";
			else firstRow = "BLACK";
		}
	}
	
	/**
	 * White player always in
	 * board[0][0] - board[0][7]
	 * board[1][0] - board[1][7]
	 * p p p p p p p p
	 * r n b q k b n r
	 */
	private void setWhitePlayer(){
		board[0][0].setPiece("r");
		board[0][1].setPiece("n");
		board[0][2].setPiece("b");
		board[0][3].setPiece("q");
		board[0][4].setPiece("k");
		board[0][5].setPiece("b");
		board[0][6].setPiece("n");
		board[0][7].setPiece("r");
		
		board[1][0].setPiece("p");
		board[1][1].setPiece("p");
		board[1][2].setPiece("p");
		board[1][3].setPiece("p");
		board[1][4].setPiece("p");
		board[1][5].setPiece("p");
		board[1][6].setPiece("p");
		board[1][7].setPiece("p");
	}
	
	/**
	 * Black player always in
	 * board[6][0] - board[6][7]
	 * board[7][0] - board[7][7]
	 * R N B Q K B N R
	 * P P P P P P P P
	 */
	private void setBlackPlayer(){
		board[6][0].setPiece("P");
		board[6][1].setPiece("P");
		board[6][2].setPiece("P");
		board[6][3].setPiece("P");
		board[6][4].setPiece("P");
		board[6][5].setPiece("P");
		board[6][6].setPiece("P");
		board[6][7].setPiece("P");
		
		board[7][0].setPiece("R");
		board[7][1].setPiece("N");
		board[7][2].setPiece("B");
		board[7][3].setPiece("Q");
		board[7][4].setPiece("K");
		board[7][5].setPiece("B");
		board[7][6].setPiece("N");
		board[7][7].setPiece("R");
	}
	
	public boolean moves(String queryInput, String turn, String mode){
		if(mode.equals("algebraic")){
			// algebraic mode
			
			if(queryInput.length() == 2){
				// Pawn movement
				
				
			}else if(queryInput.length() == 3 && !queryInput.equals("0-0")){
				// Pawn Promotion &&
				// Rook, Knight, Bishop, Queen, King movement
				
			}else{
				if(queryInput.equals("0-0-0")){
					// For queenside castling 
					
				}else if(queryInput.equals("0-0")){
					// For kingside castling
					
				}
			}


		}else{
			// coordinate mode
			//
			boolean isCoordinateValid = false;
			if(queryInput.length() == 5){
				if(	Character.isAlphabetic(queryInput.charAt(0)) &&
					Character.isDigit(queryInput.charAt(1)) &&
					Character.isAlphabetic(queryInput.charAt(3)) &&
					Character.isDigit(queryInput.charAt(4))) isCoordinateValid = true;
				else isCoordinateValid = false;
			}else if(queryInput.length() == 6){
				if(	Character.isAlphabetic(queryInput.charAt(0)) &&
					Character.isDigit(queryInput.charAt(1)) &&
					Character.isAlphabetic(queryInput.charAt(3)) &&
					Character.isDigit(queryInput.charAt(4)) &&
					Character.isAlphabetic(queryInput.charAt(5))) isCoordinateValid = true;
				else isCoordinateValid = false;
			}else {
				isCoordinateValid = false;
			}
			
			if(isCoordinateValid){
				char colSourceChar = queryInput.charAt(0);
				char rowSourceChar = queryInput.charAt(1);
				
				char colDestChar = queryInput.charAt(3);
				char rowDestChar = queryInput.charAt(4);
				
				int colSource = (colSourceChar - 'A');
				int rowSource = (rowSourceChar - '1');
				int colDest = (colDestChar - 'A');
				int rowDest = (rowDestChar - '1');
								
				String piece = board[rowSource][colSource].getPiece();

				// validate if piece can moved
				
				if(piece.equals("p") || piece.equals("P")){
					// Pawn
					if(move.isValidPawn(rowSource, colSource, rowDest, colDest, turn.toUpperCase()) == false){
						System.out.println(turn + " invalid move");
						return false;
					}
				}else if(piece.equals("r") || piece.equals("R")){
					// Rook
					if(move.isValidRook(rowSource, colSource, rowDest, colDest, turn.toUpperCase()) == false){
						System.out.println(turn + " invalid move");
						return false;
					}
				}else if(piece.equals("n") || piece.equals("N")){
					// Knight / Kuda
					
				}else if(piece.equals("b") || piece.equals("B")){
					// Bishop
					if(move.isValidBishop(rowSource, colSource, rowDest, colDest, turn.toUpperCase()) == false){
						System.out.println(turn + " invalid move");
						return false;
					}
				}else if(piece.equals("q")){
					// White Queen
				}else if(piece.equals("Q")){
					// Black Queen
				}else if(piece.equals("k") || piece.equals("K")){
					//  King
					if(move.isValidKing(rowSource, colSource, rowDest, colDest, turn.toUpperCase()) == false){
						System.out.println(turn + " invalid move");
						return false;
					}
				}
				
				board[rowSource][colSource].setPiece("X");
				board[rowDest][colDest].setPiece(piece);
				
				
				return true;
			}else{
				System.out.println("Invalid format coordinate");
				main.finish = false;
				return false;
			}
		}
		
		return true;
	}
	
	public void drawBoard(){
		for(int i = 7; i >= 0 ; i--){
			for(int j = 0; j < 8 ; j++){
				if(board[i][j] == null){
					System.out.print("- ");
				}else{
					System.out.print(board[i][j].getPiece() + " ");
				}
			}
			System.out.println(" (" + (i+1) +") ");
		}
		for(int i = 'A'; i < 'I' ; i++) System.out.print((char)i + " ");
		System.out.println("");
	}
	
}
