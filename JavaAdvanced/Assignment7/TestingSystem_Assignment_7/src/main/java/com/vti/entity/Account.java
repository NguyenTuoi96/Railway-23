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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`Account`")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accountId")
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountId;

	@Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
	private String username;

	@Column(name = "FirstName", length = 50, nullable = false, updatable = false)
	private String firstName;

	@Column(name = "LastName", length = 50, nullable = false, updatable = false)
	private String lastName;

	@Formula(" concat(LastName, ' ', FirstName) ")
	private String fullName;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
	@JsonIgnoreProperties("accounts")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
	@JsonIgnoreProperties("accounts")
	private Position position;

	@ManyToOne
	@JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
	@JsonIgnoreProperties("accounts")
	private Salary salary;

	@OneToMany(mappedBy = "createdAcc")
	@JsonIgnoreProperties("createdAcc")
	List<Group> createdGroups;

	@OneToMany(mappedBy = "account")
	@JsonIgnoreProperties("account")
	private List<GroupAccount> groupAccounts;

	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Account() {
	}

//	/**
//	 * @return the accountId
//	 */
//	public short getAccountId() {
//		return accountId;
//	}
//
//	/**
//	 * @param accountId the accountId to set
//	 */
//	public void setAccountId(short accountId) {
//		this.accountId = accountId;
//	}
//
//	/**
//	 * @return the email
//	 */
//	public String getEmail() {
//		return email;
//	}
//
//	/**
//	 * @param email the email to set
//	 */
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	/**
//	 * @return the username
//	 */
//	public String getUsername() {
//		return username;
//	}
//
//	/**
//	 * @param username the username to set
//	 */
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	/**
//	 * @return the firstName
//	 */
//	public String getFirstName() {
//		return firstName;
//	}
//
//	/**
//	 * @param firstName the firstName to set
//	 */
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	/**
//	 * @return the lastName
//	 */
//	public String getLastName() {
//		return lastName;
//	}
//
//	/**
//	 * @param lastName the lastName to set
//	 */
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	/**
//	 * @return the fullName
//	 */
//	public String getFullName() {
//		return fullName;
//	}
//
//	/**
//	 * @param fullName the fullName to set
//	 */
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	/**
//	 * @return the department
//	 */
//	public Department getDepartment() {
//		return department;
//	}
//
//	/**
//	 * @param department the department to set
//	 */
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
//
//	/**
//	 * @return the position
//	 */
//	public Position getPosition() {
//		return position;
//	}
//
//	/**
//	 * @param position the position to set
//	 */
//	public void setPosition(Position position) {
//		this.position = position;
//	}
//
//	/**
//	 * @return the salary
//	 */
//	public Salary getSalary() {
//		return salary;
//	}
//
//	/**
//	 * @param salary the salary to set
//	 */
//	public void setSalary(Salary salary) {
//		this.salary = salary;
//	}
//
//	/**
//	 * @return the createdGroups
//	 */
//	public List<Group> getCreatedGroups() {
//		return createdGroups;
//	}
//
//	/**
//	 * @param createdGroups the createdGroups to set
//	 */
//	public void setCreatedGroups(List<Group> createdGroups) {
//		this.createdGroups = createdGroups;
//	}
//
//	/**
//	 * @return the createDate
//	 */
//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	/**
//	 * @param createDate the createDate to set
//	 */
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	/**
//	 * @return the groupAccounts
//	 */
//	public List<GroupAccount> getGroupAccounts() {
//		return groupAccounts;
//	}
//
//	/**
//	 * @param groupAccounts the groupAccounts to set
//	 */
//	public void setGroupAccounts(List<GroupAccount> groupAccounts) {
//		this.groupAccounts = groupAccounts;
//	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", department=" + department
				+ ", position=" + position + ", salary=" + salary 
				+ ", createdGroups=" + createdGroups 
				+ ", createDate="
				+ createDate + ", groupAccounts=" + groupAccounts + "]";
	}

}
