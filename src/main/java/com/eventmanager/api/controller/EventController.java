package com.eventmanager.api.controller;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import com.eventmanager.api.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable("id") int id) {
        return eventService.getEventRepository().findById(id);
    }

    @PostMapping("/events/add")
    public void addEvent(@Validated @RequestBody Event event)  {
        eventService.addEvent(event);
    }

    @GetMapping("/events/latest")
    public List<EventResponse> getLatestEvents() {
        return eventService.getLatestEvents();
    }
}
