
public class ServiceManager {
	private OrderLine newOrderLine; 
	
	/**
	 * Automatically generate order. So it will called from the decrease method in Inventory
	 * @return
	 */
	public boolean checkLow() {
		
		return false;
	}
	
	
	public int calAmount(Item item) {
		return 0;
		
	}
	
	public void setOrder (Item item, int amount) {
		newOrderLine = new OrderLine(item, amount);
	}
	
	public void sendPayload (OrderLine orderLine) {
		
	}
}
