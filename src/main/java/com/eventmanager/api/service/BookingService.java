package com.eventmanager.api.service;

import com.eventmanager.api.entity.Booking;
import com.eventmanager.api.repository.BookingRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Data
public class BookingService implements IBookingService{
    private BookingRepository bookingRepository;

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    public void addBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public Booking getBookingById(UUID id)  {
        return bookingRepository.findBookingById(id);
    }
}
