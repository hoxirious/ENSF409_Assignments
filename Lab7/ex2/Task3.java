import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class Task3.
 */

public class Task3 implements Runnable {

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
	public Task3(Storage st) {
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
	public static void main(String[] args)  throws InterruptedException {
		/** The number of desired threads **/
		int numThreads = 5;

		/** Creation of fixed thread pool **/
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		
		/** Initialize new storage for threads**/
		Storage store = new Storage();

		/** Execute threads **/
		for (int i = 0; i < 5; i++) {
			executor.submit (new Task3(store));
		}
		
		executor.shutdown();
		
		boolean taskCompleted =	executor.awaitTermination(1,  TimeUnit.MINUTES);
		
		/** Call method sum calculation in storage once all tasks completed **/
		if( taskCompleted) {
			store.calSum();
			
			/** Print out the final sum **/
			System.out.println("The sum is: " + store.getSum());			
		}
				
	}
}
