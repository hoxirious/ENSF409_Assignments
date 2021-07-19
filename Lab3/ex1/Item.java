
public class Item {
	private int quantity, supID, id;
	private double price; 
	private String name;
	
	public Item(int i, String name, int q, double p, int sI) {
		setID(i);
		setName(name);
		setQuantity(q);
		setPrice(p);
		setSupID(sI);
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getSupID() {
		return this.supID;
	}
	
	public int getID() {
		return this.id; 
	}
	
	public void setQuantity (int amount) {
		this.quantity = amount;
	}
	
	public void setPrice(double price) {
		this.price = price; 
	}
	
	public void setSupID(int supID) {
		this.supID = supID;
	}
	
	public void setID(int id) {
		this.id =id;
	}
	public void setName (String name) {
		this.name =name; 
	}
	
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
