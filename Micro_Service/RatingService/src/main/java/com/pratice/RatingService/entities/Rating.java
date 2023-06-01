package com.pratice.RatingService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="Rating")
public class Rating
{
    @Id
    @Column(name="ratingId")
    private String ratingId;
    @Column(name = "userId")
    private String  userId;
    @Column(name="hotelId")
    private  String hotelId;
    @Column(name = "feedback")
    private  String feedback;
    @Column(name = "rating")
    private int rating;

}
