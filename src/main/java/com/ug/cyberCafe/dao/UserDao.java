package com.ug.cyberCafe.dao;

import java.sql.SQLException;
import java.util.List;

import com.ug.cyberCafe.domain.User;

public interface UserDao {
    
    void addUser(User user);
     
    void deleteUser(User user);
     
    List<User> getAllUsers();
 
    User getUserById(long id);
    
    void updateUser(User user);
    
    boolean isValidUser(String login, String password) throws SQLException;

}
