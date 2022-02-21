package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`salary`")
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "salary_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short salaryId;

	@Column(name = "salary_name", nullable = false, unique = true)
	@Convert(converter = SalaryNameConverter.class)
	private SalaryName salaryName;
	
	@OneToMany(mappedBy = "salary")
	private List<Account> accounts;

	public Salary() {
	}

	/**
	 * @return the salaryId
	 */
	public short getSalaryId() {
		return salaryId;
	}

	/**
	 * @param salaryId the salaryId to set
	 */
	public void setSalaryId(short salaryId) {
		this.salaryId = salaryId;
	}

	/**
	 * @return the salaryName
	 */
	public SalaryName getSalaryName() {
		return salaryName;
	}

	/**
	 * @param salaryName the salaryName to set
	 */
	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName;
	}
	

	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", salaryName=" + salaryName + ", accounts=" + accounts + "]";
	}

	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	public enum SalaryName {
		DEV("600"), TEST("700"), SCRUM_MASTER("1500"), PM("2000");

		private String salaryName;

		private SalaryName(String salaryName) {
			this.salaryName = salaryName;
		}

		public String getSalaryName() {
			return salaryName;
		}

		public static SalaryName toEnum(String sqlSalaryName) {
			for (SalaryName item : SalaryName.values()) {
				if (item.getSalaryName().equals(sqlSalaryName)) {
					return item;
				}
			}
			return null;
		}
	}
}
