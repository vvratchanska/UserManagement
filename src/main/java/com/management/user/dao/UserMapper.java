package com.management.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.management.user.entity.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	      User user = new User();
	      user.setFirstName(rs.getString("first_name"));
	      user.setLastName(rs.getString("last_name"));
	      user.setEmail(rs.getString("email"));
	      user.setRole(rs.getString("role"));
	      user.setPassword(rs.getString("password"));
	      
	      return user;
	   }
}
