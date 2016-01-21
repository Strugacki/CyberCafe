package com.ug.cyberCafe.daoUnitTests;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.AddressDao;
import com.ug.cyberCafe.dao.AddressDaoImpl;
import com.ug.cyberCafe.domain.Address;

@ContextConfiguration(locations = { "classpath:/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class AddressDaoTest {	
	
	@Autowired
	AddressDao addressDao;
	
	private String CITY = "Gdansk";
	private String POSTALCODE = "80-126";
	private String STREET = "Spokojna";
	
	/*Initialization method that cleares the address database and add few records before starting test method*/
	@Before public void initialize() {
		addressDao.deleteAllAddresses();
		
		/*First address added*/
		Address addressToAdd = new Address();
		addressToAdd.setCity(CITY);
		addressToAdd.setPostalCode(POSTALCODE);
		addressToAdd.setStreet(STREET);
		addressDao.addAddress(addressToAdd);
		
		/*Second address added*/
		Address addressToAdd2 = new Address();
		addressToAdd2.setCity(CITY);
		addressToAdd2.setPostalCode(POSTALCODE);
		addressToAdd2.setStreet(STREET);
		addressDao.addAddress(addressToAdd2);
	}
	
	@After public void finishing() {
		addressDao.deleteAllAddresses();
	}
	
	@Test
	public void addAddressCheck() {
			
		List<Address> retrievedAddresses = addressDao.getAllAddresses();
		assertEquals(CITY,retrievedAddresses.get(0).getCity());
		assertEquals(POSTALCODE,retrievedAddresses.get(0).getPostalCode());
		assertEquals(STREET,retrievedAddresses.get(0).getStreet());	
	}
	
	@Test
	public void getAllAddressesCheck() {
		List<Address> retrievedAddresses = addressDao.getAllAddresses();
		assertEquals(2, retrievedAddresses.size());
	}
}
