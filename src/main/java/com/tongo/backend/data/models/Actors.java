package com.tongo.backend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Actors")
public class Actors {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int actorID;
    private String fname;
    private String lname;
    private Date dob;
    private String bio;

    public Actors(String fname, String lname, Date dob, String bio) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.bio = bio;
    }
}
