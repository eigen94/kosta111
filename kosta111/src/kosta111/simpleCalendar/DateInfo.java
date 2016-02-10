package kosta111.simpleCalendar;

import java.io.Serializable;

public class DateInfo implements Serializable{
	
	String name;
	String date;
	public DateInfo(String name,String date) {
		this.name=name;
		this.date=date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DateInfo){
			DateInfo dateInfo = (DateInfo) obj;
			return dateInfo.name.equals(name)&& (dateInfo.date.equals(date));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+date.hashCode();
	}

	@Override
	public String toString() {
		return "DateInfo [name=" + name + ", date=" + date + "]";
	}
	
}
