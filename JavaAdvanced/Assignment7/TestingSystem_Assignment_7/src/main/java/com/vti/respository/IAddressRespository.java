package com.vti.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Address;
import com.vti.entity.Address;

public interface IAddressRespository extends JpaRepository<Address, Short> {

	public List<Address> findAll();

	public Address findByAddressId(Short id);

	public Address findByAddressName(String name);

	// @Queryannotation
	@Query("SELECT a FROM Address a")
	public List<Address> getAllAddresss();

	@Query("SELECT a FROM Address a WHERE a.addressId = :idParam")
	public Address getAddressByID(@Param("idParam") Short id);

	@Query("SELECT a FROM Address a WHERE a.addressName = :nameParam")
	public Address getAddressByName(@Param("nameParam") String name);

//	@Modifying
//	@Query("INSERT INTO Address(addressName) SELECT :nameParam FROM DUAL")
//	public void createAddress(@Param("nameParam") String name);

	@Modifying
	@Query("UPDATE Address a SET a.addressName = :nameParam WHERE a.addressId = :id")
	public void updateAddress(@Param("id") Short id, @Param("nameParam") String name);

	@Modifying
	@Query("DELETE FROM Address a WHERE a.addressId = :idParameter") 
	public void deleteAddress(@Param("idParameter") Short id);

}
