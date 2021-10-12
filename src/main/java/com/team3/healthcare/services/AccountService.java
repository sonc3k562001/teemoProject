package com.team3.healthcare.services;

import com.team3.healthcare.entities.Account;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {
	public Account findByUsername(String username);

	public void registerAccount(Account account);

	public boolean resetPassword(String username);
}
