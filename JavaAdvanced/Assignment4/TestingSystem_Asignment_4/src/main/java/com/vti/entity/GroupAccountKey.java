package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupAccountKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "group_id", nullable = false)
	private short groupId;
	
	@Column(name = "account_id")
	private short accountId;

	/**
	 * @return the groupId
	 */
	public short getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(short groupId) {
		this.groupId = groupId;
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
}
