package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.Role;

public interface RoleDao {
	
    void addRole(Role role);
    
    void deleteRoleById(int id);
     
    List<Role> getAllRoles();
 
    Role getRoleById(int id);

}
