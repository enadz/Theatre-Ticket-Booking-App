package com.tongo.backend.services;

import com.tongo.backend.data.dtos.ShortPlayDTO;
import com.tongo.backend.data.models.Play;
import com.tongo.backend.data.models.PlaySubscription;
import com.tongo.backend.repositories.PlayRepository;
import com.tongo.backend.repositories.PlaySubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlaySubscriptionService {


    @Autowired
    PlaySubscriptionRepository playSubscriptionRepository;
    PlayRepository playRepository;

    public Iterable<PlaySubscription> getPlaySubscriptionsByUserID (int id){
        Iterable<PlaySubscription> playsubs = playSubscriptionRepository.findByUserID(id);
        return playsubs;
    }

    public List<ShortPlayDTO> getPlaySubscriptionDetailsByUserId(int id){

        List<PlaySubscription> playSubscriptions = playSubscriptionRepository.findByUserID(id);;

        return playSubscriptions.stream()
                .map(playSubscription -> new ShortPlayDTO(playSubscription.getPlay().getPlayName(), playSubscription.getPlay().getPremierDate()))
                .collect(Collectors.toList());
            }


    public boolean postNewPlaySubscription(PlaySubscription playSubscription){
        PlaySubscription playsubs = new PlaySubscription(playSubscription.getUserID(), playSubscription.getPlay());
        playSubscriptionRepository.save(playsubs);
        return true;
    }

    public boolean deletePlaySubscriptionById (int id){
        if(playSubscriptionRepository.existsById(id)){
            playSubscriptionRepository.deleteById(id);
            return true;
        }
        else return false;
    }




}
