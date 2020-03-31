package chess;

public class Piece {
	private String symbol;
	private String block;
	
	public Piece(){}
	
	public Piece(String piece) {
		this.symbol = piece;
		
	}
	
	public void setBlock(String blockColor){
		this.block = blockColor;
	}
	public String getBlock(){
		return this.block;
	}
	
	public void setPiece(String piece){
		this.symbol = piece;
	}
	public String getPiece(){
		if(symbol.equals("p") || symbol.equals("P") ||
			symbol.equals("r") || symbol.equals("R") ||
			symbol.equals("n") || symbol.equals("N") ||
			symbol.equals("b") || symbol.equals("B") ||
			symbol.equals("q") || symbol.equals("Q") ||
			symbol.equals("k") || symbol.equals("K") 
			){
			return this.symbol;			
		}
		else{
			if(block.equals("WHITE")) return "-";
			else return "+";
		}

	}

}
