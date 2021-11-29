package com.vti.entity;

public class Position {
	private byte positionId;
	private String positionName;
	@Override
	public String toString() {
		return "Position [positionId=" + getPositionId() + ", positionName=" + getPositionName() + "]";
	}
	/**
	 * @return the positionId
	 */
	public byte getPositionId() {
		return positionId;
	}
	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(byte positionId) {
		this.positionId = positionId;
	}
	/**
	 * @return the positionName
	 */
	public String getPositionName() {
		return positionName;
	}
	/**
	 * @param positionName the positionName to set
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
}
