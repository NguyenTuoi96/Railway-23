package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "address_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short addressId;

	@Column(name = "address_name", length = 100, nullable = false, unique = true)
	private String addressName;
	
	@OneToMany(mappedBy = "address")
	private List<DetailDepartment> detailDepartment;

	public Address() {
	}

	/**
	 * @return the addressId
	 */
	public short getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(short addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the addressName
	 */
	public String getAddressName() {
		return addressName;
	}

	/**
	 * @param addressName the addressName to set
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	/**
	 * @return the detailDepartment
	 */
	public List<DetailDepartment> getDetailDepartment() {
		return detailDepartment;
	}

	/**
	 * @param detailDepartment the detailDepartment to set
	 */
	public void setDetailDepartment(List<DetailDepartment> detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressName=" + addressName + ", detailDepartment="
				+ detailDepartment + "]";
	}
		
}
