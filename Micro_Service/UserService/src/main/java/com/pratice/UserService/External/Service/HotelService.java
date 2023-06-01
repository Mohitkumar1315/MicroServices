package com.pratice.UserService.External.Service;

import com.pratice.UserService.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="HOTEL-SERVICE")
public interface HotelService
{
    @GetMapping("/hotel/getHotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
