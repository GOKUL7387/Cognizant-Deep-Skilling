package com.cognizant.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/data")
    public String getUserData() {
        return "User data from user-service";
    }
}
