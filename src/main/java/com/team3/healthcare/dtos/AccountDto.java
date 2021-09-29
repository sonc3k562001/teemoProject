package com.team3.healthcare.dtos;

import java.io.Serializable;
import java.util.Set;

public class AccountDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3873803460528232826L;
	
	private String username;
	private String password;
	private Set<String> permission;

	public AccountDto() {
	}

	public AccountDto(String username, String password, Set<String> permission) {
		this.username = username;
		this.password = password;
		this.permission = permission;
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

	public Set<String> getPermission() {
		return permission;
	}

	public void setPermission(Set<String> permission) {
		this.permission = permission;
	}

}
