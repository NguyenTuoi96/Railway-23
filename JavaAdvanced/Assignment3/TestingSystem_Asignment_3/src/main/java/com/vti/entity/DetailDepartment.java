package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_department")
public class DetailDepartment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "department_id")
	@Id
	private short departmentId;

	@Column(name = "emulation_point")
	private short emulationPoint;
	
	@OneToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id") 
	private Department department;

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private Address address;

	public DetailDepartment() {
	}

	/**
	 * @return the departmentId
	 */
	public short getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the emulationPoint
	 */
	public short getEmulationPoint() {
		return emulationPoint;
	}

	/**
	 * @param emulationPoint the emulationPoint to set
	 */
	public void setEmulationPoint(short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DetailDepartment [departmentId=" + departmentId + ", emulationPoint="
				+ emulationPoint + ", department=" + department + ", address=" + address.getAddressName() + "]";
	}
	
}
