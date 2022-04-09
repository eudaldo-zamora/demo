package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.User;

public interface UserService {
    void saveUser(User user);
    List<User> findUsers();
    User findUserByUsername(String username);
    Boolean login(String username, String password);
    void delete(Integer id);
    void deleteByName(String name);
}

