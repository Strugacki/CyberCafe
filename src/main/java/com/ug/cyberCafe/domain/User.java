package com.ug.cyberCafe.domain;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Users", query = "Select u from User u"),
})
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER", nullable = false)
	private long idUser;
	
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;
	
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "ACTIVE", nullable = false)
	private Boolean active;
	
	@Column(name = "DATEOFBIRTH", nullable = false)
	private String dateOfBirth;
	
	@Column(name = "NICKNAME", nullable = true)
	private String nickname=null;
	
	@Column(name = "LOGIN", nullable = false)
	private String login;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "AVATAR", nullable = true)
	private Blob avatar=null;
	
	@OneToMany
	private Set<Address> addresses;
	
	@OneToMany
	private Set<Role> roles;

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Blob getAvatar() {
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}	
	
}
