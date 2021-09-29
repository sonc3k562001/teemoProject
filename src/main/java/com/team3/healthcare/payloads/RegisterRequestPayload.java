package com.team3.healthcare.payloads;

import java.io.Serializable;
import java.util.Set;

public class RegisterRequestPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496739729791562307L;
	
	private String username;
	private String password;
	private Set<String> roles;

	public RegisterRequestPayload() {
	}

	public RegisterRequestPayload(String username, String password, Set<String> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
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

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
