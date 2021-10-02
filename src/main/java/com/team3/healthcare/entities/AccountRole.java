package com.team3.healthcare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class AccountRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3952313222693922949L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "permission")
	private String permission;

	public AccountRole() {
	}

	public AccountRole(Long id, String permission) {
		super();
		this.id = id;
		this.permission = permission;
	}

  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
