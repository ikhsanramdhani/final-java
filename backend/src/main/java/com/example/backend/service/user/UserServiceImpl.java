package com.example.backend.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.User;
import com.example.backend.repository.user.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User insert(User user) {
        // TODO Auto-generated method stub
        return userRepository.insert(user);
    }

    @Override
    public List<User> getUser() {
        // TODO Auto-generated method stub
        return userRepository.getUser();
    }

    @Override
    public User login(String email, String password) {
        // TODO Auto-generated method stub
        return userRepository.login(email, password);
    }
    
}
