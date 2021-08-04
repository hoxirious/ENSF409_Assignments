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
		String [] courseInfo;
		String line = "";
		int choice = 0;
		String response = "";
		int number = 0;
		
		while(true) {
			try {
				choice = Integer.parseInt(socketIn.readLine());
				
				switch(choice) {
				
				case 1:
					response = "Enter the course name and number: ";
					socketOut.println(response);
					courseInfo = socketIn.readLine().split("\\s+");
					if (courseInfo.length < 2) {
						response = "Invalid Input";
						socketOut.println(response);
						break;
					}
					line = courseInfo[0];
					number = Integer.parseInt(courseInfo[1]);
					response = "This is a test. This will do nothing";
					socketOut.println(response);
				
				case 2: 
					response = "Enter student id: ";
					socketOut.println(response);
					number = Integer.parseInt(socketIn.readLine());
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
