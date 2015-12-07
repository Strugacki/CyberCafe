package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ug.cyberCafe.domain.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User getById(int id) {
		return getByKey(id);
	}

	public void addUser(User user) {
		persist(user);
	}

	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<User> getAllEmployees() {
		Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
	}

	public User getUserById(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (User) criteria.uniqueResult();
	}


}
