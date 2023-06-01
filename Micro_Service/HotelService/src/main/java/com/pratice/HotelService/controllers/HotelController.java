package com.pratice.HotelService.controllers;
import java.util.*;


import com.pratice.HotelService.entites.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import com.pratice.HotelService.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController
{
    @Autowired
    private HotelService service;
    @PostMapping("create")
    ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel hotel1=service.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/getHotels")
    public ResponseEntity<List<Hotel>> getHotels()
    {
        System.out.println("Hlo");
        List<Hotel> list=service.getListHotel();
        if(list.isEmpty())
        {
            System.out.println("hlo hotels ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           // return new ResourceNotFound("Resource not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/getHotel/{HotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable  String HotelId)
    {
        System.out.println("Test");
        Hotel hotel=service.getHotel(HotelId);
        if(hotel==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
        }
    }


}
