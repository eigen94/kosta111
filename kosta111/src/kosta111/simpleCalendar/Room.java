package kosta111.simpleCalendar;

import java.io.DataOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

	static int room_last = 0;
	private int room_num;
	private List<Member> Members = new ArrayList<Member>();
	private List<DateInfo> Dates = new ArrayList<DateInfo>();
	private List<DataOutputStream> output = new ArrayList<DataOutputStream>();

	public Room() {
		room_num = room_last;
		room_last++;

	}

	public List<DataOutputStream> getOutput() {
		return output;
	}

	public List<Member> getMembers() {
		return Members;
	}

	public void setMembers(List<Member> members) {
		Members = members;

		for (int i = 0; i < members.size(); i++) {
			members.get(i).setRoom_num(room_num);

		}

	}

	public void addOutput(DataOutputStream dos) {

		output.add(dos);
	}

	public void removeOutput(DataOutputStream dos) {

		output.remove(dos);
	}

	public int getRoom_num() {

		return room_num;
	}

	public void addDate(String Date, Member m) {

		for (int i = 0; i < Dates.size(); i++) {
			if (Dates.get(i).getDate().equals(Date)) {
				Dates.get(i).addM(m);
				return;
			}

		}

		Dates.add(new DateInfo(Date, m));

	}

	public void removeDate(String Date, Member m) {

		for (int i = 0; i < Dates.size(); i++) {
			if (Dates.get(i).getDate().equals(Date)) {
				Dates.get(i).removeM(m);
				if (Dates.get(i).getSelMems().size() == 0)
					Dates.remove(i);
				return;
			}

		}

	}

	public DateInfo getDate(String msg) {

		for (int i = 0; i < Dates.size(); i++) {

			if (Dates.get(i).getDate().equals(msg))
				return Dates.get(i);

		}
		return null;
	}

}
