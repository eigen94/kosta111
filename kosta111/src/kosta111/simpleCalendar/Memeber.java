package kosta111.simpleCalendar;

import java.util.ArrayList;

public class Memeber {

	//member
	private String name;
	private String pass_word;
	private ArrayList<Integer> room_num = new ArrayList<Integer>();
	
	//constructor
	public Memeber() {}
	public Memeber(String name, String pass_word) {
		this.name=name;
		this.pass_word=pass_word;
	}
	
	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public ArrayList<Integer> getRoom_num() {
		return room_num;
	}
	public void setRoom_num(ArrayList<Integer> room_num) {
		this.room_num = room_num;
	}
}
