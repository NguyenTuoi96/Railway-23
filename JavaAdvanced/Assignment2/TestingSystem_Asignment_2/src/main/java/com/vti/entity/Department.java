package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short departmentId;

	@Column(name = "department_name", length = 30, nullable = false, unique = true)
	private String departmentName;
	
	@OneToOne(mappedBy = "department")
	DetailDepartment detailDepartment;	
	
	@OneToMany(mappedBy = "department")
	private List<Account> accounts;

	public Department() {
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
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the detailDepartment
	 */
	public DetailDepartment getDetailDepartment() {
		return detailDepartment;
	}

	/**
	 * @param detailDepartment the detailDepartment to set
	 */
	public void setDetailDepartment(DetailDepartment detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	/**
	 * @return the account
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccount(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", detailDepartment="
				+ detailDepartment + ", accounts=" + accounts + "]";
	}

}
