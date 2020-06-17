package chess;

public class Move {
	protected Main main;
	protected Piece[][] board;
	
	public Move(){}
	
	public Move(Piece[][] b){
		this.board = b;
	}
	
	public Move(Piece[][] b, Main m){
		this.board = b;
		this.main = m;
	}
	
	public boolean isValidKingsideCastling(int sourceRow, int sourceCol, 
									int destRow, int destCol,
									String turn){
		if(sourceRow < 0 || sourceRow > 7 || 
			sourceCol < 0 || sourceCol > 7 || 
			destRow < 0  || destRow > 7 ||
			destCol < 0 || destCol > 7) return false;
		
		if(turn.equals("WHITE")){
			// cek jika king dan rook ada di posisi
			// cek jika sepanjang jalan ada piece lainnya
			
			if(board[0][4].getPiece().equals("k") && 
				board[0][7].getPiece().equals("r")){
				if(isBlackPieceExist(0, 5) || isWhitePieceExist(0, 5)) return false;
				if(isBlackPieceExist(0, 6) || isWhitePieceExist(0, 6)) return false;		
				return true;
			}
			return false;
		}else if(turn.equals("BLACK")){
			// cek jika king dan rook ada di posisinya
			// cek jika sepanjang jalan ada piece lainnya
			if(board[7][4].getPiece().equals("K") && 
				board[7][7].getPiece().equals("R")){
				if(isBlackPieceExist(7, 5) || isWhitePieceExist(7, 5)) return false;
				if(isBlackPieceExist(7, 6) || isWhitePieceExist(7, 6)) return false;		
				return true;
			}
			return false;
		}else{
			return false;
		}
		
	}
	
	public boolean isValidQueensideCastling(int sourceRow, int sourceCol, 
									int destRow, int destCol,
									String turn){
		if(sourceRow < 0 || sourceRow > 7 || 
			sourceCol < 0 || sourceCol > 7 || 
			destRow < 0  || destRow > 7 ||
			destCol < 0 || destCol > 7) return false;
		
		if(turn.equals("WHITE")){
			// cek jika king dan rook ada di posisi
			// cek jika sepanjang jalan ada piece lainnya
			
			if(board[0][4].getPiece().equals("k") && 
				board[0][0].getPiece().equals("r")){
				if(isBlackPieceExist(0, 3) || isWhitePieceExist(0, 3)) return false;
				if(isBlackPieceExist(0, 2) || isWhitePieceExist(0, 2)) return false;
				if(isBlackPieceExist(0, 1) || isWhitePieceExist(0, 1)) return false;
				return true;
			}
			return false;
		}else if(turn.equals("BLACK")){
			// cek jika king dan rook ada di posisinya
			// cek jika sepanjang jalan ada piece lainnya
			if(board[7][4].getPiece().equals("k") && 
					board[7][0].getPiece().equals("r")){
					if(isBlackPieceExist(0, 3) || isWhitePieceExist(0, 3)) return false;
					if(isBlackPieceExist(0, 2) || isWhitePieceExist(0, 2)) return false;
					if(isBlackPieceExist(0, 1) || isWhitePieceExist(0, 1)) return false;
					return true;
				}
			return false;
		}else{
			return false;
		}
	}
	
	/**
	 * Check if piece exist in board coordinate
	 * @param row
	 * @param col
	 * @return true|false
	 */
	protected boolean isPieceExist(int row, int col){
		String piece = board[row][col].getPiece();
		
		if(piece.equals("p") || piece.equals("P")) return true;
		else if(piece.equals("r") || piece.equals("R")) return true;
		else if(piece.equals("n") || piece.equals("N")) return true;
		else if(piece.equals("b") || piece.equals("B")) return true;
		else if(piece.equals("q") || piece.equals("Q")) return true;
		else if(piece.equals("k") || piece.equals("K")) return true;
		
		return false;
	}
	
	/**
	 * Check if white piece exist in board coordinate
	 * @param row
	 * @param col
	 * @return
	 */
	protected boolean isWhitePieceExist(int row, int col){
		String piece = board[row][col].getPiece();
		
		if(piece.equals("p")) return true;
		else if(piece.equals("r")) return true;
		else if(piece.equals("n")) return true;
		else if(piece.equals("b")) return true;
		else if(piece.equals("q")) return true;
		else if(piece.equals("k")) return true;
		
		return false;
	}
	
	/**
	 * Check if Black piece exist in board coordinate
	 * @param row
	 * @param col
	 * @return
	 */
	protected boolean isBlackPieceExist(int row, int col){
		String piece = board[row][col].getPiece();
		
		if(piece.equals("P")) return true;
		else if(piece.equals("R")) return true;
		else if(piece.equals("N")) return true;
		else if(piece.equals("B")) return true;
		else if(piece.equals("Q")) return true;
		else if(piece.equals("K")) return true;
		
		return false;
	}
}
