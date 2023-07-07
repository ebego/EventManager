package com.eventmanager.api.repository;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends CrudRepository<Event, org.yaml.snakeyaml.events.Event.ID> {

    EventResponse findById(UUID id);

    List<Event> findAll();

    Optional<Event> findByTitleEqualsIgnoreCaseAndEventDateEquals(String title, LocalDate eventDate);

    List<EventResponse> findTop3ByEventDateGreaterThanEqualOrderByEventDateAsc(LocalDate date);

    List<EventResponse> findTop3ByOrderByViewsDesc();

    List<EventResponse> findAllByTitleEqualsIgnoreCase(String title);

}