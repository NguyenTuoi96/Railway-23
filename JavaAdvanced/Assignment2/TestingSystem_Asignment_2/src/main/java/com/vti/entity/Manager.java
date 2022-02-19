package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_id")
	@Id
	private short accountId;

	@Column(name = "management_number_of_year", nullable = false)
	private short managementNumberOfYear;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id") 
	private Account account;

	public Manager() {
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
		return "Manager [accountId=" + accountId + ", managementNumberOfYear=" + managementNumberOfYear + ", accountFullname="
				+ account.getFullName() + "]";
	}
	
	
}
