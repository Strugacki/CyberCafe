package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Entity
@Table(name="ROLE")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Roles", query = "Select r from Role r"),
	@NamedQuery(name = "get.Role.By.Name", query = "Select r from Role r WHERE r.role = ? ")
})
@Data
@Builder
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDROLE")
	private long idRole;
	
	@Column(name = "ROLE")
	private String role;
	
	@Tolerate
	Role(){}
	
}
