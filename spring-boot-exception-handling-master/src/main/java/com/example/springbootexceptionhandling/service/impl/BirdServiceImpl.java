package com.example.springbootexceptionhandling.service.impl;

import com.example.springbootexceptionhandling.dao.BirdDao;
import com.example.springbootexceptionhandling.repository.BirdRepository;
import com.example.springbootexceptionhandling.dto.BirdCollectionDto;
import com.example.springbootexceptionhandling.model.Bird;
import com.example.springbootexceptionhandling.exception_handler.EntityNotFoundException;
import com.example.springbootexceptionhandling.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdRepository birdRepository;
        @Autowired
    private BirdDao birdDao;

    @Override
    public Bird getBirdNoException(Long birdId) {
        return birdRepository.findOne(birdId);
    }

    @Override
    public Bird getBird(Long birdId) {
        Bird bird = birdRepository.findOne(birdId);
        if (bird == null) {
            throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
        }
        return bird;
    }

    @Override
    public Bird createBird(Bird bird) {
        return birdRepository.save(bird);
    }

    @Override
    public List<Bird> getBirdCollection(BirdCollectionDto birdCollection) {
        List<Bird> birds = new ArrayList<>();

        birdCollection.getBirdsIds().stream().map((birdId) -> {
            Bird bird = birdRepository.findOne(birdId);
            if (bird == null) {
                throw new EntityNotFoundException(Bird.class, "id", birdId.toString());
            }
            return bird;
        }).forEachOrdered((bird) -> {
            birds.add(bird);
        });
        return birds;
    }

    @Override
    public Iterable<Bird> getAllBirds() {
    return birdRepository.findAll();
    }

    @Override
    public Bird getBirdByName(String name) {
    return birdDao.findBirdByName(name);
    }

    @Override
    public boolean isBirdNameExists(String name) {
  return birdDao.isBirdNameExists(name);
    }

   

  
}
