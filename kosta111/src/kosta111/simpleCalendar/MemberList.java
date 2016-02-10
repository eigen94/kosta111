package kosta111.simpleCalendar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemberList implements Serializable {
	
	List<Member> list = new ArrayList<Member>();

	public MemberList(List<Member> list) {
		super();
		this.list = list;
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}
	
	
	
	
	
	

}
