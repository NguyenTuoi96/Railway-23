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
		return "Group [groupId=" + getGroupId() + ", groupName=" + getGroupName() + ", creator=" + getCreator() + ", createDate="
				+ getCreateDate() + ", accounts=" + Arrays.toString(getAccounts()) + "]";
	}
	
	public Group() {
		
	}
	
	// Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
	public Group(String groupName, Account creator, Account[] accounts, Date createDate) {
		this.setGroupName(groupName);
		this.setCreator(creator);
		this.setAccounts(accounts);
		this.setCreateDate(createDate);
	}
	
	// Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
	public Group(String groupName, Account creator, String[] usernames, Date createDate) {
//		Account[] accounts = new Account[usernames.length];
//		if(usernames != null) {
//			for(int i = 0; i < usernames.length; i++) {
//				Account acc = new Account();
//				acc.userName = usernames[i];
//				accounts[i] = acc;
//			}
//		}
//		this.groupName = groupName;
//		this.creator = creator;
//		this.accounts = accounts;
//		this.createDate = createDate;
		
		// cách 2
		this.setGroupName(groupName);
		this.setCreator(creator);
		this.setAccounts(new Account[] {});
		if(usernames.length > 0) {
			for(String un : usernames) {
				Account acc = new Account();
				acc.setUserName(un);
				// độ dài = 0
				// a = {}; -> độ dài: 0
				// a = {a, b}; -> độ dài: 2
				// a[0] = b;
				// a[1] = c;
				this.setAccounts(Arrays.copyOf(this.getAccounts(), this.getAccounts().length + 1));
				this.getAccounts()[this.getAccounts().length - 1] = acc;
			}
		}
		
		this.setCreateDate(createDate);
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