package com.tongo.backend.controllers;

import com.tongo.backend.data.dtos.PlayDto;
import com.tongo.backend.data.models.Reservation;
import com.tongo.backend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity getAllReservations() { return new ResponseEntity(reservationService.getReservations(), HttpStatus.OK); }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getReservationDetailsByUserId(@PathVariable int id){
        return new ResponseEntity(reservationService.getReservationDetailsByUserId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity DeleteReservation (@PathVariable int id){
        if (reservationService.deleteReservationById(id)){
            return new ResponseEntity("Reservation deleted successfully", HttpStatus.OK);
        }
        else return new ResponseEntity("Reservation not found", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity addNewReservation(@RequestBody Reservation reservation){
        reservationService.addNewReservation(reservation);
        return new ResponseEntity(HttpStatus.OK);
    }

}
