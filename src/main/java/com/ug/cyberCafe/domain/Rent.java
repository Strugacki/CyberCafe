package com.ug.cyberCafe.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hsqldb.types.DateTimeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="RENT")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Rents", query = "Select r from Rent r"),
	@NamedQuery(name = "get.Rent.By.Terminal.And.Date", query = "Select r from Rent r Where r.terminal = ? And r.date = ?")
})

public class Rent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDRENT", nullable = false)
	private long idRent;
	
	@ManyToOne
	@JoinColumn(name = "TERMINAL_IDTERMINAL")
	private Terminal terminal;
	
	@ManyToOne
	@JoinColumn(name = "USER_IDCUSTOMER")
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "USER_IDEMPLOYEE")
	private User employee;
	
	@Column(name = "PRICE", nullable = false)
	private Double price;
	
	@Column(name = "DATE", nullable = false)
	private String date;
	
	@Column(name = "TIMESTART", nullable = false)
	private Integer timeStart;
	
	@Column(name = "HOURS", nullable = false)
	private Integer hours;
	
	
	
	public long getIdRent() {
		return idRent;
	}

	public void setIdRent(long idRent) {
		this.idRent = idRent;
	}
	
	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Integer time_start) {
		this.timeStart = time_start;
	}
	
	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	 
}
