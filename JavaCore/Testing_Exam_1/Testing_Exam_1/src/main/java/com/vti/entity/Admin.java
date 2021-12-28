package com.vti.entity;

public class Admin extends User {

	private Byte expInYear;

	public Byte getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(Byte expInYear) {
		this.expInYear = expInYear;
	}

	public Admin(int id, String fullName, String email, String passWord, Byte expInYear, byte userType) {
		super(id, fullName, email, passWord, userType);
		this.expInYear = expInYear;
	}

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord()
				+ ", expInYear=" + expInYear
				+ "]";
	}

}
