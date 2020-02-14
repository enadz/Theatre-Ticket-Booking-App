package com.tongo.backend.services;

import com.tongo.backend.data.dtos.AcorDTO;
import com.tongo.backend.data.dtos.ShortActorDto;
import com.tongo.backend.data.models.Actors;
import com.tongo.backend.data.models.Performance;
import com.tongo.backend.repositories.ActorRepository;
import com.tongo.backend.repositories.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public List<ShortActorDto> GetAllActors() {
        List<Actors> allActors = (List<Actors>) actorRepository.findAll();
        List<ShortActorDto> actorsDTO = new ArrayList<>();
        for (Actors actor: allActors) {
            ShortActorDto actorDTO = new ShortActorDto(actor.getActorID(), actor.getFname(), actor.getLname());
            actorsDTO.add(actorDTO);
        }
        return actorsDTO;
    }

    public Optional<Actors> getActorById (int id){
        Optional<Actors> actor = actorRepository.findById(id);
        return actor;
    }

    public boolean CheckIfActorExists (int id){
        if(actorRepository.existsById(id)){
            return true;
        }
        else return false;
    }

    public Boolean addActor (AcorDTO actorDTO){
        Actors actorEM = new Actors(actorDTO.getFName(), actorDTO.getLName(), actorDTO.getDOb(), actorDTO.getBio());

        if(actorDTO.getFName() != null && actorDTO.getLName() != null && actorDTO.getDOb() != null && actorDTO.getBio() != null){
            actorRepository.save(actorEM);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteActorById (int id){
        if(actorRepository.existsById(id)){
            actorRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    public boolean updateActor (int id, AcorDTO actorDTO){
        Optional<Actors> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()){
           Actors actor = actorOptional.get();
            actor.setBio(actorDTO.getBio());
            actor.setDob(actorDTO.getDOb());
            actor.setFname(actorDTO.getFName());
            actor.setLname(actorDTO.getLName());
            actorRepository.save(actor);
            return true;
        }
        else return false;

    }

}

