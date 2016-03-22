package com.ug.cyberCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.dao.AddressDao;
import com.ug.cyberCafe.domain.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl extends UtilitiesService implements AddressService{

	@Autowired
	AddressDao addressDao;
	
	@Override
	public Address getAddressById(long id) {
		return addressDao.getAddressById(id);
	}

	@Override
	public void addAddress(Address address) {
		addressDao.addAddress(address);
	}

	@Override
	public void updateAddress(Address address) {
		addressDao.updateAddress(address);
	}

	@Override
	public void deleteAddress(Address address) {
		addressDao.deleteAddress(address);
	}

	@Override
	public List<Address> getAllAddress() {
		return addressDao.getAllAddresses();
	}

}
