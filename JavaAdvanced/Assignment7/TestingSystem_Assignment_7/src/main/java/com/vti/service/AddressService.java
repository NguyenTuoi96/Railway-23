package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Address;
import com.vti.respository.IAddressRespository;

@Service
public class AddressService implements IAddressService {
	
	@Autowired
	private IAddressRespository addressRepository;

	@Override
	public Page<Address> getAllAddresss(Pageable pageable) {
		
		return addressRepository.findAll(pageable);
	}

	@Override
	public Address getAddressByID(short id) {
		
		return addressRepository.findById(id).get();
	}

	@Override
	public Address getAddressByName(String name) {

		return addressRepository.findByAddressName(name);
	}

	@Override
	public void createAddress(Address address) {
		
		addressRepository.save(address);		
	}

	@Override
	public void updateAddress(short id, String newName) {
		Address address = new Address(id, newName);
		addressRepository.save(address);	
	}

	@Override
	public void updateAddress(Address address) {
		addressRepository.save(address);
	}

	@Override
	public void deleteAddress(short id) {
		
		addressRepository.deleteById(id);;
	}

	@Override
	public boolean isAddressExistsByID(short id) {
		
		return addressRepository.existsById(id);
	}

	@Override
	public boolean isAddressExistsByName(String name) {
		Address address = getAddressByName(name);

		if (address == null) {
			return false;
		}
		return true;
	}
	
	
}
