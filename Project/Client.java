import java.net.Socket;
import java.io.*;

public class Client {

	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private BufferedReader stdIn;

	public Client(String serverName, int portNumber) {

		try {
			aSocket = new Socket(serverName, portNumber);
			// keyboard input stream
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			// Socket input stream
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void communicate() {

		String line = "";
		int choice = 0;
		String response = "";

		appHeader();

		while (choice != 6) {
			try {
				Menu();
				choice = Integer.parseInt(stdIn.readLine());
				socketOut.println(choice);
				switch (choice) {
				case 1:
					System.out.println("Enter the course name and number(white space between them): ");
					line = stdIn.readLine();
					socketOut.println(line);
					while ((response = socketIn.readLine()) != null) {
						System.out.println(response);
					}
					break;

				case 2:
					response = socketIn.readLine();
					System.out.println(response);
					line = stdIn.readLine();
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);
					break;
				case 3:
					response = socketIn.readLine();
					System.out.println(response);
					line = stdIn.readLine();
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);
					line = stdIn.readLine();
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);
					line = stdIn.readLine();
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);
					break;

				case 4:
					while ((response = socketIn.readLine()) != null) {
						System.out.println(response);
					}
					break;

				case 5:
					response = socketIn.readLine();
					System.out.println(response);
					line = stdIn.readLine();
					socketOut.println(line);
					while ((response = socketIn.readLine()) != null) {
						System.out.println(response);
					}
					break;

				default:
					response = socketIn.readLine();
					System.out.println(response);
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public void appHeader() {
		System.out.println("Student Registration v3");
		System.out.println("Made by: Hao Nguyen and Hy Huynh");
		System.out.println("Release Date: 07/06/2021");
	}

	public void Menu() {
		System.out.println("Main Menu");
		System.out.println("Please select one of the following operations");
		System.out.println("1. Search catalouge Courses");
		System.out.println("2. Add course to Student Courses");
		System.out.println("3. Remove course from Student Courses");
		System.out.println("4. View All Courses in Catalogue");
		System.out.println("5. View all courses taken by Student");
		System.out.println("6. Quit");
		System.out.print("Please input your choice: ");
	}

	public static void main(String[] args) throws IOException {
		Client myClient = new Client("localhost", 9898);
		myClient.communicate();
	}
}
