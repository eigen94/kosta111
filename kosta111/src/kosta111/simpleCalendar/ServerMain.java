package kosta111.simpleCalendar;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket objectServer = null;
		Member m = null;
		
		try {
			objectServer = new ServerSocket(9090);
			socket = objectServer.accept();
			
			ServerThread st = new ServerThread(socket, m);
			st.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
