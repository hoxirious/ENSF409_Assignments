import java.util.ArrayList;

// TODO: Auto-generated Javadoc

/**
 * The Class SimpleList.
 *
 * @author Hy Huynh, Hao Nguyen
 * @version 1.0
 */

public class SimpleList {

	/** The list of the items. */
	private ArrayList<Integer> node = new ArrayList<Integer>();

	/** The size M. */
	private int sizeM;

	/**
	 * Size.
	 *
	 * @return sizeM the size of the List
	 */
	public int size() {
		return sizeM;
	}

	/**
	 * Instantiates a new simple list with size of 0.
	 */
	public SimpleList() {
		sizeM = 0;
	}

	/**
	 * Push back. Adds a node with an item to the end of the list, and increments
	 * sizeM
	 * 
	 * @param item the value
	 */
	public void push_back(int item) {
		node.add(item);
		sizeM++;
	}

	/**
	 * Push front. Adds a node with an item to the beginning of the list, and
	 * increments sizeM
	 * 
	 * @param item the value
	 */
	public void push_front(int item) {
		node.add(0, item);
		sizeM++;
	}

	/**
	 * Pop back. The last node int list is removedm, and decrements sizeM
	 * 
	 * @param item the value
	 */
	public void pop_back(int item) {
		node.remove(size() - 1);
		sizeM--;
	}

	/**
	 * Gets the item at the nth position in the list.
	 *
	 * @param n the position
	 * @return the item
	 */
	public int get(int n) {
		if (n < 0 || n > size() - 1) {
			System.err.println("Error: n position is invalid");
			return -1;
		} else
			return node.get(n);
	}

	/**
	 * Sets the value of v at the i-th position.
	 *
	 * @param i the position
	 * @param v the item
	 */
	public void set(int i, int v) {
		node.set(i, v);
	}

	/**
	 * Insert the item at position nth, and increment sizeM. if n == sizeM calles
	 * push_back if n == 0 calls push_front if n < 0 or n > sizeM returns and does
	 * nothing.
	 * 
	 * @param theItem the item
	 * @param n       the position
	 */
	public void insert(int theItem, int n) {
		if (n < 0 || n > sizeM)
			return;
		else if (n == 0)
			push_front(theItem);
		else if (n == sizeM)
			push_back(theItem);
		else {
			node.add(n, theItem);
			sizeM++;
		}
	}

	/**
	 * Removes the item at position nth.
	 *
	 * @param n the position
	 */
	public void remove(int n) {
		if (n < 0 || n > sizeM - 1) {
			System.err.println("Error: n position is invalid");
		} else if (node.isEmpty()) {
			System.err.println("Error: list is empty");
		} else {
			node.remove(n);
			sizeM--;
		}
	}

	/**
	 * Clear the List, and set sizeM to 0.
	 */
	public void clear() {
		node.clear();
		sizeM = 0;
	}

	/**
	 * Prints out values inside the List.
	 */
	public void print() {
		for (int i = 0; i < node.size(); i++) {
			System.out.print(node.get(i) + "  ");
		}
		System.out.println();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		SimpleList list = new SimpleList();

		System.out.println("\nList just after creation -- is empty.");

		list.push_front(50);
		System.out.println("\nAfter calling push_front. list must have: 50\n");
		list.print();

		list.push_back(440);

		list.set(0, 770);
		System.out.println("\nAfter calling push_back and set function list must have: 770  440\n");
		list.print();

		list.push_back(330);
		list.push_back(220);
		list.push_back(110);

		System.out.println("\nAfter three more calls to push_back, list must have:" + "770, 440, 330, 220, 110\n");
		list.print();

		list.remove(0);
		list.remove(2);
		System.out.println("\nAfter removing two nodes. list must have: 440, 330, 110\n");
		list.print();
		list.insert(40, 3); // insert node with the value of 40 at the 4th position
		list.insert(20, -1); // do nothing
		list.insert(30, 30000); // do nothing
		list.insert(10, 0); // insert node with the value of 10 at the 1st position
		list.insert(33, 2); // insert node with the value 33 at the 3rd position

		System.out.println("\nTwo  more nodes inserted, must have: 10, 440, 33, 330, 110, 40\n");
		list.print();
		list.remove(0);
		list.remove(1);
		list.remove(2);
		list.remove(3);
		list.remove(4);
		list.remove(5);
		System.out.println("\nAfter 6 removes, list must have: 440, 330, 40: \n");
		list.print();

		list.clear();
		System.out.println("\nAfter call to clear, list must be empty:\n");
		list.print();

		list.push_back(331);
		list.push_back(221);
		list.push_back(111);

		System.out.println("\nAfter three calls to push_back, list must have:" + "331, 221, 111\n");
		list.print();

	}

}
