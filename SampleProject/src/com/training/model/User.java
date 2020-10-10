package com.training.model;

public class User {

	private String name;
	private String pw;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String pw) {
		super();
		this.name = name;
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pw=" + pw + "]";
	}
	
	
}
