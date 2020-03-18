package com.example.springbootexceptionhandling.repository;

import com.example.springbootexceptionhandling.model.Bird;
import org.springframework.data.repository.CrudRepository;

public interface BirdRepository extends CrudRepository<Bird, Long> {
    
}
