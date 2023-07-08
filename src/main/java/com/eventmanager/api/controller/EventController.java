package com.eventmanager.api.controller;

import com.eventmanager.api.dto.EventResponse;
import com.eventmanager.api.entity.Event;
import com.eventmanager.api.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public List<EventResponse> getEvents(@RequestParam("query") String query){
        return eventService.getEvents(query);
    }

    @GetMapping("/events/{id}")
    public EventResponse getEventById(@PathVariable("id") UUID id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/events/add")
    public void addEvent(@Validated @RequestBody Event event)  {
        eventService.addEvent(event);
    }

    @GetMapping("/events/latest")
    public List<EventResponse> getLatestEvents() {
        return eventService.getLatestEvents();
    }
    @GetMapping("/events/most-viewed")
    public List<EventResponse> getMostViewedEvents() {
        return eventService.getMostViewedEvents();
    }
}
