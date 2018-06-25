package com.management.user.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.management.user.dao.UserDAOImpl;
import com.management.user.entity.User;

@RestController
public class WebController {
	@Autowired
	UserDAOImpl userDaoImpl;

	@Autowired
	DataSource dataSource;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userDaoImpl.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = { "/get-user/{email}" }, method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		System.out.println("email: " + email);
		User user = userDaoImpl.getUserByEmail(email);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User currentUser = userDaoImpl.getUserByEmail(user.getEmail());
		if (currentUser != null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		userDaoImpl.createUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update-user/{email}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("email") String email) {
		User currentUser = userDaoImpl.getUserByEmail(email);
		if (currentUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setRole(user.getRole());
		currentUser.setPassword(user.getPassword());
		userDaoImpl.updateUser(currentUser);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete-user/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("email") String email) {
		User user = userDaoImpl.getUserByEmail(email);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userDaoImpl.deleteUserByEmail(email);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}