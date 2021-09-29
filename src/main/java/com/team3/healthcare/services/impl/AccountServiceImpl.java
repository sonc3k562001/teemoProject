package com.team3.healthcare.services.impl;

import javax.persistence.EntityManager;

import com.team3.healthcare.entities.Account;
import com.team3.healthcare.repositories.AccountRepository;
import com.team3.healthcare.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	EntityManager em;

	@Autowired
	AccountRepository accountRepo;

	@Override
	public Account findByUsername(String username) {
		return accountRepo.findByUsername(username);
	}

	@Override
	public void registerAccount(Account account) {
		accountRepo.save(account);
	}

}
