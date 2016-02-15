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
@Table(name="Address")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Addresses", query = "Select a from Address a"),
})
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDADRESS", nullable = false)
	private long idAddress;
	
	@Column(name = "CITY", nullable = true)
	private String city;
	
	@Column(name = "POSTALCODE", nullable = true)
	private String postalCode;
	
	@Column(name = "STREET", nullable = true)
	private String street;
	
	public long getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(long idAddress) {
		this.idAddress = idAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
}
