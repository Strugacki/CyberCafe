package com.ug.cyberCafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
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

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void deleteUser(User user) {
		user = (User) sessionFactory.getCurrentSession().get(User.class, user.getIdUser());
		sessionFactory.getCurrentSession().delete(user);

	}

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.Users").list();
	}

	public User getUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public boolean isValidUser(String login, String password) throws SQLException {
		String query = "Select count(1) from User where login = ? and password = ?";
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

}
