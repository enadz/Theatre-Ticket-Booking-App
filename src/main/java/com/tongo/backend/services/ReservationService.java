package com.tongo.backend.services;

import com.tongo.backend.data.dtos.PlayDetailsDto;
import com.tongo.backend.data.dtos.PlayDto;
import com.tongo.backend.data.dtos.ReservationDto;
import com.tongo.backend.data.models.Performance;
import com.tongo.backend.data.models.Play;
import com.tongo.backend.data.models.Reservation;
import com.tongo.backend.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;


    public Iterable<Reservation> getReservationByUserID (int id){
        Iterable<Reservation> reservation = reservationRepository.findByUserId(id);
        return reservation;
    }


    public List<Reservation> getReservations(){

        List<Reservation> allReservations= (List<Reservation>) reservationRepository.findAll();
        return allReservations;
    }

    public ResponseEntity getReservationDetailsByUserId(int id){

        List<Reservation> reservations = (List<Reservation>) reservationRepository.findByUserId(id);
        List<ReservationDto> userReservations = null;
        for(Reservation reservation: reservations){
        ReservationDto reservationDto = new ReservationDto(reservation.getId(), reservation.getPerformanceId(), reservation.getUserId(), reservation.getDate(), reservation.getSeats());
        userReservations.add(reservationDto);
        }

        return new ResponseEntity(userReservations, HttpStatus.OK);
    }


    public boolean deleteReservationById (int id){
        if(reservationRepository.existsById(id)){
            reservationRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    public void addNewReservation(Reservation reservation){
        reservationRepository.save(new Reservation(reservation.getId(), reservation.getPerformanceId(), reservation.getUserId(), reservation.getDate(), reservation.getSeats()));
    }


}