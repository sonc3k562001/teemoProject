package com.team3.healthcare.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.healthcare.dtos.LoginResponseDto;
import com.team3.healthcare.payloads.LoginRequestPayload;
import com.team3.healthcare.security.utils.TokenManager;
import com.team3.healthcare.services.CustomUserDetailService;
import com.team3.healthcare.services.impl.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {
	@Autowired
	CustomUserDetailService customUserDetailService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenManager tokenManager;

	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody LoginRequestPayload payload) throws Exception {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwtToken = tokenManager.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		String username = userDetails.getUsername();
		String firstName = userDetails.getFirstName();
		String lastName = userDetails.getLastName();
		String gender = userDetails.getGender();
		String birthday = userDetails.getBirthday();
		String citizenId = userDetails.getCitizenId();
		String avatar = userDetails.getAvatar();
		String phone = userDetails.getPhone();
		String email = userDetails.getEmail();

		List<String> permission = userDetails.getAuthorities().stream().map(r -> r.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new LoginResponseDto(jwtToken, username, firstName, lastName, gender, birthday,
				citizenId, avatar, phone, email, permission));
	}
}
