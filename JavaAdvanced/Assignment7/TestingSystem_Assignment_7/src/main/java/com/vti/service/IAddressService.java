package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Address;

public interface IAddressService {
	public Page<Address> getAllAddresss(Pageable pageable);
	
	public Address getAddressByID(short id);
	
	public Address getAddressByName(String name);
	
	public void createAddress(Address address);
	
	public void updateAddress(short id, String newName);
	
	public void updateAddress(Address address);
	
	public void deleteAddress(short id);
	
	public boolean isAddressExistsByID(short id);
	
	public boolean isAddressExistsByName(String name);
}
