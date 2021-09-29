package com.team3.healthcare.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5346261562300156307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "firstname", nullable = true)
	private String firstName;
	
	@Column(name = "lastname", nullable = true)
	private String lastName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "account_role", 
				joinColumns = @JoinColumn(name = "account_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id")) 
	private Set<AccountRole> accountRole = new HashSet<>();
	
	public Account() {
		super();
	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<AccountRole> getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(Set<AccountRole> accountRole) {
		this.accountRole = accountRole;
	}

}
