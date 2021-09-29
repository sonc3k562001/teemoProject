package com.team3.healthcare.services;

import com.team3.healthcare.entities.AccountRole;

import org.springframework.stereotype.Service;

@Service
public interface AccountRoleService {
	public AccountRole getAccountRoleByName(String name);
}
