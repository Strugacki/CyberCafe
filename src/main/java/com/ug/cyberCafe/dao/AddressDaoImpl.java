package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ug.cyberCafe.domain.Address;

public class AddressDaoImpl extends AbstractDao<Integer, Address> implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAddress(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public void deleteAddress(Address address) {
		address = (Address) sessionFactory.getCurrentSession().get(Address.class, address.getIdAddress());
		sessionFactory.getCurrentSession().delete(address);

	}

	@Override
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
		sessionFactory.getCurrentSession().update(addressToUpdate);
	}

}
