package com.kj.yetanotherspringapp.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtService {
	private long expirationTime;
	private String jwtSecret;
	private SecretKey key;
	
	static final String PREFIX = "Bearer";
	
	public JwtService(@Value("${security.jwt.secret}") String jwtSecret, @Value("${security.jwt.expiration-time}") long expirationTime) {
		this.jwtSecret = jwtSecret;
		this.expirationTime = expirationTime;
		this.key = getSigningKey();
	}
	
	private SecretKey getSigningKey() {
	    byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
	    return Keys.hmacShaKeyFor(keyBytes);
	}

	public String getToken(String username) {
		String token = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime)).signWith(key).compact();
		return token;
	}

	public String getAuthUser(HttpServletRequest request) {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (token != null) {
			String user = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token.replace(PREFIX, ""))
					.getBody().getSubject();
			if (user != null)
				return user;
		}
		return null;
	}
}
