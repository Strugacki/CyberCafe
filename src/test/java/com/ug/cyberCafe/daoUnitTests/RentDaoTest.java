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
	private boolean AVAILABLE = true;
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
		
		User customerToAdd = User.builder().firstName(FIRSTNAMECUSTOMER).lastName(LASTNAMECUSTOMER).email(EMAILCUSTOMER).active(ACTIVECUSTOMER).dateOfBirth(DATEOFBIRTHCUSTOMER).nickname(NICKNAMECUSTOMER).login(LOGINCUSTOMER).password(PASSWORDCUSTOMER).build();
		userDao.addUser(customerToAdd);
		
		User employeeToAdd = User.builder().firstName(FIRSTNAMEEMPLOYEE).lastName(LASTNAMEEMPLOYEE).email(EMAILEMPLOYEE).active(ACTIVEEMPLOYEE).dateOfBirth(DATEOFBIRTHEMPLOYEE).nickname(NICKNAMEEMPLOYEE).login(LOGINEMPLOYEE).password(PASSWORDEMPLOYEE).build();	
		userDao.addUser(employeeToAdd);
		
		Terminal terminalToAdd = Terminal.builder().type(TYPE).available(AVAILABLE).description(DESCRIPTION).build();
		terminalDao.addTerminal(terminalToAdd);
		
		allUsers = userDao.getAllUsers();
		allTerminals = terminalDao.getAllTerminals();
		
		Rent rentToAdd = Rent.builder().terminal(allTerminals.get(0)).customer(allUsers.get(0)).employee(allUsers.get(1)).price(PRICE).date(DATE).timeStart(TIMESTART).hours(HOURS).build();
		rentDao.addRent(rentToAdd);
		
		Rent rentToAdd2 = Rent.builder().terminal(TERMINAL).customer(CUSTOMER).employee(EMPLOYEE).price(PRICE).date(DATE).timeStart(TIMESTART).hours(HOURS).build();
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
	
	@Test
	public void getRentByIdCheck() {
		List<Rent> retrievedRents = rentDao.getAllRents();
		Rent rentToCompare = retrievedRents.get(0);
		Long idToCompare = retrievedRents.get(0).getIdRent();
		Rent rentToCompare2 = rentDao.getRentById(idToCompare);
		assertEquals(rentToCompare, rentToCompare2);
	}
}
