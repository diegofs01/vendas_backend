package com.diego.venda.model;

import java.io.Serializable;
import java.util.Date;

public class JwtResponse implements Serializable {
	
	private final String jwttoken;
	private final Date expirationDate;

	public JwtResponse(String jwttoken, Date expirationDate) {
		this.jwttoken = jwttoken;
		this.expirationDate = expirationDate;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public Date getExpirationDate() {
		return this.expirationDate;
	}
}