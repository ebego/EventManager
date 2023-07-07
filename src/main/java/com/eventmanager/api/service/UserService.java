package com.eventmanager.api.service;

import com.eventmanager.api.dto.UserResponse;
import com.eventmanager.api.entity.User;
import com.eventmanager.api.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private static List<User> userList = new ArrayList<>();

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(o -> UserResponse.builder()
                .id(o.getId())
                .firstName(o.getFirstName())
                .lastName(o.getLastName())
                .email(o.getEmail())
                .phone(o.getPhone())
                .role(o.getRole())
                .build()).collect(Collectors.toList());
    }

    public void addUser(User user){
        userRepository.save(user);
    }
//    public Perdoruesi getPerdoruesiById(int id) throws FileNukUGjetException {
//        return perdoruesiRepository.findPerdoruesiById(id);
//    }
    public User getUserById(UUID id) {
        if(userList.stream().filter(s->s.getId() == id).noneMatch(p-> true) == true){
            throw new RuntimeException("Not found exception");
        }
        return userList.stream().filter(s->s.getId() == id).findFirst().get();
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
