package com.ug.cyberCafe.service;

import java.util.List;

import com.ug.cyberCafe.domain.Role;

public interface RoleService {
	
	Role getRoleById(long id);
	
	Role getRoleByName(String roleName);

	void addRole(Role role);

	void updateRole(Role role);

	void deleteRole(Role role);

	List<Role> getAllRoles();

}
