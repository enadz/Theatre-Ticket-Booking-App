package com.tongo.backend.data.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SeatDto {
    private int zone;
    private int row;


    public SeatDto(int zone, int row) {
        this.zone = zone;
        this.row = row;
    }
}
