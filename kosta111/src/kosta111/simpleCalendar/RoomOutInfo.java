package kosta111.simpleCalendar;

import java.io.Serializable;

public class RoomOutInfo implements Serializable {
	
	private int room_num;
	private Member member;
	public RoomOutInfo(int room_num, Member member) {
		super();
		this.room_num = room_num;
		this.member = member;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	

}
