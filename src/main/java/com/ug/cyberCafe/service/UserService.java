package com.ug.cyberCafe.service;

import java.util.List;

import com.ug.cyberCafe.domain.User;

public interface UserService {

	User getUserById(long id);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);
	
	User logedUser(String username, String password);

	List<User> getAllUsers();
	
	User getUserByUsername(String username);

}
