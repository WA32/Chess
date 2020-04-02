package chess;

public class Move {
	private Main main;
	private Piece[][] board;
	
	public Move(){}
	
	public Move(Piece[][] b, Main m){
		this.board = b;
		this.main = m;
	}
	
	/**
	 * Validate Pawn Movement
	 * @param sourceRow
	 * @param sourceCol
	 * @param destRow
	 * @param destCol
	 * @param turn
	 * @return true|false
	 */
	public boolean isValidPawn(int sourceRow, int sourceCol, 
										int destRow, int destCol,
										String turn){
		
		if(sourceRow < 0 || sourceRow > 7 || 
			sourceCol < 0 || sourceCol > 7 || 
			destRow < 0  || destRow > 7 ||
			destCol < 0 || destCol > 7) return false;
		
		if(turn.equals("WHITE")){
			if(isWhitePieceExist(sourceRow, sourceCol) == false) return false;		
			
			if(sourceRow == 1){
				// pawn bisa 2 langkah
				if(sourceCol == destCol && 
						(destRow-sourceRow == 1 || destRow-sourceRow == 2)
					) return true;
				
				return false;
			}else{
				// pawn hanya bisa 1 langkah dan tidak ada musuh di dpn
				if(sourceCol == destCol && destRow-sourceRow == 1 && !isBlackPieceExist(destRow, destCol)) 
					return true;
				//validate to eat black piece 
				if(sourceCol != destCol && 
					(sourceRow+1 == destRow || sourceCol-1 == destCol || sourceCol+1 == destCol ) &&
					isBlackPieceExist(destRow, destCol) ) 
					return true;
				
				return false;
			}			
		}else if(turn.equals("BLACK")){
			if(isBlackPieceExist(sourceRow, sourceCol) == false) return false;	
			
			if(sourceRow == 6){
				// pawn bisa 2 langkah
				if(sourceCol == destCol && 
					( destRow-sourceRow == -1 || destRow-sourceRow == -2) ) return true;
				
				return false;
			}else{
				// pawn hanya bisa 1 langkah dan tidak ada musuh di dpn
				if( sourceCol == destCol && destRow-sourceRow == -1 && !isWhitePieceExist(destRow, destCol)) 
					return true;
				//validate to eat black piece 
				if(sourceCol != destCol && 
					(sourceRow == destRow-1 || sourceCol-1 == destCol || sourceCol+1 == destCol ) &&
					isWhitePieceExist(destRow, destCol) ) return true;
				
				return false;
			}
		}else{
			return false;
		}
	
	}

	public boolean isValidRook(int sourceRow, int sourceCol, 
										int destRow, int destCol,
										String turn){
		if(sourceRow < 0 || sourceRow > 7 || 
				sourceCol < 0 || sourceCol > 7 || 
				destRow < 0  || destRow > 7 ||
				destCol < 0 || destCol > 7) return false;
		
		if(turn.equals("WHITE")){
			// check if in middle of road, there's enemy or friends piece
			if(destRow == sourceRow){
				for(int a = sourceCol+1; a < destCol; a++){
					if(isBlackPieceExist(sourceRow, a) == true ||
						isWhitePieceExist(sourceRow, a) == true) return false;
				}
				return true;
			}else if(destCol == sourceCol){
				for(int a = sourceRow+1; a < destRow; a++){
					if(isBlackPieceExist(a, sourceCol) == true ||
						isWhitePieceExist(a, sourceCol) == true) return false;
				}
				return true;
			}else{
				return false;
			}
			
		}else if(turn.equals("BLACK")){
			// check if in middle of road, there's enemy or friends piece
			if(destRow == sourceRow){
				for(int a = sourceCol+1; a < destCol; a++){
					if(isBlackPieceExist(sourceRow, a) == true ||
						isWhitePieceExist(sourceRow, a) == true) return false;
				}
				return true;
			}else if(destCol == sourceCol){
				for(int a = sourceRow+1; a < destRow; a++){
					if(isBlackPieceExist(a, sourceCol) == true ||
						isWhitePieceExist(a, sourceCol) == true) return false;
				}
				return true;
			}else{
				return false;
			}
		}
		
		
		
		return false;
	}

	public boolean isValidKnight(int sourceRow, int sourceCol, 
									int destRow, int destCol,
									String turn){
		if(sourceRow < 0 || sourceRow > 7 || 
			sourceCol < 0 || sourceCol > 7 || 
			destRow < 0  || destRow > 7 ||
			destCol < 0 || destCol > 7) return false;
		
		if(turn.equals("WHITE")){
			// TODO : Check if Knight move is valid
			//			and if destination is empty
			if((sourceCol+1 == destCol && sourceRow+2 == destRow) ||
				(sourceCol-1 == destCol && sourceRow+2 == destRow) ||
				(sourceCol+2 == destCol && sourceRow+1 == destRow) ||
				(sourceCol-2 == destCol && sourceRow+1 == destRow) ||
				
				(sourceCol+1 == destCol && sourceRow-2 == destRow) ||
				(sourceCol-1 == destCol && sourceRow-2 == destRow) ||
				(sourceCol+2 == destCol && sourceRow-1 == destRow) ||
				(sourceCol-2 == destCol && sourceRow-1 == destRow) ){
				if(isWhitePieceExist(destRow, destCol) == false) return true;
				
				return false;
			}
			
			return false;
		}else if(turn.equals("BLACK")){
			// TODO : Check if Knight move is valid
			//			and if destination is empty
			if((sourceCol+1 == destCol && sourceRow+2 == destRow) ||
				(sourceCol-1 == destCol && sourceRow+2 == destRow) ||
				(sourceCol+2 == destCol && sourceRow+1 == destRow) ||
				(sourceCol-2 == destCol && sourceRow+1 == destRow) ||
				
				(sourceCol+1 == destCol && sourceRow-2 == destRow) ||
				(sourceCol-1 == destCol && sourceRow-2 == destRow) ||
				(sourceCol+2 == destCol && sourceRow-1 == destRow) ||
				(sourceCol-2 == destCol && sourceRow-1 == destRow) ){
				if(isBlackPieceExist(destRow, destCol) == false) return true;
				
				return false;
			}
			
			return false;
		}else{
			return false;
		}
	}
	public boolean isValidBishop(int sourceRow, int sourceCol, 
			int destRow, int destCol,
			String turn){
			if(sourceRow < 0 || sourceRow > 7 || 
						sourceCol < 0 || sourceCol > 7 || 
							destRow < 0  || destRow > 7 ||
							destCol < 0 || destCol > 7) return false;

			if(turn.equals("WHITE")){
				// TODO : Check if Bishop move is valid
				//			and if destination is empty
				//cek jika piece ada
				if(isWhitePieceExist(sourceRow, sourceCol) == false) return false;

				//cek jika di tujuan ada piece putih
				if(isWhitePieceExist(destRow, destCol) == true) return false;

				//validasi gerakan bishop dan jika ada piece putih dijalan
				if(Math.abs(sourceCol - destCol) == Math.abs(sourceRow - destRow)){
					//gerakan ke kanan atas
					if(destRow > sourceRow && destCol > sourceCol){
						for(int i = sourceRow + 1,j = sourceCol+1  ;  i < destRow ; i++, j++){
							 
							if(isWhitePieceExist(i, j) == true) return false;
							else if(isBlackPieceExist(i, j) == true) return false;
							
						}

					}
					//gerakan kiri atas
					else if(destRow > sourceRow && destCol < sourceCol){
						for(int i = sourceRow + 1,j = sourceCol - 1; i < destRow; i++,j--){
							
							if(isWhitePieceExist(i, j) == true) return false;
							else if(isBlackPieceExist(i, j) == true) return false;
							
						}
						
					}

					//gerakan kanan bawah
					else if(destRow < sourceRow && destCol > sourceCol){
						for(int i = sourceRow - 1,j = sourceCol + 1; i > destRow ; i--,j++ ){
							
							if(isWhitePieceExist(i, j) == true) {
								
								return false;
							}
							else if(isBlackPieceExist(i, j) == true){
							
								return false;
							}
							
						}
	
					}

					//gerakan kiri bawah
					else if(destRow < sourceRow && destCol < sourceCol){
						for(int i = sourceRow - 1,j = sourceCol - 1; i > destRow ; i--,j--){
							
							if(isWhitePieceExist(i, j) == true) return false;
							else if(isBlackPieceExist(i, j) == true) return false;
							
						}

					}

				}


				return true;
			}else if(turn.equals("BLACK")){
				// TODO : Check if Bishop move is valid
				//			and if destination is empty
				//cek jika piece ada
				if(isBlackPieceExist(sourceRow, sourceCol) == false) return false;

				//cek jika di tujuan ada piece putih
				if(isBlackPieceExist(destRow, destCol) == true) return false;

				//validasi gerakan bishop dan jika ada hitam putih dijalan
				if(Math.abs(sourceCol - destCol) == Math.abs(sourceRow - destRow)){
					//gerakan ke kanan atas
					if(destRow > sourceRow && destCol > sourceCol){
						for(int i = sourceRow + 1,j = sourceCol+1 ;  i < destRow ; i++,j++){
							 
							if(isWhitePieceExist(i, j) == true) return false;
							else if(isBlackPieceExist(i, j) == true) return false;
							
						}

					}
					//gerakan kiri atas
					else if(destRow > sourceRow && destCol < sourceCol){
						for(int i = sourceRow + 1,j = sourceCol - 1; i < destRow; i++,j--){
							
							if(isWhitePieceExist(i, j) == true) return false;
							else if(isBlackPieceExist(i, j) == true) return false;
							
						}
						
					}

					//gerakan kanan bawah
					else if(destRow < sourceRow && destCol > sourceCol){
						for(int i = sourceRow - 1,j = sourceCol + 1; i > destRow ; i--,j++ ){
							
							if(isWhitePieceExist(i, j) == true) return false;
							else if(isBlackPieceExist(i, j) == true) return false;
							
						}
	
					}

					//gerakan kiri bawah
					else if(destRow < sourceRow && destCol < sourceCol){
						for(int i = sourceRow - 1,j = sourceCol - 1; i > destRow ; i--,j--){
							
							if(isWhitePieceExist(i, j) == true) return false;
							else if(isBlackPieceExist(i, j) == true) return false;
							
						}

					}

				}
				return true;
			}else{
				return false;
			}
	}
	
	
	public boolean isValidQueen(int sourceRow, int sourceCol, 
									int destRow, int destCol,
									String turn){
		if(sourceRow < 0 || sourceRow > 7 || 
		sourceCol < 0 || sourceCol > 7 || 
		destRow < 0  || destRow > 7 ||
		destCol < 0 || destCol > 7) return false;
		
		if(turn.equals("WHITE")){
		
			return true;
		}else if(turn.equals("BLACK")){
		
			return true;
		}else{
			return false;
		}
	}	
	
	
	public boolean isValidKing(int sourceRow, int sourceCol, 
			int destRow, int destCol,
			String turn){
			if(sourceRow < 0 || sourceRow > 7 || 
						sourceCol < 0 || sourceCol > 7 || 
							destRow < 0  || destRow > 7 ||
								destCol < 0 || destCol > 7) return false;

			if(turn.equals("WHITE")){
				//cek jika  ada piece 
				if(isWhitePieceExist(sourceRow, sourceCol) == false) return false;		
				
				//cek jika ada piece putih di tujuan
				if(isWhitePieceExist(destRow, destCol) == true) return false;
				
				//king jalan hanya 1 langkah
				
				if(Math.abs(destCol - sourceCol) > 1 && Math.abs(destRow - sourceRow ) > 1) return false;

				return true;
			}else if(turn.equals("BLACK")){
				//cek jika  ada piece 
				if(isBlackPieceExist(sourceRow, sourceCol) == false) return false;		
				
				//cek jika ada piece hitam di tujuan
				if(isBlackPieceExist(destRow, destCol) == true) return false;
				
				//king jalan hanya 1 langkah
				
				if(Math.abs(destCol - sourceCol) > 1 && Math.abs(destRow - sourceRow ) > 1) return false;
				

				return true;
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
	private boolean isPieceExist(int row, int col){
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
	private boolean isWhitePieceExist(int row, int col){
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
	private boolean isBlackPieceExist(int row, int col){
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
