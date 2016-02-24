package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ug.cyberCafe.domain.Role;
import com.ug.cyberCafe.domain.User;

@Repository
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.Roles").list();
	}

	@Override
	public Role getRoleById(long id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@Override
	public void updateRole(Role role) {
		Role roleToUpdate = getRoleById(role.getIdRole());
		roleToUpdate.setRole(role.getRole());
		sessionFactory.getCurrentSession().update(roleToUpdate);
	}
	
	@Override
	public void deleteAllRoles() {
		for(Role role : getAllRoles() ) {
			deleteRole(role);
		}
	}

	@Override
	public Role getRoleByName(String roleName) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			Role role = null;
			Query query = sessionFactory.getCurrentSession().getNamedQuery("get.Role.By.Name");
			query.setString(0, roleName);
			List<Role> results = query.list();
			if (!results.isEmpty()) {
				role = results.get(0);
			}
			return role;
		} catch (Exception e) {
			return null;
		}
	}
}
