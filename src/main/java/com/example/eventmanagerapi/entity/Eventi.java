package com.example.eventmanagerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Eventi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String event_name;
    @ManyToOne
    @JoinColumn(name = "perdoruesi_id")
    private Perdoruesi organizator;
    private int maximum_number;
    private String description;
    private LocalDate creation_time;
    private File imagesVideos;

}
