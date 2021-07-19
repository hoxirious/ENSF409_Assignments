import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Inventory.
 */
public class Inventory {

	/** The item list. */
	private ArrayList<Item> itemList;

	private ArrayList<Supplier> suppList;

	/** The shopping cart. */
	private Order shoppingCart;

	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		shoppingCart = new Order();
		try {
			itemList = new FileManager().readStorage();
			suppList = new FileManager().readSupplier();
			for (Item each : itemList) {
				orderAction(each, each.getQuantity());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the shopping cart.
	 *
	 * @return the shopping cart
	 */
	public Order getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * Delete item.
	 *
	 * @param item the item
	 */
	public void deleteItem(Item item) {
		int index = searchByName(item.getName());
		itemList.remove(index);
	}

	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
	public void addItem(Item item) {
		int index1 = searchByName(item.getName());
		int index2 = searchByID(item.getID());
		if (index1 == -1 && index2 == -1) {
			itemList.add(item);
		} else {
			System.err.println("The item existed already, my friend");
		}
	}

	/**
	 * Gets the item list.
	 *
	 * @return the item list
	 */
	public ArrayList<Item> getItemList() {
		try {
			return itemList;

		} catch (Exception e) {

			// TODO: handle exception
			System.err.println("No item available. Something went wrong!!");
			return null;
		}
	}

	public ArrayList<Supplier> getSuppList() {
		try {
			return suppList;

		} catch (Exception e) {

			// TODO: handle exception
			System.err.println("No suppliers available. Something went wrong!!");
			return null;
		}
	}

	/**
	 * Search by name.
	 *
	 * @param name the name
	 * @return the int
	 */
	public int searchByName(String name) {
		int i = 0;
		for (Item f : itemList) {
			if (f.getName().equals(name)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * Search by ID.
	 *
	 * @param ID the id
	 * @return the int
	 */
	public int searchByID(int ID) {
		int i = 0;
		for (Item f : itemList) {
			if (f.getID() == ID) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private int searchSupplier(int ID) {
		int i = 0;
		for (Supplier s : suppList) {

			if (s.getID() == ID) {
				return i;
			}
			i++;
		}

		return -1;
	}

	/**
	 * Order action.
	 *
	 * @param theItem  the the item
	 * @param itemLeft the item left
	 */
	private void orderAction(Item theItem, int itemLeft) {
		// TODO: trigger the order action
		if (itemLeft <= 40) {
			try {
				int indexSupp = searchSupplier(theItem.getSupID());
				if(indexSupp != -1) {
					
				int amountNeeded = 50 - itemLeft;

				shoppingCart.addToList(new OrderLine(theItem, amountNeeded, suppList.get(indexSupp)));
			}

			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("No item available. Something wrong!!");
			}
		}
	}

	/**
	 * Decrease quantity.
	 *
	 * @param ID the ID
	 * @param lost the lost
	 */
	public void decreaseQuantity(int ID, int lost) {
		int index = searchByID(ID);

		if (index == -1) {
			System.err.println("The item's name is not valid");
		} else {
			Item theItem = itemList.get(index);
			int itemQuantity = theItem.getQuantity();
			int itemLeft = itemQuantity - lost;
			theItem.setQuantity(itemLeft);

			orderAction(theItem, itemLeft);
		}
	}

	/**
	 * Save changes.
	 */
	public void outputOrders() {
		try {
			FileWriter outputStream = new FileWriter("E:\\FormCanada\\UOC\\S2021\\ENSF409\\ENSF409_Assignments\\Lab3\\ex1\\orders.txt");
			String c = shoppingCart.toString();
			outputStream.append(c);			
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
