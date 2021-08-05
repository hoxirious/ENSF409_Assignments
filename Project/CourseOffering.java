import java.util.ArrayList;

public class CourseOffering {
	
	private int secNum;
	private int secCap;
	private Course theCourse;
	//private ArrayList<Student> studentList;
	private ArrayList <Registration> offeringRegList;
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
	}
	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public int getSecCap() {
		return secCap;
	}
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	public ArrayList <Registration> getOfferingRegList() {
		return offeringRegList;
	}
	@Override
	public String toString () {
		String st = "\n";
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		for (int i = 0; i < offeringRegList.size(); i++) {
			st += "Student name:" + offeringRegList.get(i).getTheStudent().getStudentName() + "\n";
		}
		return st;
	}
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		
	}
	
	public void deleteRegistration(Registration registration) {
		for (int i = 0; i < offeringRegList.size(); i++) {
			if(registration.getTheStudent().getStudentId() == offeringRegList.get(i).getTheStudent().getStudentId()
		    && registration.getTheOffering().getTheCourse().getCourseName().equals(offeringRegList.get(i).getTheOffering().getTheCourse().getCourseName())) {
				if(registration.getTheOffering().getTheCourse().getCourseNum() == offeringRegList.get(i).getTheOffering().getTheCourse().getCourseNum()
				&& registration.getTheOffering().getSecNum() == offeringRegList.get(i).getTheOffering().getSecNum()) {
					offeringRegList.remove(i);
					return;
				}
			}
		}

}
}
