
public class Registration {
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration();
	}
	
	void cancelRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		deleteRegistration();
	}
	
	private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	private void deleteRegistration() {
		theStudent.deleteRegistration(this);
		theOffering.deleteRegistration(this);
	}
	
	public void deactivate() {
		if (requirement() == false) {
			theStudent.deleteRegistration(this);
			theOffering.getOfferingRegList().clear();
		}
	}
	
	private boolean requirement() {
		if (theOffering.getOfferingRegList().size() >= 8) {
			System.out.println("This course section has 8 or more students.");
			return true;
		}
		else { 
			System.out.println("This course section has less than 8 students --- deactivating");
			return false;
		}
	}
	
	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}
	

}
