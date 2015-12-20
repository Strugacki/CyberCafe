package com.ug.cyberCafe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ug.cyberCafe.domain.Address;

public class AddressDaoImpl extends AbstractDao<Integer, Address> implements AddressDao {

	@Override
	public void addAddress(Address address) {
		persist(address);
	}

	@Override
	public void deleteAddressById(int id) {
		
		
	}

	@Override
	public List<Address> getAllAddresses() {
		Criteria criteria = createEntityCriteria();
        return (List<Address>) criteria.list();
	}

	@Override
	public Address getAddressById(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Address) criteria.uniqueResult();
	}

}
