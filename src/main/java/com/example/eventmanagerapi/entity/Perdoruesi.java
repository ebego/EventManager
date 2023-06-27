package com.example.eventmanagerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Perdoruesi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String user;
    private String role;
    private String password;
    @OneToMany(mappedBy = "organizator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Eventi> events;
}
