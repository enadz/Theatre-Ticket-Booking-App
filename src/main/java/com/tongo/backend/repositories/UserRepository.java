package com.tongo.backend.repositories;

import com.tongo.backend.data.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
