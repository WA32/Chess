package pieces;

import chess.Main;
import chess.Move;
import chess.Piece;

public class King extends Move {
	private Rook rook;
	private Knight knight;
	private Bishop bishop;
	private Queen queen;

	public King() {
		super();
	}
	
	public King(Piece[][] b){
		super(b);
	}

	public King(Piece[][] b, Main m) {
		super(b, m);
		this.rook = new Rook(b, m);
		this.knight = new Knight(b, m);
		this.bishop = new Bishop(b, m);
		this.queen = new Queen(b, m);
	}

	public boolean isValidKing(int sourceRow, int sourceCol, int destRow, int destCol, String turn) {
		if (sourceRow < 0 || sourceRow > 7 || sourceCol < 0 || sourceCol > 7 || destRow < 0 || destRow > 7
				|| destCol < 0 || destCol > 7)
			return false;

		if (turn.equals("WHITE")) {
			// cek jika ada piece
			if (isWhitePieceExist(sourceRow, sourceCol) == false)
				return false;

			// cek jika ada piece putih di tujuan
			if (isWhitePieceExist(destRow, destCol) == true)
				return false;

			// king jalan hanya 1 langkah

			if (Math.abs(destCol - sourceCol) > 1 && Math.abs(destRow - sourceRow) > 1)
				return false;

			return true;
		} else if (turn.equals("BLACK")) {
			// cek jika ada piece
			if (isBlackPieceExist(sourceRow, sourceCol) == false)
				return false;

			// cek jika ada piece hitam di tujuan
			if (isBlackPieceExist(destRow, destCol) == true)
				return false;

			// king jalan hanya 1 langkah

			if (Math.abs(destCol - sourceCol) > 1 && Math.abs(destRow - sourceRow) > 1)
				return false;

			return true;
		} else {
			return false;
		}
	}

	public boolean isKingSafe(int kingRow, int kingCol, String turn) {
		if (turn.equals("WHITE")) {

			boolean found = false;
			int row = 0;
			int col = 0;
			// find black queen
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("Q")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if black queen can get to king
			if (queen.isValidQueen(row, col, kingRow, kingCol, turn) == true)
				return false;

			// find black knight
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("N")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if black knight can get to king
			if (knight.isValidKnight(row, col, kingRow, kingCol, turn) == true)
				return false;

			// find black bishop
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("B")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if black bishop can get to king
			if (bishop.isValidBishop(row, col, kingRow, kingCol, turn) == true)
				return false;

			// find black rook
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("R")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if black rook can get to king
			if (rook.isValidRook(row, col, kingRow, kingCol, turn) == true)
				return false;

			// check for pawn around king

			// top-right
			if (board[kingRow + 1][kingCol + 1].getPiece().equals("P"))
				return false;

			// top-left
			if (board[kingRow + 1][kingCol - 1].getPiece().equals("P"))
				return false;

		} else if (turn.equals("BLACK")) {
			boolean found = false;
			int row = 0;
			int col = 0;
			// find white queen
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("q")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if white queen can get to king
			if (queen.isValidQueen(row, col, kingRow, kingCol, turn) == true)
				return false;

			// find white knight
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("n")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if white knight can get to king
			if (knight.isValidKnight(row, col, kingRow, kingCol, turn) == true)
				return false;

			// find white bishop
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("b")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if white bishop can get to king
			if (bishop.isValidBishop(row, col, kingRow, kingCol, turn) == true)
				return false;

			// find white rook
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("r")) {
						row = i;
						col = j;
						found = true;
					}
					if (found == true)
						break;
				}
				if (found == true)
					break;
			}
			// check if white rook can get to king
			if (rook.isValidRook(row, col, kingRow, kingCol, turn) == true)
				return false;

			// check for pawn around king

			// bottom-right
			if (board[kingRow - 1][kingCol + 1].getPiece().equals("p"))
				return false;

			// bottom-left
			if (board[kingRow - 1][kingCol - 1].getPiece().equals("p"))
				return false;
		}

		return true;
	}

	public boolean isKingInCheck(String turn) {

		if (turn.equals("WHITE")) {
			// find white king location
			boolean isFound = false;
			int row = 0;
			int col = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("k")) {
						isFound = true;
						row = i;
						col = j;
					}

					if (isFound == true)
						break;
				}
				if (isFound == true)
					break;
			}

			// check if enemy knight can eat white king
			if (row + 2 <= 7 && col + 1 <= 7) {
				// bisa ke atas 2 kanan 1
				if (board[row + 2][col + 1].getPiece().equals("N")) {
					return true;
				}
			}
			if (row + 2 <= 7 && col - 1 >= 0) {
				// bisa ke atas 2 kiri 1
				if (board[row + 2][col - 1].getPiece().equals("N")) {
					return true;
				}
			}
			if (row + 1 <= 7 && col + 2 <= 7) {
				// bisa ke atas 1 kanan 2
				if (board[row + 1][col + 2].getPiece().equals("N")) {
					return true;
				}
			}
			if (row + 1 <= 7 && col - 2 >= 0) {
				// bisa ke atas 1 kiri 2
				if (board[row + 1][col - 2].getPiece().equals("N")) {
					return true;
				}
			}
			if (row - 2 >= 0 && col + 1 <= 7) {
				// bisa ke bawah 2 kanan 1
				if (board[row - 2][col + 1].getPiece().equals("N")) {
					return true;
				}
			}
			if (row - 2 >= 0 && col - 1 >= 0) {
				// bisa ke bawah 2 kiri 1
				if (board[row - 2][col - 1].getPiece().equals("N")) {
					return true;
				}
			}
			if (row - 1 >= 0 && col + 2 <= 7) {
				// bisa ke bawah 1 kanan 2
				if (board[row - 1][col + 2].getPiece().equals("N")) {
					return true;
				}
			}
			if (row - 1 >= 0 && col - 2 >= 0) {
				// bisa ke bawah 1 kiri 2
				if (board[row - 1][col - 2].getPiece().equals("N")) {
					return true;
				}
			}

			//

			// check sekitar
			// top
			for (int i = 1; i < 8; i++) {
				if (row + i > 7 || col > 7)
					break;
				if (isWhitePieceExist(row + i, col))
					break;
				if (board[row + i][col].getPiece().equals("Q")) {
					return true;
				}
			}
			// top right
			for (int i = 1; i < 8; i++) {
				if (row + i > 7 || col + i > 7)
					break;
				if (isWhitePieceExist(row + i, col + i))
					break;
				if (board[row + i][col + i].getPiece().equals("Q")) {
					return true;
				}
			}
			// top left
			for (int i = 1; i < 8; i++) {
				if (row + i > 7 || col - i < 0)
					break;
				if (isWhitePieceExist(row + i, col - i))
					break;
				if (board[row + i][col - i].getPiece().equals("Q")) {
					return true;
				}
			}
			// left
			for (int i = 1; i < 8; i++) {
				if (row > 7 || col - i < 0)
					break;
				if (isWhitePieceExist(row, col - i))
					break;
				if (board[row][col - i].getPiece().equals("Q")) {
					return true;
				}
			}
			// right
			for (int i = 1; i < 8; i++) {
				if (row > 7 || col + i > 7)
					break;
				if (isWhitePieceExist(row, col + i))
					break;
				if (board[row][col + i].getPiece().equals("Q")) {
					return true;
				}
			}
			// bottom left
			for (int i = 1; i < 8; i++) {
				if (row - i < 0 || col - i < 0)
					break;
				if (isWhitePieceExist(row - i, col - i))
					break;
				if (board[row - i][col - i].getPiece().equals("Q")) {
					return true;
				}
			}
			// bottom
			for (int i = 1; i < 8; i++) {
				if (row > 7 || col - i < 0)
					break;
				if (isWhitePieceExist(row, col - i))
					break;
				if (board[row][col - i].getPiece().equals("Q")) {
					return true;
				}
			}
			// bottom right
			for (int i = 1; i < 8; i++) {
				if (row - i < 0 || col + i > 7)
					break;
				if (isWhitePieceExist(row - i, col + i))
					break;
				if (board[row - i][col + i].getPiece().equals("Q")) {
					return true;
				}
			}

			return false;
		} else if (turn.equals("BLACK")) {
			// find black king location
			boolean isFound = false;
			int row = 0;
			int col = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j].getPiece().equals("K")) {
						isFound = true;
						row = i;
						col = j;
					}

					if (isFound == true)
						break;
				}
				if (isFound == true)
					break;
			}

			// check if enemy knight can eat black king
			if (row + 2 <= 7 && col + 1 <= 7) {
				// bisa ke atas 2 kanan 1
				if (board[row + 2][col + 1].getPiece().equals("n")) {
					return true;
				}
			}
			if (row + 2 <= 7 && col - 1 >= 0) {
				// bisa ke atas 2 kiri 1
				if (board[row + 2][col - 1].getPiece().equals("n")) {
					return true;
				}
			}
			if (row + 1 <= 7 && col + 2 <= 7) {
				// bisa ke atas 1 kanan 2
				if (board[row + 1][col + 2].getPiece().equals("n")) {
					return true;
				}
			}
			if (row + 1 <= 7 && col - 2 >= 0) {
				// bisa ke atas 1 kiri 2
				if (board[row + 1][col - 2].getPiece().equals("n")) {
					return true;
				}
			}
			if (row - 2 >= 0 && col + 1 <= 7) {
				// bisa ke bawah 2 kanan 1
				if (board[row - 2][col + 1].getPiece().equals("n")) {
					return true;
				}
			}
			if (row - 2 >= 0 && col - 1 >= 0) {
				// bisa ke bawah 2 kiri 1
				if (board[row - 2][col - 1].getPiece().equals("n")) {
					return true;
				}
			}
			if (row - 1 >= 0 && col + 2 <= 7) {
				// bisa ke bawah 1 kanan 2
				if (board[row - 1][col + 2].getPiece().equals("n")) {
					return true;
				}
			}
			if (row - 1 >= 0 && col - 2 >= 0) {
				// bisa ke bawah 1 kiri 2
				if (board[row - 1][col - 2].getPiece().equals("n")) {
					return true;
				}
			}

			//

			// check sekitar
			// top
			for (int i = 1; i < 8; i++) {
				if (row + i > 7 || col > 7)
					break;
				if (isBlackPieceExist(row + i, col))
					break;
				if (board[row + i][col].getPiece().equals("q")) {
					return true;
				}
			}
			// top right
			for (int i = 1; i < 8; i++) {
				if (row + i > 7 || col + i > 7)
					break;
				if (isBlackPieceExist(row + i, col + i))
					break;
				if (board[row + i][col + i].getPiece().equals("q")) {
					return true;
				}
			}
			// top left
			for (int i = 1; i < 8; i++) {
				if (row + i > 7 || col - i < 0)
					break;
				if (isBlackPieceExist(row + i, col - i))
					break;
				if (board[row + i][col - i].getPiece().equals("q")) {
					return true;
				}
			}
			// left
			for (int i = 1; i < 8; i++) {
				if (row > 7 || col - i < 0)
					break;
				if (isBlackPieceExist(row, col - i))
					break;
				if (board[row][col - i].getPiece().equals("q")) {
					return true;
				}
			}
			// right
			for (int i = 1; i < 8; i++) {
				if (row > 7 || col + i > 7)
					break;
				if (isBlackPieceExist(row, col + i))
					break;
				if (board[row][col + i].getPiece().equals("q")) {
					return true;
				}
			}
			// bottom left
			for (int i = 1; i < 8; i++) {
				if (row - i < 0 || col - i < 0)
					break;
				if (isBlackPieceExist(row - i, col - i))
					break;
				if (board[row - i][col - i].getPiece().equals("q")) {
					return true;
				}
			}
			// bottom
			for (int i = 1; i < 8; i++) {
				if (row > 7 || col - i < 0)
					break;
				if (isBlackPieceExist(row, col - i))
					break;
				if (board[row][col - i].getPiece().equals("q")) {
					return true;
				}
			}
			// bottom right
			for (int i = 1; i < 8; i++) {
				if (row - i < 0 || col + i > 7)
					break;
				if (isBlackPieceExist(row - i, col + i))
					break;
				if (board[row - i][col + i].getPiece().equals("q")) {
					return true;
				}
			}

			return false;
		}

		return false;
	}

}
