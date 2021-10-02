package com.team3.healthcare.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.healthcare.entities.Account;
import com.team3.healthcare.entities.AccountRole;
import com.team3.healthcare.payloads.RegisterRequestPayload;
import com.team3.healthcare.services.AccountRoleService;
import com.team3.healthcare.services.AccountService;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRoleService accountRoleService;

	@PostMapping("/register")
	public ResponseEntity<?> registerNewUser(@RequestBody RegisterRequestPayload payload) {
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String encodedPwd = pwdEncoder.encode(payload.getPassword());

		Account account = new Account(payload.getUsername(), encodedPwd);
		
		account.setFirstName(payload.getFirstName());
		account.setLastName(payload.getFirstName());
		account.setGender(payload.getGender());
		account.setCitizenId(payload.getCitizenId());
		account.setAvatar(payload.getAvatar());
		account.setBirthday(payload.getBirthday());
		account.setPhone(payload.getPhone());
		account.setEmail(payload.getEmail());
		account.setAddress(payload.getAddress());

		Set<AccountRole> roles = new HashSet<>();
		AccountRole commonUser = accountRoleService.getAccountRoleByName("ROLE_CUSTOMER");
		roles.add(commonUser);

		account.setAccountRole(roles);
		accountService.registerAccount(account);
		return ResponseEntity.ok().body(true);
	}
}
