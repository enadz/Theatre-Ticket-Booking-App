package com.tongo.backend.controllers;

import com.tongo.backend.data.dtos.ShortPlayDTO;
import com.tongo.backend.data.models.PlaySubscription;
import com.tongo.backend.services.PlaySubscriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/playsubscription")
public class PlaySubscriptionController {

    @Autowired
    PlaySubscriptionService playSubscriptionService;

    @CrossOrigin
    @GetMapping("/userid/{id}")
    public ResponseEntity <List<ShortPlayDTO>> getPlaySubscriptionDetailsByUserId(@PathVariable int id){
        return new ResponseEntity(playSubscriptionService.getPlaySubscriptionDetailsByUserId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity DeletePlaySub (@PathVariable int id){
        if (playSubscriptionService.deletePlaySubscriptionById(id)){
            return new ResponseEntity("Subscription deleted successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Subscription not found", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity AddPlaySubscription(@RequestBody PlaySubscription playSubscription) {


        boolean success =  playSubscriptionService.postNewPlaySubscription(playSubscription);

        if (success) {
            return new ResponseEntity("Subscription added successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Could not add subscription", HttpStatus.BAD_REQUEST);
    }
}
