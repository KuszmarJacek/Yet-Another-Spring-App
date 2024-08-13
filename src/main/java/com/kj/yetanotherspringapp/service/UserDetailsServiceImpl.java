package com.kj.yetanotherspringapp.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.kj.yetanotherspringapp.domain.AppUser;
import com.kj.yetanotherspringapp.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final AppUserRepository repository;
	
	public UserDetailsServiceImpl(AppUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> user = repository.findByUsername(username);
		UserBuilder builder = null;
		if (user.isPresent()) {
			AppUser currentUser = user.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}
}
