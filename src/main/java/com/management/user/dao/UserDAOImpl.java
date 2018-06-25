package com.management.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.management.user.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createUser(User newUserObject) {
		String SQL = "insert into user (first_name, last_name, email, role, password) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(SQL, newUserObject.getFirstName(), newUserObject.getLastName(), newUserObject.getEmail(),
				newUserObject.getRole(), newUserObject.getPassword());
	}

	public User getUserByEmail(String email) {
		String SQL = "select * from user where email = ?";
		User user;
		try {
			user = jdbcTemplate.queryForObject(SQL, new Object[] { email }, new UserMapper());
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	public List<User> getAllUsers() {
		String SQL = "select * from user";
		List<User> students = jdbcTemplate.query(SQL, new UserMapper());
		return students;
	}

	public void deleteUserByEmail(String email) {
		String SQL = "delete from user where email = ?";
		jdbcTemplate.update(SQL, email);
	}

	public void updateUser(User userForUpdate) {
		String SQL = "update user set first_name = ?, last_name = ?, role = ?, password = ? where email = ?";
		jdbcTemplate.update(SQL, userForUpdate.getFirstName(), userForUpdate.getLastName(), userForUpdate.getRole(),
				userForUpdate.getPassword(), userForUpdate.getEmail());
	}
}
