package com.eventmanager.api.repository;

import com.eventmanager.api.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

        Event findById(int id);

        List<Event> findAll();
        }