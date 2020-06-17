package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.Move;
import chess.Piece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Testing {
	private Piece[][] board = new Piece[8][8];
	
	private void initBoard(){
		setBoardDefault();
		setBlockColor();
		setWhitePlayer();
		setBlackPlayer();
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

	
	@Test
	public void testPawnMove(){
		initBoard();
		Pawn pawn = new Pawn(board);
		int sourceRow = 1;	int destRow = 2;
		int sourceCol = 1;	int destCol = 1;
		String turn = "WHITE";
		boolean res = pawn.isValidPawn(sourceRow, sourceCol, destRow, destCol, turn);
		
		assertEquals(res, true);
	}
	
	@Test
	public void testRookMove(){
		initBoard();
		Rook rook = new Rook(board);
		int sourceRow = 1;	int destRow = 1;
		int sourceCol = 2;	int destCol = 2;
		String turn = "WHITE";
		boolean res = rook.isValidRook(sourceRow, sourceCol, destRow, destCol, turn);
		
		assertEquals(res, true);
	}
	
	@Test
	public void testKnightMove(){
		initBoard();
		Knight knight = new Knight(board);
		int sourceRow = 0;	int destRow = 5;
		int sourceCol = 3;	int destCol = 3;
		String turn = "WHITE";
		
		boolean res = knight.isValidKnight(sourceRow, sourceCol, destRow, destCol, turn);
		
		assertEquals(res, false);
	}
	
	@Test
	public void testQueenMove(){
		initBoard();
		Queen queen = new Queen(board);
		int sourceRow = 0;	int destRow = 6;
		int sourceCol = 3;	int destCol = 3;
		String turn = "WHITE";
		boolean res = queen.isValidQueen(sourceRow, sourceCol, destRow, destCol, turn);
		
		assertEquals(res, false);
	}

	@Test
	public void testKingMove(){
		initBoard();
		King king = new King(board);
		int sourceRow = 1;	int destRow = 1;
		int sourceCol = 2;	int destCol = 2;
		String turn = "WHITE";
		boolean res = king.isValidKing(sourceRow, sourceCol, destRow, destCol, turn);
		
		assertEquals(res, false);
	}
}
