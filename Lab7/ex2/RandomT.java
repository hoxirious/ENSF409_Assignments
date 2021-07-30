import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomT.
 */
public class RandomT {

	/** The number. */
	private int number;

	/**
	 * Instantiates a new random T.
	 */
	public RandomT() {
		randomize();
	}

	/**
	 * Randomize.
	 */
	public void randomize() {
		Random ran = new Random();
		int range = 100 - 1 + 1;
		setNum(ran.nextInt(range) + 1);
	}

	/**
	 * Sets the num.
	 *
	 * @param n the new num
	 */
	public void setNum(int n) {
		number = n;
	}

	/**
	 * Gets the num.
	 *
	 * @return the num
	 */
	public int getNum() {
		return number;
	}

}
