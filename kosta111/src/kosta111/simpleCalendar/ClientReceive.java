package kosta111.simpleCalendar;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceive extends Thread {

	DataInputStream dis;

	public ClientReceive(DataInputStream dis) {
		super();
		this.dis= dis;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
	
		try {
			
		
		while(true){
			
			
				String msg = dis.readUTF();
				System.out.println(msg);
				if(msg.equals("0"))
					break;
				}}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	
		System.out.println("¹Þ°í");
		
		
	
		}

}
