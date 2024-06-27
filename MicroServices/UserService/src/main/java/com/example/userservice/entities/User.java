package com.example.userservice.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Data
@Entity
@Table(name="micro_users")
@Builder
@AllArgsConstructor
public class User {
    @Id
    private String userId;

    private String name;

    private String email;

    private String about;

    @Transient
    private List<Rating> ratings=new ArrayList<>();

    public User() {

    }

}
