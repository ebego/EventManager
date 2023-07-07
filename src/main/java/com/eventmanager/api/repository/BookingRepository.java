package com.eventmanager.api.repository;

import com.eventmanager.api.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends CrudRepository<Booking, UUID> {

    Booking findBookingById(UUID id);

    List<Booking> findAll();
}
