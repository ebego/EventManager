package com.eventmanager.api.repository;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    Optional<EventResponse> findEventById(UUID id);
    void deleteById(UUID id);

    List<Event> findAll();

    Optional<Event> findByTitleEqualsIgnoreCaseAndEventDateEquals(String title, LocalDate eventDate);

    List<EventResponse> findTop3ByEventDateGreaterThanEqualOrderByEventDateAsc(LocalDate date);

    List<EventResponse> findTop3ByOrderByViewsDesc();

    List<EventResponse> findAllByTitleEqualsIgnoreCase(String title);

    @Query(" from Event e where e.title like concat('%', :query, '%')  or e.description like concat('%', :query, '%') or e.location like concat('%', :query, '%')")
    List<EventResponse> search(@Param("query") String query);

    List<EventResponse> findAllByEventDateEquals(LocalDate date);

    Page<Event> findAll(Pageable pageable);

}