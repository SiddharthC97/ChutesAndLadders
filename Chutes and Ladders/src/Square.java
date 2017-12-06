/**
 * Class that represents a square or space on the board.
 */
public class Square {
	/**
	 * The number of the square.
	 */
	private final int number;
	/**
	 * The ladder that begins at the square.
	 * Is null if there is no ladder for the square.
	 */
	private Ladder ladder;
	/**
	 * The chute that begins at the square.
	 * Is null if there is no chute for the square.
	 */
	private Chute chute;
	
	/**
	 * Constructor for a normal Square object.
	 * @param num the number of the square
	 */
	public Square(final int num) {
		this.number = num;
	}
	
	/**
	 * Constructor for a Square object with a ladder.
	 * @param num the number of the square
	 * @param ladder the ladder starting at the square
	 */
	public Square(final int num, final Ladder ladder) {
		this.number = num;
		this.ladder = ladder;
	}
	
	/**
	 * Constructor for a Square object with a chute.
	 * @param num the number of the square
	 * @param chute the chute that starts at the square
	 */
	public Square(final int num, final Chute chute) {
		this.number = num;
		this.chute = chute;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the ladder
	 */
	public Ladder getLadder() {
		return ladder;
	}

	/**
	 * @param ladder the ladder to set
	 */
	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
	}

	/**
	 * @return the chute
	 */
	public Chute getChute() {
		return chute;
	}

	/**
	 * @param chute the chute to set
	 */
	public void setChute(Chute chute) {
		this.chute = chute;
	}
	
}
