package com.team3.healthcare.services.impl;

import javax.persistence.EntityManager;

import com.team3.healthcare.entities.AccountRole;
import com.team3.healthcare.repositories.AccountRoleRepository;
import com.team3.healthcare.services.AccountRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountRoleServiceImpl implements AccountRoleService {
	@Autowired
	EntityManager em;

	@Autowired
	AccountRoleRepository accountRoleRepo;

	@Override
	public AccountRole getAccountRoleByName(String name) {
		return accountRoleRepo.getAccountRoleByName(name);
	}
}
