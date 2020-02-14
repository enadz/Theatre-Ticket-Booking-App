package com.tongo.backend.data.dtos;

import com.tongo.backend.data.models.Seat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private int id;
    private int performanceId;
    private int userId;
    private Date date;
    private List<Seat> Seats;


}
