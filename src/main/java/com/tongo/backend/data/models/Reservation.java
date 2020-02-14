package com.tongo.backend.data.models;;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Reservations")
public class Reservation {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    private int PerformanceId;
    private int UserId;
    private Date date;
    private List<Seat> seats;

    public Reservation(Date date) {
        this.date = date;
    }


}
