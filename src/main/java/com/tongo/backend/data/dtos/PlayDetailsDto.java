package com.tongo.backend.data.dtos;

import com.tongo.backend.data.models.Actors;
import com.tongo.backend.data.models.Performance;
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
public class PlayDetailsDto {
    private String playName;
    private int duration;
    private String genre;
    private String description;
    private Date premierDate;
    private List<Performance> performances;
    private List<Actors> actors;

    public PlayDetailsDto(String playName, int duration, String genre, String description, Date premierDate, List<Performance> performances, List<Actors> actors){
        this.playName = playName;
        this.duration = duration;
        this.genre = genre;
        this.description = description;
        this.premierDate = premierDate;
        this.performances = performances;
        this.actors = actors;
    }
}
