
/**
 * The Class Item.
 */
public class Item {
	
	/** The id. */
	private int quantity, supID, id;
	
	/** The price. */
	private double price; 
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new item.
	 *
	 * @param i the i
	 * @param name the name
	 * @param q the q
	 * @param p the p
	 * @param sI the s I
	 */
	public Item(int i, String name, int q, double p, int sI) {
		setID(i);
		setName(name);
		setQuantity(q);
		setPrice(p);
		setSupID(sI);
	}
	
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Gets the sup ID.
	 *
	 * @return the sup ID
	 */
	public int getSupID() {
		return this.supID;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return this.id; 
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param amount the new quantity
	 */
	public void setQuantity (int amount) {
		this.quantity = amount;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price; 
	}
	
	/**
	 * Sets the sup ID.
	 *
	 * @param supID the new sup ID
	 */
	public void setSupID(int supID) {
		this.supID = supID;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setID(int id) {
		this.id =id;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName (String name) {
		this.name =name; 
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += "Item Name: " + getName() + "\n";
		st += "Item ID: " + getID() + "\n";
		st += "Item Price:" + getPrice() + "\n";
		st += "Item Quantity: " + getQuantity() + "\n";
		st += "Item Supplier: " + getSupID() + "\n";
		st += "\n-----------\n";
		return st;
		
	}
}
