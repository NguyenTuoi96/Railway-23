package com.vti.entity;

public class Department {
	private byte departmentId;
	private String departmentName;
	
	// hàm khởi tạo không tham số
	public Department() {
	}
	
	// hàm khởi tạo có 1 parameter là nameDepartment và default id của Department = 0
	public Department(String nameDepartment) {
		this.setDepartmentId((byte) 0);
		this.setDepartmentName(nameDepartment);
	}

	/**
	 * @return the departmentId
	 */
	public byte getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(byte departmentId) {
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
}
