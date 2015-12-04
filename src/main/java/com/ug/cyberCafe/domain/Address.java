package com.ug.cyberCafe.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_address;
	
	private String city;
	private String postalCode;
	private String street;
	
}
