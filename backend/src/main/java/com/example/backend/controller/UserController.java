package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.User;
import com.example.backend.service.user.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    IUserService userService;

    @PostMapping("/insertUser")
    public User insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/getUser")
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }


}
