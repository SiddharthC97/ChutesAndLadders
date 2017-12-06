/**
 * Class that represents the Chutes and Ladders board to be played on.
 */
public class Gameboard {
	/**
	 * The board containing the squares for the game.
	 */
	private Square[] board;
	
	/**
	 * True if board is created, false otherwise.
	 */
	private boolean boardCreated;
	
	/**
	 * Constant of 100 for the board's size.
	 */
	private static final int BOARD_SIZE = 100;
	
	/**
	 * The constructor for the game board.
	 * Creates a game board with 100  (standard game size) empty 
	 * square object references.
	 */
	public Gameboard() {
		this.board = new Square[100];
		this.boardCreated = false;
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
		
		this.boardCreated = true;
	}
	
	/**
	 * Gets the square object at a given index in the board.
	 * 
	 * @param index the index of the square object to get
	 * @return the square object at the index
	 */
	private Square getSquareAt(int index) {
		return this.board[index];
	}
	
	//TODO: add method to check if there is a player on the winning square.
	//TODO: add method to check if board is created (getter method)
}
