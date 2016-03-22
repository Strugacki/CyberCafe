package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ug.cyberCafe.domain.Rent;

public interface RentService {

	void addRent(Rent rent);
	
	void deleteRent(Rent rent);
	
	List<Rent> getAllRents();
	
	void updateRent(Rent rent);
	
	Rent getRentById(long id);
	
	List<Rent> getRentByIdTerminal(long id, String date);
	
	String getPrincipal();
	
	Model authorization(Model model);
}
