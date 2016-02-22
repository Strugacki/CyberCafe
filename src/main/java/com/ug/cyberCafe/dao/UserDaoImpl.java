package com.ug.cyberCafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	private DataSource dataSource;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void deleteUser(User user) {
		user = (User) sessionFactory.getCurrentSession().get(User.class, user.getIdUser());
		sessionFactory.getCurrentSession().delete(user);

	}

	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.Users").list();
	}

	@Override
	public User getUserById(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		User userToUpdate = getUserById(user.getIdUser());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setActive(user.getActive());
		userToUpdate.setDateOfBirth(user.getDateOfBirth());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setAvatar(user.getAvatar());
		userToUpdate.setAddresses(user.getAddresses());
		userToUpdate.setRole(user.getRole());
		sessionFactory.getCurrentSession().update(userToUpdate);
	}

	public boolean isValidUser(String login, String password) throws SQLException {
		String query = "Select count(1) from User u where u.login = ? and u.password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next()) {
			return (resultSet.getInt(1) > 0);
		} else {
			return false;
		}
	}

	@Override
	public void deleteAllUsers() {
		for (User user : getAllUsers()) {
			deleteUser(user);
		}
	}

	@Override
	public User logedUser(String username, String password) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			User user = null;
			Query query = sessionFactory.getCurrentSession().getNamedQuery("log.In.User");
			query.setString(0, username);
			query.setString(1, password);
			List<User> results = query.list();
			if (!results.isEmpty()) {
				user = results.get(0);
			}
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		try{
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
			}
			return (User) sessionFactory.getCurrentSession().getNamedQuery("get.User.By.Id");
		} catch (Exception e) {
			return null;
		}
	}

}
