package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`Group`")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "groupId")
@Setter
@Getter
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupId;

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String groupName;
	
	@ManyToOne()
	@JoinColumn(name = "CreatorID", referencedColumnName = "AccountID", updatable = false) 
	@JsonIgnoreProperties("createdGroups")
	private Account createdAcc;

	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	@OneToMany(mappedBy = "group")
	@JsonIgnoreProperties("group")
	private List<GroupAccount> groupAccounts;

	public Group() {
	}

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
//	 * @return the groupName
//	 */
//	public String getGroupName() {
//		return groupName;
//	}
//
//	/**
//	 * @param groupName the groupName to set
//	 */
//	public void setGroupName(String groupName) {
//		this.groupName = groupName;
//	}
//
//	public Account getCreatedAcc() {
//		return createdAcc;
//	}
//
//	public void setCreatedAcc(Account createdAcc) {
//		this.createdAcc = createdAcc;
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
		return "Group [groupId=" + groupId + ", groupName=" + groupName 
				+ ", createdAcc=" + createdAcc 
				+ ", createDate="
				+ createDate + ", groupAccounts=" + groupAccounts + "]";
	}
	
}
