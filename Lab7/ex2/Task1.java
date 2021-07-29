
// TODO: Auto-generated Javadoc
/**
 * The Class Task1.
 */
public class Task1 implements Runnable {

	/** The Random object. */
	private RandomT theNumber;

	/** The value that has been randomized. */
	private int value;

	/**
	 * Run. Create object RandomT. And store the random number to the member varible
	 */
	public void run() {
		theNumber = new RandomT();
		value = theNumber.getNum();
		System.out.println(Thread.currentThread().getName() + ": " + value);
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value that has been randomized.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		/** The number of desired threads **/
		int numThreads = 5;

		/** Declare the array of objects **/
		Runnable myRunnable[] = new Runnable[numThreads];
		Thread myThreads[] = new Thread[numThreads];
		Task1 myValues[] = new Task1[numThreads];

		/** Initialize and Start threads **/
		for (int i = 0; i < numThreads; i++) {
			myValues[i] = new Task1();
			myRunnable[i] = myValues[i];
			myThreads[i] = new Thread(myRunnable[i]);
			myThreads[i].start();
		}

		/** Wait until every threads finish **/
		for (Thread thread : myThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		/** Loop through objects to get sum up the value **/
		int sum = 0;
		for (Task1 value : myValues) {
			int theValue = value.getValue();
			if (theValue != -1) {
				sum += theValue;
			} else {
				System.err.println("The value is invalid");
				break;
			}
		}

		/** Print out the final sum **/
		System.out.println("The sum is: " + sum);
	}
}
