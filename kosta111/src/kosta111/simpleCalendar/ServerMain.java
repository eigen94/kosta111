package kosta111.simpleCalendar;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket objectServer = null;
		Member m = null;
		Manager manager = new Manager();
		manager.addMem(new Member("b","b"));
		manager.addMem(new Member("c","c"));
		List<Member> list = new ArrayList<Member>();
		list.add(manager.getMem("b,b"));
		list.add(manager.getMem("c,c"));
		manager.addRoom(list);
		
		try {
			objectServer = new ServerSocket(9090);
			
			
			//ServerThread st = new ServerThread(socket, m);
			//st.start();
		
			while(true){
	
			socket = objectServer.accept();
			PerClientThread t  = new PerClientThread(socket, manager);
		    t.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
