package com.tongo.backend.repositories;

import com.tongo.backend.data.models.Play;
import com.tongo.backend.data.models.PlaySubscription;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaySubscriptionRepository extends CrudRepository<PlaySubscription, Integer> {

    @Query(value = "SELECT * FROM play_subscriptions WHERE userid = ?1", nativeQuery = true)
    List<PlaySubscription> findByUserID(@Param("id") int id);

}
