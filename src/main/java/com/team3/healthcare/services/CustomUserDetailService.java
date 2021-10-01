package com.team3.healthcare.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface CustomUserDetailService extends UserDetailsService {
	public UserDetails loadUserByUsername(String username);
}
