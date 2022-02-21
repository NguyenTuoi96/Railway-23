package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "`Account`")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountId;

	@Column(name = "email", length = 50, nullable = false, unique = true, updatable = false)
	private String email;

	@Column(name = "username", length = 50, nullable = false, unique = true, updatable = false)
	private String username;

	@Column(name = "first_name", length = 50, nullable = false, updatable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false, updatable = false)
	private String lastName;
	
	@Formula(" concat(last_name, ' ', first_name) ")
	private String fullName;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "position_id", referencedColumnName = "position_id")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "salary_id", referencedColumnName = "salary_id")
	private Salary salary;
	
	@OneToMany(mappedBy = "account")
	List<Group> createdGroups;

	@Column(name = "create_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	@OneToMany(mappedBy = "account")
	private List<GroupAccount> groupAccounts;

	public Account() {
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the salary
	 */
	public Salary getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	/**
	 * @return the createdGroups
	 */
	public List<Group> getCreatedGroups() {
		return createdGroups;
	}

	/**
	 * @param createdGroups the createdGroups to set
	 */
	public void setCreatedGroups(List<Group> createdGroups) {
		this.createdGroups = createdGroups;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the groupAccounts
	 */
	public List<GroupAccount> getGroupAccounts() {
		return groupAccounts;
	}

	/**
	 * @param groupAccounts the groupAccounts to set
	 */
	public void setGroupAccounts(List<GroupAccount> groupAccounts) {
		this.groupAccounts = groupAccounts;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", department=" + department
				+ ", position=" + position + ", salary=" + salary + ", createdGroups=" + createdGroups + ", createDate="
				+ createDate + ", groupAccounts=" + groupAccounts + "]";
	}
	
}
