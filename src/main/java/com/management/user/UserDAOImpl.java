package com.management.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createUser(User newUserObject) {
		String SQL = "insert into user (first_name, last_name, email, role, password) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(SQL, newUserObject.getFirstName(), newUserObject.getLastName(), newUserObject.getEmail(),
				newUserObject.getRole(), newUserObject.getPassword());
	}

	public User getUserById(Integer id) {
		String SQL = "select * from user where id = ?";
		User user = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return user;
	}

	public List<User> getAllUsers() {
		String SQL = "select * from user";
		List<User> students = jdbcTemplate.query(SQL, new UserMapper());
		return students;
	}

	public void deleteUserById(Integer id) {
		String SQL = "delete from user where id = ?";
		jdbcTemplate.update(SQL, id);
	}

	public void updateUser(User userForUpdate) {
		String SQL = "update user set first_name = ?, last_name = ?, role = ?, password = ? where id = ?";
		jdbcTemplate.update(SQL, userForUpdate.getFirstName(), userForUpdate.getLastName(), userForUpdate.getRole(),
				userForUpdate.getPassword(), userForUpdate.getId());
	}
}
