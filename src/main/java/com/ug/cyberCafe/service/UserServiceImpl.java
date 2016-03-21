package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User logedUser(String username, String password) {
		return userDao.logedUser(username, password);
		
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public List<User> getUsersByRole(String role) {
		return userDao.getUsersByRole(role);
	}

	@Override
	public void deactivateUserAccount(long id,boolean value) {
		userDao.deactivateUserAccount(id,value);
	}

	@Override
	public boolean checkUniqueLogin(String login) {
		List<User> results = userDao.checkUniqueLogin(login);
		if(results.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUniqueNickname(String nickname) {
		List<User> results = userDao.checkUniqueNickname(nickname);
		if(results.isEmpty()){
			return true;
		}
		return false;
	}

}
