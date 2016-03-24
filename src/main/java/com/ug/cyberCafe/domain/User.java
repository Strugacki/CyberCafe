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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "USER")
@NamedQueries({ @NamedQuery(name = "get.All.Users", query = "Select u from User u"),
		@NamedQuery(name = "get.User.By.Login", query = "Select u from User u where u.login = ?"),
		@NamedQuery(name = "log.In.User", query = "Select u from User u where u.login = ? and u.password = ?"),
		@NamedQuery(name = "get.Users.By.Role", query = "Select u from User u, Role r WHERE u.role=r.idRole AND r.role=? "),
		@NamedQuery(name = "set.Active.User.Account", query = "Update User u Set u.active = ? Where u.idUser = ?"),
		@NamedQuery(name = "check.Unique.Login", query = "Select u.firstName from User u WHERE u.login = ?"),
		@NamedQuery(name = "check.Unique.Nickname", query = "Select u.firstName from User u WHERE u.nickname = ?")})
@Data
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSER", nullable = false)
	private long idUser;

	@NotNull
	@Size(min = 3, max = 20, message = "Dozwolona długość to 3-20 znaków")
	@NotEmpty(message = "Podaj imię")
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@NotNull
	@Size(min = 3, max = 20, message = "Dozwolona długość to 3-20 znaków")
	@NotEmpty(message = "Podaj nazwisko")
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;

	@Email(message = "Podaj właściwy adres email")
	@NotNull
	@NotEmpty(message = "Podaj właściwy adres email")
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@NotNull
	@Column(name = "ACTIVE", nullable = false)
	private Boolean active = true;

	@NotNull
	@NotEmpty(message = "Pole nie może zostać puste 'rrrr-mm-dd' ")
	@Pattern(regexp = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])", message = "Podaj właściwą datę rrrr-mm-dd ")
	@Column(name = "DATEOFBIRTH", nullable = false)
	private String dateOfBirth;

	@Column(name = "NICKNAME", nullable = true)
	private String nickname = null;

	@NotNull
	@Size(min = 5, max = 20, message = "Dozwolona długość to 5-20 znaków")
	@NotEmpty(message = "Podaj login")
	@Column(name = "LOGIN", nullable = false)
	private String login;

	@NotNull
	@Size(min = 6, max = 20, message = "Dozwolona długość to 6-20 znaków")
	@NotEmpty(message = "Podaj hasło")
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Lob
	@Column(name = "AVATAR", nullable = true)
	private byte[] avatar = null;

	@OneToOne
	@JoinColumn(name = "ADDRESS_IDADDRESS")
	private Address address;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ROLE_IDROLE")
	private Role role;
	// private Set<Role> roles;
	
	@Tolerate
	User(){}

}
