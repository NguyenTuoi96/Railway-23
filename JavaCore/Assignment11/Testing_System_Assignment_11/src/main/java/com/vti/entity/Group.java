package com.vti.entity;

import java.util.Arrays;
import java.util.Date;

public class Group {
	private byte groupId;
	private String groupName;
	private Account creator;
	private Date createDate;
	private Account[] accounts;
	@Override
	public String toString() {
		return "Group [groupId=" + getGroupId() + ", groupName=" + getGroupName() + ", creator=" + getCreator().getFullName() + ", createDate="
				+ getCreateDate() + ", accounts=" + Arrays.toString(getAccounts()) + "]";
	}
	

	/**
	 * Constructor for class Group
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 26, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 26, 2021
	 * @param groupId
	 * @param groupName
	 * @param creator
	 * @param createDate
	 * @param accounts
	 */
	public Group(byte groupId, String groupName, Account creator, Date createDate, Account[] accounts) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}


	/**
	 * @return the groupId
	 */
	public byte getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(byte groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the creator
	 */
	public Account getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(Account creator) {
		this.creator = creator;
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
	 * @return the accounts
	 */
	public Account[] getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
}