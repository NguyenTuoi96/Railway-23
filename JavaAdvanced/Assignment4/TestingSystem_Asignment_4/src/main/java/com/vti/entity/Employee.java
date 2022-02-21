package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "account_id")
public class Employee extends Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "working_number_of_year", nullable = false)
	private short workingNumberOfYear;

	public Employee() {
	}

	/**
	 * @return the workingNumberOfYear
	 */
	public short getWorkingNumberOfYear() {
		return workingNumberOfYear;
	}

	/**
	 * @param workingNumberOfYear the workingNumberOfYear to set
	 */
	public void setWorkingNumberOfYear(short workingNumberOfYear) {
		this.workingNumberOfYear = workingNumberOfYear;
	}

	@Override
	public String toString() {
		return "Employee [workingNumberOfYear=" + workingNumberOfYear + ", getAccountId()=" + getAccountId()
				+ ", getEmail()=" + getEmail() + ", getUsername()=" + getUsername() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getFullName()=" + getFullName()
				+ ", getCreateDate()=" + getCreateDate() + ", getDepartment()=" + getDepartment() + ", getPosition()="
				+ getPosition().getPositionName() + ", getSalary()=" + getSalary().getSalaryName().getSalaryName() + "]";
	}
	
}
