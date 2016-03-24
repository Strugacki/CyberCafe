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

import com.ug.cyberCafe.dao.RoleDao;
import com.ug.cyberCafe.domain.Role;

@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional("transactionManager")
public class RoleDaoTest {

	@Autowired
	RoleDao roleDao;
	
	private String ROLE = "Admin";
	
	/*Initialisation method that clears the news table from database and add few records before starting test method*/
	@Before public void initialize() {
		roleDao.deleteAllRoles();
		
		/*First address added*/
		Role roleToAdd = Role.builder().role(ROLE).build();
		roleDao.addRole(roleToAdd);
		
		/*Second address added*/
		Role roleToAdd2 = Role.builder().role(ROLE).build();
		roleDao.addRole(roleToAdd2);
	}
	
	/*Finishing method that clears the address table from database*/
	@After public void finishing() {
		roleDao.deleteAllRoles();
	}
	
	@Test
	public void addRoleCheck() {
			
		List<Role> retrievedRoles = roleDao.getAllRoles();
		assertEquals(ROLE,retrievedRoles.get(0).getRole());
	}
	
	@Test
	public void getAllRolesCheck() {
		List<Role> retrievedRoles = roleDao.getAllRoles();
		assertEquals(2, retrievedRoles.size());
	}
	
	@Test
	public void deleteAllRolesCheck() {
		List<Role> retrievedRoles = roleDao.getAllRoles();
		assertNotNull(retrievedRoles);
		roleDao.deleteAllRoles();
		List<Role> retrievedRolesAfterDelete = roleDao.getAllRoles();
		assertEquals(retrievedRolesAfterDelete, new ArrayList<>(0));
	}
	
	@Test 
	public void updateRoleCheck() {
		List<Role> retrievedRoles = roleDao.getAllRoles();
		Role roleToUpdate = retrievedRoles.get(0);
		roleToUpdate.setRole("Something else");
		roleDao.updateRole(roleToUpdate);
		
		List<Role> retrievedRolesAfterUpdate = roleDao.getAllRoles();
		assertEquals("Something else",retrievedRolesAfterUpdate.get(0).getRole());
	}
	
	@Test
	public void getRoleByIdCheck() {
		List<Role> retrievedRoles = roleDao.getAllRoles();
		Role roleToCompare = retrievedRoles.get(0);
		Long idToCompare = retrievedRoles.get(0).getIdRole();
		Role newsToCompare2 = roleDao.getRoleById(idToCompare);
		assertEquals(roleToCompare,newsToCompare2);
	}
}

