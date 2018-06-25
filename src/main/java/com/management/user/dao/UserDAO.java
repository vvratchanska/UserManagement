package com.management.user.dao;

import java.util.List;

import com.management.user.entity.User;

public interface UserDAO {
	
	public void createUser(User newUserObject);
	
	public User getUserByEmail(String email);
	
	public void updateUser(User userForUpdate);
	
	public List<User> getAllUsers();
	
	public void deleteUserByEmail(String email);

}
