package com.example.springbootexceptionhandling.controler;

import com.example.springbootexceptionhandling.dto.BirdCollectionDto;
import com.example.springbootexceptionhandling.model.Bird;
import com.example.springbootexceptionhandling.exception_handler.EntityNotFoundException;
import com.example.springbootexceptionhandling.exception_handler.apierror.ApiError;
import com.example.springbootexceptionhandling.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/birds")
public class BirdRestController {

    @Autowired
    private BirdService birdService;

    @GetMapping(value = "/{birdId}")
    public Bird getBird(@PathVariable("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/all")
    public Iterable<Bird> getAllBirds() throws EntityNotFoundException {
        return birdService.getAllBirds();
    }

    @GetMapping(value = "/collection")
    public List<Bird> getBirdValid(@RequestBody BirdCollectionDto birdCollection) throws EntityNotFoundException {
        return birdService.getBirdCollection(birdCollection);
    }

    @GetMapping(value = "/params")
    public Bird getBirdRequestParam(@RequestParam("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBird(birdId);
    }

    @GetMapping(value = "/noexception/{birdId}")
    public Bird getBirdNoException(@PathVariable("birdId") Long birdId) throws EntityNotFoundException {
        return birdService.getBirdNoException(birdId);
    }

    @PostMapping
    public Bird createBird(@RequestBody @Valid Bird bird) throws EntityNotFoundException  {
      boolean check=  birdService.isBirdNameExists(bird.getScientificName());
      
        if (check) {
             throw new EntityNotFoundException(Bird.class, "id", "already exsists");
        }
     return birdService.createBird(bird);
    }

    

}
