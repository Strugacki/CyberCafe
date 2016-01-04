package com.ug.cyberCafe.daoUnitTests;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ug.cyberCafe.dao.AddressDaoImpl;
import com.ug.cyberCafe.domain.Address;

@ContextConfiguration(locations = { "classpath:/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class AddressDaoTest {

	@Autowired
	AddressDaoImpl addressDaoImpl;
	
	private String CITY = "Gdansk";
	private String POSTALCODE = "80-126";
	private String STREET = "Spokojna";
	
	@Test
	public void addAddressCheck() {
			
		Address address = new Address();
		address.setCity(CITY);
		address.setPostalCode(POSTALCODE);
		address.setStreet(STREET);
		
		List<Address> retrievedAddresses = addressDaoImpl.getAllAddresses();
		assertEquals(retrievedAddresses.size(),1);
		
	}
}
