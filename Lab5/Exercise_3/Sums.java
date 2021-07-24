package Exercise_3;

import java.io.*;

public class Sums {

	public static void sum(BufferedReader in) {
		// takes a sequence of integers as inputs, and outputs their sum

		int s, nextInt = 0;
		s = 0;

		System.out.println("Please input the sequence of integers to sum, terminated by a 0");
			try {
				nextInt = Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				nextInt = 0; 
				System.out.println("Invalid number. Please re-enter: ");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				nextInt = 0; 
				System.out.println("Something wrong with your code. Please re-enter: ");
			}
		// Read next datum in input. An integer is expected
			while (nextInt != 0) {
				s = s + nextInt;
					try {
						nextInt = Integer.parseInt(in.readLine());
					} catch (NumberFormatException e) {
						s -= nextInt;
						System.out.println("Invalid number. Please re-enter: ");
						continue;
					} catch (IOException e) {
						s -= nextInt;
						System.out.println("Something wrong with your code. Please re-enter: ");
						continue;
					}
			}
		System.out.println("The sum is " + s);
	}

	public static void main(String[] arg) throws IOException  {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// "in" will receive data from the standard input stream
		String c;

		System.out.println("Do you wish to calculate a sum? (y/n)");

		c = in.readLine();
		// Read next datum in input. A string "y" or "n" is expected

		while (!c.equals("y") && !c.equals("n")) {
			System.out.println("Please answer y or n");
			c = in.readLine();
		}

		while (c.equals("y")) {
			sum(in);
			System.out.println("Do you wish to calculate another sum? (y/n)");
			c = in.readLine();

			while (!c.equals("y") && !c.equals("n")) {
				System.out.println("Please answer y or n");
				c = in.readLine();
			}
		}

		System.out.println("Goodbye");
		try {
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
