package com.tongo.backend.data.dtos;

import com.tongo.backend.data.models.Actors;
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
public class PlayDto {
    private String playName;
    private double rating;
    private int duration;
    private String genre;
    private String image;
    private String description;
    private Date premierDate;
    private List<Actors> actorsList;


    public PlayDto(String name, String description, Date openingDate, String genre, String image, int duration, double rating, List<Actors> actorsList) {
        this.playName = name;
        this.description = description;
        this.premierDate = openingDate;
        this.genre = genre;
        this.image = image;
        this.duration = duration;
        this.rating = rating;
        this.actorsList = actorsList;
    }
}
