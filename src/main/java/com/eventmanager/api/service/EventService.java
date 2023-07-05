package com.eventmanager.api.service;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import com.eventmanager.api.repository.EventRepository;
import com.eventmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    private static List<Event> eventList = new ArrayList<>();

    public List<Event> getEvents(){
        List<Event> result = new ArrayList();
        eventRepository.findAll().forEach(result::add);
        return result;
//        return eventList;
    }
    public void addEvent(Event event){
        eventRepository.save(event);
    }
    public EventResponse getEventiById(int id)  {
        return eventRepository.findById(id);
    }

    public List<EventResponse> getLatestEvents() {
        return eventRepository.findTop3ByEventDateGreaterThanEqualOrderByEventDateAsc(LocalDate.now());
    }
    public List<EventResponse> getMostViewedEvents() {
        return eventRepository.findTop3ByOrderByViewsDesc();
    }

    public List<EventResponse> searchBar(String title){
//        List<EventResponse> event = eventRepository.findAllByTitleEqualsIgnoreCase(title);
//        return event;
//        if (eventRepository.eveLocalDate.parse(title) )
        return eventRepository.findAllByTitleEqualsIgnoreCase(title);
    }
}
