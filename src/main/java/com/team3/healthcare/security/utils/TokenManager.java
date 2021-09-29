package com.team3.healthcare.security.utils;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.team3.healthcare.services.impl.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class TokenManager implements Serializable {
	private static final long serialVersionUID = 4208491073550409796L;

	private static final Logger logger = LoggerFactory.getLogger(TokenManager.class);

	@Value("${jwt.secret}")
	private String jwtSecretKey;

	@Value("${jwt.token.validity}")
	private long jwtValitity;

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtValitity))
				.signWith(SignatureAlgorithm.HS512, jwtSecretKey).compact();
	}

	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().getSubject();
	}

}
