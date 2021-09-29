package com.team3.healthcare.payloads;

import java.io.Serializable;

public class LoginRequestPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8551487877616925475L;
	
	private String username;
	private String password;

	public LoginRequestPayload() {
	}

	public LoginRequestPayload(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
