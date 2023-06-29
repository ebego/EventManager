package com.example.eventmanagerapi.service;

import com.example.eventmanagerapi.entity.Rezervimi;
import com.example.eventmanagerapi.exceptionhandler.FileNukUGjetException;
import com.example.eventmanagerapi.repository.RezervimiRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class RezervimiService {
    private RezervimiRepository rezervimiRepository;

    private static List<Rezervimi> rezervimiList = new ArrayList<>();

    public List<Rezervimi> getRezervimi(){
        List<Rezervimi> result = new ArrayList();
        rezervimiRepository.findAll().forEach(result::add);
        return result;
    }

    public void addRezervimi(Rezervimi perdoruesi){
        rezervimiRepository.save(perdoruesi);
    }
    public Rezervimi getRezervimiById(int id) throws FileNukUGjetException {
        return rezervimiRepository.findRezervimiById(id);
    }
}
