package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.Address;

public interface AddressDao {

    void addAddress(Address address);
    
    void deleteAddress(Address address);
     
    List<Address> getAllAddresses();
 
    Address getAddressById(long id);
    
    void updateAddress(Address address);
    
}
