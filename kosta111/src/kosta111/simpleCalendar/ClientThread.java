package kosta111.simpleCalendar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClientThread extends Thread{
	String clientName;
	Scanner sc = new Scanner(System.in);
	HashSet<DateInfo> dateInfo = new HashSet<DateInfo>();
	DateInfo data = new DateInfo("Kim", "4/3");
	DateInfo data2 = new DateInfo("","");
	
	public ClientThread(Socket socket, Member m) {
	
		try {
			//객체전송
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			//명령문전송 
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			//최초 접속시 이름등록 
			System.out.print("writeName :");
			clientName = sc.next();
			
			//최초에 접속 했을 때 전체 정보 받아오기 
			Object obj = ois.readObject();
			System.out.println("readDone");
			System.out.println(obj);
			dateInfo = (HashSet<DateInfo>) obj;
			System.out.println(dateInfo);
			
			
			while(true){
				System.out.print("1.add 2.remove 3.print : ");
				String tmp = sc.next();
				
				switch (tmp) {
				case "1":
					dos.writeUTF("add");
					dos.flush();
					System.out.print("write date(x/x): ");
					String tmpName = clientName;
					String tmpDate = sc.next();
					oos.writeObject(new DateInfo(tmpName,tmpDate));
					oos.flush();
					dateInfo.add(new DateInfo(tmpName, tmpDate));
					System.out.println("dateSize :"+dateInfo.size());
					System.out.println("---------");

					
					break;
				case "2":
					dos.writeUTF("del");
					dos.flush();
					System.out.print("write date(x/x): ");
					tmpName = clientName;
					tmpDate = sc.next();
					oos.writeObject(new DateInfo(tmpName,tmpDate));
					oos.flush();
					dateInfo.remove(new DateInfo(tmpName, tmpDate));
					System.out.println("dateSize :"+dateInfo.size());
					System.out.println("---------");
					
					break;

				case "3":
					Iterator it = dateInfo.iterator();
					
					while(it.hasNext()){
						System.out.println(it.next().toString());
					}
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
