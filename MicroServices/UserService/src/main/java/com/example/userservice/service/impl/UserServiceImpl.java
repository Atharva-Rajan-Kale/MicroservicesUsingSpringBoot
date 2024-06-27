package com.example.userservice.service.impl;

import com.example.userservice.entities.Hotel;
import com.example.userservice.entities.Rating;
import com.example.userservice.entities.User;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.external.services.HotelService;
import com.example.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.userservice.repository.UserRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on the server !! : "+userId));
        Rating[] ratingsOfUser=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",ratingsOfUser);
        List<Rating> ratings=Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList=ratings.stream().map(rating -> {
//            ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=hotelService.getHotel(rating.getHotelId());
//            logger.info("response status code: {}",forEntity.getStatusCode());
            rating.setHotel(hotel);
           return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }


}
