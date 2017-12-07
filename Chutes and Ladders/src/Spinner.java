import java.util.Random;
/**
 * Class to represent the spinner used in game play.
 * Generates random numbers from 1-6.
 */
public class Spinner {
	/**
	 * Random number generator.
	 */
	private Random generator;
	
	/**
	 * Maximum value for the spinner to take between 0 and MAX_VALUE.
	 * Normally should be 6.
	 */
	private static final int MAX_VALUE = 6;
	
	/**
	 * Blank constructor for Spinner.
	 */
	public Spinner() {
		this.generator = new Random();
	}
	
	/**
	 * Spins the spinner to generate a random number.
	 * 
	 * @return a random number between 0 and specified MAX_VALUE
	 */
	public int spin() {
		return generator.nextInt(MAX_VALUE + 1); // bound is exclusive
	}
}
