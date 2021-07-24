
public class SizeFactorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String err = "\nError: The factor is less than limit";
	
	public SizeFactorException() {
		super("\nError: The factor is less than limit");
	}
	
	public SizeFactorException(String s) {
		super(s);
	}
	
	public String getMessage() {
		return err;
	}
	
}
