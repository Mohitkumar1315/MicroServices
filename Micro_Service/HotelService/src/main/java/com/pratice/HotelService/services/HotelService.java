package com.pratice.HotelService.services;

import com.pratice.HotelService.entites.Hotel;

import java.util.List;

//@Service
public interface HotelService
{
    Hotel createHotel(Hotel hotel);
    List<Hotel> getListHotel();

    Hotel getHotel(String id);

}

