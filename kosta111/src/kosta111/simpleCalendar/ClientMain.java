package kosta111.simpleCalendar;

import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) {
		
		Socket socket = null;
		Member m=null;
		try {
			socket = new Socket("localhost", 9090);
			
			ClientThreadTest ct = new ClientThreadTest(socket);
			
			ct.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
