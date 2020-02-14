package com.tongo.backend.services;

import com.tongo.backend.data.dtos.PlayDetailsDto;
import com.tongo.backend.data.dtos.PlayDetailsSimpleDto;
import com.tongo.backend.data.dtos.PlayDto;
import com.tongo.backend.data.models.Performance;
import com.tongo.backend.data.models.Play;
import com.tongo.backend.repositories.PerformanceRepository;
import com.tongo.backend.repositories.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayService {
    @Autowired
    PlayRepository playRepository;
    @Autowired
    PerformanceRepository performanceRepository;
    @Autowired
    PerformanceService performanceService;

    public ResponseEntity getAllPlays(){
        return new ResponseEntity(playRepository.findAll(), HttpStatus.OK);
    }
    public Map<Integer, List<Performance>> getCurrentPlays(){
        Map<Integer, List<Performance>> plays = new HashMap<>();
        Iterable<Performance> current = (Iterable<Performance>) performanceService.getFuturePerformance();
        current.forEach(performances ->  {
           List<Performance> playPerformances = plays.get(performances.getPlayID())
            ;
           if (null == playPerformances) {
               playPerformances = new ArrayList<>();
               plays.put(performances.getPlayID(), playPerformances);
           }
           playPerformances.add(performances);
       });
       return plays;
    }
    public void postNewPlay(PlayDto playDto){
        playRepository.save(new Play(playDto.getPlayName(), playDto.getDescription(), playDto.getPremierDate(),
                playDto.getGenre(), playDto.getImage(), playDto.getDuration(), playDto.getRating(), playDto.getActorsList()));
    }
    public ResponseEntity getPlayDetailsSimple(){
        List<Play> plays = (List<Play>) playRepository.findAll();
        List<PlayDetailsSimpleDto> playsSimple = new ArrayList<>();
        for (Play play : plays){
            List<Performance> performances = (List<Performance>) performanceService.getFuturePerformanceByPlay(play.getPlayID());
            PlayDetailsSimpleDto playSimple = new PlayDetailsSimpleDto(play.getPlayID(), play.getPlayName(), play.getDescription(), play.getImage(), performances);
            playsSimple.add(playSimple);
        }
        return new ResponseEntity(playsSimple, HttpStatus.OK);
    }
    public ResponseEntity getPlayDetailsById(int id){
            Optional<Play> playOptional = playRepository.findById(id);
            if(playOptional.isPresent()){
                List<Performance> performances = (List<Performance>) performanceRepository.findByPlay(id);
                Play play = playOptional.get();
                PlayDetailsDto playDetailsDto = new PlayDetailsDto(play.getPlayName(), play.getDuration(), play.getGenre(), play.getDescription(), play.getPremierDate(), performances, play.getActorList());
                return new ResponseEntity(playDetailsDto, HttpStatus.OK);
            }
            else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    public void editPlay(int id, PlayDto playDto){
        Optional<Play> playOptional = playRepository.findById(id);
        if(playOptional.isPresent()){
            Play play = playOptional.get();
            play.setPlayName(playDto.getPlayName());
            play.setDescription(playDto.getDescription());
            play.setDuration(playDto.getDuration());
            play.setGenre(playDto.getGenre());
            play.setImage(playDto.getImage());
            play.setPremierDate(playDto.getPremierDate());
            play.setRating(playDto.getRating());
            play.setActorList(playDto.getActorsList());
            playRepository.save(play);
        }
    }
    public void deletePlay(int id){
        playRepository.deleteById(id);
    }
}
