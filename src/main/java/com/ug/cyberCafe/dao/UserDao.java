package com.ug.cyberCafe.dao;

import java.util.List;
import com.ug.cyberCafe.domain.User;

public interface UserDao {
    
    void addUser(User user);
     
    void deleteUser(User user);
     
    List<User> getAllUsers();
 
    User getUserById(int id);

}
