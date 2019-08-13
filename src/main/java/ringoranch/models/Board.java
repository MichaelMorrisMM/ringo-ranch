package ringoranch.models;

import java.util.List;

public class Board {
	
	private final List<BoardSquare> squares;
	
	public Board(List<BoardSquare> squares) {
		this.squares = squares;
	}
	
	public List<BoardSquare> getSquares() {
		return this.squares;
	}

}
