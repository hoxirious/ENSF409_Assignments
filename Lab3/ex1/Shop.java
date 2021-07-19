import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

	/*
	 * 1. List all tools (this must be handled by the proper toString methods in the
	 * backend). 2. Search for tool by toolName 3. Search for tool by toolID 4.
	 * Check item quantity 5. Decrease Item quantity (This is to simulate a sale of
	 * the item. Once the item count goes under 40, this function should trigger the
	 * creation of an order as shown in lab 2) . 6. Quit
	 */

	public static void pressEnter() {
		System.out.println("Press \"ENTER\" to continue...");
		try {
			System.in.read();
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int mainMenu() {
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		input.close();
		return i;
	}

	public static void main(String[] args) {
		Inventory shop = new Inventory();

		System.out.println("Shopee v1");
		System.out.println("Made by: Hao Nguyen and Hy Huynh");
		System.out.println("Release Date: 07/06/2021");

		Scanner input = new Scanner(System.in);
		int choice;

		while (true) {
			System.out.println("Main Menu");
			System.out.println("Please select one of the following operations");
			System.out.println("1. List all tools");
			System.out.println("2. Search for tool by toolName");
			System.out.println("3. Search for tool by toolID");
			System.out.println("4. Check item quantity");
			System.out.println("5. Decrease Item quantity");
			System.out.println("6. List all suppliers");
			System.out.println("7. Print out the receipt of order");
			System.out.println("8. Output the orders");
			System.out.println("9. Quit");
			System.out.print("Please input your choice: ");
			choice = input.nextInt();
			input.nextLine();

			System.out.println("--------");

			int foundIndex, cID, cAmount;
			String cName;

			switch (choice) {
			case 1:
				ArrayList<Item> itemList = shop.getItemList();
				for (Item a : itemList) {
					System.out.println(a.toString());
				}
				pressEnter();
				break;

			case 2:
				System.out.print("Please enter the item's name: ");
				cName = input.nextLine();

				foundIndex = shop.searchByName(cName);
				if (foundIndex == -1) {
					System.out.println("The item " + cName + " is not found" + "\n");
				} else {
					Item foundItem = shop.getItemList().get(foundIndex);
					System.out.println(foundItem.toString() + "\n");
				}
				pressEnter();
				break;

			case 3:
				System.out.print("Please enter the item's id: ");
				cID = input.nextInt();

				foundIndex = shop.searchByID(cID);
				if (foundIndex == -1) {
					System.out.println("The item " + cID + " is not found" + "\n");
				} else {
					Item foundItem = shop.getItemList().get(foundIndex);
					System.out.println(foundItem.toString() + "\n");
				}
				pressEnter();
				break;

			case 4:
				System.out.println("Please enter the item's name: ");
				cName = input.nextLine();

				foundIndex = shop.searchByName(cName);
				if (foundIndex == -1) {
					System.out.println("The item " + cName + " is not found" + "\n");
				}

				else {
					Item foundItem = shop.getItemList().get(foundIndex);
					System.out.println("The quantity of the " + cName + " is: " + foundItem.getQuantity() + "\n");
				}
				pressEnter();
				break;

			case 5:
				System.out.println("Please enter the ID of the Item: ");
				cID = input.nextInt();
				System.out.println("Please enter the amount needed to decrease: ");
				cAmount = input.nextInt();

				shop.decreaseQuantity(cID, cAmount);

				break;

			case 6:
				ArrayList<Supplier> suppList = shop.getSuppList();
				for (Supplier b : suppList) {
					System.out.println(b.toString());
				}
				pressEnter();
				break;

			case 7:
				Order cart = shop.getShoppingCart();
				System.out.println(cart.toString());

				pressEnter();
				break;
			case 8:
				shop.outputOrders();
				System.out.println("Orders saved");
				pressEnter();
				break;

			case 9:
				System.out.println("The program is closing");
				input.close();
				System.exit(1);

			default:
				System.out.println("Invalid Input");
				break;
			}
		}

	}

}