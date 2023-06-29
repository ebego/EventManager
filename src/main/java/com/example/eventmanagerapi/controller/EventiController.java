package com.example.eventmanagerapi.controller;

import com.example.eventmanagerapi.entity.Eventi;
import com.example.eventmanagerapi.exceptionhandler.FileNukUGjetException;
import com.example.eventmanagerapi.service.EventiService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventiController {
    private final EventiService eventiService;

    public EventiController(EventiService eventiService){
        this.eventiService=eventiService;
    }

    @GetMapping("/event")
    public List<Eventi> getEventi(){
        return eventiService.getEventi();
    }
    @GetMapping("/event/{id}")
    public Eventi getEventiById(@PathVariable("id") int id) throws FileNukUGjetException {
        return eventiService.getEventiRepository().findEventiById(id);
    }

    @PostMapping("/event")
    public void addEventi(@Validated @RequestBody Eventi eventi)  {
        eventiService.addEventi(eventi);
    }
}
