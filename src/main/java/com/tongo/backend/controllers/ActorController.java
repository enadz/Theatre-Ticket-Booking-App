package com.tongo.backend.controllers;


import com.tongo.backend.data.dtos.AcorDTO;
import com.tongo.backend.data.dtos.PlayDto;
import com.tongo.backend.data.models.Actors;
import com.tongo.backend.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;


@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    ActorService actorService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity GetAllActors(){
            return new ResponseEntity(actorService.GetAllActors(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity GetActor(@PathVariable int id){
        boolean success = actorService.CheckIfActorExists(id);
        if (success){
            return new ResponseEntity(actorService.getActorById(id) , HttpStatus.OK);
        }
        else return  new ResponseEntity("Actor does not exist", HttpStatus.BAD_REQUEST);

    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity AddActor(@RequestBody AcorDTO actor) {


        boolean success =  actorService.addActor(actor);

        if (success) {
            return new ResponseEntity("Actor added successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Bad request", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity DeleteActor (@PathVariable int id){
        if (actorService.deleteActorById(id)){
            return new ResponseEntity("Actor deleted successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Actor not found", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity UpdateActor (@PathVariable int id, @RequestBody AcorDTO actor){
        if (actorService.updateActor(id, actor)){
            return new ResponseEntity("Actor updated successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Actor not found", HttpStatus.BAD_REQUEST);
    }


}

