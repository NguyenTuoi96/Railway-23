package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "group_account")
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupAccountKey groupAccountId;

	@ManyToOne
	@MapsId("group_id")
	@JoinColumn(name = "group_id")
	private Group group;

	@ManyToOne
	@MapsId("account_id")
	@JoinColumn(name = "account_id")
	private Account account;
	
	@Column(name = "join_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;

	/**
	 * @return the groupAccountId
	 */
	public GroupAccountKey getGroupAccountId() {
		return groupAccountId;
	}

	/**
	 * @param groupAccountId the groupAccountId to set
	 */
	public void setGroupAccountId(GroupAccountKey groupAccountId) {
		this.groupAccountId = groupAccountId;
	}

	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
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

	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "GroupAccount [groupAccountId=" + groupAccountId + ", group=" + group + ", account=" + account
				+ ", joinDate=" + joinDate + "]";
	}
}
