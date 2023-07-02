package com.eventmanager.api.repository;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    Event findById(int id);

    List<Event> findAll();

    Optional<Event> findByTitleEqualsIgnoreCaseAndEventDateEquals(String title, LocalDate eventDate);

    List<EventResponse> findTop3ByOrderByEventDateAsc();

    List<EventResponse> findTop3ByEventDateGreaterThanEqualOrderByEventDateAsc(LocalDate date);

}