package com.eventmanager.api.service;

import com.eventmanager.api.entity.Event;
import com.eventmanager.api.repository.EventRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Data
@Service
public class EventService {
    private EventRepository eventRepository;

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
}
