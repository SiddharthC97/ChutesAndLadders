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
	private static Scanner scanner = new Scanner(System.in);
	
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
	 * Separator to use when printing to console.
	 */
	private static final String SEPARATOR = "----------";
	
	/**
	 * Maximum number of players in the game.
	 */
	private static final int MAX_PLAYERS = 4;
	
	/**
	 * Minimum number of players in the game.
	 */
	private static final int MIN_PLAYERS = 2;
	
	/**
	 * Constructor for a new game of Chutes and Ladders
	 * 
	 * @param numPlayers number of players in the game.
	 */
	public Game(int numPlayers) {
		this.players = new Player[numPlayers];
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


	/**
	 * Set a player at a certain index in the players array
	 * @param player the player to set
	 * @param index index in the array where the player will be placed
	 */
	public void setPlayerAt(Player player, int index) {
		this.players[index] = player;
	}
	
	/**
	 * Gets the current player.
	 * @return the current player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	/**
	 * Gets the index of the current player in the Player array.
	 * @return the index of the current player
	 */
	public int getCurrentPlayerIndex() {
		return this.currentPlayerIndex;
	}
	
	/**
	 * Sets the current player in the Player array.
	 * @param index the index of the player to set as current
	 */
	public void setCurrentPlayer(int index) {
		this.currentPlayerIndex = index;
		this.currentPlayer = this.getPlayerAt(currentPlayerIndex);
	}
	
	/**
	 * Prompts user for names of players and adds them to the array.
	 */
	public void addPlayers() {
		for (int playerNum = 0; playerNum < this.players.length; playerNum++) {
			// Ask for name
			System.out.print("Enter the name for Player #" + (playerNum + 1) + ": ");
			String name = scanner.nextLine();
			this.players[playerNum] = new Player(name);
			System.out.println(SEPARATOR);
		}
	}
	
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
	
	public Player determineFirstPlayer() {
		int[] values = new int[this.players.length];
		for (int playerNum = 0; playerNum < this.players.length; playerNum++) {
			Player player = this.getPlayerAt(playerNum);
			int spinValue = this.spinner.spin();
			values[playerNum] = spinValue;
			System.out.println(player.getName() + " spun a " + spinValue);
		}
		return null;
	}

	
	/**
	 * Asks user for the number of players that will be playing.
	 * 
	 * @return the number of players that will be playing
	 */
	public static int askNumPlayers() {
		int numPlayers = 0;
		while (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
			System.out.println("How many players will be playing?");
			System.out.println("(Enter a number between " + MIN_PLAYERS + " and " + MAX_PLAYERS + ")");
			try {
				numPlayers = scanner.nextInt();
			} catch (Exception e) {
				scanner.nextLine();
				continue;
			}
		}
		scanner.nextLine(); // Clears the newline character
		return numPlayers;
	}
	
	/**
	 * Begin the game of Chutes and Ladders.
	 * 
	 * <p>Gives a welcome message and get user input on how many players there are. 
	 * Then it creates an object with that number of players.
	 * 
	 * @return a new Game object with the number of players the user specifies.
	 */
	public static Game beginGame() {
		// 
		System.out.println("CHUTES AND LADDERS \nBy Bradley Fishman and Siddharth Chadha \n" + SEPARATOR);
		int numPlayers = askNumPlayers();
		System.out.println(SEPARATOR);
		return createNewGame(numPlayers);
	}
	
	/**
	 * Creates then returns a new instance of Game.
	 * @param numPlayers number of players in the game
	 * @return a new instance of Game
	 */
	public static Game createNewGame(int numPlayers) {
		return new Game(numPlayers);
	}
	
	public void nextPlayer() {
		if(this.currentPlayerIndex == this.players.length - 1) {
			this.setCurrentPlayer(0);
		} else {
			this.setCurrentPlayer(++this.currentPlayerIndex);
		}
	}
	
	public void resetPlayers() {
		for(Player player : this.players) {
			player.setCurrentSquare(null);
		}
	}
	
	//TODO: write a method for taking a standard turn of the player

	//TODO: write methods for interacting with the user and running the entire game, including the main method
	
	public static void main(final String[] unused) {
		boolean continuePlaying = true;
		Game game = null;
		Player currentPlayer;
		
		// Initialize the game
		game = beginGame();
		game.addPlayers();
		
		while (continuePlaying) {
			// Let's begin
			System.out.println("\nLet's start!\n");
			System.out.println("All players are off the board to start.");
			System.out.println("The first player will be determined by the highest number on the spinner.\n");
			game.setCurrentPlayer(0); // TODO: CHANGE THIS TO DETERMINEFIRSTPLAYER
			System.out.println(game.getCurrentPlayer().getName() + " goes first... \n" + SEPARATOR);
			
			while (true) {
				currentPlayer = game.getCurrentPlayer();
				System.out.println("It is " + currentPlayer.getName() + "\'s turn.");
				System.out.println("Press enter to spin...");
				scanner.nextLine();
				int spinNumber = game.spinner.spin();
				System.out.println("You spun a " + spinNumber);
				Square oldSquare = currentPlayer.getCurrentSquare();
				int oldSquareNum = 0;
				if (oldSquare != null) {
					oldSquareNum = oldSquare.getNumber();
				}
				if(!currentPlayer.makeMove(spinNumber, game.board)) {
					System.out.println("You can't make that move, wait until your next turn.");
					System.out.println(SEPARATOR);
					game.nextPlayer();
					continue;
				}
				int newSquareNum = currentPlayer.getCurrentSquare().getNumber();
				System.out.println("You moved from square " + oldSquareNum + " to " + newSquareNum);
				oldSquareNum = newSquareNum;
				if(currentPlayer.checkChuteLadder()) {
					newSquareNum = currentPlayer.getCurrentSquare().getNumber();
					System.out.println("You moved from square " + oldSquareNum + " to " + newSquareNum);
				}
				
				if(game.isWinner(currentPlayer)) {
					break;
				}
				System.out.println(SEPARATOR);
				game.nextPlayer();
			}
			System.out.println(currentPlayer.getName() + " won!");
			currentPlayer.incrementWins();
			System.out.println(SEPARATOR);
			for (int playerNum = 0; playerNum < game.players.length; playerNum++) {
				Player player = game.getPlayerAt(playerNum);
				System.out.println(player.getName() + ": " + player.getNumWins() + " wins");
			}
			System.out.println(SEPARATOR);
			
			// Prompt for play again
			System.out.println("Play again?");
			int playAgainResponse = 0;
			while(playAgainResponse < 1 || playAgainResponse > 2) {
				try {
					System.out.println("Type the corresponding number to respond...");
					System.out.println("Yes: 1 \nNo: 2");
					playAgainResponse = scanner.nextInt();
				} catch (Exception e) {
					scanner.nextLine();
					continue;
				}
			}
			scanner.nextLine();
			game.resetPlayers();
			if (playAgainResponse == 2) {
				continuePlaying = false;
			}
		}
		System.out.println("Thanks for playing!");
	}
}
