import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class SinValidator.
 *
 * @author Hy Huynh, Hao Nguyen
 * @version 1.0
 */
public class SinValidator {

/** The sin. */
private int[] SIN;

/**
 * Sum digit.
 *
 * @param x the x
 * @return the int
 */
private int sumDigit(int x)
{
	int result =0;
	
	while(x > 0){
		result += x % 10;
		x = x /10;
	}
	
	return result;
}

	/**
	 * Instantiates a new sin validator.
	 *
	 * @param sin the sin
	 */
	public SinValidator(String sin) {

		SIN = new int[9];
		int i =0;
		int counter =0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	/**
	 * Validate sin.
	 *
	 * @return true, if successful
	 */
	public boolean validateSin()
	{
		int num1 = SIN[0] + SIN[2] + SIN[4] + SIN[6]; 
		int num2=0, temp=0, result; 
		
		for(int i=1; i<9; i+=2 ) {
			temp= SIN[i]*2;
			num2+= temp%10 + (int)temp/10; 
		}
		
		result = 10 - ((num1 + num2)%10);
		
		return result==SIN[8];
		
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your 10 digit social insurance number"
					+ " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");
			
		}
	}

}
