package com.example.eventmanagerapi.repository;

import com.example.eventmanagerapi.entity.Rezervimi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezervimiRepository extends CrudRepository<Rezervimi, Long> {

    Rezervimi findRezervimiById (int id);

    List<Rezervimi> findAll();
}
