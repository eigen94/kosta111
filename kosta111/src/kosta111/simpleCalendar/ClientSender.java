package kosta111.simpleCalendar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientSender extends Thread {

	DataOutputStream dos;
	Scanner sc = new Scanner(System.in);

	public ClientSender(DataOutputStream dos) {
		super();
		this.dos = dos;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while (true) {

			String msg = sc.next();
			if(msg.equals("0"))
				break;
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("º¸³»°í");

		}
	}

}
