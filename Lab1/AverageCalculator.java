
public class AverageCalculator {
	public static void main (String [] args) {
		double ave = 0;
		System.out.printf("The %d numbers are: ",args.length);
		double x;
		for (int i = 0; i < args.length; i++) {
			x = Double.parseDouble(args[i]);
			System.out.printf("%10.3f",x);
			ave += x;
		}
		ave = ave / args.length;
		System.out.printf("\n\nAnd their average is: %5.3f", ave);
	}
}
