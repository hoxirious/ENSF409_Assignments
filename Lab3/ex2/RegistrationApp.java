import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationApp {
	
	public static void main (String [] args) {
		CourseCatalogue cat = new CourseCatalogue ();
		System.out.println(cat);
		Student st = new Student ("Sara", 1);
		Student st2 = new Student ("Sam", 2);
		ArrayList <Student> slist = new ArrayList<Student>();
		slist.add(st);
		slist.add(st2);
		Course myCourse = cat.searchCat("ENGG", 233);
		if (myCourse != null) {
			cat.createCourseOffering(myCourse, 1, 100);
			cat.createCourseOffering(myCourse, 2, 200);
		}
		System.out.println(myCourse.getCourseOfferingAt(0));
		
		Registration reg = new Registration ();
		reg.completeRegistration(st, myCourse.getCourseOfferingAt(0));
		
		
		System.out.println(reg);
		
		System.out.println("Student Registration v2");
		System.out.println("Made by: Hao Nguyen and Hy Huynh");
		System.out.println("Release Date: 07/06/2021");
		
		Scanner input = new Scanner(System.in);
		int choice;
		
		while (true) {
			System.out.println("Main Menu");
			System.out.println("Please select one of the following operations");
			System.out.println("1. Search catalouge Courses");
			System.out.println("2. Add course to Student Courses");
			System.out.println("3. Remove course from Student Courses");
			System.out.println("4. View All Courses in Catalogue");
			System.out.println("5. View all courses taken by Student");
			System.out.println("6. Quit");
			System.out.print("Please input your choice: ");
			choice = input.nextInt();
			input.nextLine();
			
			switch (choice) {
	    	case 1:
	    		System.out.print("Enter the Course Name: ");
	    		String cName = input.nextLine();
	    		System.out.print("Enter the Course Number: ");
	    		int cNum = input.nextInt();
	    		Course cSearch = cat.searchCat(cName, cNum);
	    		if (cSearch != null)
	    			System.out.println(cSearch.toString());
	    		break;
	    	case 2:
	    		System.out.print("Enter the student Id: ");
	    		int studentId = input.nextInt();
	    		input.nextLine();
	    		int index = -1;
	    		for (int i = 0; i < slist.size(); i++) {
	    			if (studentId == slist.get(i).getStudentId()) {
	    				index = i;
	    			}
	    		}
	    		if (index == -1) {
	    			System.out.println("Student not found");
	    			break;
	    		}
	    		if (slist.get(index).getStudentRegList().size() == 6) {
	    			System.out.println("This student has 6 course already");
	    			break;
	    		}
	    		System.out.print("Please enter course name: ");
	    		String courseName = input.nextLine();
	    		System.out.print("Please enter course number: ");
	    		int courseNum = input.nextInt();
	    		input.nextLine();
	    		Course c = cat.searchCat(courseName, courseNum);
	    		if (c == null) {
	    			System.out.print("Course not found");
	    			break;
	    		}
	    		
	    		if (slist.get(index).checkdupes(c) == true) {
	    			break;
	    		}
	    		
	    		if(slist.get(index).checkpre(c) == false) {
	    			break;
	    		}
	    		
	    		System.out.println("Please enter section you want to register: ");
	    		int secnum = input.nextInt();
	    		input.nextLine();
	    		Registration regi = new Registration();
	    		if (c.getCourseOfferingAt(secnum-1).getOfferingRegList().size() == c.getCourseOfferingAt(secnum-1).getSecCap()) {
	    			System.out.println("This section has reached the capacity. Please choose another section");
	    			secnum = input.nextInt();
	    			input.nextLine();
	    		}
	    		regi.completeRegistration(slist.get(index), c.getCourseOfferingAt(secnum-1));
	    		System.out.println("The course has been added to the student course");
	    		//reg.deactivate();
	    		break;
	    	case 3:
	    		System.out.print("Please enter the student id: ");
	    		int delId = input.nextInt();
	    		input.nextLine();
	    		index = -1;
	    		for (int i = 0; i < slist.size(); i++) {
	    			if (delId == slist.get(i).getStudentId()) {
	    				index = i;
	    			}
	    		}
	    		if (index == -1) {
	    			System.out.println("Student not found");
	    			break;
	    		}
	    		if (slist.get(index).getStudentRegList().size() == 0) {
	    			System.out.println("This student has no course registred");
	    			break;
	    		}
	    		System.out.print("Please enter the course name to delete: ");
	    		String delCName = input.nextLine();
	    		System.out.print("Please enter the course number to delete: ");
	    		int delCNum = input.nextInt();
	    		input.nextLine();
	    		System.out.print("Please enter the course number to delete: ");
	    		int delSecNum = input.nextInt();
	    		input.nextLine();
	    		Course cdel = cat.searchCat(delCName, delCNum);
	    		if (cdel == null) {
	    			System.out.println("Course not found");
	    			break;
	    		}
	    	    Registration del = new Registration();
	    	    del.cancelRegistration(slist.get(index),cdel.getCourseOfferingAt(delSecNum-1));
	    	    //System.out.println("The student has withdrew the course.");
	    	    //del.deactivate();
	    		break;
	    	case 4:
	    		System.out.println(cat.toString());
	    		break;
	    	case 5:
	    		System.out.print("Please enter the student id: ");
	    		int sId = input.nextInt();
	    		input.nextLine();
	    		index = -1;
	    		for (int i = 0; i < slist.size(); i++) {
	    			if (sId == slist.get(i).getStudentId()) {
	    				index = i;
	    			}
	    		}
	    		if (index == -1) {
	    			System.out.println("Student not found");
	    			break;
	    		}
	    		System.out.println(slist.get(index).toString());
	    		break;
	    	case 6:
	    		System.out.println("The program is closing");
	    		input.close();
	    		System.exit(1);
	    	default:
	    		System.out.println("Invalid Input");
	    		break;
		} 

		
	    
	}
	}
}
	
