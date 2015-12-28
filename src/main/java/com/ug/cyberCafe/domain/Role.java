package com.ug.cyberCafe.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRole;
	
	private String role;
	
}
