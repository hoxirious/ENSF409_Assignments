import java.io.*;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationApp.
 */
public class RegistrationApp implements Runnable {

	/** The socket out. */
	private PrintWriter socketOut;
	
	/** The socket in. */
	private BufferedReader socketIn;

	/** The cat. */
	private CourseCatalogue cat;

	/** The slist. */
	ArrayList<Student> slist;
	
	/** The clist. */
	ArrayList<Course> clist;

	/** The db. */
	DBManager db;
	
	/** The reg. */
	Registration reg;

	/**
	 *  creating student list and course list, and register from the database *.
	 *
	 * @param in the in
	 * @param out the out
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public RegistrationApp(BufferedReader in, PrintWriter out) throws IOException {
		socketOut = out;
		socketIn = in;

		cat = new CourseCatalogue();

		db = new DBManager();

		slist = db.readFromDB();
		clist = db.readFromDataBase();
	}

	/**
	 * each client is a thread, and this run function call the methods in
	 * RegistrationApp class.
	 */
	public void run() {
		application();
	}

	/**
	 * this method is used to find the course in course catalouge using course name
	 * and course num as arguments.
	 *
	 * @param courseName the course name
	 * @param courseNum the course num
	 */
	public void searchCourse(String courseName, int courseNum) {
		Course c = cat.searchCat(courseName.toUpperCase(), courseNum);
		if (c != null)
			socketOut.println(c);
		else
			socketOut.println("Course not found!\n");
	}

	/**
	 * this method is used to saving student list, course list and registration
	 * lists into database files.
	 * adding a course to student course (based on Lab 3 ex 2)
	 *
	 * @param studentId the student id
	 * @param courseName the course name
	 * @param courseNum the course num
	 * @param secNum the sec num
	 */

	public void addStudentReg(int studentId, String courseName, int courseNum, int secNum) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (studentId == slist.get(i).getStudentId()) {
				index = i;
			}
		}

		/** check if student is in the list **/
		if (index == -1) {
			socketOut.println("No student found! \n");
			return;
		}

		/** check if student has already taken 6 courses **/
		if (slist.get(index).getStudentRegList().size() == 6) {
			socketOut.println("This student has 6 course already \n");
			return;
		}

		Course c = cat.searchCat(courseName, courseNum);

		/** check if course is in the Catalouge **/
		if (c == null) {
			socketOut.println("Course not Found! \n");
			return;
		}

		/** check if student has taken the course **/
		if (slist.get(index).checkdupes(c) == true) {
			socketOut.println("This student has already taken the course \n");
			return;
		}

		/** check if student is qualified for the course **/
		if (slist.get(index).checkpre(c) == false) {
			socketOut.println("This student is not qualified for the course \n");
			return;
		}

		Registration regi = new Registration();
		regi.completeRegistration(slist.get(index), c.getCourseOfferingAt(secNum - 1));

		socketOut.println("The course has been added to the student course \n");
	}

	/**
	 *  deleting a course from student courses *.
	 *
	 * @param studentId the student id
	 * @param courseName the course name
	 * @param courseNum the course num
	 * @param secNum the sec num
	 */
	public void delStudentReg(int studentId, String courseName, int courseNum, int secNum) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (studentId == slist.get(i).getStudentId()) {
				index = i;
			}
		}

		/** check if student exist **/
		if (index == -1) {
			socketOut.println("No student found! \n");
			return;
		}

		/** check if this student has taken any course **/
		if (slist.get(index).getStudentRegList().size() == 0) {
			socketOut.println("This student has not taken any course \n");
			return;
		}

		Course c = cat.searchCat(courseName, courseNum);

		/** check if the course is in the list **/
		if (c == null) {
			socketOut.println("Course not Found! \n");
			return;
		}

		/** check if the student take the course **/
		if (slist.get(index).checkdupes(c) == false) {
			socketOut.println("This student did not take the course \n");
			return;
		}

		Registration regi = new Registration();

		regi.cancelRegistration(slist.get(index), c.getCourseOfferingAt(secNum - 1));
		socketOut.println("The course has been removed from the student course \n");
	}

	/**
	 *  showing course catalogue *.
	 */
	public void showCatalogue() {
		socketOut.println(cat);
	}

	/**
	 *  showing student infomation *.
	 *
	 * @param studentId the student id
	 */
	public void showStudent(int studentId) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (studentId == slist.get(i).getStudentId()) {
				index = i;
			}
		}

		if (index == -1) {
			socketOut.println("No student found! \n");
			return;
		}

		socketOut.println(slist.get(index));

	}

	/**
	 * Cancel handle.
	 */
	private void cancelHandle() {
		socketOut.println("Cancel \n");
	}

	/**
	 *  getting response from client-side *.
	 *
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private String getResponse() throws IOException {
		String s = socketIn.readLine();
		return s;
	}

	/**
	 *  using switch to call different methods of RegistrationApp class *.
	 */
	private void application() {
		String line;
		String[] answer;
		int choice = 0;

		while (choice != 6) {

			try {
				choice = Integer.parseInt(socketIn.readLine());
				switch (choice) {

				case 1:
					line = getResponse();
					if (line.equals("CANCEL 0")) {
						cancelHandle();
						break;
					} else {
						answer = line.split("\\s+");
						searchCourse(answer[0], Integer.parseInt(answer[1]));
						break;
					}
				case 2:
					line = getResponse();
					if (line.equals("0 CANCEL 0 0")) {
						cancelHandle();
						break;
					} else {
						answer = line.split("\\s+");
						addStudentReg(Integer.parseInt(answer[0]), answer[1].toUpperCase(), Integer.parseInt(answer[2]),
								Integer.parseInt(answer[3]));
						break;
					}

				case 3:
					line = getResponse();
					if (line.equals("0 CANCEL 0 0")) {
						cancelHandle();
						break;
					} else {
						answer = line.split("\\s+");
						delStudentReg(Integer.parseInt(answer[0]), answer[1].toUpperCase(), Integer.parseInt(answer[2]),
								Integer.parseInt(answer[3]));
						break;
					}

				case 4:
					showCatalogue();
					break;

				case 5:
					line = getResponse();
					if (line.equals("0")) {
						cancelHandle();
						break;
					} else {
						answer = line.split("\\s+");
						showStudent(Integer.parseInt(answer[0]));
						break;
					}

				case 6:
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
