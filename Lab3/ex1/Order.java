import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Order {
	private ArrayList<OrderLine> shoppingList;
	private LocalDateTime dateOrder;
	private int orderID;

	public Order() {
		shoppingList = new ArrayList<OrderLine>();
		generateID();
		dateOrder = java.time.LocalDateTime.now();
	}

	public void generateID() {
		Random ran = new Random();
		int range = 99999 - 10000 + 1;
		setID(ran.nextInt(range) + 10000);
	}

	public void setID(int ID) {
		orderID = ID;
	}
	
	public int getID() {
		return orderID;
	}
	
	public LocalDateTime getDateOrder() {
		return dateOrder; 
	}
	
	public void addToList(OrderLine theOrderLine) {
		try {
			shoppingList.add(theOrderLine);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("The Shopping List is not available");
		}
	}

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
