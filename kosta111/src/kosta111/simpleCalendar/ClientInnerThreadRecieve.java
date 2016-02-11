package kosta111.simpleCalendar;

import java.io.DataInputStream;

public class ClientInnerThreadRecieve extends Thread{

	DataInputStream dis;
	public ClientInnerThreadRecieve(DataInputStream dis) {
		this.dis=dis;
		System.out.println("recieve Start");
	}
	
	@Override
	public void run() {
		
		while(true){
			try {
				System.out.println("waiting...");
				String tmp = dis.readUTF();
				System.out.println("recieve ok");
				
				System.out.println(tmp);
//				sleep(4000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
}
