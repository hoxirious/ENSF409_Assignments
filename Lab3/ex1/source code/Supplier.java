

/**
 * The Class Supplier.
 */
public class Supplier {
	
	/** The contact. */
	private String nameComp, location, contact;
	
	/** The id comp. */
	private int idComp;
	
	
	/**
	 * Instantiates a new supplier.
	 *
	 * @param i the i
	 * @param n the n
	 * @param lo the lo
	 * @param e the e
	 */
	public Supplier(int i, String n, String lo, String e) {
		setID(i);
		setName(n);
		setLocation(lo);
		setEmail(e);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return this.idComp;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.nameComp;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return this.nameComp;
	}
	
	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public String getContact() {
		return this.contact;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.nameComp = name;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setID(int id) {
		this.idComp = id;
	}

	/**
	 * Sets the location.
	 *
	 * @param address the new location
	 */
	public void setLocation(String address) {
		this.location = address;
	}

	/**
	 * Sets the email.
	 *
	 * @param contact the new email
	 */
	public void setEmail(String contact) {
		this.contact = contact;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += "Company Name: " + getName() + "\n";
		st += "Company ID: " + getID() + "\n";
		st += "Company Location: " + getLocation() + "\n";
		st += "Company contact: " + getContact() + "\n"; 
		
		return st;
	}

}
