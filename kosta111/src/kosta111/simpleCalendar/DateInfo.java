package kosta111.simpleCalendar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DateInfo{
	
	
	String date;
	List<Member> selMems = new ArrayList<Member>();
	
	public DateInfo(String date, Member m) {
		super();
		this.date = date;
		selMems.add(m);
	}
	
	public void addM(Member m){
		
		selMems.add(m);
	}
	
	public void removeM(Member m){
		
		for(int i=0;i<selMems.size();i++){
			if(selMems.get(i) ==m){
				selMems.remove(i);
				break;
			}
		}
		
			
	}
	
	public boolean AllSel(int MemNum){
		
		if(MemNum ==selMems.size())
			return true;
		return false;
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Member> getSelMems() {
		return selMems;
	}

	public void setSelMems(List<Member> selMems) {
		this.selMems = selMems;
	}

	
	
}
