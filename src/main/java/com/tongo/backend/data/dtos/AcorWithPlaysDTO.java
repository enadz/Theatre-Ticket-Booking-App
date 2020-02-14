package com.tongo.backend.data.dtos;

import com.tongo.backend.data.models.Actors;
import com.tongo.backend.data.models.Play;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AcorWithPlaysDTO {
    Actors actor;
    List<Play> actorPlays;

    public  AcorWithPlaysDTO (Actors Actor, List<Play> plays){
        this.actor = Actor;
        this.actorPlays = plays;
    }
}
