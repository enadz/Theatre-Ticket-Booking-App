package com.tongo.backend.repositories;

import com.tongo.backend.data.models.Actors;
import com.tongo.backend.data.models.Performance;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actors, Integer> {

}
