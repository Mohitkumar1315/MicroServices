package com.pratice.HotelService.reposistoies;

import com.pratice.HotelService.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String>
{
  //
}
