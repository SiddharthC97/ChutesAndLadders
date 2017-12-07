import java.util.Scanner;
/**
 * Class to run the game of Chutes and Ladders.
 * 
 * <p>Includes all user-level interactions with the game through the console.
 */
public class Game {
	/**
	 * Array holding the players of the game.
	 */
	private final Player[] players;
	
	/**
	 * Scanner to get user input.
	 */
	private Scanner scanner;
	
	/**
	 * Gameboard for the game.
	 */
	private Gameboard board;
	
	/**
	 * The spinner for the game.
	 */
	private Spinner spinner;
	
	/**
	 * Index of the current player who's turn it is.
	 */
	private int currentPlayerIndex;
	
	/**
	 * The current player.
	 */
	private Player currentPlayer;
	
	/**
	 * Constructor for a new game of Chutes and Ladders
	 * 
	 * @param numPlayers number of players in the game.
	 */
	public Game(int numPlayers) {
		this.players = new Player[numPlayers];
		this.scanner = new Scanner(System.in);
		this.board = new Gameboard();
		this.spinner = new Spinner();
	}

	/**
	 * Get the player at a certain index in players array.
	 * 
	 * @param index
	 * @return
	 */
	public Player getPlayerAt(int index) {
		return this.players[index];
	}
	//TODO: Finish above method and javadoc comment
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public int getCurrentPlayerIndex() {
		return this.currentPlayerIndex;
	}
	
	public void setCurrentPlayer(int index) {
		this.currentPlayerIndex = index;
		this.currentPlayer = this.getPlayerAt(currentPlayerIndex);
	}
	
	//TODO: write above javadocs
	
	//TODO: write method setPlayerAt
	//TODO: write a method for taking a standard turn of the player
	
	/**
	 * Check if specified player is on the winning square.
	 * 
	 * @param player the player to check
	 * @return true if they are on winning square, false otherwise
	 */
	public boolean isWinner(Player player) {
		if (player.getCurrentSquare().getNumber() == 100) {
			return true;
		}
		return false;
	}
	//TODO: write methods for interacting with the user and running the entire game, including the main method
	
	public static void main(String[] unused) {
		// Just being used for some testing for now to make sure classes are behaving properly
		Game game = new Game(3);
		System.out.println(game.board.getSquareOffset(null, game.spinner.spin()).getNumber());
	}
}
