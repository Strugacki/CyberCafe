package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ug.cyberCafe.domain.Address;


@Component("addressDao")
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addAddress(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public void deleteAddress(Address address) {
		address = (Address) sessionFactory.getCurrentSession().get(Address.class, address.getIdAddress());
		sessionFactory.getCurrentSession().delete(address);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Address> getAllAddresses() {
		return sessionFactory.getCurrentSession().getNamedQuery("get.All.Addresses").list();
	}

	@Override
	public Address getAddressById(long id) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, id);
	}

	@Override
	public void updateAddress(Address address) {
		Address addressToUpdate = getAddressById(address.getIdAddress());
		addressToUpdate.setCity(address.getCity());
		addressToUpdate.setPostalCode(address.getPostalCode());
		addressToUpdate.setStreet(address.getStreet());
		addressToUpdate.setLocalNumber(address.getLocalNumber());
		sessionFactory.getCurrentSession().update(addressToUpdate);
	}

	@Override
	public void deleteAllAddresses() {
		for(Address address : getAllAddresses() ) {
			deleteAddress(address);
		}
	}

}
