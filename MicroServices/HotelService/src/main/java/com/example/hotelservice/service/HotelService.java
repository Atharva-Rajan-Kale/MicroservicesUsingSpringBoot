package com.example.hotelservice.service;

import com.example.hotelservice.entities.Hotel;
import java.util.*;
public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);
}
