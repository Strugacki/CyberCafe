package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.Rent;

public interface RentDao {

	void addRent(Rent rent);
	
	void deleteRent(Rent rent);
	
	List<Rent> getAllRents();
	
	void updateRent(Rent rent);
	
	Rent getRentById(long id);
	
	List<Rent> getRentByIdTerminal(long id, String date);
	
	void deleteAllRents();
	
}
