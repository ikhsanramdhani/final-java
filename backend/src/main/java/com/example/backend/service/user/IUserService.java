package com.example.backend.service.user;

import java.util.List;

import com.example.backend.model.User;

public interface IUserService {
    public User insert(User user);
    public List<User> getUser();
    public User login(String email, String password);
}
