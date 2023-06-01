package com.pratice.UserService.Servies;

import java.util.List;

import com.pratice.UserService.Entities.User;

public interface  UserServices 
{
	//create USer
	User saveUser(User user);
	
	//get all USer
	List<User> getAllUser();
	
	//get Single USer
	User getUser(String userId);
	
}
