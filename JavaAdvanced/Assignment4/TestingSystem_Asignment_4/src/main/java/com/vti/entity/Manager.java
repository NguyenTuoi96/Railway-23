package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
@PrimaryKeyJoinColumn(name = "account_id")
public class Manager extends Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "management_number_of_year", nullable = false)
	private short managementNumberOfYear;

	public Manager() {
	}

	/**
	 * @return the managementNumberOfYear
	 */
	public short getManagementNumberOfYear() {
		return managementNumberOfYear;
	}

	/**
	 * @param managementNumberOfYear the managementNumberOfYear to set
	 */
	public void setManagementNumberOfYear(short managementNumberOfYear) {
		this.managementNumberOfYear = managementNumberOfYear;
	}

	@Override
	public String toString() {
		return "Manager [managementNumberOfYear=" + managementNumberOfYear
				+ ", getAccountId()=" + getAccountId() + ", getEmail()=" + getEmail() + ", getUsername()="
				+ getUsername() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getFullName()=" + getFullName() + ", getCreateDate()=" + getCreateDate() + ", getDepartment()="
				+ getDepartment() + ", getPosition()=" + getPosition() + ", getSalary()=" + getSalary() + "]";
	}
		
}
