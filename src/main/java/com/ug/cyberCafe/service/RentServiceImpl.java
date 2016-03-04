package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ug.cyberCafe.dao.RentDao;
import com.ug.cyberCafe.domain.Rent;

public class RentServiceImpl implements RentService {

	@Autowired
	RentDao rentDao;
	
	@Override
	public void addRent(Rent rent) {
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
		rentDao.updateRent(rent);
	}

	@Override
	public Rent getRentById(long id) {
		return rentDao.getRentById(id);
	}

	@Override
	public Rent getRentByIdTerminal(long id, String date) {
		return rentDao.getRentByIdTerminal(id, date);
	}

}
