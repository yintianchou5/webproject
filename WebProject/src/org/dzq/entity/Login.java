package org.dzq.entity;

public class Login {
	
	public Login(String uname, String upwd) {
		this.uname = uname;
		this.upwd = upwd;
	}
	public Login() {
	}
	private String uname;
	private String upwd;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
}
