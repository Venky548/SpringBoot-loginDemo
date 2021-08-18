package com.venky.login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venky.login.daoIface.UserdaoIface;
import com.venky.login.model.User;
import com.venky.login.serviceIface.UserServiceIface;

@Service
public class UserServiceImpl implements UserServiceIface{
	
	@Autowired
	UserdaoIface iface;

	@Override
	public User getUserDetails11() {
		System.out.println("In service Iface");
		User user = new User();
		user = iface.getUserDetails();
		return user;
	}

	@Override
	public int saveDetails(User user) {
		System.out.println("In service Iface in saveDetails");
		int status = iface.registerDetails(user);
		return status;
	}

}
