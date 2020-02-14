package com.tongo.backend.data.models;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "ActorSubscriptions")
public class ActorSubscription {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    int useActorID;
    int userID;

    @ManyToOne
    @JoinColumn(name="actorid")
    Actors actor;

    public ActorSubscription(int userID, Actors actor) {
        this.userID = userID;
        this.actor = actor;
    }
}
