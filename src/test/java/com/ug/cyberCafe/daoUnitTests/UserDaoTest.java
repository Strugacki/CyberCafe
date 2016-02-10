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

import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.User;

@ContextConfiguration(locations = { "classpath:/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class UserDaoTest {

	@Autowired
	UserDao userDao;
	
	
	private String FIRSTNAME = "John";
	private String LASTNAME = "Smith";
	/*Initialization method that clears the news table from database and add few records before starting test method*/
	@Before public void initialize() {
		userDao.deleteAllUsers();
		
		/*First address added*/
		User userToAdd = new User();
		userToAdd.setFirstName(FIRSTNAME);
		userToAdd.setLastName(LASTNAME);
		userDao.addUser(userToAdd);
		
		/*Second address added*/
		User userToAdd2 = new User();
		userToAdd2.setFirstName(FIRSTNAME);
		userToAdd2.setLastName(LASTNAME);
		userDao.addUser(userToAdd2);
	}
	
	/*Finishing method that clears the address table from database*/
	@After public void finishing() {
		userDao.deleteAllUsers();
	}
	
	@Test
	public void addUserCheck() {
			
		List<User> retrievedUsers = userDao.getAllUsers();
		assertEquals(FIRSTNAME,retrievedUsers.get(0).getFirstName());
		assertEquals(LASTNAME,retrievedUsers.get(0).getLastName());
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
	public void updateNewsCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		User userToUpdate = retrievedUsers.get(0);
		userToUpdate.setFirstName("Something else");
		userToUpdate.setLastName("1-1-1");
		userDao.updateUser(userToUpdate);
		
		List<User> retrievedUsersAfterUpdate = userDao.getAllUsers();
		assertEquals("Sierakowice",retrievedUsersAfterUpdate.get(0).getFirstName());
		assertEquals("20-200", retrievedUsersAfterUpdate.get(0).getLastName());
	}
	
	@Test
	public void getNewsByIdCheck() {
		List<User> retrievedUsers = userDao.getAllUsers();
		User userToCompare = retrievedUsers.get(0);
		Long idToCompare = retrievedUsers.get(0).getIdUser();
		User userToCompare2 = userDao.getUserById(idToCompare);
		assertEquals(userToCompare,userToCompare2);
	}

}
