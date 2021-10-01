package com.team3.healthcare.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.healthcare.entities.Account;
import com.team3.healthcare.services.AccountRoleService;
import com.team3.healthcare.services.AccountService;
import com.team3.healthcare.services.CustomUserDetailService;

@Service
public class CustomUserDetailServiceImpl implements CustomUserDetailService {
	@Autowired
	AccountService accountService;

	@Autowired
	AccountRoleService accountRoleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountService.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}

		return UserDetailsImpl.build(account);
	}
}
