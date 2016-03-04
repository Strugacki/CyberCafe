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
@Table(name="ROLE")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Roles", query = "Select r from Role r"),
	@NamedQuery(name = "get.Role.By.Name", query = "Select r from Role r WHERE r.role = ? ")
})
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDROLE")
	private long idRole;
	
	@Column(name = "ROLE")
	private String role;

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
