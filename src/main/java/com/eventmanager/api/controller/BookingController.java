package com.eventmanager.api.controller;

import com.eventmanager.api.entity.Booking;
import com.eventmanager.api.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getBookings(){
        return bookingService.getBookings();
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable("id") int id) {
        return bookingService.getRezervimiById(id);
    }

    @PostMapping("/bookings/add")
    public void addBooking(@Validated @RequestBody Booking booking)  {
        bookingService.addBooking(booking);
    }
}
