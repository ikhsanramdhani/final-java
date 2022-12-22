package com.example.backend.repository.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.backend.model.User;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User insert(User user) {
        // TODO Auto-generated method stub
        var query = "INSERT INTO tb_user (email, nama, password) VALUES (?,?,?)";

        try {
            jdbcTemplate.update(query, new Object[] {
                user.getEmail(), user.getNama(), user.getPassword()
            });
            return user;
        } catch (Exception e) {
            // TODO: handle exception
            User obj = new User();
            return obj;
        }
    }

    @Override
    public List<User> getUser() {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_user";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<User> obj = new ArrayList<>();
            return obj;
        }
    }

    @Override
    public User login(String email, String password) {
        // TODO Auto-generated method stub
        var query = "SELECT email, password FROM tb_user WHERE email = ? AND password = ?";
        try {
            var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), email, password);
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            User obj = new User();
            return obj;
        }
    }
}
