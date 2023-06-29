package com.example.eventmanagerapi.repository;

import com.example.eventmanagerapi.entity.Perdoruesi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PerdoruesiRepository extends CrudRepository<Perdoruesi, Long> {

    Perdoruesi findPerdoruesiById(int id);

    List<Perdoruesi> findAll();
}