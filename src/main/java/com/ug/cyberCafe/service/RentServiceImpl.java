package com.ug.cyberCafe.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.RentDao;
import com.ug.cyberCafe.dao.RoleDao;
import com.ug.cyberCafe.dao.TerminalDao;
import com.ug.cyberCafe.dao.UserDao;
import com.ug.cyberCafe.domain.Rent;
import com.ug.cyberCafe.domain.Role;
import com.ug.cyberCafe.domain.User;

@Service("rentService")
@Transactional
public class RentServiceImpl extends UtilitiesService implements RentService {

	@Autowired
	private RentDao rentDao;
	@Autowired
	private TerminalDao terminalDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private RoleDao roleDao;
	
	
	@Override
	public void addRent(Rent rent) {
		
		Role customerRole = roleDao.getRoleById(rent.getCustomer().getRole().getIdRole());
		sessionFactory.getCurrentSession().merge(customerRole);
		User customer = userDao.getUserById(rent.getCustomer().getIdUser());
		customer.setRole(customerRole);
		
		Role employeeRole = roleDao.getRoleById(rent.getEmployee().getRole().getIdRole());
		sessionFactory.getCurrentSession().merge(employeeRole);
		User employee = userDao.getUserById(rent.getEmployee().getIdUser());
		employee.setRole(employeeRole);
		
		sessionFactory.getCurrentSession().merge(rent.getTerminal());
		sessionFactory.getCurrentSession().merge(employee);
		sessionFactory.getCurrentSession().merge(customer);		
				
		rent.setTerminal(terminalDao.getTerminalById(rent.getTerminal().getIdTerminal()));
		rent.setCustomer(userDao.getUserById(rent.getCustomer().getIdUser()));
		rent.setEmployee(userDao.getUserById(rent.getEmployee().getIdUser()));
		
		rentDao.addRent(rent);
	}

	@Override
	public void deleteRent(Rent rent) {
		rentDao.deleteRent(rent);
	}

	@Override
	public List<Rent> getAllRents() {
		return rentDao.getAllRents();
	}

	@Override
	public void updateRent(Rent rent) {
		Rent rentToUpdate = getRentById(rent.getIdRent());
		rentToUpdate.setTerminal(rent.getTerminal());
		rentToUpdate.setCustomer(rent.getCustomer());
		rentToUpdate.setEmployee(rent.getEmployee());
		rentToUpdate.setDate(rent.getDate());
		rentToUpdate.setTimeStart(rent.getTimeStart());
		rentToUpdate.setHours(rent.getHours());
		rentDao.updateRent(rentToUpdate);
	}

	@Override
	public Rent getRentById(long id) {
		return rentDao.getRentById(id);
	}

	@Override
	public List<Rent> getRentByIdTerminal(long id, String date) {
		return rentDao.getRentByIdTerminal(id, date);
	}

}
