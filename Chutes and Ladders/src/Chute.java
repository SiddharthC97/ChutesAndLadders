/**
 * Class that represents a chute on the board. 
 */
public class Chute {
	/**
	 * The square where the chute begins.
	 */
	private Square from;
	/**
	 * The square where the chute ends.
	 */
	private Square to;
	
	/**
	 * Constructor for Chute object.
	 * Also assigns the chute to its <b>from</b> square
	 * 
	 * @param from the square where the chute starts
	 * @param to the square the player ends on after falling down chute
	 */
	public Chute(Square from, Square to) {
		this.from = from;
		this.to = to;
		this.assignChuteToSquare();
	}
	
	/**
	 * Moves a specified player to the square at the end of the chute.
	 * 
	 * <p>This method should only be called when the player is at the beginning
	 * of the chute
	 * 
	 * @param player the player to move
	 * @throws IllegalStateException
	 */
	public void fall(Player player) {
		// Throw an IllegalStateException if precondition isn't met
		if (!player.getCurrentSquare().equals(this.from)) {
			throw new IllegalStateException("Player is not at the beginning of this chute");
		}
		
		player.setCurrentSquare(to);
	}
	
	/**
	 * Assigns the current chute to the <b>from</b> Square.
	 */
	private void assignChuteToSquare() {
		from.setChute(this);
	}
}
