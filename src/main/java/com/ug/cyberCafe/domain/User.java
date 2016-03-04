package com.ug.cyberCafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
@NamedQueries({ 
	@NamedQuery(name = "get.All.Users", query = "Select u from User u"),
	@NamedQuery(name = "get.User.By.Login", query = "Select u from User u where u.login = ?"),
	@NamedQuery(name = "log.In.User", query = "Select u from User u where u.login = ? and u.password = ?"),
	@NamedQuery(name = "get.Users.By.Role", query = "Select u from User u, Role r WHERE u.role=r.idRole AND r.role=? "),
	@NamedQuery(name = "set.Active.User.Account", query = "Update User u Set u.active = ? Where u.idUser = ?")
})
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSER", nullable = false)
	private long idUser;
	
	@NotNull
	@Size(min=3, max=20, message="Dozwolona długość to 3-20 znaków")
	@NotEmpty(message = "Podaj imię")
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;
	
	@NotNull
	@Size(min=3, max=20, message="Dozwolona długość to 3-20 znaków")
	@NotEmpty(message = "Podaj nazwisko")
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;
	
	@Email(message="Podaj właściwy adres email")
	@NotNull
	@NotEmpty(message = "Podaj właściwy adres email")
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "ACTIVE", nullable = false)
	private Boolean active = true;
	
	@NotNull
	@NotEmpty(message = "Pole nie może zostać puste 'rrrr-mm-dd' ")
	@Pattern(regexp="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])", message="Podaj właściwą datę rrrr-mm-dd ")
	@Column(name = "DATEOFBIRTH", nullable = false)
	private String dateOfBirth;
	
	
	@Column(name = "NICKNAME", nullable = true)
	private String nickname=null;
	
	@NotNull
	@Size(min=5, max=20, message="Dozwolona długość to 5-20 znaków")
	@NotEmpty(message = "Podaj login")
	@Column(name = "LOGIN", nullable = false)
	private String login;
	
	@NotNull
	@Size(min=6, max=20, message="Dozwolona długość to 6-20 znaków")
	@NotEmpty(message = "Podaj hasło")
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Lob
	@Column(name = "AVATAR", nullable = true)
	private byte[] avatar=null;
	
	@ManyToOne
	@JoinColumn(name="ADDRESS_IDADDRESS")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name="ROLE_IDROLE")
	private Role role;
//	private Set<Role> roles;

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

	public byte[]  getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	
	
}
