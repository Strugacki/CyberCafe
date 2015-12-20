package com.ug.cyberCafe.dao;

import java.util.List;
import com.ug.cyberCafe.domain.User;

public interface UserDao {
    
    void addUser(User user);
     
    void deleteUserById(int id);
     
    List<User> getAllUsers();
 
    User getUserById(int id);

}
