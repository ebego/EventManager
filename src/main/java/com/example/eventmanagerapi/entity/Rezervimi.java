package com.example.eventmanagerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rezervimi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate createdAt;
    private int leftReservations;
    @ManyToOne
    @JoinColumn(name = "eventi_id")
    private Eventi eventi_id;
    @ManyToOne
    @JoinColumn(name = "perdoruesi_id")
    private Perdoruesi perdoruesi_id;

}
