package com.pratice.UserService.External.Service;

import com.pratice.UserService.Entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Service
@FeignClient(name ="RATING-SERVICE")
public interface RatingService
{
    //create Rating
    @PostMapping("/Rating/createRating")
    public Rating CreateRating(Rating value);

    //get Rating
    //Update Rating
    @PutMapping("/Rating/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId,Rating rating);
    //Delete Rating
    @DeleteMapping("Rating/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);
}
