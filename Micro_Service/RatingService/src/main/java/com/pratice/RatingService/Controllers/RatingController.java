package com.pratice.RatingService.Controllers;

import com.pratice.RatingService.entities.Rating;
import com.pratice.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rating")
public class RatingController
{
    @Autowired
    private RatingService service;

    @RequestMapping("test")
    public void test()
    {
        System.out.println("Test");
    }
    @PostMapping("/createRating")
    public ResponseEntity<Rating> createHotel(@RequestBody Rating rating)
    {
        System.out.println("hlo");
        Rating rat=service.createRatings(rating);
        return ResponseEntity.status(HttpStatus.OK).body(rat);
    }
    @GetMapping("/ratingID/{RatingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String RatingId)
    {
        Rating rat=service.getRatingById(RatingId);
        if(rat==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(rat);
    }
    @GetMapping("/getAllHotelAndUserRatings")
    public ResponseEntity<List<Rating>> getAllRating()
    {
        List<Rating> list=service.getAllRatings();
        if(list.isEmpty())
        {
            ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId)
    {
        List<Rating> list=service.getAllRatingsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/getByHotel/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId )
    {
        System.out.println("Hotel id in Controller:"+hotelId+"");
        List<Rating> list = service.getAllRatingByHotelId(hotelId);
        if (list.isEmpty())
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @DeleteMapping("/deleteRating/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId)
    {
        service.removeRating(ratingId);
    }



}
