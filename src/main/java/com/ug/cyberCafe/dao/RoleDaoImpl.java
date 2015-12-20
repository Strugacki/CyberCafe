package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ug.cyberCafe.domain.Role;

public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

	@Override
	public void addRole(Role role) {
		persist(role);
	}

	@Override
	public void deleteRoleById(int id) {
		
		
	}

	@Override
	public List<Role> getAllRoles() {
		Criteria criteria = createEntityCriteria();
        return (List<Role>) criteria.list();
	}

	@Override
	public Role getRoleById(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Role) criteria.uniqueResult();
	}

}
