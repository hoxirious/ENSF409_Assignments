
public class Item {
	private int quantity, price, supID;
	private String name;
	
	
	public String getName() {
		return this.name;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getSupID() {
		return this.supID;
	}
	
	public void setQuantity (int amount) {
		this.quantity = amount;
	}
	
}
