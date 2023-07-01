package com.eventmanager.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "em_event")
public class Event extends BaseEntity {
    private String title;

    @Column(name="max_booking")
    private int maxBookings;

    private String description;

    private String banner;

    @Column(name = "owner_id")
    protected int ownerId;

    @ManyToOne
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private User owner;
}
