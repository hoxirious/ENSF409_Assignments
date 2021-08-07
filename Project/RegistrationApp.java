import java.io.*;
import java.util.ArrayList;

public class RegistrationApp implements Runnable {

	private PrintWriter socketOut;
	private BufferedReader socketIn;

	private CourseCatalogue cat;

	ArrayList<Student> slist;
	ArrayList<Course> clist;
	
	DBManager db;
	Registration reg;
	
	
    /**creating student list and course list, and register from the database**/
	public RegistrationApp(BufferedReader in, PrintWriter out) throws IOException {
		socketOut = out;
		socketIn = in;

		cat = new CourseCatalogue();
		
		db = new DBManager();

		slist = db.readFromDB();
		clist = db.readFromDataBase();
	}

	/**each client is a thread, and this run function call the methods in RegistrationApp class**/
	public void run() {
		application();
	}

	/**this method is used to find the course in course catalouge using course name and course num as arguments**/
	public void searchCourse(String courseName, int courseNum) {
		Course c = cat.searchCat(courseName.toUpperCase(), courseNum);
		if (c != null)
			socketOut.println(c);
		else
			socketOut.println("Course not found!\n");
	}
	
	/**this method is used to saving student list, course list and registration lists into database files**/
	public void saveToDatabase () {
		try {
			db.saveDB(slist, clist);			
			socketOut.println("Successfully save to the database");
		} catch (Exception e) {
			socketOut.println("Failed! Cannot save to the database");
		}
	}
	
   /**adding a course to student course (based on Lab 3 ex 2)**/
	public void addStudentReg(int studentId, String courseName, int courseNum, int secNum) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (studentId == slist.get(i).getStudentId()) {
				index = i;
			}
		}

		/** check if student is in the list **/
		if (index == -1) {
			socketOut.println("No student found!");
			System.out.println("No student found!");
			return;
		}

		/** check if student has already taken 6 courses **/
		if (slist.get(index).getStudentRegList().size() == 6) {
			socketOut.println("This student has 6 course already");
			System.out.println("This student has 6 course already");
			return;
		}

		Course c = cat.searchCat(courseName, courseNum);

		/** check if course is in the Catalouge **/
		if (c == null) {
			socketOut.println("Course not Found!");
			System.out.println("Course not Found!");
			return;
		}

		/** check if student has taken the course **/
		if (slist.get(index).checkdupes(c) == true) {
			socketOut.println("This student has already taken the course");
			System.out.println("This student has already taken the course");
			return;
		}

		/** check if student is qualified for the course **/
		if (slist.get(index).checkpre(c) == false) {
			socketOut.println("This student is not qualified for the course");
			System.out.println("This student is not qualified for the course");
			return;
		}

		Registration regi = new Registration();
		regi.completeRegistration(slist.get(index), c.getCourseOfferingAt(secNum - 1));

		socketOut.println("The course has been added to the student course");
	}
	
    /** deleting a course from student courses **/
	public void delStudentReg(int studentId, String courseName, int courseNum, int secNum) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (studentId == slist.get(i).getStudentId()) {
				index = i;
			}
		}

		/** check if student exist**/
		if (index == -1) {
			socketOut.println("No student found!");
			return;
		}

		/** check if this student has taken any course **/
		if (slist.get(index).getStudentRegList().size() == 0) {
			socketOut.println("This student has not taken any course");
			return;
		}

		Course c = cat.searchCat(courseName, courseNum);

		/** check if the course is in the list **/
		if (c == null) {
			socketOut.println("Course not Found!");
			return;
		}

		/** check if the student take the course **/
		if (slist.get(index).checkdupes(c) == false) {
			socketOut.println("This student did not take the course");
			return;
		}
		
		Registration regi = new Registration();

		regi.cancelRegistration(slist.get(index), c.getCourseOfferingAt(secNum - 1));
		socketOut.println("The course has been removed from the student course");
	}

	/** showing course catalogue **/
	public void showCatalogue() {
		socketOut.println(cat);
	}

	/** showing student infomation **/
	public void showStudent(int studentId) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (studentId == slist.get(i).getStudentId()) {
				index = i;
			}
		}

		if (index == -1) {
			socketOut.println("No student found!");
			return;
		}

		socketOut.println(slist.get(index));

	}

	/** getting response from client-side **/
	private String getResponse() throws IOException {
		String s = socketIn.readLine();
		System.out.println(s);
		return s;
	}

	/** using switch to call different methods of RegistrationApp class **/
	private void application() {

		String[] answer;
		int choice = 0;

		while (choice != 7) {

			try {
				choice = Integer.parseInt(socketIn.readLine());
				System.out.println(choice);
				switch (choice) {

				case 1:
					answer = getResponse().split("\\s+");
					searchCourse(answer[0], Integer.parseInt(answer[1]));
					break;
				case 2:
					answer = getResponse().split("\\s+");
					addStudentReg(Integer.parseInt(answer[0]), answer[1].toUpperCase(), Integer.parseInt(answer[2]),
							Integer.parseInt(answer[3]));
					break;

				case 3:
					answer = getResponse().split("\\s+");
					delStudentReg(Integer.parseInt(answer[0]), answer[1].toUpperCase(), Integer.parseInt(answer[2]),
							Integer.parseInt(answer[3]));
					break;

				case 4:
					showCatalogue();
					break;

				case 5:
					answer = getResponse().split("\\s+");
					showStudent(Integer.parseInt(answer[0]));
					break;
				case 6:
					saveToDatabase();
					break;
					
				case 7:
					socketOut.println("QUIT");
					break;
				default: 
					System.exit(0);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
