package com.ug.cyberCafe.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Terminal {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_terminal;
	private String type;
	private Boolean available;
}
