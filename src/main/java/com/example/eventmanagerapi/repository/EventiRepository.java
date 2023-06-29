package com.example.eventmanagerapi.repository;

import com.example.eventmanagerapi.entity.Eventi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventiRepository extends CrudRepository<Eventi, Long> {

        Eventi findEventiById (int id);

        List<Eventi> findAll();
        }