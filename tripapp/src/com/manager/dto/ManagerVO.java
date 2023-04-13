package com.manager.dto;

public class ManagerVO {
	
	private String num;
	private String id;
	private String password;
	private String telnumber;
	
	public ManagerVO() {}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	@Override
	public String toString() {
		return "ManagerVO [num=" + num + ", id=" + id + ", password=" + password + ", telnumber=" + telnumber + "]";
	}
	
	
	
}
