package com.tourist.dto;

import java.util.Date;

public class ReviewVO {
	
	private String num;
	private String content;
	private String grade;
	private Date rDate;
	private String key;
	private String id;

	
	public ReviewVO() {
		
	}

	public ReviewVO(String id, String key) {
		super();
		this.id = id;
		this.key = key;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getRDate() {
		return rDate;
	}

	public void setRDate(Date rDate) {
		this.rDate = rDate;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "{num=" + num + ", content=" + content + ", grade=" + grade + ", rDate=" + rDate + ", key="
				+ key + ", id=" + id + "}\n";
	}

	
	
}
