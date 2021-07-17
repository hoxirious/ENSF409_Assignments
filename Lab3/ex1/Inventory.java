import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList; 

	//should we extend serviceManager into Inventory?
	
	
	/**
	 * Call the Amount observer when reach the condition
	 * @param item
	 */
	public void deleteItem(Item item) {
		
	}
	
	public void addItem(Item item) {
		
	}
	
	public Item searchByName(String name) {
		
		return null;
	}
	
	public Item searchByID(int ID) {
		return null;
	}

	/**
	 * Read data from Database
	 */
	public void fetchData() {
		
	}
	
	/**
	 * Save data to database
	 */
	public void saveData() {
		
	}
	
	@Override
	public String toString() {
		
		return null;
	}
}
