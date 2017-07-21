package com.ams.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ams.app.domain.User;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userDaoImpl;
	

	@RequestMapping(value = "/validateUserLogin/{email}/{password}", method = RequestMethod.GET)
	//@Transactional(rollbackFor="savepoint1")
	public @ResponseBody User validateUser(@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password) {
		
		if(!("admin@gmail.com".equals(email) && "admin".equals(password))){
			return new User(email, email, password, "Active");
		}
		
		System.out.println(userDaoImpl.findAll().size());
		
		/*if (userDaoImpl.validateUser(email, password) ){
			return new User(email, email, password, "Active");
		}*/
		
		return new User(email, email, password, "Active");
	}

}