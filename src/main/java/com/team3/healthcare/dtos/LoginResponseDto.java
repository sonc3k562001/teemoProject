package com.team3.healthcare.dtos;

import java.io.Serializable;
import java.util.List;

public class LoginResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3204633921314748604L;

	private String token;
	private String username;
	private String firstName;
	private String lastName;
	private String gender;
	private String birthday;
	private String citizenId;
	private String avatar;
	private String phone;
	private String email;
	private List<String> permission;

	public LoginResponseDto(String token, String username, String firstName, String lastName, String gender,
			String birthday, String citizenId, String avatar, String phone, String email, List<String> permission) {
		super();
		this.token = token;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
		this.citizenId = citizenId;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPermission() {
		return permission;
	}

}
