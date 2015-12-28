package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TERMINAL")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Terminals", query = "Select t from Terminal t"),
})
public class Terminal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTerminal;
	
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@Column(name = "AVAILABLE", nullable = false)
	private Boolean available;

	public long getIdTerminal() {
		return idTerminal;
	}

	public void setIdTerminal(long idTerminal) {
		this.idTerminal = idTerminal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
