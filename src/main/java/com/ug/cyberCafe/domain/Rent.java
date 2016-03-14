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

import lombok.Data;

@Entity
@Table(name="RENT")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Rents", query = "Select r from Rent r"),
	@NamedQuery(name = "get.Rent.By.Terminal.And.Date", query = "Select r from Rent r Where r.terminal = ? And r.date = ?")
})
@Data
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
	 
}
