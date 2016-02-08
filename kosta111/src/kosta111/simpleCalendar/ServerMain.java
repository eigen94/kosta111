package kosta111.simpleCalendar;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(9090);
			socket = server.accept();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
