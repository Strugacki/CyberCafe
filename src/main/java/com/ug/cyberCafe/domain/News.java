package com.ug.cyberCafe.domain;

import java.sql.Blob;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class News {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_user;
	
	private String firstName;
	private String lastName;
	private String email;
	private Boolean active;
	private String dateOfBirth;
	private String nickname=null;
	private String login;
	private String password;
	private Blob avatar=null;
	
}
