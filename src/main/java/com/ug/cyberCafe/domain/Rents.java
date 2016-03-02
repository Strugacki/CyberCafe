package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="RENTS")
@NamedQueries({ 
	//@NamedQuery(name = "get.All.Rents", query = "Select r from Rents r"),
})

public class Rents {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDRENTS", nullable = false)
	private long idRents;
	
	@NotNull
	@NotEmpty(message = "Pole nie może zostać puste 'rrrr-mm-dd' ")
	@Pattern(regexp="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])", message="Podaj właściwą datę rrrr-mm-dd ")
	@Column(name = "DATEOFRENT", nullable = false)
	private String dateOfRent;
	
	@NotNull
	@NotEmpty(message = "Podaj liczbę godzin")
	@Column(name = "TIMEOFRENT", nullable = false)
	private Integer timeOfRent;
	
	@NotNull
	@NotEmpty(message = "Podaj właściwą cenę")
	@Column(name = "PRICEOFRENT", nullable = false)
	private Double priceOfRent;
	
	@ManyToOne
	@JoinColumn(name="USER_IDUSER")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="TERMINAL_IDTERMINAL")
	private Terminal termianl;
	
	/*@ManyToOne
	@JoinColumn(name="USER_IDEMPLOYEE")
	private User idEmployee;*/
	
	
	
	public long getIdRents() {
		return idRents;
	}

	public void setIdRents(long idRents) {
		this.idRents = idRents;
	}
	
	public String getDateOfRent() {
		return dateOfRent;
	}

	public void setDateOfRent(String dateOfRent) {
		this.dateOfRent = dateOfRent;
	}
	
	public Integer getTimeOfRent() {
		return timeOfRent;
	}

	public void setTimeOfRent(Integer timeOfRent) {
		this.timeOfRent = timeOfRent;
	}
	
	public Double getPriceOfRent() {
		return priceOfRent;
	}

	public void setPriceOfRent(Double priceOfRent) {
		this.priceOfRent = priceOfRent;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Terminal getTerminal() {
		return termianl;
	}

	public void setTerminal(Terminal termianl) {
		this.termianl = termianl;
	}
	
	/*public User getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(User idEmployee) {
		this.idEmployee = idEmployee;
	}*/
	
}
