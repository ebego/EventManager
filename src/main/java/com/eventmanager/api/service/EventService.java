package com.eventmanager.api.service;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import com.eventmanager.api.repository.EventRepository;
import com.eventmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
@Log4j2
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    private static List<Event> eventList = new ArrayList<>();

    public List<EventResponse> getEvents(String query) {
        return eventRepository.search(query);
    }
    public void addEvent(Event event){
        eventRepository.save(event);
    }
    public void deleteById(UUID id) {
     eventRepository.deleteById(id);
    }
    public EventResponse getEventById(UUID id)  {
        Optional<EventResponse> result =  eventRepository.findEventById(id);
        return result.orElse(null);
    }

    public List<EventResponse> getLatestEvents() {
        return eventRepository.findTop3ByEventDateGreaterThanEqualOrderByEventDateAsc(LocalDate.now());
    }
    public List<EventResponse> getMostViewedEvents() {
        return eventRepository.findTop3ByOrderByViewsDesc();
    }

    public List<EventResponse> searchBar(String query) {
        try {
            LocalDate searchDate = LocalDate.parse(query);
            return eventRepository.findAllByEventDateEquals(searchDate);
        }
        catch (Exception ex) {
            log.info("Query value: " + query + " is not a date");
        }

        return eventRepository.search(query);
    }
}
