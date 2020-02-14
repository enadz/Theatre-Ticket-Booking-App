package com.tongo.backend.services;


import com.tongo.backend.data.dtos.ActorSubsDto;
import com.tongo.backend.data.dtos.ShortActorDto;
import com.tongo.backend.data.models.ActorSubscription;
import com.tongo.backend.data.models.Actors;

import com.tongo.backend.data.models.PlaySubscription;
import com.tongo.backend.repositories.ActorRepository;
import com.tongo.backend.repositories.ActorSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorSubscriptionService {

    @Autowired
    ActorSubscriptionRepository actorSubscriptionRepository;
    ActorRepository actorRepository;


    public Iterable<ActorSubscription> getActorSubscriptionsByUserID (int id){
        Iterable<ActorSubscription> actorsubs = actorSubscriptionRepository.findByUserId(id);
        return actorsubs;
    }


    public List<ActorSubsDto> getActorSubscriptionDetailsByUserId(int id){

        List<ActorSubscription> actorSubscriptions = actorSubscriptionRepository.findByUserId(id);;

        return actorSubscriptions.stream()
                .map(actorSubscription -> new ActorSubsDto(actorSubscription.getActor().getFname(), actorSubscription.getActor().getLname()))
                .collect(Collectors.toList());

 }


    public boolean addNewActorSub(ActorSubscription actorSubscription){
        ActorSubscription actorSubscription1 = new ActorSubscription(actorSubscription.getUserID(),actorSubscription.getActor());
        actorSubscriptionRepository.save(actorSubscription1);
        return true;
    }

    public boolean deleteActorSubscriptionById (int id){
        if(actorSubscriptionRepository.existsById(id)){
            actorSubscriptionRepository.deleteById(id);
            return true;
        }
        else return false;
    }

}
