package com.tongo.backend.controllers;

import com.tongo.backend.data.dtos.ActorSubsDto;
import com.tongo.backend.data.dtos.ShortActorDto;
import com.tongo.backend.data.models.ActorSubscription;
import com.tongo.backend.data.models.PlaySubscription;
import com.tongo.backend.services.ActorSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/actorsubscriptions")
public class ActorSubscriptionController {

    @Autowired
    ActorSubscriptionService actorSubscriptionService;

    @CrossOrigin
    @GetMapping("/userid/{id}")
    public ResponseEntity <List<ActorSubsDto>>getActorSubscriptionDetailsByUserId(@PathVariable int id){
        return new ResponseEntity(actorSubscriptionService.getActorSubscriptionDetailsByUserId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity DeleteActorSubscription(@PathVariable int id){
        if (actorSubscriptionService.deleteActorSubscriptionById(id)){
            return new ResponseEntity("Subscription deleted successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Subscription not found", HttpStatus.BAD_REQUEST);
    }


    @CrossOrigin
    @PostMapping
    public ResponseEntity AddActorSub(@RequestBody ActorSubscription actorSubscription) {

        boolean success =  actorSubscriptionService.addNewActorSub(actorSubscription);

        if (success) {
            return new ResponseEntity("Subscription added successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Could not add subscription", HttpStatus.BAD_REQUEST);
    }

}
