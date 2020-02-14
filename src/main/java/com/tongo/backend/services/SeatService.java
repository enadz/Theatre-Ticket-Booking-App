package com.tongo.backend.services;

import com.tongo.backend.data.dtos.SeatDto;
import com.tongo.backend.data.models.Performance;
import com.tongo.backend.data.models.Seat;
import com.tongo.backend.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;
    @Autowired
    SeatService seatService;

    public List<Seat> getSeats() {
        return (List<Seat>) seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(int id) {
        return seatRepository.findById(id);
    }

    public void deleteById(int id) {
        seatRepository.deleteById(id);
    }

    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    public List<Seat> getByZoneRow(Integer zone, Integer row) {
        if (zone == null && row == null) {
            return (List<Seat>) seatRepository.findAll();
        }
        ArrayList<Seat> seatsToReturn = new ArrayList<Seat>();
        List<Seat> seats = (List<Seat>) seatRepository.findAll();
        if (zone == null) {
            for (int i = 0; i < seats.size(); i++) {
                if (seats.get(i).getRow() == row) {
                    seatsToReturn.add(seats.get(i));
                }
            }

        } else {
            for (int i = 0; i < seats.size(); i++) {
                if (seats.get(i).getZone() == zone) {
                    seatsToReturn.add(seats.get(i));
                }
            }
        }
        return seatsToReturn;
    }

    public void setTaken(int id, boolean isTaken) {
        Seat seat = seatRepository.findById(id).orElse(null);
        if(seat != null) {
            seat.setTaken(isTaken);
            seatRepository.save(seat);
        }
    }

//    public List<Seat> getAllSeatsFromZone(int zoneID){
//        return seatRepository.findAllByZone(zoneID);
//    }
}
