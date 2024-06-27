package com.example.ratingservice.repository;

import com.example.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
