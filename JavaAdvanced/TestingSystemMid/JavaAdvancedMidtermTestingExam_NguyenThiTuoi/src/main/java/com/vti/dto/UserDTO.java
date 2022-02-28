package com.vti.dto;

import com.vti.entity.User;

public class UserDTO {
	private String mess;
	private User user;

	public UserDTO() {
	}

	public UserDTO(String mess, User user) {
		this.mess = mess;
		this.user = user;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDTO [mess=" + mess + ", user=" + user + "]";
	}	

}