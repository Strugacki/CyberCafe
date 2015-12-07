package dao;

import java.util.List;
import com.ug.cyberCafe.domain.User;

public interface UserDao {
	
    User getById(int id);
    
    void addUser(User user);
     
    void deleteEmployeeById(int id);
     
    List<User> getAllEmployees();
 
    User getUserById(int id);

}
