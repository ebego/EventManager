package com.eventmanager.api.controller;



import com.eventmanager.api.dto.UserDTO;
import com.eventmanager.api.dto.UserResponse;
import com.eventmanager.api.entity.User;
import com.eventmanager.api.model.AuthenticationRequest;
import com.eventmanager.api.repository.UserRepository;
import com.eventmanager.api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class AuthController {
    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/auth")
    public String login(@RequestBody AuthenticationRequest authenticationRequest){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = userRepository.findByUsername(authenticationRequest.getUsername());

        if(user != null && passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword()))
            return jwtUtil.generateToken(user.getUsername());

        throw new AuthenticationServiceException("KREDENCIALET GABIM!");
    }

    @PostMapping("/auth")
    public void addUser(@RequestBody UserResponse user){

        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

        user.setPassword(crypt.encode(user.getPassword()));

        User userEntity = new User();

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());

        userRepository.save(userEntity);
    }

    @PutMapping("/auth")
    public List<User> login(){
        return userRepository.findAll();
    }

}
