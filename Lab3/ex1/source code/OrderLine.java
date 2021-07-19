

/**
 * The Class OrderLine.
 */
public class OrderLine {
	
	/** The item need. */
	private Item itemNeed;
	
	/** The amount need. */
	private int amountNeed;
	
	/** The supp. */
	private Supplier supp; 
	

	/**
	 * Instantiates a new order line.
	 *
	 * @param item the item
	 * @param amount the amount
	 * @param supp the supp
	 */
	public OrderLine(Item item, int amount, Supplier supp) {
		generateOrderLine(item, amount, supp);
	}

	/**
	 * Generate order line.
	 *
	 * @param item the item
	 * @param amount the amount
	 * @param supp the supp
	 */
	public void generateOrderLine(Item item, int amount, Supplier supp) {
		setItem(item);
		setAmount(amount);
		setSupp(supp);
	}

	/**
	 * Sets the item.
	 *
	 * @param item the new item
	 */
	public void setItem(Item item) {
		this.itemNeed = item;
	}
	
	/**
	 * Sets the supp.
	 *
	 * @param supp the new supp
	 */
	public void setSupp (Supplier supp) {
		this.supp = supp; 
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(int amount) {
		this.amountNeed = amount;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public int getAmount () {
		return this.amountNeed;
	}
	
	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public Item getItem () {
		return this.itemNeed;
	}
	
	/**
	 * Gets the supplier.
	 *
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return this.supp;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String st = "\n";
		
		st += "Item Description: " + getItem().getName() + "\n";
		st += "Amount ordered: " + getAmount() + "\n";
		st += "Supplier: " + getSupplier().getName() + "\n"; 
		return st;
	}

}
