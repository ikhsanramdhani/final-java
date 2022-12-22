package com.example.backend.repository.user;
import java.util.List;

import com.example.backend.model.User;

public interface IUserRepository {
    public User insert(User user);
    public List<User> getUser();
    public User login(String email, String password);
}
