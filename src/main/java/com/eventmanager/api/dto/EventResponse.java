package com.eventmanager.api.dto;

import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDate;


public interface EventResponse {
    String getId();
    String getTitle();
    LocalDate getEventDate();
    String getDescription();
    int getViews();
    String getBanner();
    int getPrice();
    String getLocation();
    @Value("#{target.eventDate < T(java.time.LocalDate).now()}")
    boolean isPast();
}

