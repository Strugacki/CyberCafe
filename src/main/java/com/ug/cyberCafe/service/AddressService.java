package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ug.cyberCafe.domain.Address;

public interface AddressService {

	Address getAddressById(long id);

	void addAddress(Address address);

	void updateAddress(Address address);

	void deleteAddress(Address address);

	List<Address> getAllAddress();
	
	String getPrincipal();
	
	Model authorization(Model model);
}
