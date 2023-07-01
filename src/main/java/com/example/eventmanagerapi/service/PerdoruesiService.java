package com.example.eventmanagerapi.service;

import com.example.eventmanagerapi.entity.Perdoruesi;
import com.example.eventmanagerapi.exceptionhandler.FileNukUGjetException;
import com.example.eventmanagerapi.repository.PerdoruesiRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class PerdoruesiService {

    private PerdoruesiRepository perdoruesiRepository;
    public PerdoruesiService(PerdoruesiRepository perdoruesiRepository){
        this.perdoruesiRepository=perdoruesiRepository;
    }


    private static List<Perdoruesi> perdoruesiList = new ArrayList<>();

    public List<Perdoruesi> getPerdoruesi(){
//        List<Perdoruesi> result = new ArrayList();
//        perdoruesiRepository.findAll().forEach(result::add);
//        return result;
        return perdoruesiRepository.findAll();
//        return perdoruesiList;
    }

    public void addPerdoruesi(Perdoruesi perdoruesi){
        perdoruesiRepository.save(perdoruesi);
    }
//    public Perdoruesi getPerdoruesiById(int id) throws FileNukUGjetException {
//        return perdoruesiRepository.findPerdoruesiById(id);
//    }
    public Perdoruesi getPerdoruesiById(int id) throws FileNukUGjetException {
        if(perdoruesiList.stream().filter(s->s.getId() == id).noneMatch(p-> true) == true){
            throw new FileNukUGjetException("Not found exception");
        }
        return perdoruesiList.stream().filter(s->s.getId() == id).findFirst().get();
    }
    public void deletePerdoruesi(Perdoruesi perdoruesi){
        perdoruesiRepository.delete(perdoruesi);
    }
}
