package com.eventmanager.api.service;

import com.eventmanager.api.entity.Booking;
import com.eventmanager.api.repository.BookingRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class BookingService {
    private BookingRepository rezervimiRepository;

    private static List<Booking> rezervimiList = new ArrayList<>();

    public List<Booking> getBookings(){
//        List<Rezervimi> result = new ArrayList();
//        rezervimiRepository.findAll().forEach(result::add);
//        return result;
        return rezervimiList;
    }

    public void addBooking(Booking rezervimi){
        rezervimiRepository.save(rezervimi);
    }
    public Booking getRezervimiById(int id)  {
        return rezervimiRepository.findBookingById(id);
    }
}
