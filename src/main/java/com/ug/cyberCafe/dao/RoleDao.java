package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.Role;

public interface RoleDao {
	
    void addRole(Role role);
    
    void deleteRole(Role role);
     
    List<Role> getAllRoles();
 
    Role getRoleById(long id);
    
    void updateRole(Role role);

	void deleteAllRoles();

}
