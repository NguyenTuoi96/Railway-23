package com.vti.academy;

import java.util.Arrays;
import java.util.Date;

public class Account {
	int accountId;
	String email;
	String userName;
	String fullName;
	Department department;
	Position position;
	Date createDate;
	Group[] groups;
	float salary;
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", department=" + department + ", position=" + position + ", createDate=" + createDate
				+ ", groups=" + Arrays.toString(groups) + ", salary=" + salary + "]";
	}
}
