package com.example.springbootexceptionhandling.service;

import com.example.springbootexceptionhandling.dto.BirdCollectionDto;
import com.example.springbootexceptionhandling.model.Bird;
import java.util.List;


public interface BirdService {

    public Iterable<Bird> getAllBirds();


    public Bird getBirdNoException(Long birdId) ;
   

    public Bird getBird(Long birdId);

    public Bird createBird(Bird bird) ;

    public List<Bird> getBirdCollection(BirdCollectionDto birdCollection) ;

    public Bird getBirdByName(String name);
    
    public boolean isBirdNameExists(String name);

    
}
