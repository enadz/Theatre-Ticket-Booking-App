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
@Table(name = "Seats")
public class Seat {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    int row;
    int zone;
    int number;
//    @ManyToOne
//            @JoinColumn(name = "performanceId", nullable = false)
//    Performance performance;
    boolean taken=false;

    public Seat(int zone, int row) {
        this.zone = zone;
        this.row = row;
    }
}
