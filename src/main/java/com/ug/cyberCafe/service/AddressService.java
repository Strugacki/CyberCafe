package com.ug.cyberCafe.service;

import java.util.List;

import com.ug.cyberCafe.domain.Address;

public interface AddressService {

	Address getAddressById(long id);

	void addAddress(Address address);

	void updateAddress(Address address);

	void deleteAddress(Address address);

	List<Address> getAllAddress();
}
