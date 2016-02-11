package kosta111.simpleCalendar;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket objectServer = null;
		Member m = null;
		Manager manager = new Manager();
		manager.addMem(new Member("b","b"));
		manager.addMem(new Member("c","c"));
		
		try {
			objectServer = new ServerSocket(9090);
			
			while(true){
				socket = objectServer.accept();
				
				//ServerThread st = new ServerThread(socket, m);
				//st.start();
				
				PerClientThread t = new PerClientThread(socket, manager);
				t.start();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
