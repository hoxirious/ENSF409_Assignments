
public class Supplier {
	private String nameComp, location, contact;
	private int idComp;
	
	
	public Supplier(int i, String n, String lo, String e) {
		setID(i);
		setName(n);
		setLocation(lo);
		setEmail(e);
	}

	public int getID() {
		return this.idComp;
	}

	public String getName() {
		return this.nameComp;
	}
	
	public String getLocation() {
		return this.nameComp;
	}
	
	public String getContact() {
		return this.contact;
	}

	public void setName(String name) {
		this.nameComp = name;
	}

	public void setID(int id) {
		this.idComp = id;
	}

	public void setLocation(String address) {
		this.location = address;
	}

	public void setEmail(String contact) {
		this.contact = contact;
	}
	
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
