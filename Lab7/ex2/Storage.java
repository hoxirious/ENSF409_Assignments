import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Storage.
 */
public class Storage {
	
	/** The sum. */
	private int sum; 
	
	/** The value list. */
	private ArrayList <Integer> valueList;
	
	/**
	 * Instantiates a new storage.
	 */
	public Storage () {
		valueList = new ArrayList<>(); 
	}
	
	/**
	 * Adds the value.
	 *
	 * @param n the n
	 */
	public void addValue(int n) {
		valueList.add(n);
	}
	
	/**
	 * Gets the list of values.
	 *
	 * @return the list
	 */
	public ArrayList <Integer> getList () {
		return valueList; 
	}
	
	/**
	 * Calculat sum.
	 */
	public void calSum () {
		for(int i : valueList ) {
			sum += i; 			
		}
	}
	
	/**
	 * Gets the sum.
	 *
	 * @return the sum
	 */
	public int getSum () {
		return sum; 
	}
}
