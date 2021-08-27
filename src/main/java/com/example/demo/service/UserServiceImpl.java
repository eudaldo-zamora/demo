package com.example.demo.service;

import static com.example.demo.repository.UserRepositoryImpl.usernameExist;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findUsers() {
        return repository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public Boolean login(String username, String password) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
