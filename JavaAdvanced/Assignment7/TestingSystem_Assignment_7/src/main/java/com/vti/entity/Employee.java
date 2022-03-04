package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Employee")
@PrimaryKeyJoinColumn(name = "AccountID")
@Setter
@Getter
public class Employee extends Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "WorkingNumberOfYear", nullable = false)
	private short workingNumberOfYear;

	public Employee() {
	}

//	/**
//	 * @return the workingNumberOfYear
//	 */
//	public short getWorkingNumberOfYear() {
//		return workingNumberOfYear;
//	}
//
//	/**
//	 * @param workingNumberOfYear the workingNumberOfYear to set
//	 */
//	public void setWorkingNumberOfYear(short workingNumberOfYear) {
//		this.workingNumberOfYear = workingNumberOfYear;
//	}

	@Override
	public String toString() {
		return "Employee [workingNumberOfYear=" + workingNumberOfYear + ", getAccountId()=" + getAccountId()
				+ ", getEmail()=" + getEmail() + ", getUsername()=" + getUsername() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getFullName()=" + getFullName()
				+ ", getCreateDate()=" + getCreateDate() + ", getDepartment()=" + getDepartment() + ", getPosition()="
				+ getPosition().getPositionName() + ", getSalary()=" + getSalary().getSalaryName().getSalaryName() + "]";
	}
	
}
