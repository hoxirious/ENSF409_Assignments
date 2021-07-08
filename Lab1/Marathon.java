
public class Marathon {
	
	static int findMin(int []list) {
		int min = list[0];
		int a = 0;
		for (int i = 1; i <list.length; i++) {
			if (min > list[i]) {
				min = list[i];
				a = i;
			}
		}
		return a;
	}
	
	public static void main (String [] args) {
		String [] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
				           "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
		int [] times = {341, 273, 278, 329, 445, 402, 338, 275, 243, 334, 412, 393, 299, 343, 317, 265};

		int localMin = findMin(times);

		System.out.printf("The fastest runner is: %s, ", names[localMin]);
		System.out.printf("and they ran for %d minutes", times[localMin]);
	}
	
}
