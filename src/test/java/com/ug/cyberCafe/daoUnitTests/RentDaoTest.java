package com.ug.cyberCafe.daoUnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import com.ug.cyberCafe.dao.RentDao;
import com.ug.cyberCafe.dao.TerminalDao;
import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.Rent;
import com.ug.cyberCafe.domain.Terminal;
import com.ug.cyberCafe.domain.User;

@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class RentDaoTest {
	
	@Autowired
	RentDao rentDao;
	@Autowired
	TerminalDao terminalDao;
	@Autowired
	UserDao userDao;
	
	//global
	private List<User> allUsers;
	private List<Terminal> allTerminals;
	
	//for terminal
	private String TYPE = "PC";
	private boolean AVAIABLE = true;
	private String DESCRIPTION = "Personal Computer";
	
	//for customer
	private String FIRSTNAMECUSTOMER = "John";
	private String LASTNAMECUSTOMER = "Smith";
	private String EMAILCUSTOMER = "test@email.com";
	private Boolean ACTIVECUSTOMER = true;
	private String DATEOFBIRTHCUSTOMER = "1994-04-10";
	private String NICKNAMECUSTOMER = "Andriej";
	private String LOGINCUSTOMER = "qwerty";
	private String PASSWORDCUSTOMER = "123456";
	
	//for employee
	private String FIRSTNAMEEMPLOYEE = "Michal";
	private String LASTNAMEEMPLOYEE = "Gorsky";
	private String EMAILEMPLOYEE = "test@email.com";
	private Boolean ACTIVEEMPLOYEE = true;
	private String DATEOFBIRTHEMPLOYEE = "1994-04-10";
	private String NICKNAMEEMPLOYEE = "Andriej";
	private String LOGINEMPLOYEE = "qwerty";
	private String PASSWORDEMPLOYEE = "123456";
	
	//for rent
	private Terminal TERMINAL;
	private User CUSTOMER;
	private User EMPLOYEE;
	private Double PRICE = 200.0;
	private String DATE = "2000-01-01";
	private Integer TIMESTART = 12;
	private Integer HOURS = 3;
	
	@Before
	public void initialize(){
		rentDao.deleteAllRents();
		userDao.deleteAllUsers();
		terminalDao.deleteAllTerminals();
		
		User customerToAdd = new User();
		customerToAdd.setFirstName(FIRSTNAMECUSTOMER);
		customerToAdd.setLastName(LASTNAMECUSTOMER);
		customerToAdd.setEmail(EMAILCUSTOMER);
		customerToAdd.setActive(ACTIVECUSTOMER);
		customerToAdd.setDateOfBirth(DATEOFBIRTHCUSTOMER);
		customerToAdd.setNickname(NICKNAMECUSTOMER);
		customerToAdd.setLogin(LOGINCUSTOMER);
		customerToAdd.setPassword(PASSWORDCUSTOMER);
		userDao.addUser(customerToAdd);
		
		User employeeToAdd = new User();
		employeeToAdd.setFirstName(FIRSTNAMEEMPLOYEE);
		employeeToAdd.setLastName(LASTNAMEEMPLOYEE);
		employeeToAdd.setEmail(EMAILEMPLOYEE);
		employeeToAdd.setActive(ACTIVEEMPLOYEE);
		employeeToAdd.setDateOfBirth(DATEOFBIRTHEMPLOYEE);
		employeeToAdd.setNickname(NICKNAMEEMPLOYEE);
		employeeToAdd.setLogin(LOGINEMPLOYEE);
		employeeToAdd.setPassword(PASSWORDEMPLOYEE);
		userDao.addUser(employeeToAdd);
		
		Terminal terminalToAdd = new Terminal();
		terminalToAdd.setAvailable(AVAIABLE);
		terminalToAdd.setDescription(DESCRIPTION);
		terminalToAdd.setType(TYPE);
		terminalDao.addTerminal(terminalToAdd);
		
		allUsers = userDao.getAllUsers();
		allTerminals = terminalDao.getAllTerminals();
		
		Rent rentToAdd = new Rent();
		rentToAdd.setTerminal(allTerminals.get(0));
		rentToAdd.setCustomer(allUsers.get(0));
		rentToAdd.setEmployee(allUsers.get(1));
		rentToAdd.setPrice(PRICE);
		rentToAdd.setDate(DATE);
		rentToAdd.setTimeStart(TIMESTART);
		rentToAdd.setHours(HOURS);
		rentDao.addRent(rentToAdd);
		
		Rent rentToAdd2 = new Rent();
		rentToAdd2.setTerminal(TERMINAL);
		rentToAdd2.setCustomer(CUSTOMER);
		rentToAdd2.setEmployee(EMPLOYEE);
		rentToAdd2.setPrice(PRICE);
		rentToAdd2.setDate(DATE);
		rentToAdd2.setTimeStart(TIMESTART);
		rentToAdd2.setHours(HOURS);
		rentDao.addRent(rentToAdd2);
		
		allUsers = userDao.getAllUsers();
		allTerminals = terminalDao.getAllTerminals();
	}
	
	@After
	public void finishing() {
		rentDao.deleteAllRents();
		userDao.deleteAllUsers();
		terminalDao.deleteAllTerminals();
	}
	
	@Test
	public void addRentCheck() {
		List<Rent> retrievedRents = rentDao.getAllRents();
		
		assertEquals(TYPE,retrievedRents.get(0).getTerminal().getType());
		assertEquals(FIRSTNAMECUSTOMER,retrievedRents.get(0).getCustomer().getFirstName());
		assertEquals(FIRSTNAMEEMPLOYEE,retrievedRents.get(0).getEmployee().getFirstName());
		assertEquals(PRICE,retrievedRents.get(0).getPrice());
		assertEquals(DATE,retrievedRents.get(0).getDate());
		assertEquals(TIMESTART,retrievedRents.get(0).getTimeStart());
		assertEquals(HOURS,retrievedRents.get(0).getHours());
	}

	@Test
	public void getAllRentsCheck() {
		List<Rent> retrievedRents = rentDao.getAllRents();
		assertEquals(2, retrievedRents.size());
	}
	
	@Test
	public void deleteAllRentsCheck() {
		List<Rent> retrievedRents = rentDao.getAllRents();
		assertNotNull(retrievedRents);
		rentDao.deleteAllRents();
		List<Rent> retrievedRentsAfterDelete = rentDao.getAllRents();
		assertEquals(retrievedRentsAfterDelete, new ArrayList<>(0));
	}
}
