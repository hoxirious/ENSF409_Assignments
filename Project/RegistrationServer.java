import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class RegistrationServer {
	

		private Socket aSocket;
		private ServerSocket serverSocket;
		private PrintWriter socketOut;
		private BufferedReader socketIn;

		public RegistrationServer(int port) {
			try {
				serverSocket = new ServerSocket(port);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void runServer() {
		try {
			while(true) {
				aSocket = serverSocket.accept();
				System.out.println("Connection accepted by server!");
			    socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
				socketOut = new PrintWriter((aSocket.getOutputStream()), true);
				
				RegistrationApp app = new RegistrationApp(socketIn, socketOut);
				
				Thread t1 = new Thread (app);
				t1.run();
				
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		closeConnection();
	}
	
	private void closeConnection() {
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		RegistrationServer myServer = new RegistrationServer(9898);
		myServer.runServer();
	}
}
