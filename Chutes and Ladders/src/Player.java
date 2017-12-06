/**
 * Class that holds information about each player in the game.
 */
public class Player {
	/**
	 * The name of the player.
	 */
	private String name;
	/**
	 * The square the player is currently on.
	 * The game starts with the currentSquare being null.
	 */
	private Square currentSquare;
	/**
	 * The number of wins the player has.
	 */
	private int numWins;
	
	/**
	 * Constructor for the Player.
	 * @param name name of player
	 */
	public Player(String name) {
		this.name = name;
		this.currentSquare = null; // Game starts off the board
		this.numWins = 0;
	}

	/**
	 * @return the currentSquare
	 */
	public Square getCurrentSquare() {
		return currentSquare;
	}

	/**
	 * @param currentSquare the currentSquare to set
	 */
	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the numWins
	 */
	public int getNumWins() {
		return numWins;
	}
	
	/**
	 * Increment the number of wins by 1.
	 */
	public void incrementWins() {
		this.numWins += 1;
	}
	
	//TODO: add method to move x number of spaces
	//TODO: add methods that check if the player is currently on a square with chute/ladder/etc.
	//TODO: add method to check if on winning square
}
