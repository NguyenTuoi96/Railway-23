package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "`user`")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "full_name", length = 100, nullable = false)
	private String fullName;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "phone", length = 15, nullable = false, unique = true)
	private String phone;

	@Column(name = "`password`", length = 30, nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<UserDevice> userDeviceList;
	
	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserDevice> getUserDeviceList() {
		return userDeviceList;
	}

	public void setUserDeviceList(List<UserDevice> userDeviceList) {
		this.userDeviceList = userDeviceList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", userDeviceList=" + userDeviceList + "]";
	}
	
}
