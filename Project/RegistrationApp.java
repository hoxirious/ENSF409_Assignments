import java.io.*;

public class RegistrationApp implements Runnable {

	private PrintWriter socketOut;
	private BufferedReader socketIn;

	private CourseCatalogue cat;

	public RegistrationApp(BufferedReader in, PrintWriter out) {
		socketOut = out;
		socketIn = in;
		cat = new CourseCatalogue();
	}

	public void run() {
		application();
	}

	public void option1(String[] arg) {

		String courseName = arg[0].toUpperCase();
		int courseNum = Integer.parseInt(arg[1]);

		Course c = cat.searchCat(courseName, courseNum);
		
		if (c != null) socketOut.println(c);
		else socketOut.println(c);
	}

	private void application() {

		String[] answer;
		String line;

		while (true) {
			try {

				line = socketIn.readLine();

				if (line.equals("QUIT")) {
					line = "Good Bye!";
					socketOut.println(line);
					break;
				}
				answer = line.split("\\s+");

				option1(answer);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
