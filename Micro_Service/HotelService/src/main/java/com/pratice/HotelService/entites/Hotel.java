package com.pratice.HotelService.entites;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="hotels")
public class Hotel
{
    @Id
   // @Column(name="id")
    private String id;
    private String name ;
    private String location;
    private String about;
}
