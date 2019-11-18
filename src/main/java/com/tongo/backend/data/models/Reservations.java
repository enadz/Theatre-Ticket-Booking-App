package com.pozoriste.pozoristebackend.data.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="reservations")
public class Reservations {
    private int id;
    private int PerformanceId;
    private int UserId;
    private Date date;

    public Reservations(Date date) {
        this.date = date;
    }
}
