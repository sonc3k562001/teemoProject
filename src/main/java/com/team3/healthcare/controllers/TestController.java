package com.team3.healthcare.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String testAll() {
		return "Test All.";
	}

	@GetMapping("/customer")
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public String testCustomer() {
		return "Test Customer.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String testAdmin() {
		return "Test Admin.";
	}
}
