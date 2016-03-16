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

import com.ug.cyberCafe.dao.TerminalDao;
import com.ug.cyberCafe.domain.Terminal;

@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class TerminalDaoTest {

	@Autowired
	TerminalDao terminalDao;
	
	private String TYPE = "PC";
	private Boolean AVAILABLE = true;
	private String DESCRIPTION = "The best PC ever";
	
	/*Initialization method that clears the news table from database and add few records before starting test method*/
	@Before public void initialize() {
		terminalDao.deleteAllTerminals();
		
		/*First address added*/
		Terminal terminalToAdd = new Terminal();
		terminalToAdd.setType(TYPE);
		terminalToAdd.setAvailable(AVAILABLE);
		terminalToAdd.setDescription(DESCRIPTION);
		terminalDao.addTerminal(terminalToAdd);
		
		/*Second address added*/
		Terminal terminalToAdd2 = new Terminal();
		terminalToAdd2.setType(TYPE);
		terminalToAdd2.setAvailable(AVAILABLE);
		terminalToAdd2.setDescription(DESCRIPTION);
		terminalDao.addTerminal(terminalToAdd2);
	}
	
	/*Finishing method that clears the address table from database*/
	@After public void finishing() {
		terminalDao.deleteAllTerminals();
	}
	
	@Test
	public void addTerminalCheck() {
			
		List<Terminal> retrievedTerminals = terminalDao.getAllTerminals();
		assertEquals(TYPE,retrievedTerminals.get(0).getType());
		assertEquals(AVAILABLE,retrievedTerminals.get(0).getAvailable());
		assertEquals(DESCRIPTION,retrievedTerminals.get(0).getDescription());
	}
	
	@Test
	public void getAllTerminalsCheck() {
		List<Terminal> retrievedTerminals = terminalDao.getAllTerminals();
		assertEquals(2, retrievedTerminals.size());
	}
	
	@Test
	public void deleteAllTerminalsCheck() {
		List<Terminal> retrievedTerminals = terminalDao.getAllTerminals();
		assertNotNull(retrievedTerminals);
		terminalDao.deleteAllTerminals();
		List<Terminal> retrievedTerminalsAfterDelete = terminalDao.getAllTerminals();
		assertEquals(retrievedTerminalsAfterDelete, new ArrayList<>(0));
	}
	
	@Test 
	public void updateTerminalCheck() {
		List<Terminal> retrievedTerminals = terminalDao.getAllTerminals();
		Terminal terminalToUpdate = retrievedTerminals.get(0);
		terminalToUpdate.setType("Something else");
		terminalToUpdate.setAvailable(false);
		terminalDao.updateTerminal(terminalToUpdate);
		
		List<Terminal> retrievedTerminalsAfterUpdate = terminalDao.getAllTerminals();
		assertEquals("Something else",retrievedTerminalsAfterUpdate.get(0).getType());
		assertEquals(false,retrievedTerminalsAfterUpdate.get(0).getAvailable());
	}
	
	@Test
	public void getTerminalByIdCheck() {
		List<Terminal> retrievedTerminals = terminalDao.getAllTerminals();
		Terminal terminalToCompare = retrievedTerminals.get(0);
		Long idToCompare = retrievedTerminals.get(0).getIdTerminal();
		Terminal newsToCompare2 = terminalDao.getTerminalById(idToCompare);
		assertEquals(terminalToCompare,newsToCompare2);
	}
}

