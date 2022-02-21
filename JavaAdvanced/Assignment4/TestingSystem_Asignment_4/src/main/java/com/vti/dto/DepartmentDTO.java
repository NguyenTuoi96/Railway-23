package com.vti.dto;

public class DepartmentDTO {
	
	private short departmentId;
	
	private String departmentName;
	
	private String address;

	public DepartmentDTO() {
	}

	public DepartmentDTO(short id, String name, String address) {
		this.departmentId = id;
		this.departmentName = name;
		this.address = address;
	}

	/**
	 * @return the departmentId
	 */
	public short getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + ", address="
				+ address + "]";
	}

}
