package com.eventmanager.api.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface EventResponse {
    int getId();
    String getTitle();
    LocalDate getEventDate();
    String getDescription();
    int getViews();
    String getBanner();
    @Value("#{target.eventDate < T(java.time.LocalDate).now()}")
    boolean isPast();
}

