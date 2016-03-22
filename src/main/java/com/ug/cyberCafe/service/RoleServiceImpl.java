package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.RoleDao;
import com.ug.cyberCafe.domain.Role;

@Service
@Transactional
public class RoleServiceImpl extends UtilitiesService implements RoleService{
	
	@Autowired
	RoleDao roleDao;

	@Override
	public Role getRoleById(long id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	@Override
	public void updateRole(Role role) {
		Role roleToUpdate = getRoleById(role.getIdRole());
		roleToUpdate.setRole(role.getRole());
		roleDao.updateRole(roleToUpdate);
		
	}

	@Override
	public void deleteRole(Role role) {
		roleDao.deleteRole(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Override
	public Role getRoleByName(String roleName) {
		return roleDao.getRoleByName(roleName);
	}

}
