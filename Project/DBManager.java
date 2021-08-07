import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

//This class is simulating a database for our
//program
public class DBManager {
	
	ArrayList <Course> courseList;
	ArrayList <Student> studentList;

	/** constructor **/
	public DBManager () {
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
	}

	/** creating course list from the database**/
	public ArrayList <Course> readFromDataBase() throws IOException {
		// TODO Auto-generated method stub
//		courseList.add(new Course ("ENGG", 233));
//		courseList.add(new Course ("ENSF", 409));
//		courseList.add(new Course ("PHYS", 259));
		
		RandomAccessFile ra1 = null;
		RandomAccessFile ra2 = null;
		RandomAccessFile ra3 = null;
		
		try {
		   ra1 = new RandomAccessFile("courses.txt","r");
		   ra2 = new RandomAccessFile("students.txt", "r");
    	   ra3 = new RandomAccessFile("courseReg.txt", "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 		
		String temp;
		String [] courseInfo;
		String [] studentInfo;
//		String tempReg;
//		String [] regInfo;
		
		while ((temp = ra2.readLine()) != null) {
			
			studentInfo = temp.split(";");
			
			Student s = new Student(studentInfo[0], Integer.parseInt(studentInfo[1]));
			
			studentList.add(s);
			
		}
		
		while ((temp = ra1.readLine()) != null) {
			
			courseInfo = temp.split(";");
			
			Course c = new Course(courseInfo[0], Integer.parseInt(courseInfo[1]));
			
			if (courseInfo.length > 2) {
				
				for (int i = 2; i < courseInfo.length; i += 2) {
					int secNum = Integer.parseInt(courseInfo[i]);
					c.addOffering(new CourseOffering(Integer.parseInt(courseInfo[i]), Integer.parseInt(courseInfo[i+1])));
					register(c, studentList, ra3, secNum);
					ra3.seek(0);
					
				}	
				
			}
			
			courseList.add(c);
		}
		ra1.close();
		ra2.close();
		ra3.close();
        return courseList;
	}
	
	/** register students into the courses from database **/
	public void register(Course course, ArrayList<Student> slist, RandomAccessFile arg, int secNum) throws IOException {
		String tempR;
		String [] regInfo;
		
		while ((tempR = arg.readLine()) != null) {
			regInfo = tempR.split(";");
			
			if (course.getCourseName().equals(regInfo[0]) && course.getCourseNum() == Integer.parseInt(regInfo[1])) {
				
				if (secNum == Integer.parseInt(regInfo[2])) {
					for (int i = 3; i < regInfo.length; i++) {
						for (int j = 0; j < slist.size(); j++) {
							if (Integer.parseInt(regInfo[i]) == slist.get(j).getStudentId()) {
								Registration regi = new Registration();
								regi.completeRegistration(slist.get(j), course.getCourseOfferingAt(secNum -1));
							}
						}
					}
				}
				
			}
		}
		
	}
	
	/** creating student list from the database **/
	public ArrayList <Student> readFromDB() throws IOException {
		
		RandomAccessFile ra1 = null;
		RandomAccessFile ra2 = null;
		RandomAccessFile ra3 = null;
		
		try {
			ra1 = new RandomAccessFile("students.txt", "r");
			ra2 = new RandomAccessFile("courses.txt", "r");
			ra3 = new RandomAccessFile("studentReg.txt", "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String temp;
		String [] studentInfo;
		String [] courseInfo;
		
		while((temp = ra2.readLine()) != null) {
			
			courseInfo = temp.split(";");
			
            Course c = new Course(courseInfo[0], Integer.parseInt(courseInfo[1]));
			
			if (courseInfo.length > 2) {
				
				for (int i = 2; i < courseInfo.length; i += 2) {
					c.addOffering(new CourseOffering(Integer.parseInt(courseInfo[i]), Integer.parseInt(courseInfo[i+1])));
				}
			}
			
			courseList.add(c);
			
		}
		
		while((temp = ra1.readLine()) != null) {
			studentInfo = temp.split(";");
			
			Student st = new Student(studentInfo[0], Integer.parseInt(studentInfo[1]));
			
			studentReg(st, courseList, ra3);
			ra3.seek(0);
			
			studentList.add(st);
		}
		
		ra1.close();
		ra2.close();
		ra3.close();
		return studentList;
	}
	
	/** register courses into student courses from the database **/
	public void studentReg(Student arg1, ArrayList<Course> arg2, RandomAccessFile arg3) throws IOException {
		
		String tempR;
		String [] regInfo;
		
		while ((tempR = arg3.readLine()) != null) {
			
			regInfo = tempR.split(";");
			
			if (Integer.parseInt(regInfo[0]) == arg1.getStudentId()) {
				
				for (int a = 1; a < regInfo.length; a += 3) {
					for (int i = 0; i < arg2.size(); i++) {
						if (regInfo[a].equals(arg2.get(i).getCourseName()) && Integer.parseInt(regInfo[a+1]) == arg2.get(i).getCourseNum()) {
							
							Registration regi = new Registration();
							regi.completeRegistration(arg1, arg2.get(i).getCourseOfferingAt(Integer.parseInt(regInfo[a+2])-1));
							
						}
					}
				}
				
					
			}
			
		}
		
	}
	
	/** saving course list, student list and register list into database (NOT WORKING - maybe try writeUTF) **/
	public void saveDB(ArrayList<Student> slist, ArrayList<Course> clist) throws IOException {
		
		RandomAccessFile ra1 = null;
		RandomAccessFile ra2 = null;
		RandomAccessFile ra3 = null;
		RandomAccessFile ra4 = null;
		
		try {
			ra1 = new RandomAccessFile("courses.txt", "rw");
			ra2 = new RandomAccessFile("students.txt", "rw");
			ra3 = new RandomAccessFile("courseReg.txt", "rw");
			ra4 = new RandomAccessFile("studentReg.txt", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ra1.setLength(0);
		ra2.setLength(0);
		ra3.setLength(0);
		ra4.setLength(0);
		
		for (int i = 0; i < clist.size(); i++) {
			ra1.writeChars(clist.get(i).getCourseName() + ";" + clist.get(i).getCourseNum());
			for (int j = 0; j < clist.get(i).getOfferingList().size(); i++) {
				ra1.writeChars(";" + clist.get(i).getCourseOfferingAt(j).getSecNum() + ";" + clist.get(i).getCourseOfferingAt(j).getSecCap());
			}
			ra1.writeChars("\n");
		}
		
		for (int i = 0; i < slist.size(); i++) {
			ra2.writeChars(slist.get(i).getStudentName() + ";" + slist.get(i).getStudentId() + "\n");
		}
		
		for (int i = 0; i < clist.size(); i++) {
			for (int j = 0; j < clist.get(i).getOfferingList().size(); j++) {
				ra3.writeChars(clist.get(i).getCourseName() + ";" + clist.get(i).getCourseNum() + ";"
						       + clist.get(i).getCourseOfferingAt(j).getSecNum());
				for (int a = 0; a < clist.get(i).getCourseOfferingAt(j).getOfferingRegList().size(); a++) {
					ra3.writeChars(";" + clist.get(i).getCourseOfferingAt(j).getOfferingRegList().get(a).getTheStudent().getStudentId());
				}
			}
			
			ra3.writeChars("\n");
		}
		
		for (int i = 0; i < slist.size(); i++) {
			ra4.writeInt(slist.get(i).getStudentId());
			for (int j = 0; j < slist.get(i).getStudentRegList().size(); j++) {
				ra4.writeChars(";" + slist.get(i).getStudentRegList().get(j).getTheOffering().getTheCourse().getCourseName());
				ra4.writeChars(";" + slist.get(i).getStudentRegList().get(j).getTheOffering().getTheCourse().getCourseNum());
				ra4.writeChars(";" + slist.get(i).getStudentRegList().get(j).getTheOffering().getSecNum());
			}
			ra4.writeChars("\n");
		}
		
		ra1.close();
		ra2.close();
		ra3.close();
		ra4.close();
	
	}
	
}
