package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path="api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path="/save")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping(path="/findAll")
    public List<User> findAll() {
        return userService.findUsers();
    }

    @GetMapping("/findByUsername")
    public User findUserByUsername(@RequestParam String username) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nombre de usuario no encontrado");
        }
        return user;
    }

    @GetMapping("/login")
    public Boolean login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @DeleteMapping("/delete")
    public void login(@RequestParam Integer id) {
        userService.delete(id);
    }
}
