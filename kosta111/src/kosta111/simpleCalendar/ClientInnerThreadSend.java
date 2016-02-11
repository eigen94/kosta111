package kosta111.simpleCalendar;

import java.io.DataOutputStream;
import java.util.Scanner;

public class ClientInnerThreadSend extends Thread{
	DataOutputStream dos;
	Scanner sc = new Scanner(System.in);
	public ClientInnerThreadSend(DataOutputStream dos) {
		System.out.println("sendStart");
		this.dos=dos;
	}
	
	@Override
	public void run() {
		while(true){
//			System.out.println("send ok");
			
			try {
				System.out.print("innerThread : write command : ");
				dos.writeUTF(sc.next());
//				sleep(4000);
				
			} catch (Exception e) {
			}
			
		}
	}
}
