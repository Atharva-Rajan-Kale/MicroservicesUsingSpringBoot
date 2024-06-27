package com.example.userservice;

import com.example.userservice.entities.Rating;
import com.example.userservice.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private RatingService ratingService;
//    @Test
//    void createRating(){
//        Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("created using feign").build();
//        Rating savedRating = ratingService.createRating(rating);
//        System.out.println("new rating created");
//    }

}
