package dorm.system.entity;

import java.sql.Timestamp;

public class Notice {
	private int id;
	private String context;
	private Timestamp time;
	private Staff staffId;
	public Staff getStaffId() {
		return staffId;
	}
	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}


}
