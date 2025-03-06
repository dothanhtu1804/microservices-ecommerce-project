package com.example.user_service.controllers;

import com.example.user_service.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @RequestMapping("/user-service")
    public List<User> getImages() {
        List<User> users = Arrays.asList(
                new User(1L, 1L, "tu","dothanhtu","03452445","dotu@gmail.com", User.gender.MALE,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmAe2tP9bjEMk9FwfEzj4Gh4sJsmtjccmbmw&s","2025-02-28T16:08:15.805+07:00", "2025-02-28T16:08:15.805+07:00"),
                new User(2L, 2L, "mai","lethikimmai","03452445","dotu@gmail.com", User.gender.MALE,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmAe2tP9bjEMk9FwfEzj4Gh4sJsmtjccmbmw&s","2025-02-28T16:08:15.805+07:00", "2025-02-28T16:08:15.805+07:00"),
                new User(3L, 3L, "son","dothanhson","03452445","dotu@gmail.com", User.gender.MALE,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmAe2tP9bjEMk9FwfEzj4Gh4sJsmtjccmbmw&s","2025-02-28T16:08:15.805+07:00", "2025-02-28T16:08:15.805+07:00"));
        return users;
    }
}
