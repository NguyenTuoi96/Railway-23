package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class GroupAccountKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID", nullable = false)
	private short groupId;
	
	@Column(name = "AccountID")
	private short accountId;

//	/**
//	 * @return the groupId
//	 */
//	public short getGroupId() {
//		return groupId;
//	}
//
//	/**
//	 * @param groupId the groupId to set
//	 */
//	public void setGroupId(short groupId) {
//		this.groupId = groupId;
//	}
//
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
}
