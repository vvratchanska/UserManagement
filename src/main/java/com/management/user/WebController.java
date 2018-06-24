package com.management.user;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class WebController {
	@Autowired
	UserDAOImpl userDaoImpl;
	
	@Autowired
	DataSource dataSource;

	@RequestMapping(value={"/"})
    public String home(){
		
//        System.out.println("Our DataSource is = " + dataSource);
//	      User tempUser = new User();
//	      tempUser.setFirstName("Ivan");
//	      tempUser.setLastName("Ivanov");
//	      tempUser.setEmail("ivan.ivanov@sap.com");
//	      tempUser.setRole("Admin");
//	      tempUser.setPassword("password");
//	      
//	      userDaoImpl.createUser(tempUser);
	      
	      List<User> users = userDaoImpl.getAllUsers();
	      for(User u : users) {
	    	  System.out.println(u.toString());
	      }
       
    	
        return "home";
    }
}