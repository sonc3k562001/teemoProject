package com.team3.healthcare.services.impl;

import javax.persistence.EntityManager;

import com.team3.healthcare.entities.Account;
import com.team3.healthcare.repositories.AccountRepository;
import com.team3.healthcare.services.AccountService;
import com.team3.healthcare.services.MailService;
import com.team3.healthcare.utils.Constant;

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

	@Autowired
	MailService mailService;

	@Override
	public Account findByUsername(String username) {
		return accountRepo.findByUsername(username);
	}

	@Override
	public void registerAccount(Account account) {
		accountRepo.save(account);
	}

	@Override
	public boolean resetPassword(String username) {
		// step 1: finding account exist with this email
		Account account = accountRepo.findByUsername(username);

		if(account != null) {
			// step 2: reset this account password with default one
			String newPwd = Constant.RESET_PASSWORD;
			String newBcryptPwd = Constant.BCRYPT_RESET_PASSWORD;
			accountRepo.resetAccountPassword(newBcryptPwd, account.getUsername());
			// step 3: sending email to this account email with modified password
			mailService.sendResetPasswordMail(account.getEmail(),
																			Constant.EMAIL_SUBJECT,
																			"Reset password for user " + account.getUsername() + "is: " + newPwd);
			return true;
		}
		return false;
	}
}
