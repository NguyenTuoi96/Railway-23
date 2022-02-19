package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_id")
	@Id
	private short accountId;

	@Column(name = "working_number_of_year", nullable = false)
	private short workingNumberOfYear;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id") 
	private Account account;

	public Employee() {
	}

	/**
	 * @return the accountId
	 */
	public short getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(short accountId) {
		this.accountId = accountId;
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

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [accountId=" + accountId + ", workingNumberOfYear=" + workingNumberOfYear + ", accountFullname="
				+ account.getFullName() + "]";
	}
	
}
