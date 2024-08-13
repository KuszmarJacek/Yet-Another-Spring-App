package com.kj.yetanotherspringapp.domain;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//Disable automatic creation of rest endpoints for AppUser entity
@RepositoryRestResource(exported = false)
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String role;
	
	public AppUser() {}

	public AppUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
