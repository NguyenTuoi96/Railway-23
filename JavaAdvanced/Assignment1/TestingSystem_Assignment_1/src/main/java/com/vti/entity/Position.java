package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "position_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positionId;

	@Column(name = "position_name", nullable = false)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;

	public Position() {
	}

	/**
	 * @return the positionId
	 */
	public short getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(short positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the positionName
	 */
	public PositionName getPositionName() {
		return positionName;
	}

	/**
	 * @param positionName the positionName to set
	 */
	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + "]";
	}

	public enum PositionName {
		DEV("Dev"), TEST("Test"), SCRUM_MASTER("ScrumMaster"), PM("PM");

		private String positionName;

		private PositionName(String positionName) {
			this.positionName = positionName;
		}

		public String getPositionName() {
			return positionName;
		}

		public static PositionName toEnum(String sqlPositionName) {
			for (PositionName item : PositionName.values()) {
				if (item.getPositionName().equals(sqlPositionName)) {
					return item;
				}
			}
			return null;
		}
	}
}
