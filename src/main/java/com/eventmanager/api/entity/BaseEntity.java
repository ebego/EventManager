package com.eventmanager.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Getter @Setter
public class BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDate.now();
    }
}
