package com.example.eventmanagerapi.controller;

import com.example.eventmanagerapi.entity.Rezervimi;
import com.example.eventmanagerapi.exceptionhandler.FileNukUGjetException;
import com.example.eventmanagerapi.service.RezervimiService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RezervimiController {
    private final RezervimiService rezervimiService;

    public RezervimiController(RezervimiService rezervimiService){
        this.rezervimiService=rezervimiService;
    }

    @GetMapping("/rezervim")
    public List<Rezervimi> getRezervimi(){
        return rezervimiService.getRezervimi();
    }
    @GetMapping("/rezervim/{id}")
    public Rezervimi getRezervimiById(@PathVariable("id") int id) throws FileNukUGjetException {
        return rezervimiService.getRezervimiRepository().findRezervimiById(id);
    }

    @PostMapping("/rezervim")
    public void addRezervimi(@Validated @RequestBody Rezervimi rezervimi)  {
        rezervimiService.addRezervimi(rezervimi);
    }
}
