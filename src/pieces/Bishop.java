package pieces;

import chess.Main;
import chess.Move;
import chess.Piece;

public class Bishop extends Move {
	public Bishop() {
		super();
	}
	
	public Bishop(Piece[][] b){
		super(b);
	}

	public Bishop(Piece[][] b, Main m) {
		super(b, m);
	}

	public boolean isValidBishop(int sourceRow, int sourceCol, int destRow, int destCol, String turn) {
		if (sourceRow < 0 || sourceRow > 7 || sourceCol < 0 || sourceCol > 7 || destRow < 0 || destRow > 7
				|| destCol < 0 || destCol > 7)
			return false;

		if (turn.equals("WHITE")) {
			// Check if Bishop move is valid and if destination is empty
			// cek jika piece ada
			if (isWhitePieceExist(sourceRow, sourceCol) == false)
				return false;

			// cek jika di tujuan ada piece putih
			if (isWhitePieceExist(destRow, destCol) == true)
				return false;

			// validasi gerakan bishop dan jika ada piece putih dijalan
			if (Math.abs(sourceCol - destCol) == Math.abs(sourceRow - destRow)) {
				// gerakan ke kanan atas
				if (destRow > sourceRow && destCol > sourceCol) {
					for (int i = sourceRow + 1, j = sourceCol + 1; i < destRow; i++, j++) {

						if (isWhitePieceExist(i, j) == true)
							return false;
						else if (isBlackPieceExist(i, j) == true)
							return false;

					}

				}
				// gerakan kiri atas
				else if (destRow > sourceRow && destCol < sourceCol) {
					for (int i = sourceRow + 1, j = sourceCol - 1; i < destRow; i++, j--) {

						if (isWhitePieceExist(i, j) == true)
							return false;
						else if (isBlackPieceExist(i, j) == true)
							return false;

					}

				}

				// gerakan kanan bawah
				else if (destRow < sourceRow && destCol > sourceCol) {
					for (int i = sourceRow - 1, j = sourceCol + 1; i > destRow; i--, j++) {

						if (isWhitePieceExist(i, j) == true) {

							return false;
						} else if (isBlackPieceExist(i, j) == true) {

							return false;
						}

					}

				}

				// gerakan kiri bawah
				else if (destRow < sourceRow && destCol < sourceCol) {
					for (int i = sourceRow - 1, j = sourceCol - 1; i > destRow; i--, j--) {
						if (isWhitePieceExist(i, j) == true)
							return false;
						else if (isBlackPieceExist(i, j) == true)
							return false;
					}
				}

			}

			return true;
		} else if (turn.equals("BLACK")) {
			// Check if Bishop move is valid and if destination is empty
			// cek jika piece ada
			if (isBlackPieceExist(sourceRow, sourceCol) == false)
				return false;

			// cek jika di tujuan ada piece putih
			if (isBlackPieceExist(destRow, destCol) == true)
				return false;

			// validasi gerakan bishop dan jika ada hitam putih dijalan
			if (Math.abs(sourceCol - destCol) == Math.abs(sourceRow - destRow)) {
				// gerakan ke kanan atas
				if (destRow > sourceRow && destCol > sourceCol) {
					for (int i = sourceRow + 1, j = sourceCol + 1; i < destRow; i++, j++) {

						if (isWhitePieceExist(i, j) == true)
							return false;
						else if (isBlackPieceExist(i, j) == true)
							return false;

					}

				}
				// gerakan kiri atas
				else if (destRow > sourceRow && destCol < sourceCol) {
					for (int i = sourceRow + 1, j = sourceCol - 1; i < destRow; i++, j--) {

						if (isWhitePieceExist(i, j) == true)
							return false;
						else if (isBlackPieceExist(i, j) == true)
							return false;

					}

				}

				// gerakan kanan bawah
				else if (destRow < sourceRow && destCol > sourceCol) {
					for (int i = sourceRow - 1, j = sourceCol + 1; i > destRow; i--, j++) {

						if (isWhitePieceExist(i, j) == true)
							return false;
						else if (isBlackPieceExist(i, j) == true)
							return false;

					}

				}

				// gerakan kiri bawah
				else if (destRow < sourceRow && destCol < sourceCol) {
					for (int i = sourceRow - 1, j = sourceCol - 1; i > destRow; i--, j--) {

						if (isWhitePieceExist(i, j) == true)
							return false;
						else if (isBlackPieceExist(i, j) == true)
							return false;

					}

				}

			}
			return true;
		} else {
			return false;
		}
	}

}
