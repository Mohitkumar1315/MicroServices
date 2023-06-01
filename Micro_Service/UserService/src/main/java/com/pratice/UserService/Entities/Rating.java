package com.pratice.UserService.Entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity(name = "user_rating")
public class Rating 
{
    //@Id
    @Column(name="Id")
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private  String feedback;

    private Hotel hotel;

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId='" + ratingId + '\'' +
                ", userId='" + userId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                ", hotels=" + hotel +
                '}';
    }
}
