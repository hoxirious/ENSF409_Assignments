import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationServer.
 */
public class RegistrationServer {
	

		/** The a socket. */
		private Socket aSocket;
		
		/** The server socket. */
		private ServerSocket serverSocket;
		
		/** The socket out. */
		private PrintWriter socketOut;
		
		/** The socket in. */
		private BufferedReader socketIn;
		
		/** The pool. */
		private ExecutorService pool;

		/**
		 *  Constructor creating Server-side application *.
		 *
		 * @param port the port
		 */
		public RegistrationServer(int port) {
			try {
				serverSocket = new ServerSocket(port);
				pool = Executors.newFixedThreadPool(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	/**
	 *  using client as thread to run the server *.
	 */
	public void runServer() {
		try {
			while(true) {
				aSocket = serverSocket.accept();
				System.out.println("Connection accepted by server!");
			    socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
				socketOut = new PrintWriter((aSocket.getOutputStream()), true);
				
				RegistrationApp app = new RegistrationApp(socketIn, socketOut);
				
				pool.execute(app);
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		closeConnection();
	}
	
	/**
	 *  close the connection between client and server *.
	 */
	private void closeConnection() {
		try {
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	/**
	 *  main methods calling constructor and run server method*.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		RegistrationServer myServer = new RegistrationServer(9898);
		myServer.runServer();
	}
}