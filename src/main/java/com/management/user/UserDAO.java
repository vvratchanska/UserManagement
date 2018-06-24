package com.management.user;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {
	
	/** 
     * Initializes database resources ie. connection.
     */
	public void setDataSource(DataSource ds);
	
	public void createUser(User newUserObject);
	
	public User getUserById(Integer id);
	
	public void updateUser(User userForUpdate);
	
	public List<User> getAllUsers();
	
	public void deleteUserById(Integer id);

}
