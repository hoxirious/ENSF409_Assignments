import java.net.Socket;
import java.io.*;

public class Client {

	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private BufferedReader stdIn;

	/** constructor creating a new Client-side Application **/
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

	/** creating a communication between Client and Server of the application **/
	public void communicate() {
		RegistrationGUI gui = new RegistrationGUI(socketIn, socketOut);
		String line = "";

		while (!line.contentEquals("QUIT")) {

		}

		/** closing the connection **/
		try {
			if (Integer.parseInt(socketIn.readLine()) == 6) {
				stdIn.close();
				socketIn.close();
				socketOut.close();
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	/** calling constructor and communicate method **/
	public static void main(String[] args) throws IOException {
		Client myClient = new Client("localhost", 9898);
		myClient.communicate();
	}
}
