package com.tongo.backend.data.models;

import java.util.ArrayList;
import java.util.List;

public class Row {

    ArrayList<Seat> seats;
    public int rowId;
    public int zoneId;
    public int RowNumber;

    public Row(int rowId) {
        this.rowId = rowId;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

}