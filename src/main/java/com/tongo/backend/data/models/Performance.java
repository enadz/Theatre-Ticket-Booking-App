package com.tongo.backend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Performances")

public class Performance {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int PerformanceID;
    private int PlayID;
    private Date datetime;
    private int numOfTickets;
    private int ticketPrice;


    public Performance(Date datetime, int nugitmOfTickets, int ticketPrice) {
        this.datetime = datetime;
        this.numOfTickets=numOfTickets;
        this.ticketPrice=ticketPrice;
    }
}