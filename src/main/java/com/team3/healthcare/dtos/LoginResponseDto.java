package com.team3.healthcare.dtos;

import java.io.Serializable;
import java.util.List;

public class LoginResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3204633921314748604L;
	
	private String token;
	private	String username;
	private List<String> permission;

	public LoginResponseDto(String token, String username, List<String> permission) {
		super();
		this.token = token;
		this.username = username;
		this.permission = permission;
	}

	public String getToken() {
		return token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getPermission() {
		return permission;
	}
	
}
