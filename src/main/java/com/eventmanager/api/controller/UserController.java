package com.eventmanager.api.controller;

import com.eventmanager.api.dto.UserResponse;
import com.eventmanager.api.entity.User;
import com.eventmanager.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }
    @PostMapping("/users/add")
    public void addUser(@Validated @RequestBody User user)  {
        userService.addUser(user);
    }

    @DeleteMapping("/users/delete")
    public void deleteUser(@Validated @RequestBody User user)  {
        userService.deleteUser(user);
    }
}
