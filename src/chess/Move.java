package chess;

import javax.sql.RowSet;

public class Move {
	private Main main;
	private Board board;
	
	public Move(){}
	
	public Move(Board board, Main main){
		this.board = board;
		this.main = main;
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
	public static boolean isValidPawn(int sourceRow, int sourceCol, 
										int destRow, int destCol,
										String turn){
		
		if(turn.equals("WHITE")){
			if(sourceRow == 1){
				// pawn bisa 2 langkah
				if(sourceCol == destCol && 
						(destRow-sourceRow == 1 || destRow-sourceRow == 2)
					) return true;
				
				return false;
			}else{
				// pawn hanya bisa 1 langkah
				if(sourceCol == destCol && destRow-sourceRow == 1) return true;
				
				return false;
			}			
		}else if(turn.equals("BLACK")){
			if(sourceRow == 6){
				// pawn bisa 2 langkah
				if(sourceCol == destCol && 
					( destRow-sourceRow == -1 || destRow-sourceRow == -2) ) return true;
				
				return false;
			}else{
				// pawn hanya bisa 1 langkah
				if( sourceCol == destCol && destRow-sourceRow == -1) return true;
				
				return false;
			}
		}else{
			return false;
		}
	
		
	}
}
