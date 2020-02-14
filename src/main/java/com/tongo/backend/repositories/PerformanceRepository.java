package com.tongo.backend.repositories;

import com.tongo.backend.data.models.Performance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PerformanceRepository extends CrudRepository<Performance, Integer> {

    @Query(value = "SELECT * FROM performances WHERE performanceid = ?1", nativeQuery = true)
    public Iterable<Performance> findByPlay(@Param("id") int id);

}
