package com.tongo.backend.repositories;

import com.tongo.backend.data.models.ActorSubscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorSubscriptionRepository extends CrudRepository<ActorSubscription, Integer> {


    @Query(value = "SELECT * FROM actor_subscriptions WHERE userid = ?1", nativeQuery = true)
    List<ActorSubscription> findByUserId(@Param("id") int id);


}
