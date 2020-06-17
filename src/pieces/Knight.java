package pieces;

import chess.Main;
import chess.Move;
import chess.Piece;

public class Knight extends Move {

	public Knight() {
		super();
	}
	
	public Knight(Piece[][] b){
		super(b);
	}

	public Knight(Piece[][] b, Main m) {
		super(b, m);
	}

	public boolean isValidKnight(int sourceRow, int sourceCol, int destRow, int destCol, String turn) {
		if (sourceRow < 0 || sourceRow > 7 || sourceCol < 0 || sourceCol > 7 || destRow < 0 || destRow > 7
				|| destCol < 0 || destCol > 7)
			return false;

		if (turn.equals("WHITE")) {
			// TODO : Check if Knight move is valid
			// and if destination is empty
			if ((sourceCol + 1 == destCol && sourceRow + 2 == destRow)
					|| (sourceCol - 1 == destCol && sourceRow + 2 == destRow)
					|| (sourceCol + 2 == destCol && sourceRow + 1 == destRow)
					|| (sourceCol - 2 == destCol && sourceRow + 1 == destRow) ||

					(sourceCol + 1 == destCol && sourceRow - 2 == destRow)
					|| (sourceCol - 1 == destCol && sourceRow - 2 == destRow)
					|| (sourceCol + 2 == destCol && sourceRow - 1 == destRow)
					|| (sourceCol - 2 == destCol && sourceRow - 1 == destRow)) {
				if (isWhitePieceExist(destRow, destCol) == false)
					return true;

				return false;
			}

			return false;
		} else if (turn.equals("BLACK")) {
			// TODO : Check if Knight move is valid
			// and if destination is empty
			if ((sourceCol + 1 == destCol && sourceRow + 2 == destRow)
					|| (sourceCol - 1 == destCol && sourceRow + 2 == destRow)
					|| (sourceCol + 2 == destCol && sourceRow + 1 == destRow)
					|| (sourceCol - 2 == destCol && sourceRow + 1 == destRow) ||

					(sourceCol + 1 == destCol && sourceRow - 2 == destRow)
					|| (sourceCol - 1 == destCol && sourceRow - 2 == destRow)
					|| (sourceCol + 2 == destCol && sourceRow - 1 == destRow)
					|| (sourceCol - 2 == destCol && sourceRow - 1 == destRow)) {
				if (isBlackPieceExist(destRow, destCol) == false)
					return true;

				return false;
			}

			return false;
		} else {
			return false;
		}
	}

}
