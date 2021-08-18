package com.venky.login.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.venky.login.daoIface.UserdaoIface;
import com.venky.login.model.User;

@Repository
public class UserdaoImpl implements UserdaoIface{
	@Autowired
	JdbcTemplate jdbctemplate ;
	String query = "select user_name, email, phone_number from Venky548.user_table";
	User user1 = new User();
	@Override
	public User getUserDetails() {
		
		user1 =  jdbctemplate.queryForObject(query, (rs, rowNum) ->{
			user1.setUser_name(rs.getString(1));
			user1.setEmail(rs.getString(2));
			user1.setPhone_number(rs.getLong(3));
			return user1;
			
			
		});
		
		return user1;
	}
	@Override
	public int registerDetails(User user) {
		String query = "insert into user_table(user_name, email, phone_number,password, confirm_password) values (?,?,?,?,?)";
		int i =  jdbctemplate.update(query, user.getUser_name(), user.getEmail(),user.getPhone_number(),user.getPassword(),user.getConfirm_password());
		return i;
	}

}
