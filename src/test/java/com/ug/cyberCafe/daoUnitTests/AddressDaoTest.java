package com.ug.cyberCafe.daoUnitTests;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.AddressDaoImpl;
import com.ug.cyberCafe.domain.Address;

@ContextConfiguration(locations = { "classpath:/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class AddressDaoTest {

	@Autowired
	AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
	
	private String CITY = "Gdansk";
	private String POSTALCODE = "80-126";
	private String STREET = "Spokojna";
		
	@Rollback(false)
	@Test
	public void addAddressCheck() {
			
		Address address = new Address();
		address.setCity(CITY);
		address.setPostalCode(POSTALCODE);
		address.setStreet(STREET);
		
		addressDaoImpl.addAddress(address);
		List<Address> retrievedAddress = addressDaoImpl.getAllAddresses();
		assertEquals(CITY,retrievedAddress.get(0).getCity());
		
	}
}
