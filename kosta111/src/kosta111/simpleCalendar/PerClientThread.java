package kosta111.simpleCalendar;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {

	Socket socket;
	Manager manager;
	Member member = null;

	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	DataInputStream dis = null;
	DataOutputStream dos = null;

	public PerClientThread(Socket socket,  Manager manager) {
		super();
		this.socket = socket;
		this.manager = manager;
		//System.out.println(manager.getMem("b,b").toString());
		

		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void sendAll(String msg, Room room) {
		
		room.addDate(msg, member);

		List<DataOutputStream> list =room.getOutput();
		for (DataOutputStream writer : list) {
			try {
				writer.writeUTF(msg);
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		super.run();
		
		while (true) {
			try {

				String mode = dis.readUTF();

				// 로그인 생성
				if (mode.equals("mode1")) {
					String logInfo = dis.readUTF();
					System.out.println(logInfo);
				if (manager.getMem(logInfo) != null) {
						member = manager.getMem(logInfo);
						System.out.println("로그인 성공");

					}
				}

				// mode2 : 방 생성
				if (mode.equals("mode2")) {
					Object obj = ois.readObject();
					MemberList mList = (MemberList) obj;
					mList.getList().add(member);
					//System.out.println(mList.getList().size());
					manager.addRoom(mList.getList());
					System.out.println(manager.getRooms().get(0).getMembers().size());
					
				}

				// mode3: 방 아웃
				if (mode.equals("mode3")) {
					int Room_num = dis.readInt();
				
					manager.RoomOut(Room_num, member);
					System.out.println("방 아웃호"+manager.getRooms().get(0).getMembers().size());

				}

				// mode4: 방 입장
				if (mode.equals("mode4")) {
					int room_num = dis.readInt();

					Room room = manager.getRoom(room_num);
					room.addOutput(dos);
					
					oos.writeObject(room);
					oos.flush();
					
					
					while(true){
					
						
						String msg = dis.readUTF();
						String[] token = msg.split(",");

						// 선택
						if (token[0].equals("+"))
							room.addDate(token[1], member);

						// 해제
						if (token[0].equals("-"))
							room.removeDate(token[1], member);

						System.out.println(token[1]);
						if (msg.equals("0"))
							break;

						// 접속자에게 실시간으로 뿌려주는 내용

						msg += "," + room.getDate(token[1]).toString() + ","
								+ room.getDate(token[1]);

						sendAll(msg, room);
					

				}
					break;
					
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
