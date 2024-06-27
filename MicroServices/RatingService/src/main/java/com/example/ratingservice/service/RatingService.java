package com.example.ratingservice.service;

import com.example.ratingservice.entities.Rating;
import java.util.*;
public interface RatingService {
    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
