import java.util.ArrayList;

public class Student {
	
	private String studentName;
	private int studentId;
	//private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList;
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public ArrayList<Registration> getStudentRegList() {
		return studentRegList;
	}
	
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		st += "The course list that the student has registered: ";
		for (int i = 0; i < studentRegList.size(); i++) {
			st += studentRegList.get(i).getTheOffering().getTheCourse().getCourseName();
			st += studentRegList.get(i).getTheOffering().getTheCourse().getCourseNum();
			st += "\n";
		}
		return st;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);
	}
	
	public void deleteRegistration(Registration registration) {
		for (int i = 0; i < studentRegList.size(); i++) {
			if(registration.getTheStudent().getStudentId() == studentRegList.get(i).getTheStudent().getStudentId()
		    && registration.getTheOffering().getTheCourse().getCourseName().equals(studentRegList.get(i).getTheOffering().getTheCourse().getCourseName())) {
				if(registration.getTheOffering().getTheCourse().getCourseNum() == studentRegList.get(i).getTheOffering().getTheCourse().getCourseNum()
				&& registration.getTheOffering().getSecNum() == studentRegList.get(i).getTheOffering().getSecNum()) {
					studentRegList.remove(i);
					System.out.println("The course has been removed from the student course");
					return;
				}
			}
		}
		System.out.println("This student didn't take the course");
	}
	
	public boolean checkpre(Course course) {
		ArrayList <Course> prereq = course.getPreReq();
		int count = 0;
		for (int i = 0; i < studentRegList.size(); i++) {
			for (int j = 0; j < prereq.size(); j++) {
				if (studentRegList.get(i).getTheOffering().getTheCourse().getCourseName().equals(prereq.get(j).getCourseName())
						&& studentRegList.get(i).getTheOffering().getTheCourse().getCourseNum() == prereq.get(j).getCourseNum()) {
					count += 1;
				}
			}
		}
		if (count == prereq.size()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkdupes(Course course) {
		for (int i = 0; i < studentRegList.size(); i++) {
			if (course.getCourseName().equals(studentRegList.get(i).getTheOffering().getTheCourse().getCourseName())
					&& course.getCourseNum() == studentRegList.get(i).getTheOffering().getTheCourse().getCourseNum()) {
				return true;
			}
		}
		return false;
	}
	
	

}
