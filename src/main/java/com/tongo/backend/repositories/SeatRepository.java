package com.tongo.backend.repositories;

import com.tongo.backend.data.models.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Integer> {

//    List<Seat> findAllByZone(int zoneId);
}
