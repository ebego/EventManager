package com.eventmanager.api.controller;

import com.eventmanager.api.entity.Booking;
import com.eventmanager.api.service.BookingService;
import com.eventmanager.api.service.IBookingService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
public class BookingController {
    private final IBookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getBookings(){
        return bookingService.getBookings();
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable("id") UUID id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/bookings/add")
    public void addBooking(@Validated @RequestBody Booking booking)  {
        bookingService.addBooking(booking);
    }
}
