package com.vti.entity;

import com.vti.entity.enums.PositionName;

public class Position {
	private byte positionId;
	private String positionName;
	
	public Position(ScannerUtils scUtils) {
		System.out.println("Hãy nhâp id của vị trí (giá trị số)");
		this.positionId = (byte) scUtils.inputInt("Bạn nhập sai, hãy nhập lại 1 giá trị số");
		System.out.println("Hãy nhâp mã tên của vị trí: 1. Dev, 2. Test, 3. Scrum Master, 4. PM");
		while(true) {
			int positionNameNum = scUtils.inputInt("Bạn nhập sai, hãy nhập lại 1 giá trị số");			
			if(1 <= positionNameNum && positionNameNum <= 4) {
				this.positionName = PositionName.values()[positionNameNum - 1].getPositionName(); 
				break;
			}else {
				System.out.println("Bạn nhập sai mã. Hãy nhâp đúng mã của vị trí: 1. Dev, 2. Test, 3. Scrum Master, 4. PM");
			}
		}
	}
	
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
