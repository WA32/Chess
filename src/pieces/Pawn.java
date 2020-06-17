package pieces;

import chess.Main;
import chess.Move;
import chess.Piece;

public class Pawn extends Move {

	public Pawn() {
		super();
	}
	
	public Pawn(Piece[][] b){
		super(b);
	}

	public Pawn(Piece[][] b, Main m) {
		super(b, m);
	}

	/**
	 * Validate Pawn Movement
	 * 
	 * @param sourceRow
	 * @param sourceCol
	 * @param destRow
	 * @param destCol
	 * @param turn
	 * @return true|false
	 */
	public boolean isValidPawn(int sourceRow, int sourceCol, int destRow, int destCol, String turn) {

		if (sourceRow < 0 || sourceRow > 7 || sourceCol < 0 || sourceCol > 7 || destRow < 0 || destRow > 7
				|| destCol < 0 || destCol > 7)
			return false;

		if (turn.equals("WHITE")) {
			if (isWhitePieceExist(sourceRow, sourceCol) == false)
				return false;

			if (sourceRow == 1) {
				// pawn bisa 2 langkah
				if (sourceCol == destCol && (destRow - sourceRow == 1 || destRow - sourceRow == 2))
					return true;

				return false;
			} else {
				// pawn hanya bisa 1 langkah dan tidak ada musuh di dpn
				if (sourceCol == destCol && destRow - sourceRow == 1 && !isBlackPieceExist(destRow, destCol))
					return true;
				// validate to eat black piece
				if (sourceCol != destCol
						&& (sourceRow + 1 == destRow || sourceCol - 1 == destCol || sourceCol + 1 == destCol)
						&& isBlackPieceExist(destRow, destCol))
					return true;

				return false;
			}
		} else if (turn.equals("BLACK")) {
			if (isBlackPieceExist(sourceRow, sourceCol) == false)
				return false;

			if (sourceRow == 6) {
				// pawn bisa 2 langkah
				if (sourceCol == destCol && (destRow - sourceRow == -1 || destRow - sourceRow == -2))
					return true;

				return false;
			} else {
				// pawn hanya bisa 1 langkah dan tidak ada musuh di dpn
				if (sourceCol == destCol && destRow - sourceRow == -1 && !isWhitePieceExist(destRow, destCol))
					return true;
				// validate to eat black piece
				if (sourceCol != destCol
						&& (sourceRow == destRow - 1 || sourceCol - 1 == destCol || sourceCol + 1 == destCol)
						&& isWhitePieceExist(destRow, destCol))
					return true;

				return false;
			}
		} else {
			return false;
		}

	}

	// pawn promotion
	public boolean isPromotionValid(String query, String turn, int rowDest) {

		if (query.length() != 6) {
			return false;
		} else if (query.charAt(5) != 'Q' && query.charAt(5) != 'R' && query.charAt(5) != 'N'
				&& query.charAt(5) != 'B') {

			return false;
		} else if (turn.equals("WHITE") && rowDest == 0) {

			return false;
		} else if (turn.equals("BLACK") && rowDest == 7) {

			return false;
		}

		return true;
	}

}
