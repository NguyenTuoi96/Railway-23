package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Position")
@Setter
@Getter
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positionId;

	@Column(name = "PositionName", nullable = false, unique = true)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;
	
	@OneToMany(mappedBy = "position")
	@JsonIgnoreProperties("position")
	private List<Account> accounts;

	public Position() {
	}

//	public short getPositionId() {
//		return positionId;
//	}
//
//	public void setPositionId(short positionId) {
//		this.positionId = positionId;
//	}
//
//	public PositionName getPositionName() {
//		return positionName;
//	}
//
//	public void setPositionName(PositionName positionName) {
//		this.positionName = positionName;
//	}
//
//	/**
//	 * @return the accounts
//	 */
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	/**
//	 * @param accounts the accounts to set
//	 */
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", accounts=" + accounts + "]";
	}

	public enum PositionName {
		DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");

		private String name;

		private PositionName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public static PositionName toEnum(String sqlStatus) {
			for (PositionName item : PositionName.values()) {
				if (item.getName().equals(sqlStatus)) {
					return item;
				}
			}
			return null;
		}
	}
}
