package com.tourist.dto;

import java.util.List;


public class TouristVO {
	
	private String name;
	private String type;
	private String address;
	private String closeday;
	private String time;
	private String areaname;
	private String number;
	private String season;
	private String mnumber;
	private String trcode;
	
	private List<ReviewVO> reviewList;
	
	
	public TouristVO() {}
	public TouristVO(String trcode) {
		super();
		this.trcode = trcode;
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCloseday() {
		return closeday;
	}
	public void setCloseday(String closeday) {
		this.closeday = closeday;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getMnumber() {
		return mnumber;
	}
	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}
	public String getTrcode() {
		return trcode;
	}
	public void setTrcode(String trcode) {
		this.trcode = trcode;
	}
	@Override
	public String toString() {
		return "관광지정보 번호 = " + trcode + ", 관광지 이름 = " + name + ", 형식 = " + type + ", 주소 = " + address + ", 휴무 = " + closeday
				+ ", 영업시간 = " + time + "\n, 지역 = " + areaname + ", 문의 = " + number + ", 추천계절 = " + season+"\n";
			
	}
	public List<ReviewVO> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<ReviewVO> reviewList) {
		this.reviewList = reviewList;
	}

		
	}
