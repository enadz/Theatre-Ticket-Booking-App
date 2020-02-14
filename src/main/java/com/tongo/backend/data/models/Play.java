package com.tongo.backend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Plays")

public class Play {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int PlayID;
    private double rating;
    private int duration;
    private String genre;
    private String image;
    private String playName;
    private String description;
    private Date premierDate;
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Actors> actorList;


    public Play(String name, String description, Date openingDate, String genre, String image, int duration, double rating, List<Actors> actorsList) {
        this.playName = name;
        this.description = description;
        this.premierDate = openingDate;
        this.genre = genre;
        this.image = image;
        this.duration = duration;
        this.rating = rating;
        this.actorList = actorsList;
    }

}

