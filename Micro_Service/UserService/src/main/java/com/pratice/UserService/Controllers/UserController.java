package com.pratice.UserService.Controllers;

import java.util.List;


import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import com.pratice.UserService.Entities.User;
import com.pratice.UserService.Servies.UserServices;

@Controller
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserServices userSerivice;
	private Logger logger= LoggerFactory.getLogger(UserController.class);

	//@PostMapping
	@PostMapping("/usercreate")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		System.out.println(user);
		User user1=userSerivice.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	int retryCount=1;
	@GetMapping("/getuser/{UserId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="userRateLimiter",fallbackMethod ="ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String UserId)
	{
		logger.info("get sinle User Handler:userCpntroller");
		logger.info("Retry count:{}",retryCount);
		retryCount++;
		User user =userSerivice.getUser(UserId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	
	}
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex)
	{
		ex.printStackTrace();
		User user = User.builder().email("mvkrampur1315@gmail.com").name("Hlo Mohit").about("This user is created dummy because some Service  is down").userId("1315").build();
		return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getAllUser()
	{
		System.out.println("hlo");
		List<User> list=userSerivice.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
