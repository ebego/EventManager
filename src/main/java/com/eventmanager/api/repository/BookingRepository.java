package com.eventmanager.api.repository;

import com.eventmanager.api.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    Booking findBookingById(int id);

    List<Booking> findAll();
}
