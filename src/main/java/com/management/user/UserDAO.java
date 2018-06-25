package com.management.user;

import java.util.List;

public interface UserDAO {
	
	public void createUser(User newUserObject);
	
	public User getUserByEmail(String email);
	
	public void updateUser(User userForUpdate);
	
	public List<User> getAllUsers();
	
	public void deleteUserByEmail(String email);

}
