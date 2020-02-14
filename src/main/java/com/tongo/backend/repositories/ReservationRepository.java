package com.tongo.backend.repositories;

import com.tongo.backend.data.models.Performance;
import com.tongo.backend.data.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    @Query(value = "SELECT * FROM reservations WHERE userid = ?1", nativeQuery = true)
    public Iterable<Reservation> findByUserId(@Param("id") int id);


}
