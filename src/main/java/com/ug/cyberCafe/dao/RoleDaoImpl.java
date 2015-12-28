package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.Role;

public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public void deleteRole(Role role) {
		role = (Role) sessionFactory.getCurrentSession().get(Role.class, role.getIdRole());
		sessionFactory.getCurrentSession().delete(role);
		
	}

	@Override
	public List<Role> getAllRoles() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.Roles").list();
	}

	@Override
	public Role getRoleById(int id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

}
