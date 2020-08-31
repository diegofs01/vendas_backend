package com.diego.venda.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diego.venda.model.JwtUserDetails;
import com.diego.venda.repository.JwtUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private JwtUserRepository jwtUserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> user = jwtUserRepo.findById(username);
		if(user.isPresent()) {
			return user.get();
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public void saveNewUser(JwtUserDetails newUser) {
		jwtUserRepo.save(newUser);
	}
	
	public void updateUser(JwtUserDetails user) {
		jwtUserRepo.updateUser(user.getEmail(), user.getRole(), user.getUsername());
		if(!user.getPassword().isEmpty()) {
			jwtUserRepo.updatePassword(user.getPassword(), user.getUsername());
		}
	}
}
