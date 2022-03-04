package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GroupAccount")
@Setter
@Getter
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupAccountKey groupAccountId;

	@ManyToOne
	@MapsId("GroupID")
	@JoinColumn(name = "GroupID")
	@JsonIgnoreProperties("groupAccounts")
	private Group group;

	@ManyToOne
	@MapsId("AccountID")
	@JoinColumn(name = "AccountID")
	@JsonIgnoreProperties("groupAccounts")
	private Account account;
	
	@Column(name = "JoinDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;

//	/**
//	 * @return the groupAccountId
//	 */
//	public GroupAccountKey getGroupAccountId() {
//		return groupAccountId;
//	}
//
//	/**
//	 * @param groupAccountId the groupAccountId to set
//	 */
//	public void setGroupAccountId(GroupAccountKey groupAccountId) {
//		this.groupAccountId = groupAccountId;
//	}
//
//	/**
//	 * @return the group
//	 */
//	public Group getGroup() {
//		return group;
//	}
//
//	/**
//	 * @param group the group to set
//	 */
//	public void setGroup(Group group) {
//		this.group = group;
//	}
//
//	/**
//	 * @return the account
//	 */
//	public Account getAccount() {
//		return account;
//	}
//
//	/**
//	 * @param account the account to set
//	 */
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//
//	/**
//	 * @return the joinDate
//	 */
//	public Date getJoinDate() {
//		return joinDate;
//	}
//
//	/**
//	 * @param joinDate the joinDate to set
//	 */
//	public void setJoinDate(Date joinDate) {
//		this.joinDate = joinDate;
//	}

	@Override
	public String toString() {
		return "GroupAccount [groupAccountId=" + groupAccountId + ", group=" + group + ", account=" + account
				+ ", joinDate=" + joinDate + "]";
	}
}
