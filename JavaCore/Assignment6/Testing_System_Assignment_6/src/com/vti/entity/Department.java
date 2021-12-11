package com.vti.entity;

public class Department {
	private byte departmentId;
	private String departmentName;

	public Department(ScannerUtils scUtils) {
		System.out.println("Hãy nhâp id của phòng ban (giá trị số)");
		this.departmentId = (byte) scUtils.inputInt("Bạn nhập sai, hãy nhập lại");
		System.out.println("Hãy nhâp tên của phòng ban");
		this.departmentName = scUtils.inputString();
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

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	
}
