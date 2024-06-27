package com.example.ratingservice.controller;

import com.example.ratingservice.entities.Rating;
import com.example.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        rating.setRatingId(UUID.randomUUID().toString());

        // Save the Rating object
        Rating savedRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(savedRating));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getRating(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }


    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
