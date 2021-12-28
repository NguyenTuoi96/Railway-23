package com.vti.entity;

public class Employee extends User {
	private String proSkill;

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public Employee(int id, String fullName, String email, String passWord, String proSkill, byte userType) {
		super(id, fullName, email, passWord, userType);
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord()
				+ ", proSkill=" + proSkill
				+ "]";
	}

}
