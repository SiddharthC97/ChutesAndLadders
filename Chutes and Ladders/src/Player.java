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
	
	/**
	 * Move the player by a specified number of spaces.
	 * 
	 * Also makes player fall down chute or climb ladder if it lands on
	 * one of those squares.
	 * 
	 * @param number the number of spaces to move
	 * @param board the board to move on
	 * @return true if the move was successful (i.e. didn't place player out of bounds), false otherwise
	 */
	public boolean makeMove(int number, Gameboard board) {
		Square nextSquare = board.getSquareOffset(this.currentSquare, number);
		if (nextSquare == null) {
			return false;
		}
		this.currentSquare = nextSquare;
		return true;
	}
	
	/**
	 * Check if the player is on a square with a chute or a ladder.
	 * If they are, the method has the player climb the ladder or fall down chute.
	 * 
	 * @return true if a ladder or chute is encountered, false otherwise
	 */
	public boolean checkChuteLadder() {
		if (this.getCurrentSquare().getChute() != null) {
			System.out.println("Uh oh! You landed on a chute :(");
			this.getCurrentSquare().getChute().fall(this);
			return true;
		}
		if (this.getCurrentSquare().getLadder() != null) {
			System.out.println("You landed on a ladder");
			this.getCurrentSquare().getLadder().climb(this);
			return true;
		}
		return false;
	}
}
