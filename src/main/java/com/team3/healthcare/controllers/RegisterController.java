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

		Set<String> strRoles = payload.getRoles();
		Set<AccountRole> roles = new HashSet<>();
		
		if (strRoles == null) {
			throw new RuntimeException("Error: Role is not found.");
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_ADMIN_ROOT":
					AccountRole adminRoot = accountRoleService.getAccountRoleByName("ROLE_ADMIN_ROOT");
					roles.add(adminRoot);
					break;
				case "ROLE_ADMIN":
					AccountRole admin = accountRoleService.getAccountRoleByName("ROLE_ADMIN");
					roles.add(admin);
					break;
				case "ROLE_USER":
					AccountRole user = accountRoleService.getAccountRoleByName("ROLE_USER");
					roles.add(user);
					break;
				default:
					break;
				}
			});
		}
		account.setAccountRole(roles);
		accountService.registerAccount(account);
		return ResponseEntity.ok().body(true);
	}
}
