package com.diego.venda.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diego.venda.jwt.JwtTokenUtil;
import com.diego.venda.jwt.JwtUserDetailsService;
import com.diego.venda.model.JwtRequest;
import com.diego.venda.model.JwtResponse;

@RestController
@CrossOrigin
@RequestMapping("/jwt")
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			
		final String token = jwtTokenUtil.generateToken(userDetails);
		final Date expDate = jwtTokenUtil.getExpirationDateFromToken(token);

		return ResponseEntity.ok(new JwtResponse(token, expDate));
	}

	@RequestMapping(value = "/checkToken", method = RequestMethod.POST)
	public @ResponseBody HttpStatus checkToken(@RequestBody String token) throws Exception {
		final UserDetails user = userDetailsService.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));
		final boolean check = jwtTokenUtil.validateToken(token, user);
		
		if(check) {
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
