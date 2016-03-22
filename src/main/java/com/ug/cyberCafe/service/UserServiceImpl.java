package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.User;

@Service("userService")
@Transactional
public class UserServiceImpl extends UtilitiesService implements UserService{

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
		User userToUpdate = getUserById(user.getIdUser());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setActive(user.getActive());
		userToUpdate.setDateOfBirth(user.getDateOfBirth());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setPassword(user.getPassword());
		if(user.getAvatar().length != 0){
		userToUpdate.setAvatar(user.getAvatar());
		}
		userDao.updateUser(userToUpdate);
		
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
