import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

//This class is simulating a database for our
//program
public class DBManager {
	
	ArrayList <Course> courseList;
	ArrayList <Student> studentList;

	public DBManager () {
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
	}

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
		
		
		return studentList;
	}
	
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
	
}
