package com.vti.repository;

import java.util.List;

import com.vti.entity.User;

public interface IUserRepository {

	public User getUserByEmailPassword(String email, String password);

	public void createUser(User user);
	
	public List<User> getUsersByName(String name);
}
