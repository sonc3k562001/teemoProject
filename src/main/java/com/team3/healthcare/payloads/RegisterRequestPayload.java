package com.team3.healthcare.payloads;

import java.io.Serializable;

public class RegisterRequestPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496739729791562307L;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String citizenId;
	private String birthday;
	private String avatar;
	private String gender;
	private String phone;
	private String email;
	private String address;

	public RegisterRequestPayload() {
	}

	public RegisterRequestPayload(String username, String password, String firstName, String lastName, String citizenId,
			String birthday, String avatar, String gender, String phone, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.citizenId = citizenId;
		this.birthday = birthday;
		this.avatar = avatar;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
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

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
