package com.vti.entity;

import java.util.Arrays;
import java.util.Date;

public class Account {
	private int accountId;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	private Group[] groups;
	private float salary;

	@Override
	public String toString() {
		return "Account [accountId=" + getAccountId() + ", email=" + getEmail() + ", userName=" + getUserName() + ", fullName="
				+ getFullName() + ", department=" + getDepartment() + ", position=" + getPosition() + ", createDate=" + getCreateDate()
				+ ", groups=" + Arrays.toString(getGroups()) + ", salary=" + getSalary() + "]";
	}
	
	// hàm khởi tạo không tham số
	public Account() {
		
	}
	
	public Account(String userName) {
		this.setUserName(userName);
	}
	
	// hàm khởi tạo có các parameter là id, Email, Username, FirstName,LastName (với FullName = FirstName + LastName)
	public Account(int id, String email, String userName, String firstName, String lastName) {
		this.setAccountId(id);
		this.setEmail(email);
		this.setUserName(userName);
		this.setFullName(firstName.concat(" ").concat(lastName));
	}
	
	// Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
	public Account(int id, String email, String userName, String firstName, String lastName, Position position) {
		this.setAccountId(id);
		this.setEmail(email);
		this.setUserName(userName);
		this.setFullName(firstName.concat(" ").concat(lastName));
		this.setPosition(position);
		this.setCreateDate(new Date());
	}
	
	// Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
	public Account(int id, String email, String userName, String firstName, String lastName, Position position, Date createDate) {
		this.setAccountId(id);
		this.setEmail(email);
		this.setUserName(userName);
		this.setFullName(firstName.concat(" ").concat(lastName));
		this.setPosition(position);
		this.setCreateDate(createDate);
	}

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the groups
	 */
	public Group[] getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
