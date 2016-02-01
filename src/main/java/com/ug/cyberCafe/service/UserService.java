package com.ug.cyberCafe.service;

import java.util.List;

import com.ug.cyberCafe.domain.User;

public interface UserService {

	User getUserById(long id);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	List<User> getAllUsers();

}
