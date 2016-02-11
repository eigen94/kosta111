package kosta111.simpleCalendar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ClientThreadTest extends Thread{
	String clientName;
	Scanner sc = new Scanner(System.in);

	
	public ClientThreadTest(Socket socket) {
	
		try {
			//媛앹껜�쟾�넚
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			//紐낅졊臾몄쟾�넚 
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
	
			
			while(true){
				System.out.print("mode 입력 ");
				String tmp = sc.next();
				
				switch (tmp) {
				case "1":
					dos.writeUTF("mode1");
					dos.flush();
					System.out.print("write 로그인: ");
					String LogInfo = sc.next();
					dos.writeUTF(LogInfo);
					dos.flush();
					

					
					break;
				case "2":
					dos.writeUTF("mode2");
					dos.flush();
					System.out.print("방생성 ");
					List<Member> mList = new ArrayList<Member>();
					mList.add(new Member("aa","aa"));
					MemberList MList = new MemberList(mList);
					
					oos.writeObject(MList);
					oos.flush();
					
					
					
					break;

				case "3":
					dos.writeUTF("mode3");
					dos.flush();
					System.out.println("방아웃");
					String roomInt = sc.next();
					dos.writeInt(Integer.parseInt(roomInt));
					//dos.flush();
					
					
				
					break;
				case "4":
					dos.writeUTF("mode4");
					dos.flush();
					System.out.println("방입장");
					System.out.println("write roomNum : ");
					String roomInt2 = sc.next();
					dos.writeInt(Integer.parseInt(roomInt2));
					dos.flush();
					
//					
//					String msg = sc.next();
//					if(msg.equals("0"))
//						break;
//					dos.writeUTF(msg);
//					dos.flush();
					
//				while(true){
//					
//					String in = dis.readUTF();
//					if(in.equals("9"))
//						break;
//					System.out.println(in);
//				}
				
					
					//InnerThreadStart
					
					ClientInnerThreadSend cits = new ClientInnerThreadSend(dos);
					ClientInnerThreadRecieve citr = new ClientInnerThreadRecieve(dis);
					
					cits.start();
					citr.start();
					while(true){
						
						if(cits.isAlive()!=true){
							break;
						}
						
					}
				
				/*	while(true){
						String msg = sc.next();
						if(msg.equals("0"))
							break;
						dos.writeUTF(msg);
						dos.flush();
						
						
						
					}*/
					
				
					break;
				default:
					System.out.println("worng Command");
					break;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
