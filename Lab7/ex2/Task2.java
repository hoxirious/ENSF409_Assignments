import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Task2.
 */

public class Task2 implements Runnable {

	/** The Random object. */
	private RandomT theNumber;

	/** The value that has been randomized. */
	private int value;

	/**  The store connection between threads *. */
	private Storage store;

	
	/**
	 * Instantiates a new task 2.
	 *
	 * @param st the storage
	 */
	public Task2(Storage st) {
		store = st;
	}

	/**
	 * Create object RandomT. And store the random number to the member varible
	 */
	public void run() {
		theNumber = new RandomT();
		value = theNumber.getNum();
		System.out.println(Thread.currentThread().getName() + ": " + value);
		store.addValue(value);
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
	 * Gets the store.
	 *
	 * @return the store
	 */
	public Storage getStore () {
		return store;
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
		
		/** Initialize new storage for threads**/
		Storage store = new Storage();

		/** Initialize and Start threads **/
		for (int i = 0; i < numThreads; i++) {
			myRunnable[i] = new Task2(store);
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
		
		/** Call method sum calculation in storage **/
		store.calSum();
				
		/** Print out the final sum **/
		System.out.println("The sum is: " + store.getSum());
	}
}
