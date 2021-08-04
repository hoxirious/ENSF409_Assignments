import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomT.
 */
public class RandomT {

	/** The number. */
	private int number;
	private static int s; 

	/**
	 * Instantiates a new random T.
	 */
	public RandomT() {
		randomize();
	}
	
	public static void add () {
		this.s = 2; 
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
	
	public static void main(String []args){
		RandomT a = new RandomT(); 
		a.add();
     }

}
