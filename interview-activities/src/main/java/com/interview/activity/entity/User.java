package com.interview.activity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int userid;
	private String name;
	private String password;
	private String status;

	public User() {
		super();
		
	}

	public User(int userid, String name, String password, String status) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		
	
		return name;
	}

	public void setUsername(String name) {
	
		this.name =name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", Password=" + password + ", status=" + status + "]";
	}
	
	
	

}
