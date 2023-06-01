package com.pratice.HotelService.hotelServiceImpl;

import com.pratice.HotelService.Exception.ResourceNotFound;
import com.pratice.HotelService.entites.Hotel;
import com.pratice.HotelService.reposistoies.HotelRepository;
import com.pratice.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    private HotelRepository repo;


    @Override
    public Hotel createHotel(Hotel hotel)
    {
        String hotelid= UUID.randomUUID().toString();
        System.out.println("Hotel id:"+hotelid+"");
        hotel.setId(hotelid);
        return repo.save(hotel);
    }


    @Override
    public List<Hotel> getListHotel() {
        return repo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        System.out.println("hlo");
        return repo.findById(hotelId).orElseThrow(() -> new ResourceNotFound("Resource not found!!!"));
    }
}
