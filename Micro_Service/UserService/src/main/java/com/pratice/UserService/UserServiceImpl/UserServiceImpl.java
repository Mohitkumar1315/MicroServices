package com.pratice.UserService.UserServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.pratice.UserService.Entities.Hotel;
import com.pratice.UserService.Entities.Rating;
import com.pratice.UserService.External.Service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pratice.UserService.Entities.User;
import com.pratice.UserService.Exceptions.ResourceNotFound;
import com.pratice.UserService.Servies.UserServices;
import com.pratice.UserService.UserRepositories.UserRepository;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiceImpl implements UserServices 
{
	@Autowired
	private UserRepository repo;
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;
	private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User saveUser(User user) 
	{
		// TODO Auto-generated method stub
		String ranUserid =UUID.randomUUID().toString();
		user.setUserId(ranUserid);
		//System.out.println(ranUserid);
		System.out.println("user:"+user+"");
		return repo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> list =repo.findAll();

		return list;

	}

	@Override
	public User getUser(String userId)
	{
		User user=repo.findById(userId).orElseThrow(()-> new ResourceNotFound("User given Id is not found on Server"+userId+""));
		//fetch Rating
		//	"http://localhost:8083/Rating/users/dc35bcd4-fb61-4a30-8ff9-a9ec5cf8f638"
		//http://localhost:8082/hotel/getHotel/91d7b2aa-636e-4e43-b774-6f16b21e36fc
		String ratingurl="http://RATING-SERVICE/Rating/users/" + userId;
        //logger'.info("{}", forObject);   //for printing on the console
		//ArrayList<Rating> ratingOfUser=restTe mplate.getForObject(ratingurl, ArrayList.class);    //-----genrate error of casting-----
		Rating[] ratingOfUser=restTemplate.getForObject(ratingurl, Rating[].class);
		//System.out.println("Hotel id "+ratingOfUser[2]);
		logger.info("{}", ratingOfUser);

			List<Rating> ratings=Arrays.asList(ratingOfUser);




			List<Rating> ratingList=ratings.stream().map(rating ->{
			//api patch to hotelServcie to get The Hotel
				//System.out.println("Hotel Id:"+rating.getHotelId());
			//ResponseEntity forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/getHotel/"+rating.getHotelId(),Hotel.class);
			//we are using fiegn Client insted of RestTemplate
				//use Feign Clinet
				Hotel hotel=hotelService.getHotel(rating.getHotelId());
				//End Here Feign Client
				//Hotel hotel= (Hotel) forEntity.getBody();
	//		logger.info("Status Code is {}",forEntity.getStatusCode());

			// set The Hotel to  Rating
			rating.setHotel(hotel);
			//return rating
			return  rating;
		}).collect(Collectors.toList());

			int noOfRating=ratings.size();
		System.out.println("Total no of Rating which give to hotels:"+noOfRating);

		user.setRatings(ratings);
		//user.setRatings(ratingOfUser);
		return  user;
	}

}
