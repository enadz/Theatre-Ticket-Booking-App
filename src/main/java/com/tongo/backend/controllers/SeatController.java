package com.tongo.backend.controllers;

import com.tongo.backend.data.models.Seat;
import com.tongo.backend.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")

public class SeatController {

    @Autowired
    SeatService seatService;

//    @CrossOrigin
//    @GetMapping
//    public ResponseEntity getAll() {
//        try {
//            List<Seat> seats = seatService.getSeats();
//
//            return new ResponseEntity(seats, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @CrossOrigin
    @GetMapping()
    public ResponseEntity getSeats(@RequestParam(value = "zone", required = false) Integer zone, @RequestParam(value = "row", required = false) Integer row) {
        try {
            List<Seat> seats = seatService.getByZoneRow(zone, row);
            return new ResponseEntity(seats, HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") int id) {
        try {
            Optional<Seat> seat = seatService.getSeatById(id);
            return new ResponseEntity(seat, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @CrossOrigin
//    @GetMapping("zone/{id}")
//    public ResponseEntity getZoneById(@PathVariable(value="id") int id) {
//        try {
//            List<Seat> seats = seatService.getAllSeatsFromZone(id);
//            return new ResponseEntity(seats, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") int id) {
        try {
            seatService.deleteById(id);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity addSeat(@RequestBody Seat seat) {
        try {
            seatService.addSeat(seat);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity setTaken(@RequestBody boolean taken, @PathVariable(value = "id") int id) {
        try {
            seatService.setTaken(id, taken);
            return new ResponseEntity("Succesfully updated seat.",  HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}