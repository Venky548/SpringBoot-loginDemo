package com.venky.login.daoIface;

import com.venky.login.model.User;

public interface UserdaoIface {
	public User getUserDetails();
	public int registerDetails(User user);

}
