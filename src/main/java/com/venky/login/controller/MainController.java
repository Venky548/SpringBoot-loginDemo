package com.venky.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venky.login.model.User;
import com.venky.login.serviceIface.UserServiceIface;

@RestController
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	UserServiceIface serviceIface;
	
	@GetMapping("/getUserDetails")
	public User getDetails() {
		System.out.println("In Controller");
		User user = new User();
		user = serviceIface.getUserDetails11();
		return user;
		
	}
	@PostMapping("/saveUserDetails")
	public int saveUserDetails(@RequestBody User user) {
		System.out.println("In Controller in saveUserDetails");
		int status = serviceIface.saveDetails(user);
		if(status>=1) {
			System.out.println("inserted");
		}
		return status;
		
	}

}
