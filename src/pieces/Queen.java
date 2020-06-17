package pieces;

import chess.Main;
import chess.Move;
import chess.Piece;

public class Queen extends Move {
	public Queen() {
		super();
	}
	
	public Queen(Piece[][] b){
		super(b);
	}

	public Queen(Piece[][] b, Main m) {
		super(b, m);
	}

	public boolean isValidQueen(int sourceRow, int sourceCol, int destRow, int destCol, String turn) {
		if (sourceRow < 0 || sourceRow > 7 || sourceCol < 0 || sourceCol > 7 || destRow < 0 || destRow > 7
				|| destCol < 0 || destCol > 7)
			return false;

		if (turn.equals("WHITE")) {
			// cek jika ada piece putih
			if (isWhitePieceExist(sourceRow, sourceCol) == false)
				return false;

			// cek jika di tujuan ada piece putih
			if (isWhitePieceExist(destRow, destCol) == true)
				return false;

			// validasi 2 tipe gerakan queen : bishop-like dan rook-like

			// rook-like
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
			}
			// bishop-like
			else if (Math.abs(sourceCol - destCol) == Math.abs(sourceRow - destRow)) {
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
				return true;
			} else {
				return false;
			}

		} else if (turn.equals("BLACK")) {
			// cek jika piece ada
			if (isBlackPieceExist(sourceRow, sourceCol) == false)
				return false;

			// cek jika di tujuan ada piece putih
			if (isBlackPieceExist(destRow, destCol) == true)
				return false;

			// rook-like
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
			}
			// bishop-like
			else if (Math.abs(sourceCol - destCol) == Math.abs(sourceRow - destRow)) {
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
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
