
public class OrderLine {
	private Item itemNeed;
	private int amountNeed;
	private Supplier supp; 
	

	public OrderLine(Item item, int amount, Supplier supp) {
		generateOrderLine(item, amount, supp);
	}

	public void generateOrderLine(Item item, int amount, Supplier supp) {
		setItem(item);
		setAmount(amount);
		setSupp(supp);
	}

	public void setItem(Item item) {
		this.itemNeed = item;
	}
	
	public void setSupp (Supplier supp) {
		this.supp = supp; 
	}

	public void setAmount(int amount) {
		this.amountNeed = amount;
	}
	
	public int getAmount () {
		return this.amountNeed;
	}
	public Item getItem () {
		return this.itemNeed;
	}
	
	public Supplier getSupplier() {
		return this.supp;
	}
	
	@Override
	public String toString() {
		String st = "\n";
		
		st += "Item Description: " + getItem().getName() + "\n";
		st += "Amount ordered: " + getAmount() + "\n";
		st += "Supplier: " + getSupplier().getName() + "\n"; 
		return st;
	}

}
