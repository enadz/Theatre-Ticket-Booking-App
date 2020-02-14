package com.tongo.backend.data.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "PlaySubscriptions")
public class PlaySubscription {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    int userPlayID;
    int userID;
    @ManyToOne
    @JoinColumn(name="playid")
    Play play;

    public PlaySubscription(int userID, Play play) {
        this.userID = userID;
        this.play = play;
    }
}
