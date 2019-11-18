package com.pozoriste.pozoristebackend.data.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="ratings")
public class Ratings {
    private int id;
    private int PlayId;
    private int UserId;
    private double score;

    public User(double score){
        this.score = score;
    }
}
