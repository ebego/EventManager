package com.example.eventmanagerapi.controller;

import com.example.eventmanagerapi.entity.Perdoruesi;
import com.example.eventmanagerapi.exceptionhandler.FileNukUGjetException;
import com.example.eventmanagerapi.service.PerdoruesiService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PerdoruesiController {
    private final PerdoruesiService perdoruesiService;

    public PerdoruesiController(PerdoruesiService perdoruesiService){
        this.perdoruesiService=perdoruesiService;
    }

    @GetMapping("/perdorues")
    public List<Perdoruesi> getPerdoruesi(){
        return perdoruesiService.getPerdoruesi();
    }
    @GetMapping("/perdorues/{id}")
    public Perdoruesi getPerdoruesiById(@PathVariable("id") int id) throws FileNukUGjetException {
        return perdoruesiService.getPerdoruesiRepository().findPerdoruesiById(id);
    }

    @PostMapping("/perdorues")
    public void addPerdorues(@Validated @RequestBody Perdoruesi perdoruesi)  {
        perdoruesiService.addPerdoruesi(perdoruesi);
    }
}
