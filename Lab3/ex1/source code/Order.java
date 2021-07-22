import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * The Class Order.
 */
public class Order {
	
	/** The shopping list. */
	private ArrayList<OrderLine> shoppingList;
	
	/** The date order. */
	private LocalDateTime dateOrder;
	
	/** The order ID. */
	private int orderID;

	/**
	 * Instantiates a new order.
	 */
	public Order() {
		shoppingList = new ArrayList<OrderLine>();
		generateID();
		dateOrder = java.time.LocalDateTime.now();
	}

	/**
	 * Generate ID.
	 */
	public void generateID() {
		Random ran = new Random();
		int range = 99999 - 10000 + 1;
		setID(ran.nextInt(range) + 10000);
	}

	/**
	 * Sets the id.
	 *
	 * @param ID the new id
	 */
	public void setID(int ID) {
		orderID = ID;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return orderID;
	}
	
	/**
	 * Gets the date order.
	 *
	 * @return the date order
	 */
	public LocalDateTime getDateOrder() {
		return dateOrder; 
	}
	
	/**
	 * Adds the to list.
	 *
	 * @param theOrderLine the the order line
	 */
	public void addToList(OrderLine theOrderLine) {
		try {
			shoppingList.add(theOrderLine);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("The Shopping List is not available");
		}
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String st = "\n";
		st += "*****************************************\n";
		st += "ORDER ID: " + getID() + "\n";
		st += "Date Ordered: " + getDateOrder() + "\n";
		for(OrderLine ol : shoppingList) {
			st += ol.toString();
		}
		st += "*****************************************\n";
		return st;
	}

}
