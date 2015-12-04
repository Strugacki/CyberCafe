package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TERMINAL")
public class Terminal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_terminal;
	
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@Column(name = "AVAILABLE", nullable = false)
	private Boolean available;
}
