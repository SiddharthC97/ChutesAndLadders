/**
 * Class that represents the Chutes and Ladders board to be played on.
 */
public class Gameboard {
	/**
	 * The board containing the squares for the game.
	 */
	private Square[] board;
	

	/**
	 * Constant of 100 for the board's size.
	 */
	private static final int BOARD_SIZE = 100;
	
	/**
	 * The constructor for the game board.
	 * Creates a game board with 100 (standard game size) squares.
	 */
	public Gameboard() {
		this.board = new Square[100];
		this.fillBoard();
	}
	
	/**
	 * Fills the empty game board with squares.
	 * Also adds ladders and chutes where necessary.
	 */
	public void fillBoard() {
		// Make all squares with incrementing numbers
		for (int index = 0; index < BOARD_SIZE; index++) {
			this.board[index] = new Square(index + 1);
		}
		
		// Add ladders and chutes, numbers come from the Chutes and Ladders board game
		// Note that indexes start at 0
		new Ladder(this.getSquareAt(0), this.getSquareAt(37));
		new Ladder(this.getSquareAt(3), this.getSquareAt(15));
		new Ladder(this.getSquareAt(8), this.getSquareAt(30));
		new Chute(this.getSquareAt(15), this.getSquareAt(5));
		new Ladder(this.getSquareAt(20), this.getSquareAt(41));
		new Ladder(this.getSquareAt(27), this.getSquareAt(83));
		new Ladder(this.getSquareAt(35), this.getSquareAt(43));
		new Chute(this.getSquareAt(47), this.getSquareAt(25));
		new Chute(this.getSquareAt(48), this.getSquareAt(10));
		new Ladder(this.getSquareAt(50), this.getSquareAt(66));
		new Chute(this.getSquareAt(55), this.getSquareAt(52));
		new Chute(this.getSquareAt(61), this.getSquareAt(18));
		new Chute(this.getSquareAt(63), this.getSquareAt(59));
		new Ladder(this.getSquareAt(70), this.getSquareAt(90));
		new Ladder(this.getSquareAt(79), this.getSquareAt(99));
		new Chute(this.getSquareAt(86), this.getSquareAt(23));
		new Chute(this.getSquareAt(92), this.getSquareAt(72));
		new Chute(this.getSquareAt(94), this.getSquareAt(74));
		new Chute(this.getSquareAt(97), this.getSquareAt(77));
	}
	
	/**
	 * Gets the square object at a given index in the board.
	 * 
	 * @param index the index of the square object to get
	 * @return the square object at the index, null if index out of bounds
	 */
	private Square getSquareAt(int index) {
		if (index >= this.board.length || index < 0) {
			return null;
		}
		return this.board[index];
	}

	
	/**
	 * Get a square with a given offset amount from specified square.
	 * 
	 * <p>To be used to move players by a certain amount
	 * 
	 * <p>If the specified square is null (i.e. off the board before the first turn)
	 * this method will offset from the first square on the board
	 * 
	 * @param square the square from which the offset will be based
	 * @param offset the amount of squares to move by
	 * @return another square after offset is applied, null if off the board after offset
	 */
	public Square getSquareOffset(Square square, int offset) {
		// If the square is null (i.e. before first turn), we move a certain number of squares from the beginning
		if (square == null) {
			return this.getSquareAt(offset - 1);
		}
		int currentIndex = square.getNumber() - 1;
		int nextIndex = currentIndex + offset;
		return this.getSquareAt(nextIndex); // Returns null if the index is out of bounds
	}
}
