package com.example.eventmanagerapi.service;

import com.example.eventmanagerapi.entity.Eventi;
import com.example.eventmanagerapi.exceptionhandler.FileNukUGjetException;
import com.example.eventmanagerapi.repository.EventiRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Data
@Service
public class EventiService {
    private EventiRepository eventiRepository;

    private static List<Eventi> eventiList = new ArrayList<>();

    public List<Eventi> getEventi(){
        List<Eventi> result = new ArrayList();
        eventiRepository.findAll().forEach(result::add);
        return result;
    }

    public void addEventi(Eventi eventi){
        eventiRepository.save(eventi);
    }
    public Eventi getEventiById(int id) throws FileNukUGjetException {
        return eventiRepository.findEventiById(id);
    }
}
