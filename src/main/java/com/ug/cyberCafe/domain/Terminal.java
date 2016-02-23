package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TERMINAL")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Terminals", query = "Select t from Terminal t"),
})
public class Terminal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTERMINAL", nullable = false)
	private long idTerminal;
	
	@NotNull
	@Size(min=2, max=20, message="Dozwolona długość to 2-20 znaków")
	@NotEmpty(message = "Podaj typ")
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@Column(name = "AVAILABLE", nullable = false)
	private Boolean available;
	
	@NotNull
	@Size(min=5, max=100, message="Dozwolona długość to 5-100 znaków")
	@NotEmpty(message = "Podaj opis")
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
