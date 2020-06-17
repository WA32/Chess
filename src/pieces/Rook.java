package pieces;

import chess.Main;
import chess.Move;
import chess.Piece;

public class Rook extends Move {

	public Rook() {
		super();
	}
	
	public Rook(Piece[][] b){
		super(b);
	}

	public Rook(Piece[][] b, Main m) {
		super(b, m);
	}

	public boolean isValidRook(int sourceRow, int sourceCol, int destRow, int destCol, String turn) {
		if (sourceRow < 0 || sourceRow > 7 || sourceCol < 0 || sourceCol > 7 || destRow < 0 || destRow > 7
				|| destCol < 0 || destCol > 7)
			return false;

		if (turn.equals("WHITE")) {
			// check if in middle of road, there's enemy or friends piece
			if (destRow == sourceRow) {
				for (int a = sourceCol + 1; a < destCol; a++) {
					if (isBlackPieceExist(sourceRow, a) == true || isWhitePieceExist(sourceRow, a) == true)
						return false;
				}
				return true;
			} else if (destCol == sourceCol) {
				for (int a = sourceRow + 1; a < destRow; a++) {
					if (isBlackPieceExist(a, sourceCol) == true || isWhitePieceExist(a, sourceCol) == true)
						return false;
				}
				return true;
			} else {
				return false;
			}

		} else if (turn.equals("BLACK")) {
			// check if in middle of road, there's enemy or friends piece
			if (destRow == sourceRow) {
				for (int a = sourceCol + 1; a < destCol; a++) {
					if (isBlackPieceExist(sourceRow, a) == true || isWhitePieceExist(sourceRow, a) == true)
						return false;
				}
				return true;
			} else if (destCol == sourceCol) {
				for (int a = sourceRow + 1; a < destRow; a++) {
					if (isBlackPieceExist(a, sourceCol) == true || isWhitePieceExist(a, sourceCol) == true)
						return false;
				}
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
