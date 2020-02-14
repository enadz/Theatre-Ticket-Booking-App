package com.tongo.backend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Characters")
public class Character {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int CharacterID;
    private int PlayID;
    private int ActorID;
    private String name;

    public Character(String name) {
        this.name = name;
    }

}
