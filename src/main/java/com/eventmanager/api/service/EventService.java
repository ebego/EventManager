package com.eventmanager.api.service;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import com.eventmanager.api.entity.User;
import com.eventmanager.api.repository.EventRepository;
import com.eventmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    private static List<Event> eventList = new ArrayList<>();

    public List<Event> getEvents(){
//        List<Eventi> result = new ArrayList();
//        eventiRepository.findAll().forEach(result::add);
//        return result;
        return eventList;
    }
    public void addEvent(Event event){
        eventRepository.save(event);
    }
    public Event getEventiById(int id)  {
        return eventRepository.findById(id);
    }

    public List<EventResponse> getLatestEvents() {
        return eventRepository.findTop3ByEventDateGreaterThanEqualOrderByEventDateAsc(LocalDate.now());
    }
}
