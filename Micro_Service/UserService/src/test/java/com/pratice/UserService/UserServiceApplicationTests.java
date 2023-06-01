package com.pratice.UserService;

import com.pratice.UserService.Entities.Rating;
import com.pratice.UserService.External.Service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService service;
	@Test
	void contextLoads() {
	}
	@Test
	void createRating()
	{
		Rating rating=Rating.builder().rating(10).userId("5c147e98-1519-4626-bb4a-11f5f6c5e81a").hotelId("a3a15eaf-9b56-4550-857b-6148dab834b9").feedback("This is created using feign clinet").build();
		Rating saveRating=service.CreateRating(rating);

		System.out.println("New Rating");
	}

}
