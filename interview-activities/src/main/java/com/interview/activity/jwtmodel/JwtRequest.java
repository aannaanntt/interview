package com.interview.activity.jwtmodel;

public class JwtRequest {
	 String name;
	 String password;

	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtRequest(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequest [name=" + name + ", password=" + password + "]";
	}

}
