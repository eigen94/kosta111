package kosta111.simpleCalendar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;

public class ServerThread extends Thread{
	
	HashSet<DateInfo> dateInfo = new HashSet<DateInfo>();
	public ServerThread(Socket socket, Member m) {
		try {
			//테스트용 초기정보 
			dateInfo.add(new DateInfo("Kim", "4/2"));
			dateInfo.add(new DateInfo("Lee", "4/2"));
			System.out.println(dateInfo);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			//최초 접속시 전체 정보 넘겨주기
			oos.writeObject(dateInfo);
			oos.flush();
			System.out.println("sendDone");
			
			while(true){
				System.out.println("waiting...");
				
				String tmpCmd = dis.readUTF();
				if(tmpCmd.equals("add")){
					System.out.println("addOp");
					dateInfo.add((DateInfo)ois.readObject());
					System.out.println("readDone");
					System.out.println("dateSize :"+dateInfo.size());
					System.out.println("---------");
					
				} else if(tmpCmd.equals("del")){
					System.out.println("delOp");
					dateInfo.remove((DateInfo)ois.readObject());
					System.out.println("readDone");
					System.out.println("dateSize :"+dateInfo.size());
					System.out.println("---------");
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
