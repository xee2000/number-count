package com.tourist.dto;

public class MemberVO {
	
	private String id;
	private String pwd;
	private String name;
	private String nickname;
	private String email;
	
	public MemberVO() {
		
	}

	public MemberVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", pwd=" + pwd + ", name=" + name + ",email=" + email + ", nickname=" + nickname +
				"}\n";
	}
	
	

}
