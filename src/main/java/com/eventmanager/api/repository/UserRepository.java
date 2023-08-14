package com.eventmanager.api.repository;

import com.eventmanager.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    List<User> findAll();
    Optional<User> findByEmailEqualsIgnoreCase(String email);

    User findByUsername(String username);

}