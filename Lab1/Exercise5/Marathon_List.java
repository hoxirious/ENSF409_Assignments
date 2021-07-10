import java.util.ArrayList;
import java.util.Scanner;

public class Marathon_List {
	
	static int findFatestRunner(ArrayList<Integer> args) {
		int min = args.get(0);
		int a = 0;
		for (int i = 1; i < args.size(); i++ ) {
			if (min > args.get(i)) {
				min = args.get(i);
				a = i;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		// Define two array lists here to store the names and the running times
		// Read user input
		String sin;
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> times = new ArrayList<Integer>();
		
		while (true)
		{
		System.out.println("Please enter the name of the participant"); sin = scan.nextLine();
		if(sin.toUpperCase().equals("QUIT")) break;
		
		// Add the name to your ArrayList
		names.add(sin);
		
		
		System.out.println("Please enter the running time of the participant"); sin = scan.nextLine();
		
		// Add the running time to your array list
		times.add(Integer.valueOf(sin));
		}
		
		scan.close();
		
		// Call the function findFastestRunner and pass the running times array list to it
		int localMin = findFatestRunner(times);
		
		// Print the name of the fastestrunner to the console
		System.out.printf("The fastest runner is: %s\n", names.get(localMin));
		System.out.printf("They run in %d minutes.\n", times.get(localMin));
		}
}
