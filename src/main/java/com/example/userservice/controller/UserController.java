package com.example.userservice.controller;

import com.example.userservice.model.ForumUser;
import com.example.userservice.model.ForumUserRequest;
import com.example.userservice.model.LoginRequest;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profilePic/{userId}")
    public String getProfilePic(@PathVariable String userId){
        return userService.getProfilePic(userId);
    }
    @PutMapping("/updateProfilePic/{userId}/{profilePic}")
    public void getProfilePic(@PathVariable String userId, @PathVariable String profilePic){
        userService.updateProfilePic(userId,profilePic);
    }
    @PostMapping("/register")
    public ForumUser registerUser(@Valid @RequestBody ForumUserRequest request){
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public ForumUser loginUser(@Valid @RequestBody LoginRequest request){
        return userService.loginUser(request);
    }





}
