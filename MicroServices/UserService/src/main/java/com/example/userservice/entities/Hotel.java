package com.example.userservice.entities;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;
}
