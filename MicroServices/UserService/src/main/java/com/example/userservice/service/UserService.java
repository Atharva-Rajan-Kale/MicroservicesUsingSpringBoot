package com.example.userservice.service;

import com.example.userservice.entities.User;

import java.util.List;
public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);


}
