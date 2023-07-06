package com.eventmanager.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "em_event")
public class Event extends BaseEntity {
    private String title;

    @Column(name="max_booking")
    @Min(0)
    private int maxBookings;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Min(0)
    private int views;

    private String description;
    private int price;

    private String location;

    private String banner;

    @Column(name = "owner_id")
    protected int ownerId;

    @ManyToOne
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private User owner;
}
