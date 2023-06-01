package com.pratice.RatingService.serviceImpl;

import com.pratice.RatingService.entities.Rating;
import com.pratice.RatingService.repositories.RatingRepositories;
import com.pratice.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RatingServiceImpl implements RatingService
{
    @Autowired
    private RatingRepositories repo;
    @Override
    public Rating createRatings(Rating rating)
    {
        Rating  rat=rating;
        if(rat==null)
        {
            return null;
        }
        String RatingId= UUID.randomUUID().toString();
        System.out.println(RatingId);
        rat.setRatingId(RatingId);
        return repo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings()
    {
        List<Rating> list=repo.findAll();

        return repo.findAll();
    }

    @Override
    public List<Rating> getAllRatingsByUserId(String userId)
    {
        return repo.findByUserId(userId);
    }

    @Override
    public Rating getRatingById(String ratingId)
    {
        System.out.println("RatingID:"+ratingId+"");

        return  repo.findByRatingId(ratingId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId)
    {
            return  repo.findByHotelId(hotelId);
    }

    @Override
    public void removeRating(String ratingId)
    {
        repo.deleteById(ratingId);
    }


}
