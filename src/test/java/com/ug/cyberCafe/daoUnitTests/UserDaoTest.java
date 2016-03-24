package com.ug.cyberCafe.daoUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.AddressDao;
import com.ug.cyberCafe.dao.RoleDao;
import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.Role;
import com.ug.cyberCafe.domain.User;

@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class UserDaoTest {

	@Autowired
	UserDao userDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	RoleDao roleDao;

	private String FIRSTNAME = "John";
	private String LASTNAME = "Smith";
	private String EMAIL = "test@email.com";
	private Boolean ACTIVE = true;
	private String DATEOFBIRTH = "1994-04-10";
	private String NICKNAME = "Andriej";
	private String LOGIN = "qwerty";
	private String PASSWORD = "123456";
	

	/*
	 * Initialisation method that clears the news table from database and add
	 * few records before starting test method
	 */
	@Before
	public void initialize() {
		userDao.deleteAllUsers();

		/* First address added */
		User userToAdd = User.builder().firstName(FIRSTNAME).lastName(LASTNAME).email(EMAIL).active(ACTIVE).dateOfBirth(DATEOFBIRTH).nickname(NICKNAME).login(LOGIN).password(PASSWORD).build();
		userDao.addUser(userToAdd);

		/* Second address added */
		User userToAdd2 = User.builder().firstName(FIRSTNAME).lastName(LASTNAME).email(EMAIL).active(ACTIVE).dateOfBirth(DATEOFBIRTH).nickname(NICKNAME).login(LOGIN).password(PASSWORD).build();
		userDao.addUser(userToAdd2);
	}

	/* Finishing method that clears the address table from database */
	@After
	public void finishing() {
		userDao.deleteAllUsers();
	}

	@Test
	public void addUserCheck() {

		List<User> retrievedUsers = userDao.getAllUsers();
		assertEquals(FIRSTNAME, retrievedUsers.get(0).getFirstName());
		assertEquals(LASTNAME, retrievedUsers.get(0).getLastName());
		assertEquals(EMAIL, retrievedUsers.get(0).getEmail());
		assertEquals(ACTIVE, retrievedUsers.get(0).getActive());
		assertEquals(DATEOFBIRTH, retrievedUsers.get(0).getDateOfBirth());
		assertEquals(NICKNAME, retrievedUsers.get(0).getNickname());
		assertEquals(LOGIN, retrievedUsers.get(0).getLogin());
		assertEquals(PASSWORD, retrievedUsers.get(0).getPassword());
	}

	@Test
	public void getAllUsersCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		assertEquals(2, retrievedUsers.size());
	}

	@Test
	public void deleteAllUsersCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		assertNotNull(retrievedUsers);
		userDao.deleteAllUsers();
		List<User> retrievedUsersAfterDelete = userDao.getAllUsers();
		assertEquals(retrievedUsersAfterDelete, new ArrayList<>(0));
	}

	@Test
	public void updateUserCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		User userToUpdate = retrievedUsers.get(0);
		userToUpdate.setFirstName("Michal");
		userToUpdate.setLastName("Gorski");
		userToUpdate.setEmail("Michal@gmail.com");
		userToUpdate.setActive(false);
		userToUpdate.setDateOfBirth("1995-10-10");
		userToUpdate.setNickname("Gorsky");
		userToUpdate.setLogin("DajMiNazwe");
		userToUpdate.setPassword("654321");
		userDao.updateUser(userToUpdate);

		List<User> retrievedUsersAfterUpdate = userDao.getAllUsers();
		assertEquals("Michal", retrievedUsersAfterUpdate.get(0).getFirstName());
		assertEquals("Gorski", retrievedUsersAfterUpdate.get(0).getLastName());
		assertEquals("Michal@gmail.com", retrievedUsersAfterUpdate.get(0).getEmail());
		assertEquals(false, retrievedUsersAfterUpdate.get(0).getActive());
		assertEquals("1995-10-10", retrievedUsersAfterUpdate.get(0).getDateOfBirth());
		assertEquals("Gorsky", retrievedUsersAfterUpdate.get(0).getNickname());
		assertEquals("DajMiNazwe", retrievedUsersAfterUpdate.get(0).getLogin());
		assertEquals("654321", retrievedUsersAfterUpdate.get(0).getPassword());
	}

	@Test
	public void getUserByIdCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		User userToCompare = retrievedUsers.get(0);
		Long idToCompare = retrievedUsers.get(0).getIdUser();
		User userToCompare2 = userDao.getUserById(idToCompare);
		assertEquals(userToCompare, userToCompare2);
	}
	
	@Test
	public void addAddressToUserCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		User userToUpdate = retrievedUsers.get(0);
		Address addressToAdd = Address.builder().city("Kwidzyn").postalCode("80-126").street("Lakowa").localNumber("14").build();
		addressDao.addAddress(addressToAdd);
		List<Address> retrievedAddresses = addressDao.getAllAddresses();
		addressToAdd = retrievedAddresses.get(0);
		userToUpdate.setAddress(addressToAdd);
		userDao.updateUser(userToUpdate);
		List<User> retrievedUsersAfterUpdate = userDao.getAllUsers();
		User userAfterUpdate = retrievedUsersAfterUpdate.get(0);
		assertEquals(userAfterUpdate.getAddress().getIdAddress(),addressToAdd.getIdAddress());
		addressDao.deleteAllAddresses();
	}
	
	@Test
	public void addRoleToUserCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		User userToUpdate = retrievedUsers.get(0);
		Role roleToAdd = Role.builder().role("ADMIN").build();
		roleDao.addRole(roleToAdd);
		List<Role> retrievedRoles = roleDao.getAllRoles();
		roleToAdd = retrievedRoles.get(0);
		userToUpdate.setRole(roleToAdd);
		userDao.updateUser(userToUpdate);
		List<User> retrievedUsersAfterUpdate = userDao.getAllUsers();
		User userAfterUpdate = retrievedUsersAfterUpdate.get(0);
		assertEquals(userAfterUpdate.getRole().getIdRole(),roleToAdd.getIdRole());
		roleDao.deleteAllRoles();
	}

}
