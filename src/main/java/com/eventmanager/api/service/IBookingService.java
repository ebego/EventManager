package com.eventmanager.api.service;


import com.eventmanager.api.entity.Booking;

import java.util.List;
import java.util.UUID;

public interface IBookingService {
    List<Booking> getBookings();
    void addBooking(Booking booking);
    Booking getBookingById(UUID id);
}
