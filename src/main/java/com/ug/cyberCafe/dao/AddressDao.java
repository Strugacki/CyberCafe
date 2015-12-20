package com.ug.cyberCafe.dao;

import java.util.List;

import com.ug.cyberCafe.domain.Address;

public interface AddressDao {

    void addAddress(Address address);
    
    void deleteAddressById(int id);
     
    List<Address> getAllAddresses();
 
    Address getAddressById(int id);
    
}
