package com.team3.healthcare.services.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team3.healthcare.entities.Account;

public class UserDetailsImpl implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9143737007989157736L;

	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String gender;
	private String birthday;
	private String citizenId;
	private String avatar;
	private String phone;
	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String firstName, String lastName, String gender, String birthday,
			String citizenId, String avatar, String phone, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
		this.citizenId = citizenId;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Account account) {
		List<GrantedAuthority> grantedAuthorities = account.getAccountRole().stream()
				.map(role -> new SimpleGrantedAuthority(role.getPermission())).collect(Collectors.toList());

		return new UserDetailsImpl(account.getId(), account.getUsername(), account.getFirstName(),
				account.getLastName(), account.getGender(), account.getBirthday(), account.getCitizenId(),
				account.getAvatar(), account.getPhone(), account.getEmail(), account.getPassword(), grantedAuthorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getCitizenId() {
		return citizenId;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
