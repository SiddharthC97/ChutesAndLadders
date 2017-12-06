/**
 * Class that represents a ladder on the board.
 */
public class Ladder {
	/**
	 * The square where the ladder begins.
	 */
	private Square from;
	/**
	 * The square where the ladder ends.
	 */
	private Square to;
	
	/**
	 * Constructor for Ladder object.
	 * Also assigns the ladder to its <b>from</b> square.
	 * 
	 * @param from the square where the ladder starts at
	 * @param to the square that the player ends at after climbing the ladder
	 */
	public Ladder(Square from, Square to) {
		this.from = from;
		this.to = to;
		this.assignLadderToSquare();
	}
	
	/**
	 * Moves a specified player to the square at the end of the ladder.
	 * 
	 * <p>This method should only be called when the player is at the beginning
	 * of the ladder
	 * 
	 * @param player the player to move
	 * @throws IllegalStateException
	 */
	public void climb(Player player) {
		// Throw an IllegalStateException if precondition isn't met
		if (!player.getCurrentSquare().equals(this.from)) {
			throw new IllegalStateException("Player is not at the beginning of this ladder");
		}
		
		player.setCurrentSquare(to);
	}
	
	/**
	 * Assigns the current ladder to the <b>from</b> Square.
	 */
	private void assignLadderToSquare() {
		from.setLadder(this);
	}
}
