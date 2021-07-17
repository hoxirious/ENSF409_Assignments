
public class OrderLine {
	private Item itemNeed;
	private int amountNeed;

	public OrderLine(Item item, int amount) {
		generateOrderLine(item, amount);
	}

	public void generateOrderLine(Item item, int amount) {
	}

	public void setItem(Item item) {
		itemNeed = item;
	}

	public void setAmount(int amount) {
		this.amountNeed = amount;
	}

}
