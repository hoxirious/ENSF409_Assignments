import java.io.*;

public class RegistrationApp implements Runnable {
	
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	
	public RegistrationApp(BufferedReader in, PrintWriter out) {
		socketOut = out;
		socketIn = in;
	}
	
	public void run() {
		application();
	}
	
	public void application() {
		String [] answer;
		String courseName = "";
		int choice = 0;
		String response = "";
		int courseNum = 0;
		int studentId = 0;
		int secNum = 0;
		
		while(true) {
			try {
				choice = Integer.parseInt(socketIn.readLine());
				
				switch(choice) {
				
				case 1:
					response = "Enter the course name and number(white space between them): ";
					socketOut.println(response);
					answer = socketIn.readLine().split("\\s+");
					if (answer.length != 2) {
						response = "Invalid Input";
						socketOut.println(response);
						break;
					}
					courseName = answer[0];
					courseNum = Integer.parseInt(answer[1]);
					response = "This is a test. This will do nothing";
					socketOut.println(response);
					break;
				
				case 2: 
					response = "Enter student id, course name, number and section number (white space between each of them):  ";
					socketOut.println(response);
					answer = socketIn.readLine().split("\\s+");
					if (answer.length != 4) {
						response = "Invalid Input";
						socketOut.println(response);
						break;
					}
					studentId = Integer.parseInt(answer[0]);
					courseName = answer[1];
					courseNum = Integer.parseInt(answer[2]);
					secNum = Integer.parseInt(answer[3]);
					response = "This is a test. This will do nothing";
					socketOut.println(response);
					break;
					
				case 3:
					response = "Enter student id, course name, number and section number (white space between each of them):  ";
					socketOut.println(response);
					answer = socketIn.readLine().split("\\s+");
					if (answer.length != 4) {
						response = "Invalid Input";
						socketOut.println(response);
						break;
					}
					studentId = Integer.parseInt(answer[0]);
					courseName = answer[1];
					courseNum = Integer.parseInt(answer[2]);
					secNum = Integer.parseInt(answer[3]);
					response = "This is a test. This will do nothing";
					socketOut.println(response);
					break;
					
				case 4:
					response = "This is a test. This will do nothing";
					socketOut.println(response);
					break;
					
				case 5: 
					response = "Enter student id: ";
					socketOut.println(response);
					studentId = Integer.parseInt(socketIn.readLine());
					response = "This is a test. This will do nothing";
					socketOut.println(response);
					break;
				
				case 6:
					response = "Good bye!";
					socketOut.println(response);
					break;
					
				default:
					response = "Wrong input";
					socketOut.println(response);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
