package com.vti.entity;

import java.util.Date;
import java.util.List;

public class Account {
	private int accountId;
	private String email;
	private String userName;
	private String fullName;
	private String gender;
	private Department department;
	private Position position;
	private List<Group> groups;
	private Date createDate;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", gender=" + gender + ", department=" + department + ", position=" + position
				+ ", groups=" + groups + ", createDate=" + createDate + "]";
	}
	
	/**
	 * Constructor for class Account
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 26, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 26, 2021
	 * @param accountId
	 * @param email
	 * @param userName
	 * @param fullName
	 * @param gender
	 * @param department
	 * @param position
	 * @param groups
	 * @param createDate
	 */
	public Account(int accountId, String email, String userName, String fullName, String gender, Department department,
			Position position, List<Group> groups, Date createDate) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.gender = gender;
		this.department = department;
		this.position = position;
		this.groups = groups;
		this.createDate = createDate;
	}	
}
