package com.pratice.RatingService.repositories;

import com.pratice.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
public interface RatingRepositories extends JpaRepository<Rating, String>
{

    List<Rating>findByUserId(String UserId);
    Rating findByRatingId(String id);

  // @Query(value = "select r from user_rating r where r.hotel_rating=:HotelId")
  List<Rating> findByHotelId(String HotelId);

}

