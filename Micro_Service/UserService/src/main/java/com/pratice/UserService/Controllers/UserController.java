package com.pratice.UserService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pratice.UserService.Entities.User;
import com.pratice.UserService.Servies.UserServices;

@Controller
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserServices userSerivice;
	//@PostMapping
	@PostMapping("/usercreate")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		System.out.println(user);
		User user1=userSerivice.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	@GetMapping("/getuser/{UserId}")
	public ResponseEntity<User> getUser(@PathVariable String UserId)
	{
		User user =userSerivice.getUser(UserId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	
	}
	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getAllUser()
	{
		System.out.println("hlo");
		List<User> list=userSerivice.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
