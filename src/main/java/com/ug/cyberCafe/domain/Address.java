package com.ug.cyberCafe.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "Address")
@NamedQueries({ @NamedQuery(name = "get.All.Addresses", query = "Select a from Address a"), })
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDADDRESS", nullable = false)
	private long idAddress;

	@NotNull
	@Column(name = "CITY", nullable = false)
	@NotEmpty(message = "Podaj właściwą nazwę miejscowości!")
	private String city;

	@NotNull
	@Column(name = "POSTALCODE", nullable = false)
	@NotEmpty(message = "Podaj właściwy kod pocztowy!")
	private String postalCode;

	@NotNull
	@Column(name = "STREET", nullable = false)
	@NotEmpty(message = "Podaj właściwą nazwę ulicy!")
	private String street;

	@NotNull
	@Column(name = "LOCALNUMBER", nullable = false)
	@Size(min = 1, max = 5, message = "Dozwolona długość to 5-20 znaków")
	@NotEmpty(message = "Podaj właściwy numer lokalu/domu!")
	private String localNumber;

}
