package com.pratice.RatingService.service;

import com.pratice.RatingService.entities.Rating;
import com.pratice.RatingService.repositories.RatingRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

public interface RatingService
{

    public Rating createRatings(Rating rating);

    public List<Rating> getAllRatings();

    //give rating on the bases of UserID
    public List<Rating> getAllRatingsByUserId(String userId);
    Rating getRatingById(String ratingId);

    List<Rating> getAllRatingByHotelId(String hotelId);

    void removeRating(String ratingId);
}
